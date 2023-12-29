package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
@Getter @Setter
@MappedSuperclass//공통 속성화를 나타내는 상위클래스
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {

    @CreatedDate
    @Column(updatable=false)
    private LocalDateTime createdAt;
    @LastModifiedDate
    @Column(insertable=false)//추가시에 안되고, 수정시에만 가능
    private LocalDateTime modifiedAt;
}

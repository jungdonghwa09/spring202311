package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
//@Table(name="USERS",indexes =@Index(name="idx_member_createdAt",
//columnList="createdAt DESC"))
//@EntityListeners(AuditingEntityListener.class)
public class Member extends Base {
    @Id @GeneratedValue
    private Long seq;
    @Column(length=80,unique = true,nullable=false)
    private String email;
    @Column(length=40,nullable=false)
    private String name;

    @Column(length=65,nullable = false)
    private String password;
    //@Lob
    //@Transient//엔티티 내부에서만, db테이블에 반영되지 않음
    //private String introduction;//CLOB로 됨
    @Enumerated(EnumType.STRING)
    @Column(length=10)
    private MemberType type;

    @ToString.Exclude
    @OneToMany(mappedBy = "member", fetch=FetchType.LAZY
    ,cascade=CascadeType.REMOVE)
    private List<BoardData> items = new ArrayList<>();
    //한 회원에게 게시글이 여러개가 보임

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="addressNo")
    private Address address;
}

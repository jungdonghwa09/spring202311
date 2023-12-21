package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Member {
    //USER_NO=userNo
    @Id
    private Long userNo;//기본키는 래퍼형태로

    private String userId;
    @JsonIgnore
    private String userPw;
    private String userNm;
    private String email;

    @JsonFormat(pattern="yyyy.MM.dd HH:mm")
    private LocalDateTime regDt;

    @JsonFormat(pattern= "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt;
}

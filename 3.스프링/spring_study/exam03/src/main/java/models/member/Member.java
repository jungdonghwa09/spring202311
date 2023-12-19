package models.member;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
public class Member {
    private String userId;
    private String userPw;
    private String confirmPw;
    private String userNm;
    private LocalDateTime regDt;
    private String regDtStr;

}

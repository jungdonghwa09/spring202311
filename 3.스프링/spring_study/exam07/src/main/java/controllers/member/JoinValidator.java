package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;

import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao;
    @Override
    public boolean supports(Class<?> clazz) {
        //검증 커멘드 객체를 제한
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        //target이 검증할 커맨드객체
        //실제로 검증을 수행할 메서드
        //필수항목-id,pw,confirmpw, nm,약관동의
        //중복 아이디 여부 체크-아이디 최소 자릿수
        //비밀번호 최소 자릿수

        RequestJoin form = (RequestJoin)target;
        //중복 아이디 여부
        String userId=form.getUserId();
        if(StringUtils.hasText(userId)&& memberDao.exist(userId)){
            //이미 가입된 아이디이면
            errors.rejectValue("userId", "Duplicated");
        }

        String userPw = form.getUserPw();
        String confirmPw = form.getConfirmPw();

        if(StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw)
                &&!userPw.equals(confirmPw)){
            errors.rejectValue("confirmPw", "Mismatch");

        }
        /*
            boolean result=false;
        if(!result){
            errors.reject("ErrorTest","공통에러-커맨드");
        }
        */
    }
}

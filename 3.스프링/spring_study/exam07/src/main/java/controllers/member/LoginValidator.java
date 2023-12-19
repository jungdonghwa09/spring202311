package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberDao memberDao;
    //validate메서드가 의존함
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1.아이디로 회원을 조회할 수 있는지
         * 2.비밀번호 서로 일치하는지
         */
        RequestLogin form = (RequestLogin)target;
        String userId = form.userId();
        String userPw = form.userPw();
        Member member = memberDao.get(userId);
        if(member == null){
            errors.reject("Login.auth.fail");

        }
        //비밀번호가 일치하지 않다--아이디는 맞다는 뜻(애매하게 문구 작성해야 보안)
        if(member!=null && StringUtils.hasText(userPw)
            &&!BCrypt.checkpw(userPw,member.getUserPw())){
            errors.reject("Login.auth.fail");
        }

    }
}

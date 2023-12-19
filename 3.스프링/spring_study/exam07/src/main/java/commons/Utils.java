package commons;

import jakarta.servlet.http.HttpSession;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {
    @Autowired
    private HttpSession session;

    public boolean isLogin(){
        return getMember() !=null;
        //세션의 getMember해서값이 있으면 로그인 상태라는 뜻
    }
    public Member getMember(){
        Member member = (Member)session.getAttribute("member");
        return member;
    }

}

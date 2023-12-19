package configs;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.member.Member;
import org.springframework.web.servlet.HandlerInterceptor;

public class MemberOnlyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //Jsessionid얻는거?
        Member member = (Member)session.getAttribute("member");
        if(member !=null) {//로그인한 상태
            return true;
        }
        //비회원이면 로그인페이지로 이동
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

        String url = request.getContextPath()
                +"/member/login";
        // /exam07/member/login이라는 뜻
        response.sendRedirect(url);
        return false;
    }
}

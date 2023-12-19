package controllers.member;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.LoginService;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller//컨트롤러 빈으로써 역할
@RequestMapping("/member")//공통주소-member
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator;

    private final JoinService joinService;
    private final LoginValidator loginValidator;
    private final LoginService loginService;
    //@GetMapping("/member/join")//get방식의 매핑
    @ModelAttribute("hobbies")
    public List<String> hobbies(){
        return Arrays.asList("자바", "oracle", "jsp", "spring");
    }
@GetMapping("/join")

    //아래 new RequestJoin생성 대신 @ModelAttribute RequestJoin form쓴다
    public String join(@ModelAttribute RequestJoin form,  Model model){
        //요청이 없는 비어있는 상태여도 form이 화면에 떠야되기 때문에 new
        //model.addAttribute("requestJoin", new RequestJoin());

    // String[]addCss = {"member/style1.css", "member/style2.css"};
       // List<String> addScript = Arrays.asList("member/script1.js", "member/script2.js");

       // model.addAttribute("addCss", addCss);
       // model.addAttribute("addScript", addScript);
        model.addAttribute("pageTitle", "회원가입");
        return "member/join";
    }
    //RequestJoin클래스에도 Address를 본인 클래스말고도 중첩 커맨드객체를 만들어
    //form으로 넘어가게 함
    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model){
       joinValidator.validate(form, errors);
        //전역 validator이용하면 모든 컨트롤러에서 사용
        if(errors.hasErrors()){
            //검증 시 실패하면 -오류를 받음

            return "member/join";
        }
        //오류없으면 회원가입처리
        joinService.join(form);

        //이 RequestJoin타입의 form변수는 RequestJoin이 가진 정보를 갖고 있는
        //변수로써 그냥 이름을 여기서 form으로 지정함

        //model.addAttribute("requestJoin",form);


        //response.sendRedirect(request.getContextPath()+"
        // /member/login")외 같음, location
        //회원가입이 되면 로그인 페이지로 이동
        return "redirect:/member/login";//--302, get주소
    }


    @GetMapping("/login")
    public String login(@ModelAttribute RequestLogin form){

        return "member/login";
    }
    @PostMapping("/login")
    public String loginPs(@Valid RequestLogin form,Errors errors){
       loginValidator.validate(form,errors);
       //아이디 있는지, 비밀번호가 일치하는지 검증
        if(errors.hasErrors()){
            return "member/login";
        }
        //에러가 없다면 로그인처리후, 메인으로
        loginService.login(form);
        return "redirect:/";//로그인 성공 메인페이지로
    }
        @RequestMapping("/logout")
        public String logout(HttpSession session){
            session.invalidate();
            return "redirect:/member/login";
        }
    @GetMapping("/list")
    public String members(Model model){
        List<Member> members = new ArrayList<>();
        for(int i=1; i<=10;i++){
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userPw("1234")
                    .userId("user" + i)
                    .userNm("사용자" + i)
                    .email("user" + i+ "@test.org")
                    .regDt(LocalDateTime.now())
                    .build();
            members.add(member);
        }
        model.addAttribute("members", members);
        //view에 전달된다

        return "member/list";
    }
    /*@InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(joinValidator);

    }
    */

}

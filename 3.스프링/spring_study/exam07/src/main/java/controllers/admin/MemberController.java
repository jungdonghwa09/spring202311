package controllers.admin;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import models.member.MemberNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class MemberController {
    //목록나오게
    private final MemberDao memberDao;//=new MemberDao();

    //public MemberController(MemberDao memberDao){
      //  this.memberDao = memberDao;
    //}

    @GetMapping // /admin/member로 나옴
    public String index(@ModelAttribute MemberSearch search, Errors errors, Model model){
        //MemberSearch가 커맨드객체-데이터가 들어오는 거
        //비어있는 객체라도만듬
        List<Member> members = memberDao.getList(search);
        model.addAttribute("members",members);
        members.forEach(System.out::println);
        return "admin/member/list";
    }
    // /admin/member/회원아이디
    @GetMapping("/{id}")// admin/member/user01(있는 아이디)이렇게 주소창에 치면 info로 이동
    public String info(@PathVariable("id") String userId){
        System.out.println(userId);
        return "admin/member/info";

    }
    @GetMapping("/test")
    public String errorTest(){
        boolean result= true;
        if(result){
            //throw new RuntimeException("예외발생");
        throw new MemberNotFoundException();
        }
        return "admin/member/info";
    }
    /*
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e,Model model){
        e.printStackTrace();
        model.addAttribute("message",e.getMessage());//사용자에게

        return "error/common";//동일한 예외가 발생하면 여기로 이동
    }

     */
}

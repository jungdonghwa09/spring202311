package controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @GetMapping("/hello")
    //@RequestParam()안에 dafaultValue="기본값"은 파라미터?...으로 넘어온 값없을때 나옴
    public String hello(@RequestParam(name="name", required=false) String nm,
                        Model model){
        model.addAttribute("name", nm);
        return "hello";

    }
    /*
    @GetMapping("/hello")
    //@RequestParam-은 /hello요청 시 필수로 입력해야 되는 것임
    public String hello(HttpServletRequest request,
                        HttpServletResponse response,
                        HttpSession session
                        ){
       // System.out.println(name + ","+num);
        System.out.println("request : " + request);
        System.out.println("response : " + response);
        System.out.println("session : " + session);
        return "hello";//MvcConfig의 viewresolver가 찾음
    }

     @GetMapping("/hello1")
    public ModelAndView hello(){
         ModelAndView mv = new ModelAndView();
         //request.setAttribute("message", "안녕하세요")아래와 동일
         mv.addObject("message", "안녕하세요");
     mv.setViewName("hello"); // /WEB-INF/templates/hello.jsp를 요청해줌

         return mv;
     }
     */

}

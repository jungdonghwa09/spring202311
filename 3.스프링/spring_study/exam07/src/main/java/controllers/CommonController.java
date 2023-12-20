package controllers;

import commons.CommonException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice("controllers")
public class CommonController {
    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model, HttpServletResponse
                               response){
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;//status고정
        if(e instanceof CommonException){
            CommonException commonException = (CommonException)e;
            status = commonException.getStatus();//status변경
        }//그냥 Exception을 CommonException으로 형변환 후, status변경
        response.setStatus(status.value());
        e.printStackTrace();

        model.addAttribute("message",e.getMessage());//사용자에게
        //"message"는 common.html화면에 출력될 이름-string message와는 관련없음
        return "error/common";//동일한 예외가 발생하면 여기로 이동
    }
}

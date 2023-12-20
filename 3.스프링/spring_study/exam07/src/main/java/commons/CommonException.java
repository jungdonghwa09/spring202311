package commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException{
    private HttpStatus status;

    public CommonException(String message){
        this(message,HttpStatus.INTERNAL_SERVER_ERROR);
        //500
        //이거 생성자임

    }
    public CommonException(String message, HttpStatus status){
        super(message);//String message는 그냥 여기서 정한 이름
        //어디에서 변수이름으로 정해진거를 갖고오는 느낌인줄 알고, 근데
        //그냥 정한 이름임
        //super는 상속받은 RuntimeException의 생성자를 호출
        //여기서 super하는 이유가 this를 하면 여기서 저 위처럼 상태를 정해줘야되니까

        this.status=status;//응답코드를 직접 정할 수 있는 생성자
    }
    public HttpStatus getStatus(){
        return status;
    }
}

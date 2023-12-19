package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
@Service
public class ListService {
    private MemberDao memberDao;
    

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd");
    //이 형식대로 regDtStr이 나옴, 언제는 regDtStr이 null이 나오고
    //@Bean이 살아있어야 autowired의 내용이 작동, 주석처리되면 auto가 작동하지 않아
    // regDtr이 null
    //@Autowired(required=false)
    @Autowired
    public void setFormatter(@Nullable DateTimeFormatter formatter){
        this.formatter=formatter;
    }

    //setMemberDao는 뜻이 ??
    @Autowired//이건 의존성 주입해주는 어노테이션
    //setMemberDao(의존성객체를 set해주는)는 print에서 memberDao를 쓰려고 이 클래스의 위에서 선언한 멤버변수에
    //memberDao를 대입해주기 위한 메서드
    public void setMemberDao(MemberDao memberDao){

        this.memberDao=memberDao;
    }
    public void print(){
        List<Member> members = memberDao.getList();

        for(Member member : members){

            if(formatter !=null) {
                //formatter가 regDtStr에 regDt를 얻어와 대입
                String regDtStr = formatter.format(member.getRegDt());
                member.setRegDtStr(regDtStr);
            }
            System.out.println(member);

        }
    }
}

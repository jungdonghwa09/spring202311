package models.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor//final쓴것이 생성자의 매개변수로 들어감-final없이 위에
//@Nonnull
public class MemberDao {

    private final MemberMapper mapper;

    public boolean register(Member member){
        int affectedRows = mapper.register(member);
        return affectedRows >0;
    }
    public boolean exist(String userId){
        int cnt = mapper.exist(userId);
        return cnt >0;//1이상이라는 뜻으로, 이미 가입된 아이디

    }
    public Member get(String userId){
        return mapper.get(userId);

    }
    public List<Member> getList(MemberSearch search){
        LocalDate edate = search.getEdate();
        if(edate !=null) {
            LocalDate newEdate = edate.plusDays(1);

            search.setEdate(newEdate);
        }
        //하루를 더해서 select쿼리문으로
        return mapper.getList(search);//MemberMapper의 mapper????
    }
}

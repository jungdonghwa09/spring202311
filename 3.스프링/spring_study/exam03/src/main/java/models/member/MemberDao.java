package models.member;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class MemberDao {
    private static Map<String, Member> members = new HashMap<>();
    public void register(Member member){
        //이게 주석처리되어있으면 실행내용이 안뜸
        members.put(member.getUserId(), member);

    }
    //이미 아이디가 존재하는지 체크
    public boolean exists(String userId){
        return members.containsKey(userId);
    }
    public List<Member> getList(){
        return new ArrayList<>(members.values());
    }
}

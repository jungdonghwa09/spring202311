package models.member;

import config.ManualBean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@ManualBean
@Repository
public class MemberDao {//이건 자동 빈@Repository로 힌트를 주고,
    // 자동 빈 이름이 memberDao

    private static Map<String, Member>members = new HashMap<>();
    public void register(Member member){
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

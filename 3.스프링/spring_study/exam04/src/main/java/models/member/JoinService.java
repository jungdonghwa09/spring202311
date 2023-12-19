package models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
//필요한거-private으로 가져오기
    //외부에서 의존성주입한 이유-cached로 변경하고 싶을 때 여기에 memberDao=new CachedMemberDao
    //로 하면 다 고쳐야 되기 때문에 외부(ServiceManager)에서 MemberDao memberDao()메서드
    //내부에서 new CachedMemberDao를 만드는 기능을 추가하여(의존 주입)야 한다

    private final MemberDao memberDao;
    @NonNull
    private  JoinValidator validator;

    /*public JoinService(MemberDao memberDao, JoinValidator validator){
        this.memberDao = memberDao;
        this.validator=validator;
    }
    */

    public void join(Member member){
        //데이터 검증
        validator.validate(member);
        //데이터 추가
        memberDao.register(member);

    }
}

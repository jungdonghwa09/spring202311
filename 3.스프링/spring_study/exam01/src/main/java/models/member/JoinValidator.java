package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import commons.validators.Validator;

public class JoinValidator implements Validator<Member>, RequiredValidator {
    //내부 구성 요소로써 MemberDao를 상속하는 것 보다 멤버변수로 dao의 기능을 확장받음
    //그러나 이것도 안좋음 , setter, 생성자를 통한 주입(MemberDao의존성 주입)이 더 좋음
    //전략패턴-변화에 닫힘(캡슐화-(MemberDao memberDao)), 확장에는 열림
    
    //private MemberDao를 JoinValidator에서 끌어댕겨오는 이유가 
    //얘가 상속받은 인터페이스 RequiredValidator에서 private MemberDao로 선언하면
    //인터페이스에서는 상수밖에 선언 못하니까(변수 선언 못해서), JoinValidator에서
    //필요한 memberDao변수를 선언했다는 것임
    private MemberDao memberDao;
    public JoinValidator(MemberDao memberDao){
        this.memberDao= memberDao;
    }
    public void validate(Member member){
        /*필수 항목을 검증할 것-아이디, 비번, 비번확인, 회원명

         */

        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

        //필수항목이 null이거나 빈 공백문자이면
        checkRequired(userId, new BadRequestException("아이디를 입력하세요"));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요"));
        checkRequired(confirmPw, new BadRequestException("비밀번호를 올바르게 입력하세요"));
        checkRequired(userNm, new BadRequestException("회원명 입력하세요"));
        
        //아이디가 이미 있는지 체크
        checkFalse(memberDao.exists(userId), new BadRequestException("이미 등록된" +
                        "아이디입니다"));
        
        //비밀번호,비밀번호 확인시 일치 여부-2개 동시에
        checkTrue(userPw.equals(confirmPw),
                new BadRequestException("비밀번호가 일치하지 않습니다"));
            
        
    }
}

package models.member;



public class ServiceManager {
    //멤버변수에 static을 붙여서 외부에서 객체생성 없이도? 사용가능하게?
    //클래스 내부에서 ServiceManager타입의 객체를 생성해놓고, private로(1단계)
    //2단계로 static
    //이 상태면 필요할때만 객체 생성이 안되서 null로 밑에 getInstance에서 객체생성기능 넣기
    private static ServiceManager instance = null;
    //싱글톤
    //기본 생성자-private
    //내부에서 한개를 null로 만들어놓고, 외부에서 접근가능하게 getInstance를 public
    //으로 만들고, static은 왜 붙이는지..
    private ServiceManager(){}

    //정적메서드로, 외부에서 객체없이도 이용가능하게-
    //인스턴스메서드에는 (객체가 되어야 만, 객체의 멤버변수를 사용할 수 있는)this가 있는데, 정적메서드에는 없다

    public static ServiceManager getInstance(){
        if(instance ==null){
            instance = new ServiceManager();
        }
        return instance;
    }
    //필요한 의존성, 의존성 완성까지-memberdao, joinvalidator

    //memberDao를 만들 수 있는 메서드임
    //memberDao틀을 유지하되, 다형성으로 하위클래스인cached이용
    //이 메서드는 MemberDao memberDao= new CachedMemberDao();라는 뜻
    //이게 외부주입한 것 -다 고치지 않고, 통제가 유리하게 됨
    //MemberDao객체 만드는 거
    public MemberDao memberDao(){
        return new CachedMemberDao();
    }
    //JoinValidator객체 만드는 거
    //이 메서드의 리턴값에 memberDao()함수를 넣어주면 자동으로 만들어지게
    public JoinValidator joinValidator(){
        return new JoinValidator(memberDao());
    }
    //JoinService객체 만드는 거
    public JoinService joinService(){
        return new JoinService(memberDao(), joinValidator());
    }
    //ListService객체 만드는 거
    public ListService listService(){
        ListService listService = new ListService();
        listService.setMemberDao(memberDao());

        return listService;
    }
}

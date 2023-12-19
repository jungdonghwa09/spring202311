package exam04;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Ex01 {
    public static void main(String[] args) {
        HashMap<String, String> members = new HashMap<>();

        members.put("user01", "이이름");
        members.put("user02", "김이름");
        members.put("user03", "박이름");

        //members.put("user02", "(수정)김이름");
        //members.remove("user02");
        //String name=members.get("user02");
        //System.out.println(name);

        //HashMap의 메서드 entrySet, 그리고 이 메서드의
        //반환타입이 Map.Entry이고, 이건 키와 값을 같이 관리,그래서
        //entry.getKey(), getValue()로 같이 가져온다-한번에
        Set<Map.Entry<String, String>> entries = members.entrySet();
        for(Map.Entry<String, String> entry : entries){
            System.out.printf("key=%s, value=%s%n",
                    entry.getKey(), entry.getValue());
        }
        //Map.Entry로 같이 관리하게 될 때 그 중 키 값은 중복되지 않아
        //집합Set 타입으로 keySet()메서드로 가져오기 가능
        Set<String> keys = members.keySet();
        System.out.println(keys);

        //Collection으로 값을 values()로 가져오기 가능
        Collection<String> values = members.values();
        System.out.println(values);

    }
}

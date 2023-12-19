package exam01;

import java.util.ArrayList;
import java.util.List;

public class Ex05 {
    public static void main(String[] args) {
        String[] words1 = {"aaa", "aaa", "bb", "ccc","ccc","abcd"};

        List<String> tmp = new ArrayList<>();
        List<String> newWords = new ArrayList<>();

        //중복제거
        for(String word : words1){
            if(!tmp.contains(word)){
                newWords.add(word);
            }
        }
        List<String> newWords2 = new ArrayList<>();
        for(String word : newWords){
            if(word.length()>=3){
                newWords2.add(word);
            }
        }
        for(String word : newWords2){
            System.out.println(word);
        }
    }
}

package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        System.out.print("입력함 : ");
        //char ch = (char)System.in.read();//in은 콘솔에서 입력한거 읽음
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        char ch = (char)br.read();
        //char ch = (char)isr.read();
        System.out.println(ch);
    }
}

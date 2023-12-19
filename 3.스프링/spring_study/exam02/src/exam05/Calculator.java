package exam05;

public interface Calculator {
    int num=10;
    int add(int num1, int num2);

    int minus(int num1, int num2);

    default int multi(int num1, int num2){
        return num1*num2;
    }




}

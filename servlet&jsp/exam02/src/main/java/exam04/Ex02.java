package exam04;

public class Ex02 {
    public static void main(String[] args) {
        Book2 b2 = Book2.builder()
                .title("책2")
                .author("저자2")
                .publisher("출판사2")
                .build();
        System.out.println(b2);

    }
}

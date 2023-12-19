package exam01;

import lombok.*;

//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor(access=AccessLevel.PRIVATE)//기본생성자에 private
//@RequiredArgsConstructor
//@EqualsAndHashCode
@Data
public class book {
    private String title;
  //  @NonNull
    private String author;
    private String publisher;

  /*
    public book(String title){
        this.title=title;
    }
*/
}

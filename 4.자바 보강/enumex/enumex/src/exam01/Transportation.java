package exam01;

public enum Transportation {
    BUS("버스", 1400) {
        //Transportation은 abstract 추상클래스였음
        //그래서 BUS객체 생성 시에 메서드 오버라이딩
        @Override
        public int getTotal(int person) {
            return price*person;
        }
    },
    SUBWAY("지하철", 1450) {
        @Override
        public int getTotal(int person) {
            return price*person;
        }
    },
    TAXI("택시", 4500) {
        @Override
        public int getTotal(int person) {
            return price*person;
        }
    };

    private final String title;
    protected final int price;
    private Transportation(String title, int price){
        this.title=title;
        this.price=price;
    }

    public String getTitle(){
        return title;
    }
    public abstract int getTotal(int person);

}

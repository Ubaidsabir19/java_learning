package practiceWork;
// Immutable Class
// Variable de clear as. Private and final
// Not have a Setter Method

public final class Integer2{

    private final int num1;

    public Integer2(int num1){
        this.num1 = num1;
    }

    public void getNumber() {
        System.out.println(num1);
    }
}

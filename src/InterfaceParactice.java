interface Practice {
    void learn();

    static void getLearn2(){
        System.out.println("Learn Practice Get");
    }

    default void sharedBehavior() {
        System.out.println("This is a shared behavior for all Practice implementations.");
    }

}

class Learn implements Practice{
    @Override
    public void learn() {
        System.out.println("Learn");
    }
}

class ReadLearn implements Practice{
    @Override
    public void learn() {
        System.out.println("Read Learn");
    }
}

public class InterfaceParactice {
    public static void main(String[] args) {
      Practice lrn = new Learn();
      lrn.learn();
      lrn.sharedBehavior();

      Practice readLearn = new ReadLearn();
      readLearn.learn();
      readLearn.sharedBehavior();


      Practice.getLearn2();
    }
}

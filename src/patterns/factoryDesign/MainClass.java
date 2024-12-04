package patterns.factoryDesign;

public class MainClass {
    public static void main(String[] args) {
        Shape shape = FactoryShape.getShape("CIRCLE");
        shape.draw();

        Shape shape2 = FactoryShape.getShape("RECTANGLE");
        shape2.draw();
    }
}

package patterns.factoryDesign;

public class FactoryShape {

    public static Shape getShape(String shapeType) {

        if (shapeType.trim().equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.trim().equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else {
            return null;
        }
    }
}

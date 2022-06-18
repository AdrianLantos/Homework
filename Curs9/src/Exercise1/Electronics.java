package Exercise1;

public class Electronics extends Product {
    private String type;
    private double length;
    private double width;
    private double height;
    private double weight;

    @Override
    public String toString() {
        return "Electronics{" +
                "type='" + type + '\'' +
                ", length=" + length +
                ", width=" + width +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }

    public String getType() {
        return type;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getWeight() {
        return weight;
    }

    public Electronics(int price, String name, String description, int quantity, String type, double width, double length, double height, double weight) {
        super(price, name, description, quantity);
        this.height = height;
        this.length = length;
        this.type = type;
        this.weight = weight;
        this.width = width;
    }
}


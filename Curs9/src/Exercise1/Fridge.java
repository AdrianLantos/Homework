package Exercise1;

public class Fridge extends Electronics {
    private int temperature;

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public Fridge(int price, String name, String description, int quantity, String type, double width, double length, double height, double weight) {
        super(price, name, description, quantity, type, width, length, height, weight);
    }
}

package Exercise1;

public class main {
    public static void main(String[] args) {
        Fridge artic = new Fridge(580, "Artic Chill", "A fridge", 14, "Electrocasnic de dimensiuni mari", 0.7, 0.8, 2.3, 30);
        Cosmetics cremaDeFata = new Cosmetics(80,"Face Cream", "Crema de fata hidratanta", 60, "colorless", 0.500);
        //Nu are logica neaparat. Era doar pentru a face hard-cast mai jos.
        Product cablu = new Fridge(15, "Cablu HDMI", "Cablu de lungime medie", 40, "Calitate medie", 0.08, 2.5, 0.003, 0.35);

        artic.setTemperature(-1);
        System.out.println(artic.getTemperature());
        System.out.println(artic.getPrice());
        System.out.println(cremaDeFata.getColor());
        System.out.println(cremaDeFata.getQuantity());
        cablu = (Electronics)cablu;
        System.out.println(cablu.toString());
    }
}

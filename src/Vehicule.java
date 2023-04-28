public class Vehicule {

    private String color;
    private String brand;
    private String licensePlate;
    private int horsePower;

    public Vehicule( String color, String brand, String licensePlate, int horsePower) {
        this.color = color;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.horsePower = horsePower;
    }


    public String getBrand() {
        return brand;
    }

    public int getHorsePower() {
        return horsePower;
    }
    @Override
    public String toString() {
        return brand + " = " + horsePower ;
    }


}

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opt = 0;
        Algoritmos algoritmos = new Algoritmos();
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        Random random = new Random();
        //Se crean los vehiculos
        Car car = new Car("Mercedes", "Gray", "KES505", 500);
        MotorCycle motorCycle = new MotorCycle("HarleyDavidson", "Black", "AUS203", 200);
        AirPlane airPlane = new AirPlane("Airbus", "White", "AK22", 6000);
        BackHoe backHoe = new BackHoe("Caterpillar", "Yellow", "AS332", 350);
        Submarine submarine = new Submarine("Putin", "Gray", "A173NSN221", 1000);
        Bicycle bicycle = new Bicycle("BMX", "Green", "213124", 2);

        Vehicule[] vehiculos = {car, motorCycle, airPlane, backHoe, submarine, bicycle};
        //Se clona el arreglo de vehiculos
        Vehicule[] copiaVehiculos = vehiculos.clone();
        //Se crea un arreglo de marcas y caballos d fuerza que se generan aleatoriamente
        String[] letras = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        int[] horsePowers = {500, 200, 6000, 350, 1000, 2};
        //se crea el arreglo con 10k vehiculos
        copiaVehiculos = new Vehicule[10000];
            //bucle que crea los vehiculos aleatoriamente
        for (int i = 0; i < copiaVehiculos.length; i++) {
            String brands = letras[random.nextInt(26)] + letras[random.nextInt(26)] + letras[random.nextInt(26)];
            int numRandom = random.nextInt(6);
            if (numRandom == 0) {
                copiaVehiculos[i] = new Car(brands, "Gray", "KES" + random.nextInt(1000), random.nextInt(horsePowers[numRandom]));
            } else if (numRandom == 1) {
                copiaVehiculos[i] = new MotorCycle(brands, "Black", "AUS" + random.nextInt(1000), random.nextInt(horsePowers[numRandom]));
            } else if (numRandom == 2) {
                copiaVehiculos[i] = new AirPlane(brands, "White", "AK" + random.nextInt(100), random.nextInt(horsePowers[numRandom]));
            } else if (numRandom == 3) {
                copiaVehiculos[i] = new BackHoe(brands, "Yellow", "AS" + random.nextInt(1000), random.nextInt(horsePowers[numRandom]));
            } else if (numRandom == 4) {
                copiaVehiculos[i] = new Submarine(brands, "Gray", "A" + random.nextInt(1000) + "NSN" + random.nextInt(1000), random.nextInt(horsePowers[numRandom]));
            } else if (numRandom == 5) {
                copiaVehiculos[i] = new Bicycle(brands, "Green", String.valueOf(random.nextInt(1000000)), random.nextInt(horsePowers[numRandom]));
            }
        }
        System.out.println("Por favor ingrese la opción con la que desea ordenar el arreglo según caballos de fuerza");
        System.out.println("1 [Bubble Sort]\n2 [Selected Sort]\n3 [Insertion Sort]\n4 [Merge Sort]\n5 [Shell Sort]\n6 [Quick Sort]");

        try {
            opt = scanner.nextInt();
            if (opt < 1 || opt > 6) {
                throw new IllegalArgumentException("Por favor ingrese un número entre 1 y 6.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese solo numeros");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println("Por favor ingrese un número entre 1 y 6");
            return;
        }
        System.out.println(controller.getArray(copiaVehiculos, opt));
    }
}
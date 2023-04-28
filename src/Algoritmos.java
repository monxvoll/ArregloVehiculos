import java.util.Arrays;
import java.util.Optional;

public class Algoritmos {

    //Metodo ( Bubble sort ) que ordena los vehiculos segun su atributo
    public Vehicule[] bubbleSort(Vehicule[] copiaVehiculos ) {
        long startTime = System.currentTimeMillis();
        int arrayLength = copiaVehiculos.length;
            for (int i = 0; i < arrayLength - 1; i++) {
                for (int j = 0; j < arrayLength - i - 1; j++) {
                    if (copiaVehiculos[j].getHorsePower() > copiaVehiculos[j + 1].getHorsePower()) {
                        Vehicule temp = copiaVehiculos[j];
                        copiaVehiculos[j] = copiaVehiculos[j + 1];
                        copiaVehiculos[j + 1] = temp;
                    }
                }
            }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos.");
        return  copiaVehiculos;
    }
    //Metodo secuencial para hallar la ubicacion en el arreglo de un vehiculo
    public int sequentialAlgorithm(Vehicule[] copiaVehiculos , String name) {
        for (int i = 0; i < copiaVehiculos.length; i++) {
            if(copiaVehiculos[i].getBrand() == name){
                return i;
            }
        }

        return 999;
    }

    //Metodo ( Selected sort ) que ordena los vehiculos segun su atributo

    public Vehicule[] selectedSort(Vehicule[] copiaVehiculos){
        long startTime = System.currentTimeMillis();
        int arrayLength = copiaVehiculos.length;
            for (int i = 0; i < arrayLength - 1; i++) {
                int pos = i;
                for (int j = i + 1; j < arrayLength; j++) {
                    if (copiaVehiculos[j].getHorsePower() < copiaVehiculos[pos].getHorsePower()) {
                        pos = j;
                    }
                }
                Vehicule temp = copiaVehiculos[pos];
                copiaVehiculos[pos] = copiaVehiculos[i];
                copiaVehiculos[i] = temp;
            }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos.");
        return copiaVehiculos;
    }
    //Metodo binarie para hallar la ubicacion en el arreglo de un vehiculo
    public int binarie(Vehicule[] copiaVehiculos, String name) {
        int minValue = 0;
        int maxValue = copiaVehiculos.length ;

        while (minValue <= maxValue) {
            int midValue = (minValue + maxValue) / 2;

            if (copiaVehiculos[midValue].getBrand().compareTo(name) == 0) {
                return midValue;
            } else if (copiaVehiculos[midValue].getBrand().compareTo(name) < 0) {
                minValue = midValue + 1;
            } else {
                maxValue = midValue - 1;
            }
        }

        return 999; // El valor no se encontró
    }

    ///Metodo ( Insertion sort ) que ordena los vehiculos segun su atributo
    public Vehicule[] insertionSort(Vehicule[] copiaVehiculos) {
        long startTime = System.currentTimeMillis();
        int arrayLength = copiaVehiculos.length;

            for (int i = 0; i < arrayLength; i++) {
                Vehicule element = copiaVehiculos[i];
                int aux = i - 1;
                while (aux >= 0 && copiaVehiculos[aux].getHorsePower() > element.getHorsePower()) {
                    copiaVehiculos[aux + 1] = copiaVehiculos[aux];
                    aux--;
                }
                copiaVehiculos[aux + 1] = element;
            }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos.");
        return copiaVehiculos;
    }
    //Metodo (Merge sort) que ordena los vehiculos segun su atributo
    public Vehicule[] mergeSort(Vehicule[] copiaVehiculos) {
        long startTime = System.currentTimeMillis();
        int arrayLength = copiaVehiculos.length;
            if (copiaVehiculos.length > 1) {
                int mid = copiaVehiculos.length / 2;
                Vehicule[] left = Arrays.copyOfRange(copiaVehiculos, 0, mid);
                Vehicule[] right = Arrays.copyOfRange(copiaVehiculos, mid, copiaVehiculos.length);
                mergeSort(left);
                mergeSort(right);
                merge(copiaVehiculos, left, right);
            }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos.");
            return copiaVehiculos;
    }

    public  void merge(Vehicule[] copiaVehiculos, Vehicule[] izquierda , Vehicule[] derecha) {
        int i = 0, j = 0, k = 0;
        while (i < izquierda.length && j < derecha.length) {
            if (izquierda[i].getHorsePower() <= derecha[j].getHorsePower()) {
                copiaVehiculos[k++] = izquierda[i++];
            } else {


                copiaVehiculos[k++] = derecha[j++];
            }
        }
        while (i < izquierda.length) {
            copiaVehiculos[k++] = izquierda[i++];
        }
        while (j < izquierda.length) {
            copiaVehiculos[k++] = derecha[j++];
        }
    }

    //Metodo (Shell sort) que ordena los vehiculos segun su atributo
    public Vehicule[] shellSort(Vehicule[] copiaVehiculos) {
        long startTime = System.currentTimeMillis();
        int arrayLength = copiaVehiculos.length;
            int arrayA = arrayLength / 2;

            while (arrayA > 0) {
                for (int i = arrayA; i < arrayLength; i++) {
                    Vehicule temp = copiaVehiculos[i];
                    int j = i;

                    while (j >= arrayA && copiaVehiculos[j - arrayA].getHorsePower() > temp.getHorsePower()) {
                        copiaVehiculos[j] = copiaVehiculos[j - arrayA];
                        j -= arrayA;
                    }

                    copiaVehiculos[j] = temp;
                }
                arrayA /= 2;
            }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos.");
        return copiaVehiculos;
    }

    //Metodo (Quick sort) que ordena los vehiculos segun su atributo
    public Vehicule[] quickSort(Vehicule[] copiaVehiculos) {
            //Metodo que devuelve el arreglo ordenado
        long startTime = System.currentTimeMillis();
        int arrayLength = copiaVehiculos.length;

        quickSort(copiaVehiculos, 0, copiaVehiculos.length - 1);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Tiempo de ejecución: " + totalTime + " milisegundos.");
        return copiaVehiculos;

    }

    private void quickSort(Vehicule[] copiaVehiculos, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int aux = quick(copiaVehiculos, izquierda, derecha);
            quickSort(copiaVehiculos, izquierda, aux - 1);
            quickSort(copiaVehiculos, aux + 1, derecha);
        }
    }

    private int quick(Vehicule[] copiaVehiculos, int izquierda, int derecha) {
        Vehicule aux = copiaVehiculos[derecha];
        int i = izquierda - 1;
        for (int j = izquierda; j < derecha; j++) {
            if (copiaVehiculos[j].getHorsePower() <= aux.getHorsePower()) {
                i++;
                Vehicule temp = copiaVehiculos[i];
                copiaVehiculos[i] = copiaVehiculos[j];
                copiaVehiculos[j] = temp;
            }
        }
        Vehicule temp = copiaVehiculos[i + 1];
        copiaVehiculos[i + 1] = copiaVehiculos[derecha];
        copiaVehiculos[derecha] = temp;
        return i + 1;
    }
}

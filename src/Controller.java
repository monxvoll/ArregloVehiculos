import java.util.Arrays;
import java.util.InputMismatchException;

public class Controller {
  private  Algoritmos algoritmos;

    public void option(Vehicule[] copiaVehiculos, int opt){
        algoritmos = new Algoritmos();
            if (opt ==1 ) {
                algoritmos.bubbleSort(copiaVehiculos);
            } else if (opt ==2) {
                algoritmos.selectedSort(copiaVehiculos);
            } else if (opt ==3) {
                algoritmos.insertionSort(copiaVehiculos);
            } else if (opt ==4) {
                algoritmos.mergeSort(copiaVehiculos);
            } else if (opt ==5) {
                algoritmos.shellSort(copiaVehiculos);
            } else if (opt ==6) {
                algoritmos.quickSort(copiaVehiculos);
            }
    }
        public String getArray(Vehicule[] copiaVehiculos , int opt){
        option(copiaVehiculos , opt);
        return Arrays.toString(copiaVehiculos);
    }
}

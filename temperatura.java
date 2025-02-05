import java.util.Scanner;
public class temperatura {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese numero de dias del mes que se va a utilizar: ");
        int numDias = scanner.nextInt();
        
        double[] temperaturas = new double[numDias];
        double[] predicciones = new double[numDias];
        int[] distribucion = new int[5];
        
        System.out.println("Ingrese las temperaturas del mes");
        for (int i = 0; i < numDias; i++) {
            System.out.print("Temperatura Dia " + (i + 1) + ": ");
            temperaturas[i] = scanner.nextDouble();
        }
        
        mostrarTempExtrema(temperaturas);
        double promedioTemp = calcularPromedioTemp(temperaturas);
        System.out.printf("El promedio de temperatura del mes es: %.2f%n" , promedioTemp);
        int diasProm = contarDiasProm(temperaturas, promedioTemp);
        System.out.println("El numero de dias por encima del promedio es: " + diasProm);
        
        calcularDistribucion(temperaturas, distribucion);
        mostrarTablaDistribucion(distribucion);
        System.out.println("Temperaturas Extremas: ");
        temperaturasExtremas(temperaturas);
        generarPredicciones(temperaturas, predicciones);
        mostrarPredicciones(predicciones);
        
        scanner.close();
    }
    
    public static void mostrarTempExtrema(double[] temperaturas) {
        double tempMaxima = temperaturas[0];
        double tempMinima = temperaturas[0];
        
        for (double temp : temperaturas) {
            if (temp < tempMinima) tempMinima = temp;
            if (temp > tempMaxima) tempMaxima = temp;
        }
        
        System.out.println("La temperatura mas alta es: " + tempMaxima);
        System.out.println("La temperatura mas baja es: " + tempMinima);
    }
    
    public static double calcularPromedioTemp(double[] temperaturas) {
        double suma = 0;
        for (double temp : temperaturas) {
            suma += temp;
        }
        return suma / temperaturas.length;
    }
    
    public static int contarDiasProm(double[] temperaturas, double promedio) {
        int contador = 0;
        for (double temp : temperaturas) {
            if (temp > promedio) {
                contador++;
            }
        }
        return contador;
    }
    
    public static void calcularDistribucion(double[] temperaturas, int[] distribucion) {
        for (double temp : temperaturas) {
            if (temp < 10) distribucion[0]++;
            else if (temp < 20) distribucion[1]++;
            else if (temp < 30) distribucion[2]++;
            else if (temp < 40) distribucion[3]++;
            else distribucion[4]++;
        }
    }
    
    public static void mostrarTablaDistribucion(int[] distribucion) {
        System.out.println("\nTabla de Distribucion de Temperaturas:");
        System.out.println("----------------------------------------");
        System.out.println("| Rango de Temperatura  | Dias        |");
        System.out.println("----------------------------------------");
        System.out.println("| Menos de 10C       | " + distribucion[0] + " dias |");
        System.out.println("| 10C - 19C          | " + distribucion[1] + " dias |");
        System.out.println("| 20C - 29C          | " + distribucion[2] + " dias |");
        System.out.println("| 30C - 39C          | " + distribucion[3] + " dias |");
        System.out.println("| 40C o mas          | " + distribucion[4] + " dias |");
        System.out.println("----------------------------------------");
    }
    
    public static void temperaturasExtremas(double[] temperaturas) {
        double promedio = calcularPromedioTemp(temperaturas);
        for (int i = 0; i < temperaturas.length; i++) {
            if (temperaturas[i] > promedio) {
                System.out.println("Dia " + (i + 1) + " - Temperatura: " + temperaturas[i]);
            }
        }
    }
    
    public static void generarPredicciones(double[] temperaturas, double[] predicciones) {
        for (int i = 0; i < temperaturas.length - 1; i++) {
            predicciones[i] = (temperaturas[i] + temperaturas[i + 1]) / 2;
        }
        predicciones[temperaturas.length - 1] = temperaturas[temperaturas.length - 1];
    }
    
    public static void mostrarPredicciones(double[] predicciones) {
        System.out.println("\nPredicciones de temperatura para los proximos dias:");
        for (int i = 0; i < predicciones.length; i++) {
            System.out.printf("Dia " + (i + 1) + " - Temperatura estimada: %.2f%n" ,predicciones[i]);
        }
    }
}

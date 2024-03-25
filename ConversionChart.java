public class ConversionChart {
   /** prints charts */ 
    public static void main(String[] args) {
        System.out.println("Feet      Meters");
        for (double feet = 1.0; feet <= 10.0; feet++) {
            System.out.printf("%-10.1f%-10.3f\n", feet, footToMeter(feet));
        }
        
        System.out.println("\nMeters    Feet");
        for (double meters = 20.0; meters <= 65.0; meters += 5.0) {
            System.out.printf("%-10.1f%-10.3f\n", meters, meterToFoot(meters));
        }
    }
    
    /** Conversion for feet to meters */
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }
    /** Coversion for meters to feet */
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }
}

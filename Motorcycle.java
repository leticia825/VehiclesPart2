/** This program is subclass of abstract Vehicle.
* CPSC 1223   Project 5
* @author Leticia Garcia 
* @version 9.20.2020 */
public class Motorcycle extends Vehicle {

   protected double engineSize;
   /** tax rate. */
   public static final double TAX_RATE = 0.005;
   /** alternative fuel tax rate. */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.0025;
   /** large bike threshold. */
   public static final double LARGE_BIKE_CC_THRESHOLD = 499;
   /** large bike tax rate. */
   public static final double LARGE_BIKE_TAX_RATE = 0.015;

/** constructor.
@param ownerIn String
@param yearMakeModelIn String
@param valueIn double
@param alternativeFuelIn boolean 
@param engineSizeIn double */
   public Motorcycle(String ownerIn, String yearMakeModelIn, double valueIn,
                              boolean alternativeFuelIn, double engineSizeIn) {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
      engineSize = engineSizeIn;
   }
   
/** getSize.
@return engineSize double */
   public double getEngineSize() {
      return engineSize;
   }

/** setSize.
@param engineSizeSet double */
   public void setEngineSize(double engineSizeSet) {
      engineSize = engineSizeSet;
   }

/** useTax.
@return total double */
   public double useTax() {
      double total;
   
      if (alternativeFuel) {
         total = value * ALTERNATIVE_FUEL_TAX_RATE;
      }
      
      else {
         total = value * TAX_RATE;
      }
      if (engineSize > LARGE_BIKE_CC_THRESHOLD) {
         total += value * LARGE_BIKE_TAX_RATE;
      }
   
      return total;
   }

/** toString.
@return outputM String */
   public String toString() {
      String outputC = super.toString();
      String outputM = outputC.replace(": Car", ": Motorcycle");
   
      outputM += "\nwith Tax Rate: ";
      outputM += (alternativeFuel)
            ? ALTERNATIVE_FUEL_TAX_RATE : TAX_RATE;
      
      outputM += (engineSize > LARGE_BIKE_CC_THRESHOLD)
            ? " Large Bike Tax Rate: " + LARGE_BIKE_TAX_RATE : "";
            
      return outputM;
   }

}
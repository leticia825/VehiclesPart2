/** This program is subclass of abstract Vehicle.
* CPSC 1223   Project 5
* @author Leticia Garcia 
* @version 9.20.2020 */

public class Car extends Vehicle {
   
   /** tax rate. */
   public static final double TAX_RATE = 0.01;
   /** alternate fuel tax rate. */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.005;
   /** luxury threshold. */
   public static final double LUXURY_THRESHOLD = 50000; //NUM WRITTEN 50_000 
   /** luxury tax rate. */
   public static final double LUXURY_TAX_RATE = 0.02;

/** constructor.
@param ownerIn String
@param yearMakeModelIn String
@param valueIn double
@param alternativeFuelIn boolean */
   public Car(String ownerIn, String yearMakeModelIn, double valueIn,
                                                 boolean alternativeFuelIn) {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
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
   
      if (value > LUXURY_THRESHOLD) {
         total += value * LUXURY_TAX_RATE;
      }
   
   
      return total;
   }

/** toString.
@return output String */
   public String toString() {
      String output = super.toString() + "\nwith Tax Rate: ";
   
      output += alternativeFuel ? ALTERNATIVE_FUEL_TAX_RATE : TAX_RATE;
   
      output += value > LUXURY_THRESHOLD 
                                  ? " Luxury Tax Rate: " + LUXURY_TAX_RATE : "";
   
      return output;
   }

}
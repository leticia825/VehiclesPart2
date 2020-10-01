/** This program is subclass of abstract Vehicle.
* CPSC 1223   Project 5
* @author Leticia Garcia 
* @version 9.20.2020 */

public class Truck extends Vehicle {  

   protected double tons;
   /** tax rate. */
   public static final double TAX_RATE = 0.02;
   /** alternative fuel tax rate. */
   public static final double ALTERNATIVE_FUEL_TAX_RATE = 0.01;
   /** large truck threshold. */
   public static final double LARGE_TRUCK_TONS_THRESHOLD = 2.0;
   /** large truck tax rate. */
   public static final double LARGE_TRUCK_TAX_RATE = 0.03;

/** constructor.
@param ownerIn String
@param yearMakeModelIn String
@param valueIn double
@param alternativeFuelIn boolean 
@param tonsIn double */
   public Truck(String ownerIn, String yearMakeModelIn, double valueIn,
                                boolean alternativeFuelIn, double tonsIn) {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn);
      tons = tonsIn;
   }
   
   /** getTons.
   @return tons double */
   public double getTons() {
      return tons;
   }
   
   /** setTons.
   @param tonsSet double */
   public void setTons(double tonsSet) {
      tons = tonsSet;
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
   
      if (tons > LARGE_TRUCK_TONS_THRESHOLD) {
         total += value * LARGE_TRUCK_TAX_RATE;
      }
      
      return total;
   }
   
   /** toString.
   @return output String */
   public String toString() {
      String output = super.toString() + "\nwith Tax Rate: ";
     
      output += alternativeFuel ? ALTERNATIVE_FUEL_TAX_RATE : TAX_RATE;
   
      output += tons > LARGE_TRUCK_TONS_THRESHOLD
                        ? " Large Truck Tax Rate: " + LARGE_TRUCK_TAX_RATE : "";
   
      return output;
   } 
  
}
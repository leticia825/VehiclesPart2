/** This program is subclass of Truck.
* CPSC 1223   Project 5
* @author Leticia Garcia 
* @version 9.20.2020 */
public class SemiTractorTrailer extends Truck {

   protected int axles; 
   /** Per axle tax rate. */
   public static final double PER_AXLE_TAX_RATE = 0.005;

/** constructor.
@param ownerIn String
@param yearMakeModelIn String
@param valueIn double
@param alternativeFuelIn boolean 
@param tonsIn double 
@param axlesIn int */
   public SemiTractorTrailer(String ownerIn, String yearMakeModelIn, 
        double valueIn, boolean alternativeFuelIn, double tonsIn, int axlesIn) {
      super(ownerIn, yearMakeModelIn, valueIn, alternativeFuelIn, tonsIn);
      axles = axlesIn;
   }

/** getAxles.
@return axles int */
   public int getAxles() {
      return axles;
   } 

/** setAxles.
@param axlesSet int
@return axles int */
   public int setAxles(int axlesSet) {
      axles = axlesSet;
      return axles;
   }

/** useTax.
@return total double */
   public double useTax() {
      double total = super.useTax(); 
      total += value * PER_AXLE_TAX_RATE * axles;
      return total;
   }
   
   /** toString.
   @return output String */
   public String toString() {
      String output = super.toString();
      output += " Axle Tax Rate: " + PER_AXLE_TAX_RATE * axles;
      return output;
   }

}
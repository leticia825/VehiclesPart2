import java.text.DecimalFormat;
/** This program stores vehicle data & proveides methods to access data.
* CPSC 1223   Project 5
* @author Leticia Garcia 
* @version 9.20.2020 */

public abstract class Vehicle implements Comparable<Vehicle> {

   protected String owner, yearMakeModel;
   protected double value;
   protected boolean alternativeFuel;
   protected static int vehicleCount = 0;

/** constructor.
@param ownerIn String
@param yearMakeModelIn String
@param valueIn double
@param alternativeFuelIn boolean */
   public Vehicle(String ownerIn, String yearMakeModelIn, double valueIn,
                                                    boolean alternativeFuelIn) {
      owner = ownerIn;
      yearMakeModel = yearMakeModelIn;
      value = valueIn;
      alternativeFuel = alternativeFuelIn;
   
      vehicleCount++;
   }

/** compare object by owner.
@param objectIn Vehicle
@return int; */
   public int compareTo(Vehicle objectIn) {
      return owner.compareTo(objectIn.owner); 
      // (-) owner alphabetically before objectIn.owner
      // (+) vis versa
      // (0) same owner
   }


/** getOwner.
@return owner String */
   public String getOwner() {
      return owner;
   }
   
/** setOwner.
@param ownerSet String */
   public void setOwner(String ownerSet) {
      owner = ownerSet;
   }
  
/** getyearMakeModel.
@return yearMakeModel String */
   public String getYearMakeModel() {
      return yearMakeModel;
   }

/** setYearMakeModel.
@param yearMakeModelSet String */
   public void setYearMakeModel(String yearMakeModelSet) {
      yearMakeModel = yearMakeModelSet;
   }

/** getValue.
@return value double */
   public double getValue() {
      return value;
   }

/** setValue.
@param valueSet double */
   public void setValue(double valueSet) {
      value = valueSet;
   }

/** getAlternativeFuel.
@return alternativeFuel String */
   public boolean getAlternativeFuel() {
      return alternativeFuel;
   }
   
 /** setAlternativeFuel.
@param alternativeFuelSet boolean */
   public void setAlternativeFuel(boolean alternativeFuelSet) {
      alternativeFuel = alternativeFuelSet;
   }

/** getVehicleCount.
@return vehicleCount int */
   public static int getVehicleCount() {
      return vehicleCount;
   }

/** resetVehicleCount.
@return vehicleCount int */
   public static int resetVehicleCount() { //static cuz static variable
      vehicleCount = 0;
      return vehicleCount;
   }
   
   
/** abstract useTax.
@return double */
   public abstract double useTax();   //need body in subclass


/** toString.
@return output String */
   public String toString() {
      DecimalFormat f = new DecimalFormat("$#,##0.00");
   
      String output = getOwner() + ": Car " + getYearMakeModel();
      if (alternativeFuel) {
         output += " (Alternative Fuel)";
      } 
      output += "\nValue: " + f.format(getValue()) + " Use Tax: " 
             + f.format(useTax());
   
      return output; //must be included in all prints
   }
   
/** equals.
@param obj the other object
@return boolean */
   public boolean equals(Object obj) {
      if (!(obj instanceof Vehicle)) {
         return false;
      }
      
      else {
         Vehicle other = (Vehicle) obj;
         return (owner + yearMakeModel + value).
            equals(other.owner + other.yearMakeModel + other.value);
      }
   
   }
   
/** @return 0 */
   public int hashCode() {
      return 0;
   }
   
}
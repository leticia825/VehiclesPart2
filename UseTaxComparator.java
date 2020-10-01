import java.util.Comparator;
/** UseTaxComparator.
to order Use Tax ascendingly */
public class UseTaxComparator implements Comparator<Vehicle> {

/** compare.
@param v1 Vehicle
@param v2 Vehicle 
@return int */
   public int compare(Vehicle v1, Vehicle v2) {
      if (v1.useTax() < v2.useTax()) {
         return -1;
      }
      
      else if (v1.useTax() > v2.useTax()) {
         return 1;
      }
      
      else {
         return 0;
      }
   }

}
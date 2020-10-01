import org.junit.Assert;
import java.io.FileNotFoundException;
import org.junit.Test;
/** test VehiclesPart2. */

public class VehiclesPart2Test {

/** test vehiclePart2. 
@throws FileNotFoundException here */
   @Test public void vehiclePart2Test() throws FileNotFoundException {
      VehiclesPart2 obj = new VehiclesPart2();  // test constuctor
      Vehicle.resetVehicleCount();
      String[] args = {"vehicles1.txt"}; 
      VehiclesPart2.main(args);
      Assert.assertEquals(8, Vehicle.getVehicleCount());
   }
}

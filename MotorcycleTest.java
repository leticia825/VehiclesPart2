import org.junit.Assert;
import org.junit.Test;
/** test Motorcycle. */

public class MotorcycleTest {

/** test get&setEngineSize. */
   @Test public void getSetEngineSizeTest() {
      Motorcycle m = new Motorcycle("Bo", "2020 tricycle", 14000, false, 750);
      m.setEngineSize(700);
      Assert.assertEquals(700, m.getEngineSize(), 0.000001);
   }
/** test useTax1. */
   @Test public void useTaxTest() {
      Motorcycle m = new Motorcycle("Bo", "2020 tricycle", 14000, false, 750);
      Assert.assertEquals(280, m.useTax(), 0.000001);
   }
/** test useTax2. */
   @Test public void useTaxTest2() {
      Motorcycle m = new Motorcycle("Bo", "2020 tricycle", 14000, true, 750);
      Assert.assertEquals(245, m.useTax(), 0.000001);
   }

/** test toString. */
   @Test public void toStringTest1() {
      Motorcycle m = new Motorcycle("Bo", "2020 tricycle", 14000, false, 750);
      String output = "Bo: Motorcycle 2020 tricycle"
             + "\nValue: $14,000.00 Use Tax: $280.00"
             + "\nwith Tax Rate: 0.005 Large Bike Tax Rate: 0.015";
      Assert.assertEquals(output, m.toString());
   }

/** test toString. */
   @Test public void toStringTest2() {
      Motorcycle m = new Motorcycle("Bo", "2020 tricycle", 14000, false, 400);
      String output = "Bo: Motorcycle 2020 tricycle"
             + "\nValue: $14,000.00 Use Tax: $70.00"
             + "\nwith Tax Rate: 0.005";
      Assert.assertEquals(output, m.toString());
   }

//.end
}

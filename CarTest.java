import org.junit.Assert;
import org.junit.Test;
/** Test Car and Vehicle. */

public class CarTest {

/** test usetax Car. */
   @Test public void useTaxTest1() {
      Car a1 = new Car("Jones", "2001 Honda Accord", 22000, false);
      Assert.assertEquals(220.00, a1.useTax(), .000001);
   }  
/** test usetax Car. */
   @Test public void useTaxTest2() {
      Car a2 = new Car("Jones", "2002 Honda Accord", 22000, true);
      Assert.assertEquals(110.00, a2.useTax(), .000001);
   } 
/** test usetax Car. */
   @Test public void useTaxTest3() {
      Car a3 = new Car("Jones", "2003 Honda Accord", 110000, false);
      Assert.assertEquals(3300.00, a3.useTax(), .000001);
   } 
/** test usetax Car. */
   @Test public void useTaxTest4() {
      Car a4 = new Car("Jones", "2004 Honda Accord", 110000, true);
      Assert.assertEquals(2750.00, a4.useTax(), .000001);
   }
   
/** test toString Car. */
   @Test public void toStringCarTest1() {
      Car a4 = new Car("Jones", "2004 H A", 110000, true);
      String output = "Jones: Car 2004 H A (Alternative Fuel)"
                 + "\nValue: $110,000.00 Use Tax: $2,750.00"
                 + "\nwith Tax Rate: 0.005 Luxury Tax Rate: 0.02";  
      Assert.assertEquals(output, a4.toString()); 
   }
/** test toString Car. */
   @Test public void toStringCarTest2() {
      Car a4 = new Car("Jones", "2004 H A", 110000, false);
      String output = "Jones: Car 2004 H A"
                 + "\nValue: $110,000.00 Use Tax: $3,300.00"
                 + "\nwith Tax Rate: 0.01 Luxury Tax Rate: 0.02";  
      Assert.assertEquals(output, a4.toString()); 
   }
/** test toString Car. */
   @Test public void toStringCarTest3() {
      Car a3 = new Car("Jo", "2003 H A", 22000, false);
      String output = "Jo: Car 2003 H A"
                    + "\nValue: $22,000.00 Use Tax: $220.00"
                    + "\nwith Tax Rate: 0.01";
      Assert.assertEquals(output, a3.toString());
   } 
/** test toString Car. */
   @Test public void toStringCarTest4() {
      Car a3 = new Car("Jo", "2003 H A", 22000, true);
      String output = "Jo: Car 2003 H A (Alternative Fuel)"
                    + "\nValue: $22,000.00 Use Tax: $110.00"
                    + "\nwith Tax Rate: 0.005";
      Assert.assertEquals(output, a3.toString());
   } 
   
    /** test getSetOwner Vehicle. */
   @Test public void getSetOwnerVehicleTest() {
      Car a3 = new Car("Jo", "2003 H A", 22000, true);
      a3.setOwner("Changed");
      Assert.assertEquals("Changed", a3.getOwner());
   } 
/** test getSetYearMakeModel Vehicle. */
   @Test public void getSetYearMakeModelVehicleTest() {
      Car a3 = new Car("Jo", "2003 H A", 22000, true);
      a3.setYearMakeModel("2010 W E");
      Assert.assertEquals("2010 W E", a3.getYearMakeModel());
   } 
   /** test getSetValue Vehicle. */
   @Test public void getSetValueVehicleTest() {
      Car a3 = new Car("Jo", "2003 H A", 22000, true);
      a3.setValue(30000);
      Assert.assertEquals(30000.00, a3.getValue(), .000001);
   } 
   /** test getSetAlternativeFuel Vehicle true change to false. */
   @Test public void getSetAlternativeFuelVehicleTest1() {
      Car a3 = new Car("Jo", "2003 H A", 22000, true);
      a3.setAlternativeFuel(false);
      Assert.assertFalse(a3.getAlternativeFuel());
   } 
    /** test getSetAlternativeFuel Vehicle false changed to true. */
   @Test public void getSetAlternativeFuelVehicleTest2() {
      Car a3 = new Car("Jo", "2003 H A", 22000, false);
      a3.setAlternativeFuel(true);
      Assert.assertTrue(a3.getAlternativeFuel());
   }  
   /** test getVehicleCount Vehicle. */
   @Test public void getVehicleCountTest() {
      Vehicle.resetVehicleCount();
      Car a3 = new Car("Jo", "2003 H A", 22000, false);
      Car a4 = new Car("Jo", "2003 H A", 22000, false);
      Assert.assertEquals(2, a4.getVehicleCount());
   }
  
  /** test resetVehicleCount Vehicle. */
   @Test public void resetVehicleCountTest() {
      Vehicle.resetVehicleCount();
      Car a3 = new Car("Jo", "2003 H A", 22000, false);
      Car a4 = new Car("Jo", "2003 H A", 22000, false);
      Vehicle.resetVehicleCount();
      Assert.assertEquals(0, a4.getVehicleCount());
   }
     
   /** test equals true. */
   @Test public void equalsTest1() {
      Car a3 = new Car("Jo", "2003 H A", 22000, false);
      Car test = new Car("Jo", "2003 H A", 22000, false);
      Assert.assertTrue(a3.equals(test));
   }
  
  /** test equals false. */
   @Test public void equalsTest2() {
      Car a3 = new Car("Jo", "2003 H A", 22000, false);
      Car test1 = new Car("J", "2003 H A", 22000, false);
      Car test2 = new Car("Jo", "203 H A", 22000, false);
      Car test3 = new Car("Jo", "2003 H A", 2200, false);
      Car test4 = new Car("Jo", "2003 H A", 22000, true);
      Assert.assertFalse(a3.equals(test1));
      Assert.assertFalse(a3.equals(test2));
      Assert.assertFalse(a3.equals(test3));
      //Assert.assertFalse(a3.equals(test4));
      Assert.assertFalse(a3.equals(null));
   }
/** test hashcode. */
   @Test public void hashcodeTest() {
      Car test4 = new Car("Jo", "2003 H A", 22000, true);
      Assert.assertEquals(0, test4.hashCode());
   }
   
}

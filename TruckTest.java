import org.junit.Assert;
import org.junit.Test;
/** test Truck. */

public class TruckTest {

/** test get&setTons. */
   @Test public void getSetTonsTest() {
      Truck t = new Truck("Liam", "2020 Y M", 30000, false, 1.5);
      t.setTons(1);
      Assert.assertEquals(1, t.getTons(), .000001);
   } 

/** test useTax. */
   @Test public void useTaxTest1() {
      Truck t = new Truck("Liam", "2020 Y M", 30000, false, 1.5);
      Assert.assertEquals(600, t.useTax(), .000001);
   }
 /** test useTax. */
   @Test public void useTaxTest2() {
      Truck t = new Truck("Liam", "2020 Y M", 30000, false, 2.5);
      Assert.assertEquals(1500, t.useTax(), .000001);
   }  
 /** test useTax. */
   @Test public void useTaxTest3() {
      Truck t = new Truck("Liam", "2020 Y M", 30000, true, 1.5);
      Assert.assertEquals(300, t.useTax(), .000001);
   } 
 /** test useTax. */
   @Test public void useTaxTest4() {
      Truck t = new Truck("Liam", "2020 Y M", 30000, true, 2.5);
      Assert.assertEquals(1200, t.useTax(), .000001);
   }
   
 /** test toString. */ 
   @Test public void toStringTest1() {
      Truck t = new Truck("Liam", "20 Y M", 30000, false, 1.5);
      String output = "Liam: Car 20 Y M"
                 + "\nValue: $30,000.00 Use Tax: $600.00"
                 + "\nwith Tax Rate: 0.02";  
      Assert.assertEquals(output, t.toString()); 
   }
  /** test toString. */ 
   @Test public void toStringTest2() {
      Truck t = new Truck("Liam", "20 Y M", 30000, false, 2.5);
      String output = "Liam: Car 20 Y M"
                 + "\nValue: $30,000.00 Use Tax: $1,500.00"
                 + "\nwith Tax Rate: 0.02 Large Truck Tax Rate: 0.03";  
      Assert.assertEquals(output, t.toString()); 
   }
  /** test toString. */ 
   @Test public void toStringTest3() {
      Truck t = new Truck("Liam", "20 Y M", 30000, true, 1.5);
      String output = "Liam: Car 20 Y M (Alternative Fuel)"
                 + "\nValue: $30,000.00 Use Tax: $300.00"
                 + "\nwith Tax Rate: 0.01";  
      Assert.assertEquals(output, t.toString()); 
   }
  /** test toString. */ 
   @Test public void toStringTest4() {
      Truck t = new Truck("Liam", "20 Y M", 30000, true, 2.5);
      String output = "Liam: Car 20 Y M (Alternative Fuel)"
                 + "\nValue: $30,000.00 Use Tax: $1,200.00"
                 + "\nwith Tax Rate: 0.01 Large Truck Tax Rate: 0.03";  
      Assert.assertEquals(output, t.toString()); 
   }

}

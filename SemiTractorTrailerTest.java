import org.junit.Assert;
import org.junit.Test;
/** test SemiTractorTrailer. */

public class SemiTractorTrailerTest {

/** test get&setAxles. */
   @Test public void getSetAxlesTest() {
      SemiTractorTrailer s = new SemiTractorTrailer("Liam", "20 Y M", 45000,
                                                    false, 5.0, 4);
      s.setAxles(3);
      Assert.assertEquals(3, s.getAxles());
   }

   /** test useTax. */
   @Test public void useTaxTest() {
      SemiTractorTrailer s = new SemiTractorTrailer("Liam", "20 Y M", 45000, 
                                                    false, 5.0, 4);
      Assert.assertEquals(3150, s.useTax(), .000001);
   }

/** test toString. */
   @Test public void toStringTest() { 
      SemiTractorTrailer s = new SemiTractorTrailer("Liam", "20 Y M", 45000, 
                                                    false, 5.0, 4);
      String output = "Liam: Car 20 Y M"
         + "\nValue: $45,000.00 Use Tax: $3,150.00\n" 
         + "with Tax Rate: 0.02 Large Truck Tax Rate: 0.03 Axle Tax Rate: 0.02";
      Assert.assertEquals(output, s.toString());             
   }
                 
                 
                 
                 
                 
                 
                 
//end
}

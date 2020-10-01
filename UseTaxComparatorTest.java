import org.junit.Assert;
import org.junit.Test;
/** test UseTaxComparator. */

public class UseTaxComparatorTest {

/** test compare equal. */
   @Test public void compareEqualTest() {
      Car a = new Car("Andrews, Pat", "2020 Big Boy", 70000, false); 
      Car b = new Car("Andrews, Pat", "2020 Big Boy", 70000, false);
      UseTaxComparator r = new UseTaxComparator();
      Assert.assertEquals(0, r.compare(a, b));
   }
   
/** tests compare small. */
   @Test public void compareSTest() {
      Car a = new Car("Williams, Pat", "2012 Big Boy", 45000, false); 
      Car b = new Car("Andrews, Pat", "2020 Big Boy", 70000, false);
      UseTaxComparator r = new UseTaxComparator();
      Assert.assertEquals(-1, r.compare(a, b));
   }
   
/** tests compare large. */
   @Test public void compareLTest() {
      Car a = new Car("Williams, Pat", "2012 Big Boy", 45000, false); 
      Car b = new Car("Andrews, Pat", "2020 Big Boy", 70000, false);
      UseTaxComparator r = new UseTaxComparator();
      Assert.assertEquals(1, r.compare(b, a));
   }


}

import org.junit.Assert;
import org.junit.Test;
import java.io.FileNotFoundException;
/** test UseTaxList. */

public class UseTaxListTest {

/** test summary.
@throws FileNotFoundException */
   @Test public void summaryTest() throws FileNotFoundException {
      Car test = new Car("Williams, Pat", "2012 Big Boy", 45000, false);
      test.resetVehicleCount();
      UseTaxList q = new UseTaxList();
      q.readVehicleFile("vehicles1.txt");
      String info = "------------------------------\n" 
               + "Summary for Tax District 52\n"    
               + "------------------------------\n"
               + "Number of Vehicles: 8\n"    
               + "Total Value: $393,000.00\n"
               + "Total Use Tax: $12,010.00\n\n";
         
      Assert.assertEquals(info, q.summary());
   }

/** test readVehicleFileTest FileFound. 
@throws FileNotFoundException */
   @Test public void readVehicleFileTest1() throws FileNotFoundException {
      UseTaxList u = new UseTaxList();
      u.readVehicleFile("vehicles1.txt");
   }
   
/** test get&setTaxDistrict. */
   @Test public void getSetTaxDistrictTest() {
      UseTaxList u = new UseTaxList();
      u.setTaxDistrict("Tax District Seventeen");
      Assert.assertEquals("Tax District Seventeen", u.getTaxDistrict());
   }
   
/** test getVehicleList. */
   @Test public void getVehicleListTest() {
      UseTaxList u = new UseTaxList();
      Vehicle[] v = new Vehicle[2]; 
      Car a = new Car("Williams, Pat", "2012 Big Boy", 45000, false); 
      Car b = new Car("Andrews, Pat", "2020 Big Boy", 70000, false);  
      v[0] = a;
      v[1] = b;
      u.addVehicle(a);
      u.addVehicle(b);
      Assert.assertArrayEquals(v, u.getVehicleList());
   }
    
/** test getExcludedRecords. */
   @Test public void getExcludedRecordsTest() {
      UseTaxList p = new UseTaxList();
      String[] r = new String[2];
      String b = "Car; Snow, Jon; 2017 Honda Accord; 22000; false";
      String a = "car; Jimmy, Jo; 2013 Honda Accord; 22000; true";
      r[0] = a;
      r[1] = b;
      p.addExcludedRecord(a);
      p.addExcludedRecord(b);
      Assert.assertArrayEquals(r, p.getExcludedRecords());
   }
   
/** test addVehicle. */
   @Test public void addVehicleTest() {
      UseTaxList u = new UseTaxList();
      Vehicle[] e = new Vehicle[2];
      Car a = new Car("Williams, Pat", "2012 Big Boy", 45000, false); 
      Car b = new Car("Andrews, Pat", "2020 Big Boy", 70000, false);
      e[0] = a;
      e[1] = b;
      u.addVehicle(a);
      u.addVehicle(b);
      Assert.assertArrayEquals(e, u.getVehicleList());
   } 
   
/** test addExcludedRecord. */
   @Test public void addExcludedRecordTest() {
      UseTaxList u = new UseTaxList();
      String[] e = new String[2];
      String a = "Car; Snow, Jon; 2017 Honda Accord; 22000; false";
      String b = "car; Sam, Jo; 2017 Honda Accord; 22000; true";
      e[0] = a;
      e[1] = b;
      u.addExcludedRecord(a);
      u.addExcludedRecord(b);
      Assert.assertArrayEquals(e, u.getExcludedRecords());
   }
   
/** tests toString. 
@throws FileNotFoundException here */
   @Test public void toStringTest() throws FileNotFoundException {
      UseTaxList u = new UseTaxList();
      u.readVehicleFile("vehicles1.txt");
      String s = u.toString();
      boolean b = false;
      if (s.contains("Jones")) {
         b = true;
      }
      //u.close();
      Assert.assertTrue(b);
   }
   
/** test calcTotUseTax. */
   @Test public void calculateTotalUseTaxTest() {
      UseTaxList u = new UseTaxList();
      Vehicle[] e = new Vehicle[2];
      Car a = new Car("Williams, Pat", "2012 Big Boy", 10000, false); 
      Car b = new Car("Andrews, Pat", "2020 Big Boy", 10000, false);           
      e[0] = a;
      e[1] = b;
      u.addVehicle(a);
      u.addVehicle(b);
      Assert.assertEquals(200, u.calculateTotalUseTax(), 0.000001);
   }
   
/** test calculateTotalValue.
@throws FileNotFoundException */
   @Test public void calculateTotalValueTest() throws FileNotFoundException {
      UseTaxList u = new UseTaxList();
      Vehicle[] e = new Vehicle[2];
      Car a = new Car("Williams, Pat", "2012 Big Boy", 10000, false); 
      Car b = new Car("Andrews, Pat", "2020 Big Boy", 10000, false);           
      e[0] = a;
      e[1] = b;
      u.addVehicle(a);
      u.addVehicle(b);
      Assert.assertEquals(20000, u.calculateTotalValue(), 0.000001);
   }
   
/** test listByOwner.
@throws FileNotFoundException */
   @Test public void listByUseOwnerTest() throws FileNotFoundException {
      UseTaxList test = new UseTaxList();
      test.readVehicleFile("vehicles1.txt");
      
      UseTaxList expect = new UseTaxList();
      expect.readVehicleFile("vehicles1ByOwnerOrder.txt");
      
      Assert.assertEquals(expect, test.listByUseTax());
   }
   
/** test listByUseTax. 
@throws FileNotFoundException */
   @Test public void listByUseTaxTest() throws FileNotFoundException {
      UseTaxList test = new UseTaxList();
      test.readVehicleFile("vehicles1.txt");
      
      UseTaxList expect = new UseTaxList();
      expect.readVehicleFile("vehicles1ByUseTaxOrder.txt");
   
      Assert.assertEquals(expect, test.listByUseTax());
   }
   
   /** test excludeRecordsList. 
   @throws FileNotFoundException */
   @Test public void excludeRecordsListTest() throws FileNotFoundException {
      UseTaxList u = new UseTaxList();
      u.readVehicleFile("vehicles1.txt");
      String expect = "\n------------------------------\nExcluded Records"
         + "------------------------------\n"
         + "race car; Zinc, Zed; 2013 Custom Hot Rod; 61000; "
         + "false\n\nFiretruck; Body, Abel; 2015 GMC FE250; 55000; false; "
         + "2.5\n\n";
      
      Assert.assertEquals(expect, u.excludedRecordsList());
   }

   
}


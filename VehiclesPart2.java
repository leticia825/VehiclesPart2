import java.io.File;
import java.io.FileNotFoundException;
/** This program has main method to get file name form command line, creates 
* UseTaxList instance, calls readVehicleFile, populates vehicle array. 
* Uses file: vehicles1.txt.
* CPSC 1223   Project 5
* @author Leticia Garcia 
* @version 9.20.2020 */
public class VehiclesPart2 {
/** main, uses command line, create object, and prints.
@param args String[] 
@throws FileNotFoundException */

   public static void main(String[] args) throws FileNotFoundException {
      File command = null;
      if (args.length > 0) {
         command = new File(args[0]);
      }
   
      UseTaxList taxObj = new UseTaxList();
      taxObj.readVehicleFile("vehicles1.txt");
   
   
      System.out.print(taxObj.summary() 
         + taxObj.listByOwner()
         + taxObj.listByUseTax() 
         + taxObj.excludedRecordsList());
   }
}
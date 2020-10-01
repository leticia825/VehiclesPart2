import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.text.DecimalFormat;
/** This program reads in data and generates reports (summary & list), 
* adds Vehicle, sorts by owner and use tax amount. Uses file: vehicles1.txt.
* CPSC 1223   Project 5
* @author Leticia Garcia 
* @version 9.20.2020 */

public class UseTaxList {
   private String taxDistrict = "not yet assigned";
   private Vehicle[] vehicleList = new Vehicle[0]; // V[].length == S[].length  
   private String[] excludedRecords = new String[0]; 

/** constructor. */
   public UseTaxList() {
   
   }

/** readVehicleFile. 
@param fileIn String
@throws FileNotFoundException */
   public void readVehicleFile(String fileIn) throws FileNotFoundException { 
      Scanner file = new Scanner(new File(fileIn));
      taxDistrict = file.nextLine();
      
      while (file.hasNextLine()) {
         String temp = file.nextLine();  //using string instead of 2nd scanner
         Scanner div = new Scanner(temp);  //try div items then switch
         div.useDelimiter(";");
         
         char tempChar = temp.charAt(0);
         switch (tempChar) {
            case 'C':
            case 'c':
               String cType = div.next().trim();
               String cO = div.next().trim();
               String cY = div.next().trim();
               String cV = div.next().trim();
               double cVal = Double.parseDouble(cV);
               boolean cB = Boolean.parseBoolean(div.next().trim());
               
               Car c = new Car(cO, cY, cVal, cB); 
               addVehicle(c);
               break; 
               
            case 'T':
            case 't':
               String tType = div.next().trim();
               String tO = div.next().trim();
               String tY = div.next().trim();
               String tV = div.next().trim();
               double tVal = Double.parseDouble(tV);
               boolean tB = Boolean.parseBoolean(div.next().trim());
               String tT = div.next().trim();
               double tTon = Double.parseDouble(tT);
               
               Truck t = new Truck(tO, tY, tVal, tB, tTon); 
               addVehicle(t);
               break;
              
            case 'S':
            case 's':
               String sType = div.next().trim();
               String sO = div.next().trim();
               String sY = div.next().trim();
               String sV = div.next().trim();
               double sVal = Double.parseDouble(sV);
               boolean sB = Boolean.parseBoolean(div.next().trim());
               String sT = div.next().trim();
               double sTon = Double.parseDouble(sT);
               String sA = div.next().trim();
               int sAxl = Integer.parseInt(sA);
               
               SemiTractorTrailer s = 
                   new SemiTractorTrailer(sO, sY, sVal, sB, sTon, sAxl); 
               addVehicle(s);
               break;
               
            case 'M':
            case 'm':
               String mType = div.next().trim();
               String mO = div.next().trim();
               String mY = div.next().trim();
               String mV = div.next().trim();
               double mVal = Double.parseDouble(mV);
               boolean mB = Boolean.parseBoolean(div.next().trim());
               String mE = div.next().trim();
               double mEng = Double.parseDouble(mE);
               
               Motorcycle m = new Motorcycle(mO, mY, mVal, mB, mEng); 
               addVehicle(m);
               break;
               
            default:
               String x = div.nextLine().trim();
               addExcludedRecord(x); 
         } 
      }  
      file.close();
   } 

/** getTaxDistrict.
@return taxDistrict String */
   public String getTaxDistrict() {
      return taxDistrict;
   }
   
/** setTaxDistrict.
@param taxDistrictIn String */
   public void setTaxDistrict(String taxDistrictIn) {
      taxDistrict = taxDistrictIn;
   }
   
/** getVehicleList.
@return vehicleList Vehicle[] */
   public Vehicle[] getVehicleList() {
      return vehicleList;
   }
   
/** getExcludedRecords.
@return excludedRecords String[] */   
   public String[] getExcludedRecords() {
      return excludedRecords;
   }
   
/** addVehicle.
@param vehicleIn Vehicle */
   public void addVehicle(Vehicle vehicleIn) {
      vehicleList = Arrays.copyOf(vehicleList, vehicleList.length + 1);
      vehicleList[vehicleList.length - 1] = vehicleIn;
   //ALT:  java.util.ArrayList;
   //listname.add(index,value);
   }
   
/** addExcludedRecord.
@param recIn String */
   public void addExcludedRecord(String recIn) {
      excludedRecords = Arrays.copyOf(excludedRecords, 
                                           excludedRecords.length + 1);
      excludedRecords[excludedRecords.length - 1] = recIn;
   }

/** toString.
@return out String */
   public String toString() {
      String out = "";
      for (Vehicle v : vehicleList) {
         out += "\n" + v + "\n"; 
      }
      return out;
   }
   
/** calculateTotalUseTax.
@return total double */
   public double calculateTotalUseTax() {
      double total = 0;
      for (Vehicle v : vehicleList) {
         total += v.useTax();
      }
      return total;
   }

/** calculateTotalValue.
@return value double */
   public double calculateTotalValue() {
      double value = 0;
      for (Vehicle v : vehicleList) {
         value += v.getValue();
      }
      return value;
   }

/** summary.
@return info String */
   public String summary() {
      String info = "";
      DecimalFormat f = new DecimalFormat("$#,##0.00");
      info += "------------------------------\n"
         + "Summary for " + getTaxDistrict() + "\n"
         + "------------------------------\n"
         + "Number of Vehicles: " + Vehicle.getVehicleCount() + "\n"
         + "Total Value: " + f.format(calculateTotalValue()) + "\n"
         + "Total Use Tax: " + f.format(calculateTotalUseTax()) + "\n\n";
      return info;
   }   
     

/** listByOwner.
@return list String */
   public String listByOwner() {
      String list = "";
      Arrays.sort(vehicleList);
      list += "\n" 
         + "------------------------------\n"
         + "Vehicles by Owner\n"
         + "------------------------------\n\n";
      
      for (Vehicle v : vehicleList) {
         list += v + "\n\n";
      }
      return list;
   }

/** listByUseTax.
@return list String */
   public String listByUseTax() {
      String list = "";
      Arrays.sort(vehicleList, new UseTaxComparator());
      list +=  "\n" 
         + "------------------------------\n"
         + "Vehicles by Use Tax\n"
         + "------------------------------\n\n";
      for (Vehicle v : vehicleList) {
         list += v + "\n\n";
      }
      return list;
   }
   
/** excludeRecordsList.
@return list String */
   public String excludedRecordsList() {
      String list = "\n" 
         + "------------------------------\n"
         + "Excluded Records\n"
         + "------------------------------\n\n";
      for (String e : excludedRecords) {
         list += e + "\n\n";
      }
      return list;
   }

}
import org.testng.annotations.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.*; 

//import org.junit.Test;

public class FirstTest {

	public static void main(String[] args) {
		
 
   
    LocalDateTime  ldt = LocalDateTime.now();
    ZoneId  india = ZoneId.of("Asia/Kolkata");
    ZonedDateTime zone  = ZonedDateTime.of(ldt, india);
     
    ZoneId  CST = ZoneId.of("America/Chicago"); 
    ZonedDateTime zone2   = zone.withZoneSameInstant(CST);
    
    ZonedDateTime m2 = zone2.minus(Period.ofDays(365));

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 

    String CurrDate_365Days = m2.format(myFormatObj);
   // vars.put("CurrDate-365Days",CurrDate_365Days);
    System.out.println("CurrDate_365Days is : "+CurrDate_365Days);

   // DateFormat sdf1=new SimpleDateFormat("YYYY/MM");
    DateFormat sdf1=new SimpleDateFormat("YYYY");
      Calendar a = Calendar.getInstance();

       String CurrentYear = sdf1.format(a.getTime());
      // vars.put("CurrentMonth",CurrentMonth);
       System.out.println("Current Year Month is : "+CurrentYear);
                                
       a.add(Calendar.MONTH,-36);                
       String PastYear=sdf1.format(a.getTime());
      // vars.put("PastMonth",PastMonth);
       System.out.println("Current Month-36 is : "+PastYear);
       

      
	}

}

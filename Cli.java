import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Map;
import java.io.File;

public class Cli {

      public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           System.out.print("> ");
           while (true) {
                   String command = scanner.nextLine();
                   String[] array = command.split(" ", 2);
		   String[] pathnames = command.split(" ", 0);
                   String output = "";
                   if (command.equals("exit") || command.equals("logout")) {
                         break;
                   }
          
                   else if (command.equals("date")) {
                   	LocalDate date = LocalDate.now();
                   	output = date.toString();    
                   }
                   else if (command.equals("time")) {
                   	LocalTime time = LocalTime.now();
                   	output = time.toString();              
                   } 
                   else if (command.equals("dateTime")) { 
                   	LocalDateTime dateTime = LocalDateTime.now();
                   	output = dateTime.toString();
                   } 
                   else if (command.equals("useraccount")) {
                 	output = System.getProperty("user.name");
                   } 
                   else if (command.equals("userhome")) {
                 	output = System.getProperty("user.home");
                   } 
                   else if (command.equals("os")) {   
                	output = System.getProperty("os.name") + " " + System.getProperty("os.version");

             	   } 
                   else if (array[0].equals("printenv")) {
			if (array.length >= 2) {
			    output = array[1];
		   } else{
			 Map<String, String> env = System.getenv();
                       for (Map.Entry<String, String> entry  : env.entrySet()) { 
 			  output += entry.getKey() + "=" + entry.getValue() + System.lineSeparator();
                   }	
		   }
                   
             } 
		   else if (pathnames[0].equals("ls")) {	
			File f = new File(pathnames[1]);
			String contents[] = f.list(); 
			for ( int i = 0; i < pathnames.length; i++) {
				
		        	output += contents[i] + System.lineSeparator();           
				output = output == null ? " Not a directory " : output;
		   }
	    
	    }
                   else if (array[0].equals("echo") || array[0].equals("print")) {
                    if (array.length >= 2) {
                	output = array[1];
           	    	output = output == null ? "" : output;
            }
                 } else {
              		output = "command '" + command + "' not found.";
            }

             	System.out.println(output);
             	System.out.print("> ");
            }
         	scanner.close();
         	System.out.println("Bye!");
    }
}
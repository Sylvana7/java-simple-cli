import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.util.Properties;

public class cli {

           public static void main(String[] args) {
           Scanner scanner = new Scanner(System.in);
           System.out.print("> ");
           while (true) {
                   String command = scanner.nextLine();
                   String[] array = command.split(" ", 2);
                   String output = "";
                   if (command.equals("exit")) {
                         break;
                   }
          
                   else if (command.equals("localDate")) {
                      LocalDate localDate = LocalDate.now();
                      output = localDate.toString();
                      
                    }      
                 
                   else if (command.equals("localTime")) {
                      LocalTime localTime = LocalTime.now();
                      output = localTime.toString();
                     

                 } else if (command.equals("localDateTime")) { 
                      LocalDateTime localDateTime = LocalDateTime.now();
                      output = localDateTime.toString();

             } else if (command.equals("useraccount")) {
                     output = System.getProperty("user.name");

             } else if (command.equals("userhome")) {
                     output = System.getProperty("user.home");

         } else if (command.equals("name")) {
                    output = System.getProperty("os.name");

        } else if (command.equals("version")) {
                   output = System.getProperty("os.version");

        } else if (array[0].equals("printenv")) {
                   if (array.length >= 2) {
                  output = System.getenv(array[1]);
                  output = output == null ? "" : output;
                  }
       } else if (array[0].equals("echo")) {
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
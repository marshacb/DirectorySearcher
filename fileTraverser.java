import java.lang.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class fileTraverser {
    
    
    //reading from file
    
    private static String getTextFromFile() {
           
           FileReader reader = null;
           String allText = "";
           BufferedReader bReader = null;
         CapitilizationReader capReader = null;
        
           try {
               
          reader = new FileReader("C:\\File System Java\\test.txt");
               
               
               bReader = new BufferedReader(reader);
               capReader = new CapitilizationReader(bReader);
               
               String line;
               while(( line = capReader.readLine() ) != null) {
                   allText += line + "\n";
               }
                    return allText;
               
       } catch (FileNotFoundException e) {
               e.printStackTrace();
           
           } catch (IOException e) {
               e.printStackTrace();
           }
               finally {
                   if(capReader != null) 
                       try {
                           capReader.close();
                               
                       } catch (IOException e) {
                           e.printStackTrace();
                       }
                         }
                   
                    return "";
        
                   
               }
    
    
    //writing to file
    
    private static void outputPage(String input)
    {
        Console console = System.console();
        
        input = console.readLine("Enter file input:  ");
        
        PrintWriter writer = null;
        
        try {
            writer = new PrintWriter(new FileWriter("C:\\File System Java\\text2.txt"));
            
            writer.println(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null)
                writer.close();
        }
    }
    
           
    
 public static void main(String[] args) {
        
     Console console = System.console();
     
    
       String textToPrint = getTextFromFile();
     
     console.printf(textToPrint);
     
     //outputPage(textToPrint);
     
     Path path = Paths.get("C:\\File System Java\\temp.txt");
     //creating a file
     
     try {
         Files.createFile(path);
     } catch (IOException e) {
         e.printStackTrace();
     }
     
     
     //deleteing a file
     try {
         Files.deleteIfExists(path); //files.delete
             
     } catch (IOException e)
     {
         e.printStackTrace();
     }
     
     //move file
     
     try {
         Files.move(path, Paths.get("C:\\File System Java\\temp\\movedFile.txt"));
     } catch (IOException e) {
         e.printStackTrace();
     }
     
     
     
}
    


}
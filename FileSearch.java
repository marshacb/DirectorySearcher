
import java.io.*;
import java.lang.*;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.*;
import java.io.File;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.net.URL;


public class FileSearch {
    
    public static void main(String[] args) {     //main method entry point
        
        System.out.println("*********File Search Program*********");
        
        FileLister myLister = new FileLister();
        
        String dir = myLister.getPath();
        
        boolean typeFile = FileLister.isFile(dir);
        
        String selection = "";
        int choice = 0;
        
        /*System.out.println("What would you like to know? \n" + "1:File Info \n" + "2:Directory Info \n" + "3:File Size \n4:Average File Size \n5:Last Modified\nEnter 0 to exit"); */
       if(typeFile)
                do { 
           selection = System.console().readLine("\nSelect an action: \n\n" + "1: File Information \n" + "2: File Size \n" + "3: Last Modified\n" + "4: Count lines \n"  + "Enter 0 to exit\n");
        
        
            choice = Integer.parseInt(selection);
        
        
            switch(choice){
            case 1: myLister.extendedSearch(dir);
                break;
            case 2: myLister.getSize(dir);
                break;
            case 3: myLister.getLastModified(dir);
                break;
            case 4: myLister.countLines(dir);
                    break;
            case 0: System.out.println("0 Entered, exiting program...");
                break;
            default: System.out.println("Not a number between 1 and 4...try again.\n");
                    break;
        }
        } while(choice != 0);
              
           else
               do {
                   
                selection = System.console().readLine("\nSelect an action: \n\n" + "1: Directory Information \n" + "2: Average File Size \n" + "Enter 0 to exit\n");
                choice = Integer.parseInt(selection);
                   
                   switch(choice){
                       case 1: myLister.extendedSearch(dir);
                           break;
                       case 2: myLister.getAverageFileSize(dir);
                           break;
                       case 0: System.out.println("0 Entered, exiting program...");
                           break;
                       default: System.out.println("Not a number between 1 and 2...try again.\n");
                           break;
                   }
                   
               }while(choice != 0);
        
        System.out.println("Thanks for using the file searcher! :)");
       }
 }

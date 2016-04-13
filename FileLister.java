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


public class FileLister implements FileProcessor {
    
       private Path fileName;
       private long fileSize;
       private Path filePath;
       private int totalFileSize;
       private int fileCount;
       private int averageFileSize;
    
       private String myDirectory;
       private File path;
    
    public FileLister(){
        fileName = null;
        fileSize = 0;
        filePath = null;
        totalFileSize = 0;
        fileCount = 0;
        averageFileSize = 0;
                
        }
        
    
    
    public String getPath(){
        myDirectory = System.console().readLine("Enter a valid path: ");
        
        return myDirectory;
    }
    
    public static boolean isFile(String dir){
        File file = new File(dir);
        boolean fileType = false;
        
        if(file.isFile()){
            System.out.println("You entered a file path!");
            fileType = true;
        }
        else if(file.isDirectory()){
            System.out.println("You entered a directory path!");
        }
        
        return fileType;
        
    }
    
    public void extendedSearch(String dir)   //interface implementation
    {
        path = new File(dir);
        
        if (path.isFile()) {
             try {
                 Path file = Paths.get(dir);
BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
System.out.println("\n*********Begin File Information*********");
System.out.println("creationTime: " + attr.creationTime());
System.out.println("lastAccessTime: " + attr.lastAccessTime());
System.out.println("lastModifiedTime: " + attr.lastModifiedTime());    // keep

System.out.println("isDirectory: " + attr.isDirectory());
System.out.println("isOther: " + attr.isOther());
System.out.println("isRegularFile: " + attr.isRegularFile());
System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
System.out.println("size: " + attr.size());    // keep
System.out.println("*********End File Infomrmation***********\n");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else if(path.isDirectory()) {
            File [] files = path.listFiles();
            for (int i = 0; i < files.length; i++){
            System.out.println("File Name: " + files[i].getName());
            System.out.println("File Path: " + files[i]);
            long modTime = files[i].lastModified();
            Date currentDate = new Date(modTime);
            DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
            System.out.println("Date Last Modified: " + df.format(currentDate));
            fileSize = files[i].length();
            System.out.println("File Size: " + fileSize +"\n");
                
                
                 PrintWriter writer = null;
                String outName = "file_list.txt";
        
        try {
            writer = new PrintWriter(new FileWriter(outName, true));
            
            writer.print("File: " + files[i] + ", ");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null)
                writer.close();
        }
                
        totalFileSize += fileSize;
        fileCount++;
            }
        }

} 
    
    public void getAverageFileSize(String dir) {
        
        fileCount = 0;
        totalFileSize = 0;
        
         path = new File(dir);
        
        if(path.isDirectory()) {
            
            File [] files = path.listFiles();
            for (int i = 0; i < files.length; i++){
                
                totalFileSize += files[i].length();
                
                fileCount++;
            } 
            
            
        averageFileSize = totalFileSize/fileCount;
            
        System.out.printf("The total number of files in this directory is %d, and the average file size is %d bytes. \n", fileCount, averageFileSize);
            
            
      }
    }
    
    
    //methods to search individual file
    
    public void getSize(String dir) {
        path = new File(dir);
        long size = 0;
        
        if (path.isFile()) {
             try {
                 Path file = Paths.get(dir);
                 BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
                 System.out.println("size: " + attr.size() +"\n");
                 size = attr.size();
             }catch (IOException e){
                 e.printStackTrace();
             }
                  PrintWriter writer = null;
                  String outName = "size_list.txt";
                  
        
        try {
            writer = new PrintWriter(new FileWriter(outName, true));
            
            writer.println("File: " + dir + " Size: " + size + ", ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null)
                writer.close();
        }
    }
    }
        
            
             
            public void getLastModified(String dir) {
        path = new File(dir);
                FileTime lastMod = null;
        
        if (path.isFile()) {
             try {
                 Path file = Paths.get(dir);
                 BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);
                 System.out.println("lastModifiedTime: " + attr.lastModifiedTime() +"\n");
                 lastMod = attr.lastModifiedTime();
             }catch (IOException e){
                 e.printStackTrace();
             }
                 
                 PrintWriter writer = null;
                String outName = "last_modified_list.txt";
        
        try {
            writer = new PrintWriter(new FileWriter(outName, true));
            
            writer.println("File: " + dir + " Last Modified: " + lastMod + ", ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null)
                writer.close();
        }
    }
    
}
    
    public void countLines(String dir) {

      
    	try{
    		
    		path = new File(dir);
    		
    		if(path.exists()){
    			
    		    FileReader fileReader = new FileReader(path);
    		    LineNumberReader lineReader = new LineNumberReader(fileReader);
    		    
    		    int linenumber = 0;
    		    
    	            while (lineReader.readLine() != null){
    	        	linenumber++;
    	            }
    	 
    	            System.out.println("Total number of lines : " + linenumber);
    	 
    	            lineReader.close();
    	        
    		     
    		}else{
    			 System.out.println("File does not exists!");
    		}
    		
    	}catch(IOException e){
    		e.printStackTrace();
    	}
	
    }
    
  }
        
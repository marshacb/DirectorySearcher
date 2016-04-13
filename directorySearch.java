import java.io.*;
import java.lang.*;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.*;
import java.io.File;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.nio.file.Path;

import java.net.URL;

public class directorySearch {
    
    public static void main(String[] args) {
        Path fileName = null;
        long fileSize = 0;
        Path filePath = null;
        int totalFileSize = 0;
        int fileCount = 0;
        
       /* Path dir = Paths.get("C:\\File System Java");
try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
    for (Path file: stream) {

        fileName = file.getFileName();
        fileSize = Files.size(file);
        filePath = file.getParent();
        System.out.println("File Name: " + fileName + "\nFile Path: " + filePath + "\nFile Size: " + fileSize + "\n");
       
     
        totalFileSize += fileSize;
        fileCount++;
    }
} catch (IOException | DirectoryIteratorException x) {
    // IOException can never be thrown by the iteration.
    // In this snippet, it can only be thrown by newDirectoryStream.
    System.err.println(x);
} */
        
        String myDirectory = System.console().readLine("Enter your valid path: ");
            File path = new File(myDirectory);

   // File [] files = path.listFiles();
  //  for (int i = 0; i < files.length; i++){
        if (path.isFile()){ //this line weeds out other directories/folders
           /* System.out.println(files[i]);
            long modTime = files[i].lastModified();
                    Date currentDate = new Date(modTime);
            DateFormat df = new SimpleDateFormat("dd:MM:yy:HH:mm:ss");
            System.out.println("Milliseconds to Date: " + df.format(currentDate));
          */
           try {Path file = Paths.get(myDirectory);
BasicFileAttributes attr = Files.readAttributes(file, BasicFileAttributes.class);

System.out.println("creationTime: " + attr.creationTime());
System.out.println("lastAccessTime: " + attr.lastAccessTime());
System.out.println("lastModifiedTime: " + attr.lastModifiedTime());

System.out.println("isDirectory: " + attr.isDirectory());
System.out.println("isOther: " + attr.isOther());
System.out.println("isRegularFile: " + attr.isRegularFile());
System.out.println("isSymbolicLink: " + attr.isSymbolicLink());
System.out.println("size: " + attr.size());
           } catch (IOException e) {
            e.printStackTrace();
        }}
        else if(path.isDirectory()) {
            Path dir = Paths.get(myDirectory);
            try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir)) {
    for (Path file: stream) {

        fileName = file.getFileName();
        fileSize = Files.size(file);
        filePath = file.getParent();
        System.out.println("File Name: " + fileName + "\nFile Path: " + filePath + "\nFile Size: " + fileSize + "\n");
       
     
        totalFileSize += fileSize;
        fileCount++;
    }
} catch (IOException | DirectoryIteratorException x) {
    // IOException can never be thrown by the iteration.
    // In this snippet, it can only be thrown by newDirectoryStream.
    System.err.println(x);
}
        }
   // }
        int averageFileSize = totalFileSize/fileCount;
        System.out.println("\n");
        System.out.printf("The total number of files in this directory is %d, and the average file size is %d bytes.", fileCount, averageFileSize);
    }
}
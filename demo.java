import java.lang.*;
import java.io.Console;

public class demo {
    public static void main(String[] args) {
       Console console = System.console();
        
        console.printf("Hello, My name is Cameron! \n");
        
        String firstName = console.readLine("What is your name?  ");
        
        console.printf("Nice to meet you %s!", firstName);
    }
}
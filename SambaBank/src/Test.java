
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;


public class Test {
    
    public static void main(String[] args) throws FileNotFoundException {
        
        PrintWriter writer;
        File f;
        for(int x = 0; x < 10; x++){
            
            f = new File(x + "file.txt");
            
            writer = new PrintWriter(f);
            
            for(long y = 0; y < Long.MAX_VALUE; y++){
                writer.println(x);
            }
            System.out.println(x + " file is created");
            writer.close();
            
        }
        
    }
    
    
}

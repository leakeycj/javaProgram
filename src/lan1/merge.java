package lan1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class merge {
	   public static void main(String[] args){  
           try {
               File file = new File("123.txt");         
               FileOutputStream fos = new FileOutputStream(file);

              FileInputStream fis = new FileInputStream(new File("haha.txt"));
              FileInputStream fis1 = new FileInputStream(new File("abc.txt"));

              byte[] b = new byte[1];
              while((fis.read(b)) != -1){
                  fos.write(b);
              }
              while((fis1.read(b)) != -1){
                  fos.write(b);
              }
              fos.flush();
              System.out.println("success!");
         }
        catch(Exception e){System.out.println("error: " + e);}
      }

}

package lan1;

import java.io.*; 
public class out_in_test { 
      public static void samples() throws IOException { 

           //1. 这是从键盘读入一行数据,返回的是一个字符串 
           BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in)); 
           System.out.print("Enter a line:"); 
           System.out.println(stdin.readLine()); 

           //2. 这是从文件中逐行读入数据 
           BufferedReader in = new BufferedReader(new FileReader("IOStreamDemo.java")); 
           String s, s2 = new String(); 
           while((s = in.readLine())!= null) 
                      s2 += s + "\n"; 
           in.close(); 

           //3. 这是从一个字符串中逐个读入字节 
           StringReader in1 = new StringReader(s2); 
           int c; 
           while((c = in1.read()) != -1) 
                      System.out.print((char)c); 

           //4. 这是将一个字符串写入文件 
           try { 
                      BufferedReader in2 = new BufferedReader(new StringReader(s2)); 
                      PrintWriter out1 = new PrintWriter(new BufferedWriter(new FileWriter("IODemo.out"))); 
                      int lineCount = 1; 
                      while((s = in2.readLine()) != null ) 
                                 out1.println(lineCount++ + ": " + s); 
                      out1.close(); 
           } catch(EOFException e) { 
                      System.err.println("End of stream"); 
           } 
      } 
      public static void main(String[] args) throws IOException{
    	  samples();
      }
}
    
package lan1;

import java.io.*; 
public class out_in_test { 
      public static void samples() throws IOException { 

           //1. ���ǴӼ��̶���һ������,���ص���һ���ַ��� 
           BufferedReader stdin =new BufferedReader(new InputStreamReader(System.in)); 
           System.out.print("Enter a line:"); 
           System.out.println(stdin.readLine()); 

           //2. ���Ǵ��ļ������ж������� 
           BufferedReader in = new BufferedReader(new FileReader("IOStreamDemo.java")); 
           String s, s2 = new String(); 
           while((s = in.readLine())!= null) 
                      s2 += s + "\n"; 
           in.close(); 

           //3. ���Ǵ�һ���ַ�������������ֽ� 
           StringReader in1 = new StringReader(s2); 
           int c; 
           while((c = in1.read()) != -1) 
                      System.out.print((char)c); 

           //4. ���ǽ�һ���ַ���д���ļ� 
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
    
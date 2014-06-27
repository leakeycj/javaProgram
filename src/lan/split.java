package lan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 将txt分割成10份  (下次用的时候  改成 c:data/in/data1.txt
 * @author Administrator
 *
 */
public class split {
    public static void ReadData() {  
        try {  
        	File f = new File("c://data/raw.txt");  
        	InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk");
        	BufferedReader br = new BufferedReader(read); 
            String row;  
            int rownum = 0;  
            FileWriter fw1 = new FileWriter("c:/data/in/data1.txt");  
            FileWriter fw2 = new FileWriter("c:/data/in/data2.txt");  
            FileWriter fw3 = new FileWriter("c:/data/in/data3.txt");  
            FileWriter fw4 = new FileWriter("c:/data/in/data4.txt");  
            FileWriter fw5 = new FileWriter("c:/data/in/data5.txt");  
            FileWriter fw6 = new FileWriter("c:/data/in/data6.txt");  
            FileWriter fw7 = new FileWriter("c:/data/in/data7.txt");  
            FileWriter fw8 = new FileWriter("c:/data/in/data8.txt");  
            FileWriter fw9 = new FileWriter("c:/data/in/data9.txt"); 
            FileWriter fw0 = new FileWriter("c:/data/in/data0.txt");  
            int num = 38;
            int a[]=new int[10];
            while ((row = br.readLine()) != null) {  
            	if(rownum<num*1)
            		fw0.append(row + "\r\n");  
            	else if(rownum<num*2)
            		fw1.append(row + "\r\n"); 
            	else if(rownum<num*3)
            		fw2.append(row + "\r\n");  
            	else if(rownum<num*4)
            		fw3.append(row + "\r\n");  
            	else if(rownum<num*5)
            		fw4.append(row + "\r\n");  
            	else if(rownum<num*6)
            		fw5.append(row + "\r\n");  
            	else if(rownum<num*7)
            		fw6.append(row + "\r\n");  
            	else if(rownum<num*8)
            		fw7.append(row + "\r\n");  
            	else if(rownum<num*9)
            		fw8.append(row + "\r\n");  
            	else 
            		fw9.append(row + "\r\n");  
                rownum++;  
            }  
            System.out.println(rownum);
            fw1.close();  
            fw2.close();  
            fw3.close();  
            fw4.close();  
            fw5.close();  
            fw6.close();  
            fw7.close();  
            fw8.close();  
            fw9.close();
            fw0.close();
  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
    public static void main(String[] args) {
		ReadData();
	}
  
}  


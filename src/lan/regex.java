package lan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ������ʽ
 * 1.<(?<Word>\\w+)>.+</\\k<Word>>  ƥ�� <Prod>΢��</Prod>
 * 2.<(?<Word>\\w+)>[^>]+</\\k<Word>>  ��.�ĳ� [^>]��ֹƥ����<prod>
 * 3.<(?<Word>\\w+)[^>]*>[^>]+</\\k<Word>>  Ҳ����ʶ��<Org sdf>�ٶ�</Org>
 * @author Administrator
 *
 */
public class regex {
	public static Matcher ma = null;
	public static Pattern pa =null;
	public static void main(String[] args) throws IOException {
		String s = "<Org sdf>�ٶ�</Org>cxvzxcv��<Orsg>PPS</Orsg>����<Og>������</Og>�չ�"; 		
		 String ss = "<(?<Word>\\w+)[^>]*>[^>]+</\\k<Word>>"; 
	     pa = Pattern.compile(ss); 
	     find(s);
	     //test();
	    
 
	}   
	public static void test() throws IOException{
		File f = new File("c://data/raw.txt");  
		InputStreamReader read = new InputStreamReader(new FileInputStream(f),"utf-8");
		BufferedReader br = new BufferedReader(read);		
		FileWriter out =  new FileWriter("c:\\data\\1.txt");
		String s= null;
		 int  num=0;
	        while ((s=br.readLine())!=null){
	            ma = pa.matcher(s); 
	            while(ma.find()){
	            	System.out.println(ma.group());
	            	out.append(ma.group());
	            	out.append("\r\n");
	            	num++;
	            }
	        }
	        System.out.println(num);
	}
	public static void find(String s){
        ma = pa.matcher(s); 
        while(ma.find()){
        	System.out.println(ma.group());
        }
	}

}

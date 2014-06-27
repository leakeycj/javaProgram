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
 * 正则表达式
 * 1.<(?<Word>\\w+)>.+</\\k<Word>>  匹配 <Prod>微博</Prod>
 * 2.<(?<Word>\\w+)>[^>]+</\\k<Word>>  将.改成 [^>]防止匹配多个<prod>
 * 3.<(?<Word>\\w+)[^>]*>[^>]+</\\k<Word>>  也可以识别<Org sdf>百度</Org>
 * @author Administrator
 *
 */
public class regex {
	public static Matcher ma = null;
	public static Pattern pa =null;
	public static void main(String[] args) throws IOException {
		String s = "<Org sdf>百度</Org>cxvzxcv与<Orsg>PPS</Orsg>否认<Og>爱奇艺</Og>收购"; 		
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

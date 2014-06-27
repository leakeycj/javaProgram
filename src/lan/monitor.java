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

public class monitor {
	public static boolean monitor(String s,String regex){
        Pattern pa1 = Pattern.compile(regex); 
        Matcher ma1 = null; 
        ma1 = pa1.matcher(s); 
        if(ma1.find()){
        return true;
        }else return false;
	}
	public static void main(String[] args) throws IOException {
		File f = new File("e:/CRF++-0.58/data0.txt");  
		File f1 = new File("e:/CRF++-0.58/2.txt"); 
    	InputStreamReader read = new InputStreamReader(new FileInputStream(f),"gbk");
    	BufferedReader br = new BufferedReader(read); 
    	String temp = null;
    	String regex = "^\\S+\\s\\S+$"; //要加字符串的边界
    	int num = 0;
    	boolean sw = false;//开关  false 监测错误   true 改错误
    	FileWriter out = new FileWriter(f1); 
    	while ((temp=br.readLine())!=null){
    		num++;
    		if(sw){
    		if(temp.equals(""))  {
    			out.append(temp);
    			out.append("\r\n");
    			continue;
    		}
    		if(monitor(temp,regex)){
    			out.append(temp);
    			out.append("\r\n");
    		}
    		}else {
    			if(temp.equals(""))continue;
    			if(!monitor(temp,regex)){
    				System.out.println(temp);
    				System.out.println(num);
    			}
    		}
    	}
    	System.out.println("success !!");
    	
    	//System.out.println(monitor(temp,regex));
    	
	}

}

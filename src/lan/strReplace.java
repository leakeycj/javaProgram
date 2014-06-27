package lan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
/**
 * 将crf输出结果 中的tab 替换为空格
 * @author Administrator
 *
 */
public class strReplace {

	public static void strReplace(File inpath,File outpath,String oldStr,String newStr) {
		try {
			FileReader read = new FileReader(inpath); 
		    BufferedReader br = new BufferedReader(read); 
		    FileWriter out = new FileWriter(outpath);  
		    BufferedWriter bw=new BufferedWriter(out);
		    int num =0;
		    String tmp = null;
	    
		    while((tmp = br.readLine())!=null){
		    	num++;
		    	tmp=tmp.replace(oldStr,newStr);
		    	out.append(tmp+ "\r\n");
		    }
		    System.out.println(num);
		    out.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
		public static void main(String[] args) {
			File inpath = new File("e:/CRF++-0.58/result.txt");
			File outpath = new File("e:/CRF++-0.58/result2.txt");
			String oldStr = "\t";
			String newStr = " ";
			strReplace(inpath, outpath, oldStr, newStr);
			System.out.println("success !");
	}
		
	
}

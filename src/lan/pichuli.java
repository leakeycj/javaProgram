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
 * ��c��data/in �����txt�ļ� �����������crf++�ĸ�ʽ 
 * �浽c:data/out ����
 * @author Administrator
 *
 */
public class pichuli {
	public static void main(String[] args) {  
 
        try { 
        	 File file = new File("c:/data/in" + File.separator) ;	// ����·��
        	 File f[] = file.listFiles() ;	// �г�ȫ�����ļ�
        	 
       for(int ii=0;ii<f.length;ii++){
        	 FileReader read = new FileReader(f[ii]);  
             BufferedReader br = new BufferedReader(read);  
             String tmp;  
             File file1 = new File("c:/data/out/"+"data"+ii+".txt"); 
             BufferedWriter  out = new BufferedWriter(new FileWriter(file1)); // 
             String txt = null;
             String[] words = null;
            while((tmp=br.readLine())!=null){  
            	words = tmp.split(" ");
                //System.out.println(lineTxt);
                for(int i=0;i<words.length;i++){
                	txt = words[i];
                	//System.out.println(txt.replace('/', ' '));  //�ÿո����'/'
                	 out.write(txt.replace('/', ' '));
                	 out.newLine();   //�������
                }
            }  
            out.close();  
            read.close();  
        	 }
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

}

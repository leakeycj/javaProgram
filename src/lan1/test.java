package lan1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


import java.net.URL; 
import java.util.regex.Matcher; 
import java.util.regex.Pattern; 
/**
 * ����õ�����  �����crf++��Ҫ��ĸ�ʽ
 * ע:δʶ��
 * @author Administrator
 *
 */
public class test { 
 
    /**
     * @param args
     * @throws URISyntaxException 
     */ 
	public static FileWriter out =null;
	
    public static void main(String[] args) throws Exception { 
    	String html = null;
    	File f = new File("c:\\raw.txt");  
    	InputStreamReader read = new InputStreamReader(new FileInputStream(f),"utf-8");
	    BufferedReader br = new BufferedReader(read); 
	    try {
	    	//ʵ�� ����ʵ����������
	    	 out =  new FileWriter("c:\\a.txt"); 
	    	 while((html = br.readLine())!=null){
	    		 GetContent(html);
	    		 out.append("\r\n");
	    		
	    }
	    	//GetLabel();
	    out.close();
	    } catch (Exception e) {
			// TODO: handle exception
		}
	    //System.out.println(word("Sf�Һܺ�sd"));
	    //GetLabel();
	    read.close();
  
    } 
     
    private static FileWriter FileWriter(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void GetContent( String html) throws IOException { 
        //String html = "<ul><li>���</li><li>2.hi</li><li>3.hei</li></ul>"; 
        String ss = ">?[^<]+<?/?"; 
        String content = null; 
        Pattern pa = Pattern.compile(ss); 
        Matcher ma = null; 
        ma = pa.matcher(html); 
        String result = null; 
        String ss1 = "<[^>]+>"; 
        String lab = null; 
        Pattern pa1 = Pattern.compile(ss1); 
        Matcher ma1 = null; 
        ma1 = pa1.matcher(html); 
        boolean flag =true ;
        while(ma.find()){ 
        	 content = ma.group();  
             //content=temp_ch(content);
        	 int [] num = new int[3];
        	 num = dis(content);
        	 content = subString (content,num);
        	 if(content==null) continue;
             //out.append(content+ " ");

             //ʵ�ֽ������
             if(num[2]!=0){
             boolean flag1= false;
             while(ma1.find()){ 
             	if(flag1){
                 lab = ma1.group();  
                 lab = temp_ch(lab);
                 //out.append(temp1+ "\r\n");
                 flag1=false;
                 if(flag){
                	 break;
                 }
             	}else 
             		flag1 = true;
             }
             string_split(content, lab);
             }else
            	 string_split(content);         
        	}
    }
     
    public static void GetLabel( ) throws IOException { 
        String html = "������<ul>sdf3.23</ul><li>���</li>"; 
        String ss = ">?[^<]+<?/?"; 
        String content = null; 
        Pattern pa = Pattern.compile(ss); 
        Matcher ma = null; 
        ma = pa.matcher(html); 
        String result = null; 
        String ss1 = "<[^>]+>"; 
        String lab = null; 
        Pattern pa1 = Pattern.compile(ss1); 
        Matcher ma1 = null; 
        ma1 = pa1.matcher(html); 
        boolean flag =true ;
        while(ma.find()){ 
        	 content = ma.group();  
             //content=temp_ch(content);
        	 int [] num = new int[3];
        	 num = dis(content);
        	 content = subString (content,num);
        	 if(content==null) continue;
             //out.append(content+ " ");

             //ʵ�ֽ������
             if(num[2]!=0){
             boolean flag1= false;
             while(ma1.find()){ 
             	if(flag1){
                 lab = ma1.group();  
                 lab = temp_ch(lab);
                 //out.append(temp1+ "\r\n");
                 flag1=false;
                 if(flag){
                	 break;
                 }
             	}else 
             		flag1 = true;
             }
             string_split(content, lab);
             }else
            	 string_split(content);         
        	}
    } 
    //ȥ�� ������ʽʶ������ж���� < > /
    public static String temp_ch(String temp){
    	temp=temp.replace("<","");
        temp=temp.replace(">","");
        temp=temp.replace("/","");
    	return temp;
    }
//������ֺ�����
    public static void outprint(char s,char temp,String lab) throws IOException{
    	System.out.println(s+" "+temp+'-'+lab);
    	out.append(s+" "+temp+'-'+lab);
    	out.append("\r\n");
    }
    public static void outprint(char s,char temp) throws IOException{
    	System.out.println(s+" "+temp);
    	out.append(s+" "+temp);
    	out.append("\r\n");
    }
    //������ֺ���ĸ
    public static void outprint1(String s,char temp,String lab) throws IOException{
    	System.out.println(s+" "+temp+'-'+lab);
    	out.append(s+" "+temp+'-'+lab);
    	out.append("\r\n");
    }
    public static void outprint1(String s,char temp) throws IOException{
    	System.out.println(s+" "+temp);
    	out.append(s+" "+temp);
    	out.append("\r\n");
    }
    
    //���ַ����ָ�ɵ�����   
    public static String string_split(String s,String lab) throws IOException{

    	char[] chars = s.toCharArray();
    	char bio ='B';
        for(int i=0;i<s.length();i++){ 
        	if(i!=0) bio = 'I';
        	if(Character.getType(chars[i]) == Character.OTHER_LETTER) //�ж��Ƿ�Ϊ����
        	{
        		outprint(chars[i],bio,lab);

        	}else if(Character.isLetter(chars[i])||Character.isDigit(chars[i])) //��ĸ
        	{       
        		int n = word(s,"[A-Za-z0-9]+",bio,lab);
        		for (int j=0;j<n;j++){
        			chars[i+j]+='��';
        		}
        		s=String.valueOf(chars);
        		i=i+n-1;
        	}else if(chars[i]!=' ')
        	{
        		outprint(chars[i],bio,lab);
        	}
        }
    	
    	
    	return s;
    }
    public static String string_split(String s) throws IOException{

    	char[] chars = s.toCharArray();
    	char bio ='O';
        for(int i=0;i<s.length();i++){ 
        	if(Character.getType(chars[i]) == Character.OTHER_LETTER) //�ж��Ƿ�Ϊ����
        	{
        		outprint(chars[i],bio);

        	}else if(Character.isLetter(chars[i])||Character.isDigit(chars[i])) //��ĸ
        	{       
        		int n = word(s,"[A-Za-z0-9]+",bio);
        		for (int j=0;j<n;j++){
        			chars[i+j]+='��';
        		}
        		s=String.valueOf(chars);
        		i=i+n-1;
        	}else if(chars[i]!=' ')
        	{
        		outprint(chars[i],bio);
        	}
        }
    	
    	
    	return s;
    }
    //����������ʽ ʶ��Ӣ�ĵ�������       ���� ����
	private static int word(String s,String ss1,char bio,String lab) throws IOException {
		// TODO Auto-generated method stub
		String temp =null;
        Pattern pa1 = Pattern.compile(ss1); 
        Matcher ma1 = null; 
        ma1 = pa1.matcher(s); 
        if(ma1.find()){
        temp = ma1.group();
        outprint1(temp,bio,lab);
        }
		return temp.length();
	}	
	private static int word(String s,String ss1,char bio) throws IOException {
		// TODO Auto-generated method stub
		String temp =null;
        Pattern pa1 = Pattern.compile(ss1); 
        Matcher ma1 = null; 
        ma1 = pa1.matcher(s); 
        if(ma1.find()){
        temp = ma1.group();
        outprint1(temp,bio);
        }
		return temp.length();
	}
	
	//ʶ��< > /��λ��
	public static int[] dis(String s){
		int[] num=new int[3];
		char[] chars =s.toCharArray();
		int len =chars.length;
		for(int i=0;i<len;i++){
			if(chars[i]=='>') num[0]=i;
			if(chars[i]=='<') num[1]=i;
			if(chars[i]=='/') num[2]=i;
		}
		return num;
	}
	public static String subString(String s,int [] num){
		String temp = null;
		if(num[0]==0){
			temp=s.substring(0, num[1]);
		}else if(num[1]==0){
			temp=s.substring(num[0]+1);
		}else {
			temp=s.substring(num[0]+1, num[1]);
		}
		return temp;
	}
	
} 
package com.nt.test;

import java.util.StringTokenizer;

public class LengthFounder {

	static public int maxNoOfWords(String str){
		int result=0,count=0;
		StringTokenizer st,st1;
		st=new StringTokenizer(str,".?!");
		count=st.countTokens();
		while(st.hasMoreElements()){
			count=0;
			String temp=(String)st.nextElement();
			String []tempWords= temp.split(" ");
			for(String s:tempWords){
				++count;
			} 
			if(result < count)
				result=count;
			/*System.out.println(temp+" "+count);*/
			
		}
		System.out.println();
		return result;
	}
	
	
	
	public static void main(String[] args) {
		
		System.out.println(maxNoOfWords("This is java.Are you new?Your!are most welcomed here."));
	}
}

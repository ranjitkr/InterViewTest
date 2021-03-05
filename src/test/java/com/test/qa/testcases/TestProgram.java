package com.test.qa.testcases;

public class TestProgram {

	public static void main(String[] args) {
		
		String str="Ranjit Alok Amit Umesh";
		String[] sarr=str.split(" ");
		for(int i=0;i<sarr.length;i++) {
			
			char ch=sarr[i].charAt(0);
			
			if(ch=='A' || ch=='E' || ch=='O' || ch=='I' || ch=='U') {
				System.out.println(sarr[i]);
			}
		}

	}

}

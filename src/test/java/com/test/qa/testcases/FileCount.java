package com.test.qa.testcases;

public class FileCount {
	
	public static int add(int ...a) {
		int[] i1=a;
		int add1=0;
		for(int i=0;i<i1.length;i++) {
			add1=add1+i1[i];
		}
		return add1;
		
	}

	public static void main(String[] args) {
		
		System.out.println(add(10,20,30,70,80));

	}

}

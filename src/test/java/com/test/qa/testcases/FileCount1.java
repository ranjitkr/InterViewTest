package com.test.qa.testcases;

import java.io.File;
import java.io.FilenameFilter;

public class FileCount1 {
	
	public static void main(String[] args) {
		
		File file = new File("./src/test/resources");
		File[] files = file.listFiles(new FilenameFilter() {
			
			public boolean accept(File dir, String name) {
				
				if(name.toLowerCase().endsWith(".pdf")) {
					return true;
				}
				else if(name.toLowerCase().endsWith(".csv")) {
					return true;
				}
				else if(name.toLowerCase().endsWith(".txt")) {
					return true;
				}
				return false;
			}
		});
		int pdfcount=0,txtCount=0,csvCount=0;
		for(File f:files) {
			
			if(f.getName().endsWith(".pdf")) {
				pdfcount++;
			}else if(f.getName().endsWith(".txt")) {
				txtCount++;
			}
			else if(f.getName().endsWith(".csv")) {
				csvCount++;
			}
			
		}
		
		System.out.println("PDF==>"+pdfcount+" TXT==>"+txtCount+" CSV==> "+csvCount);
	}

}

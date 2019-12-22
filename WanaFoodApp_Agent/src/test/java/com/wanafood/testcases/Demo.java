package com.wanafood.testcases;

public class Demo {
	public  static void main(String args[]) {
	String str="rs.12.02kg/g";
	str=str.replaceAll("rs.", " ");
	str=str.replaceAll("[^.0-9]", "");
	System.out.println("-->"+str);
	Float f=Float.valueOf(str);
	System.out.println("f-->"+f);
}
}
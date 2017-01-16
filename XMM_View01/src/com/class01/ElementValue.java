package com.class01;

import org.dom4j.Element;

public class ElementValue {
	 String elementXML = "";
	public  void getElementText(Element element){
		
//		System.out.println(" <li><span class='file'>  "+element.getText()+"</span></li></ul></li>");
		
		elementXML += " <li><span class='file'>  "+element.getText()+"</span></li></ul></li>";
	}
	
	
	public String getElementXML() {
		return elementXML;
	}
	

}

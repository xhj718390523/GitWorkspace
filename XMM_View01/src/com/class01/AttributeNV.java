package com.class01;


import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Element;
/**
 * 
 * @author XHJ
 * 获取节点名称以及属性
 */
public class AttributeNV {
	  String attributeXML = "";
	   String attr = "";
	   String end = "";
	public  void getNV(Element root ){
		attributeXML += "<li><span class='folder'>&lt"+root.getName()+" ";
		
//		System.out.print("<li><span class='folder'>&lt"+root.getName()+" ");
		//--获取节点属性集合遍历器-------	
			Iterator it =root.attributeIterator();
		//--遍历节点属性---	
			while (it.hasNext()) {
				Attribute attribute = (Attribute) it.next();
				String text = attribute.getText();
//	           System.out.print(attribute.getName()+" : "+text+" ");
	           
		           attr += attribute.getName()+" : "+text+" ";
				
			}
			
//			System.out.println("&gt</span><ul>");
			attributeXML += attr + "&gt</span><ul>";
	}
	public  String getAttributeXML() {
		return attributeXML;
	}
	
	public String getEnd(){
		return "</ul>";
	}
 
}

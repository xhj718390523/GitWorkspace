package com.class01;

import java.util.Iterator;

import org.dom4j.Element;

import com.class01.AttributeNV;;

public class ElementIt {
	 String elementItXML = "";
  public  void ItElement(Element root){
//		Iterator elementIterator = root.elementIterator();
		/**
		while (elementIterator.hasNext()) {
			
			AttributeNV attributeNV = null;
			ElementValue elementValue = null;
			//--获取节点对象， 并输出-------
			Element element = (Element) elementIterator.next();
			Iterator element_1 = element.elementIterator();
			//--判断节点是否包含子节点，如果包含，遍历子节点---------
			if(element_1.hasNext()){
				//---如果包含子节点   ------
				while (element_1.hasNext()) {
					//--获取子节点集合
					Element element02 = (Element) element_1.next();
					Iterator element02_1 = element02.elementIterator();
					//---新增修改
					attributeNV = new AttributeNV();
					attributeNV.getNV(element );
					elementItXML += attributeNV.getAttributeXML();
					
					//---修改完成-----------------
					
					//--如果子节点还有子节点------------
					if(element02_1.hasNext()){
						
					}
					else{
						//---如果不包含子节点---------------
						attributeNV = new AttributeNV();
						attributeNV.getNV(element02);
						elementItXML += attributeNV.getAttributeXML();
						elementValue = new ElementValue();
						elementValue.getElementText(element02);
						elementItXML += elementValue.getElementXML();
						
					}
					//---新增修改
					elementItXML += "</ul></li>";
					//--修改完成
				}
			
			}else{
				//---如果不包含，输出节点值
				attributeNV = new AttributeNV();
				attributeNV.getNV(element);
				elementItXML += attributeNV.getAttributeXML();
			
				elementValue = new ElementValue();
				elementValue.getElementText(element);
				elementItXML += elementValue.getElementXML();
				
			}

		}
		elementItXML += "</ul></li>";
//		System.out.println("</ul></li>");
		 */
		
	//----------- 重写---------------------------
	  Iterator elementIterator = root.elementIterator();
	    //--AttributeNV 用于输出标签名，以及属性
	    AttributeNV attributeNV = new AttributeNV();
	    //--ElementValue 用于输出标签值
		ElementValue elementValue = new ElementValue();
		//---输出父节点--------
		attributeNV.getNV(root);
		elementItXML += attributeNV.getAttributeXML();
		//--遍历自标签
		while(elementIterator.hasNext()){
			//--如果子标签包含其他标签，则遍历子标签
			Element element01 = (Element) elementIterator.next();
			//--获取标签名，以及属性
			attributeNV = new AttributeNV();
			attributeNV.getNV(element01);
			elementItXML += attributeNV.getAttributeXML();
			Iterator elementIt01 = element01.elementIterator();
            //--判断是否包含自标签
			if(elementIt01.hasNext()){
				while(elementIt01.hasNext()){
					Element element02 = (Element) elementIt01.next();
					Iterator elementIt02 = element02.elementIterator();
					attributeNV = new AttributeNV();
					attributeNV.getNV(element02);
					elementItXML += attributeNV.getAttributeXML();
					if(elementIt02.hasNext()){
						//--如果包含子标签
						
					}else{
						elementValue = new ElementValue();
						elementValue.getElementText(element02);
						elementItXML += elementValue.getElementXML();
//						System.out.println(" abc "+element02.getText());
					}
//					elementItXML += attributeNV.getEnd();
				}
				
			//---如果不包含，则输出标签值	
			}else{
				elementValue = new ElementValue();
				elementValue.getElementText(element01);
				elementItXML += elementValue.getElementXML();
			}
			//---遍历结束------
			elementItXML += attributeNV.getEnd();
		}
		//--遍历结束------
		elementItXML += attributeNV.getEnd();
		
		
  }
 
public String getElementItXML() {
	return elementItXML;
}
  
}

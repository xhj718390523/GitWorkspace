package com.class01;

import java.io.Reader;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.class01.AttributeNV;;

public class TranslateXML {
	 String tranXML = "";
	public  void tran(Reader reader){
		//--读取xml文档
//				File file = new File("src/web.xml");
		AttributeNV attributeNV =new AttributeNV();
		ElementIt elementIt = new ElementIt();
				SAXReader saxReader = new SAXReader();
				try {
//					FileReader reader = new FileReader(file);
					Document document = saxReader.read(reader);
				//--获取根节点---------	
					Element root = document.getRootElement();
				//--获取根节点属性----	
//					attributeNV.getNV(root);
//					tranXML += attributeNV.getAttributeXML();
			    //--遍历子节点
					elementIt.ItElement(root);
					tranXML += elementIt.getElementItXML();
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					tranXML = "xml文件错误，请确认xml文件";
				}
				
	}
	
	public String getTranXML() {
		return tranXML;
	}

}

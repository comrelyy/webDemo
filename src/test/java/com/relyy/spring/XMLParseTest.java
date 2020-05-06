package com.relyy.spring;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Description
 * @Created by cairuirui
 * @Date 2020/5/6
 */
public class XMLParseTest {

	@Test
	public void parseTest() throws ParserConfigurationException, IOException, SAXException {
		InputStream inputStream = new ClassPathResource("spring/spring-bean.xml").getInputStream();
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		Document document = documentBuilder.parse(inputStream);
		Element documentElement = document.getDocumentElement();
		NodeList childNodes = documentElement.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			Node item = childNodes.item(i);
			NamedNodeMap attributes = item.getAttributes();
			if (attributes != null) {
				System.out.println(attributes.getNamedItem("id"));
				System.out.println(attributes.getNamedItem("class"));
			}
		}
	}
}

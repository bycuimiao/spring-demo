package com.bycuimiao.copy;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.xml.SimpleSaxErrorHandler;

/**
 * 这个demo把spring解析xml的主要点单拎出来，写成一个方法，可以读取xml.
 *
 * @author cuimiao
 * @since 07 January 2019
 */
public class DemoParseXml {

	protected static final Log logger = LogFactory.getLog(DemoParseXml.class);

	public static void main(String[] args) throws Exception{
		// 模仿spring加载bean的过程"applicationContext.xml"
		// 利用spring core包工具，解析文件到流，获取org.springframework.core.io.Resource对象
		Resource resource = new ClassPathResource("applicationContext.xml");
		// 通过Resource对象获取流对象 java.io.InputStream
		InputStream inputStream = resource.getInputStream();
		// 通过输入流对象获取 org.xml.sax.InputSource ，文件的源对象.
		InputSource inputSource = new InputSource(inputStream);
		// 将文件源对象处理为 文档对象 org.w3c.dom.Document
		Document root = doLoadDocument(inputSource);
		Element element = root.getDocumentElement();
		//System.out.println(element.getAttribute("default-lazy-init"));
		NodeList nl = element.getChildNodes();
		for (int i = 0; i < nl.getLength(); i++) {
			Node node = nl.item(i);
			if (node instanceof Element) {
				Element ele = (Element) node;
				// namespaceURI 标志了这个bean属于spring还是自定义，spring根据这个字段来对不同来源的bean进行不通逻辑的加载
				System.out.println("namespaceURI : " + ele.getNamespaceURI());
				// nodeName可以获取 标签名 ps:<bean id="hello" class="com.bycuimiao.demo.HelloService"/> 这里获取的就是"bean"
				// <myname:user id="testBean" userName="aaa" email="bbb"/> 这里获取的就是 myname:user
				// 所以spring用这个字段区分 import bean alias beans的情况
				System.out.println("nodeName : " + ele.getNodeName());
				String id = ele.getAttribute("id");
				System.out.println("id : " + id);
				String classStr = ele.getAttribute("class");
				System.out.println("class : " + classStr);
			}

		}
	}

	private static Document doLoadDocument(InputSource inputSource) throws Exception{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(true);
		factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
		// factory 创建无误
		DocumentBuilder docBuilder = factory.newDocumentBuilder();
		docBuilder.setErrorHandler(new SimpleSaxErrorHandler(logger));
		docBuilder.setEntityResolver(new MyEntityResolver());
		return docBuilder.parse(inputSource);
	}
}

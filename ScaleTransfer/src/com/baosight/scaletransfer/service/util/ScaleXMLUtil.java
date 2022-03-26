package com.baosight.scaletransfer.service.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.UserDataHandler;
import org.xml.sax.SAXException;
import com.baosight.scaletransfer.bean.Scale;
import com.ctc.wstx.util.StringUtil;

/**
 * xml操作工具类
 * @author tianwei
 * @date 2019年1月8日
 * @version 1.0
 */
public class ScaleXMLUtil {
	private static DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder builder;
	private static Document doc;
	
	public static Scale loadXMLToBean(File file) {
		String rootName = null;
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			rootName = doc.getDocumentElement().getTagName();
			Element root = doc.getDocumentElement();
			Element element = doc.createElement("scaleLogs");
			element.setAttribute("archiveFlag", " ");
			root.appendChild(element);
			NodeList scaleList = root.getElementsByTagName("scaleLogs");
			Node item = scaleList.item(0);
			Element scaleElement = (Element) item;
			scaleElement.setAttribute("archiveFlag", "dsdsds");
			scaleElement.getAttribute("logGrade");
			System.out.println(scaleElement.getAttribute("logGrade"));
			//nameList.item(0).setTextContent("这里是我修改的名字");
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "gbk");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");  
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			Source source = new DOMSource(doc);
			Result result = new StreamResult(file);
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		//自己现编的
		map.put("Ethernet_ip", "192.168.100.3");
		map.put("Ethernet_port", "2012");
		updateConfig(map , new File("d:/testConfig.xml"));
	}*/
	
	/**
	 * 	执行返回执行结果info
	 * @param file
	 * @param deviceIds
	 * @return
	 */
	public static String deleteElements(File file, List<String> deviceIds) {
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			Element root = doc.getDocumentElement();
			NodeList list = root.getElementsByTagName("scales");
			NodeList list1 = root.getElementsByTagName("Communication");
			for(String deviceId : deviceIds) {
				for(int i = 0; i < list.getLength(); i++) {
					Node scaleNode = list.item(i);
					if(scaleNode.getNodeType() == Node.ELEMENT_NODE) {
						NamedNodeMap nodeMap = scaleNode.getAttributes();
						Node node = nodeMap.getNamedItem("deviceId");
						if(node.getTextContent().equals(deviceId)) {
							String a = node.getTextContent();
							System.out.println(a);
							root.removeChild(scaleNode);
							break; // 找到则退出for循环 如存在多个id一样的设备则需删除此行
						}
					}
				}
				for(int j = 0; j < list1.getLength(); j++) {
					Node scaleNode = list1.item(j);
					if(scaleNode.getNodeType() == Node.ELEMENT_NODE) {
						NamedNodeMap nodeMap = scaleNode.getAttributes();
						Node node = nodeMap.getNamedItem("scaleId");
						if(node.getTextContent().equals(deviceId)) {
							String a = node.getTextContent();
							System.out.println(a);
							root.removeChild(scaleNode);
							break; // 找到则退出for循环 如存在多个id一样的设备则需删除此行
						}
					}
				}
				
				
			}
			//148-162   165
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "gbk");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");  
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			Source source = new DOMSource(doc);
			Result result = new StreamResult(file);
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return "ParserConfigurationException";
		} catch (SAXException e) {
			e.printStackTrace();
			return "SAXException";
		} catch (IOException e) {
			e.printStackTrace();
			return "IOException";
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return "TransformerConfigurationException";
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
			return "TransformerFactoryConfigurationError";
		} catch (TransformerException e) {
			e.printStackTrace();
			return "TransformerException";
		}
		
		return "success";
	}
	
	/** JAXB操作，只能用于读取,生成
	 * 	将xml转换成对应的javaBean
	 * @return
	 */
	public static Object xmlToBean(String xmlPath, Class<?> load){
        JAXBContext context = null;
        Unmarshaller unmarshaller = null;
        Object object = null;
		try {
			context = JAXBContext.newInstance(load);
			unmarshaller = context.createUnmarshaller();
			object = unmarshaller.unmarshal(new File(xmlPath));
		} catch (JAXBException e) {
			e.printStackTrace();
		}  
        return object;
    }
	
	/**
	 * 	读取所有配置数据
	 * @param file
	 * @return
	 */
	public static Map<String, String> loadConfig(File file) {
		Map<String, String> map = new HashMap<>();
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			Element root = doc.getDocumentElement();
			NodeList lists = root.getChildNodes();
			for(int i = 0; i < lists.getLength(); i++) {
				if(lists.item(i).getNodeType() == Node.ELEMENT_NODE) {
					if(!lists.item(i).getNodeName().equals("scales")) {
						NodeList nodes = lists.item(i).getChildNodes();
						for(int j = 0; j < nodes.getLength(); j ++) {
							if(nodes.item(j).getNodeType() == Node.ELEMENT_NODE) {
								map.put(nodes.item(j).getNodeName(), nodes.item(j).getTextContent());
							}
						}
					}
				}
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	public static String updateScaleInfo(Map<String, String> map, File file){
		
		/** 为了简单，map key，value所代表的数据做唯一处理*/
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			Element root = doc.getDocumentElement();	
			NodeList nodes = root.getElementsByTagName("Communication");
			for(int i = 0; i < nodes.getLength(); i++) {
				NamedNodeMap attributes = nodes.item(i).getAttributes();
				for(int j = 0;j<attributes.getLength();j++){
					if(attributes.item(j).getNodeValue().equals(map.get("scaleId"))){						
						NodeList childNodes = nodes.item(i).getChildNodes();
						for(int p = 0;p<childNodes.getLength();p++){
							if(!childNodes.item(p).getNodeName().equals("#text")){
								if(childNodes.item(p).getNodeName().equals("Ethernet_ip")){
									childNodes.item(p).setTextContent(map.get("Ethernet_ip"));
								}else if(childNodes.item(p).getNodeName().equals("Ethernet_port")){
									childNodes.item(p).setTextContent(map.get("Ethernet_port"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_num")){
									childNodes.item(p).setTextContent(map.get("SerialPort_num"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_baudrate")){
									childNodes.item(p).setTextContent(map.get("SerialPort_baudrate"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_standarddatabit")){
									childNodes.item(p).setTextContent(map.get("SerialPort_standarddatabit"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_stopbit")){
									childNodes.item(p).setTextContent(map.get("SerialPort_stopbit"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_paritybit")){
									childNodes.item(p).setTextContent(map.get("SerialPort_paritybit"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_strlen")){
									childNodes.item(p).setTextContent(map.get("SerialPort_strlen"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_digitalstartbit")){
									childNodes.item(p).setTextContent(map.get("SerialPort_digitalstartbit"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_digitalbitlen")){
									childNodes.item(p).setTextContent(map.get("SerialPort_digitalbitlen"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_unitstartbit")){
									childNodes.item(p).setTextContent(map.get("SerialPort_unitstartbit"));
								}else if(childNodes.item(p).getNodeName().equals("SerialPort_unitbitlen")){
									childNodes.item(p).setTextContent(map.get("SerialPort_unitbitlen"));
								}
								
								
								
							}
							
						}
						
						
					}
				}
			}
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "gbk");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");  
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			Source source = new DOMSource(doc);
			Result result = new StreamResult(file);
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			return "ParserConfigurationException";
		} catch (SAXException e) {
			e.printStackTrace();
			return "SAXException";
		} catch (IOException e) {
			e.printStackTrace();
			return "IOException";
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
			return "TransformerConfigurationException";
		} catch (TransformerFactoryConfigurationError e) {
			e.printStackTrace();
			return "TransformerFactoryConfigurationError";
		} catch (TransformerException e) {
			e.printStackTrace();
			return "TransformerException";
		}
		return "success";
	}
	
	public static String insertConfig(Map<String, String> map, File file){
		try {
			builder = factory.newDocumentBuilder();
			doc = builder.parse(file);
			Element newElement = doc.createElement("scales");
			Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()){
				Entry<String, String> next = iterator.next();
				newElement.setAttribute(next.getKey(), next.getValue());
				
			}
						
			Element CommElement = doc.createElement("Communication");
			CommElement.setAttribute("scaleId", map.get("deviceId"));
			Element Child1 = doc.createElement("Ethernet_ip");
			Element Child2 = doc.createElement("Ethernet_port");			
			Element Child3 = doc.createElement("SerialPort_num");
			Element Child4 = doc.createElement("SerialPort_baudrate");
			Element Child5 = doc.createElement("SerialPort_standarddatabit");
			Element Child6 = doc.createElement("SerialPort_stopbit");
			Element Child7 = doc.createElement("SerialPort_paritybit");
			Element Child8 = doc.createElement("SerialPort_strlen");
			Element Child9 = doc.createElement("SerialPort_digitalstartbit");
			Element Child10 = doc.createElement("SerialPort_digitalbitlen");
			Element Child11 = doc.createElement("SerialPort_unitstartbit");
			Element Child12 = doc.createElement("SerialPort_unitbitlen");
			
			
			CommElement.appendChild(Child1);
			CommElement.appendChild(Child2);			
			CommElement.appendChild(Child3);
			CommElement.appendChild(Child4);
			CommElement.appendChild(Child5);
			CommElement.appendChild(Child6);
			CommElement.appendChild(Child7);
			CommElement.appendChild(Child8);
			CommElement.appendChild(Child9);
			CommElement.appendChild(Child10);
			CommElement.appendChild(Child11);
			CommElement.appendChild(Child12);
			
			Element rootElement = doc.getDocumentElement();
			
			rootElement.appendChild(newElement);
			rootElement.appendChild(CommElement);
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "gbk");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");  
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			Source source = new DOMSource(doc);
			Result result = new StreamResult(file);
			
			transformer.transform(source, result);
			
		} catch (ParserConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return "success";
	}
	
	/**
	 * 	根据scaleId获取配置以太网数据
	 * @param scaleId
	 * @param file
	 * @return
	 */
	public static Map<String, String> getCommunication(String scaleId, File file){
		Map<String, String> map = new HashMap<>();
			try {
				builder = factory.newDocumentBuilder();
				doc = builder.parse(file);
				Element root = doc.getDocumentElement();
				NodeList list = root.getElementsByTagName("Communication");
				for(int i = 0; i < list.getLength(); i++) {
					if(list.item(i).getNodeType() == Node.ELEMENT_NODE) {
						NamedNodeMap attributes  = list.item(i).getAttributes();
						String attributeName = null;
						String attributeValue = null;
						for (int j = 0; j < attributes.getLength(); j++) {
		                    Node attribute = attributes.item(j);
		                    attributeName = attribute.getNodeName();
		                    attributeValue = attribute.getNodeValue();
		                }
						if(attributeName != null) {
							if(attributeName.equals("scaleId") && attributeValue.equals(scaleId)) {
								NodeList ethernetInfo = list.item(i).getChildNodes();
								for(int k = 0; k < ethernetInfo.getLength(); k++) {
									if(ethernetInfo.item(k).getNodeType() == Node.ELEMENT_NODE) {
										map.put(ethernetInfo.item(k).getNodeName(), ethernetInfo.item(k).getTextContent());
									}
								}
							}
						}
					}
				}
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return map;
	}
	
	public static Map<String, String> getScaleInfo(String scaleId, File file){
		Map<String, String> map = new HashMap<>();
			try {
				builder = factory.newDocumentBuilder();
				doc = builder.parse(file);
				Element root = doc.getDocumentElement();
				NodeList list = root.getElementsByTagName("scales");
				
				for(int i = 0; i < list.getLength(); i++) {
					if(list.item(i).getNodeType() == Node.ELEMENT_NODE) {
						NamedNodeMap attributes  = list.item(i).getAttributes();
						String attributeValue = null;
						attributeValue = attributes.getNamedItem("deviceId").getNodeValue();
						if(attributeValue.equals(scaleId)){
							for(int k = 0; k < attributes.getLength(); k++) {				
								map.put(attributes.item(k).getNodeName(), attributes.item(k).getTextContent());							
						}				
						}
					}
				}
					
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return map;
	}
	
	
	public static Map<String, String> getScaleErroInfo(File file){
		Map<String, String> map = new HashMap<>();
		String k = null;
		String v = null;
			try {
				builder = factory.newDocumentBuilder();
				doc = builder.parse(file);
				Element root = doc.getDocumentElement();
				NodeList list = root.getElementsByTagName("MT_SICS_NG_INFO");
				for(int i = 0; i < list.getLength(); i++) {
					if(list.item(i).getNodeType() == Node.ELEMENT_NODE) {
						NodeList nodeList = list.item(i).getChildNodes();
						for(int j = 0; j < nodeList.getLength(); j++) {
							if(nodeList.item(j).getNodeType() == Node.ELEMENT_NODE) {
								if(nodeList.item(j).getNodeName().equals("RESPONSE")) {
									k = nodeList.item(j).getTextContent();
								}
								if(nodeList.item(j).getNodeName().equals("DESC")) {
									v = nodeList.item(j).getTextContent();
								}
							}
						}
						map.put(k, v);
					}
				}
			} catch (ParserConfigurationException e) {
				e.printStackTrace();
			} catch (SAXException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return map;
	}
}

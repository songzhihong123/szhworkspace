package com.baosight.scaletransfer.service.webService.impl;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
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


import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.baosight.scaletransfer.bean.ScaleLog;
import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;
import com.baosight.scaletransfer.service.util.StringFormatUtil;
import com.baosight.scaletransfer.service.webService.IScaleCommService;
import com.baosight.scaletransfer.service.webService.ScaleService;
import com.baosight.scaletransfer.service.webService.mode.ScaleSocketServiceImpl;

@WebService
public class ScaleServiceImpl implements ScaleService{
	
	public static JAXRSServerFactoryBean factoryBean;
	public static void beginSocket(){
		factoryBean = new JAXRSServerFactoryBean();  
        factoryBean.setAddress("http://localhost:8739/WcfWeighService");
        factoryBean.setServiceBean(new ScaleServiceImpl());
        factoryBean.create();
	}
	
	public String findChidClassByScalId(String scaleId){
		Map<String, String> scaleInfoMap = ScaleXMLUtil.getScaleInfo(scaleId, new File(CommConstant.xmlPath));
		String className = scaleInfoMap.get("processingClass"); 
		return className;
	}
	

	@Override
	public String getWeighValue(String scaleId) {
		String info = null;
		ScaleServiceImpl impl = new ScaleServiceImpl();
		String processingClass = impl.findChidClassByScalId(scaleId);
		try {
			
			Class<?> class1 = Class.forName(processingClass);
			Constructor<?> constructor = class1.getConstructor(String.class);
			Method method = class1.getMethod("getWeighValue", String.class);
			info = (String)method.invoke(constructor.newInstance(scaleId), scaleId);
			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public String scaleIsOnline(String scaleId) {
		String info = null;
		ScaleServiceImpl impl = new ScaleServiceImpl();
		String processingClass = impl.findChidClassByScalId(scaleId);
		try {
			Class<?> class1 = Class.forName(processingClass);
			Constructor<?> constructor = class1.getConstructor(String.class);
			Method method = class1.getMethod("scaleIsOnline", String.class);
			info = (String)method.invoke(constructor.newInstance(scaleId), scaleId);			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return info;
		
	}

	@Override
	public String setTare(String scaleId, String tareValue, String uom) {
		String info = null;
		ScaleServiceImpl impl = new ScaleServiceImpl();
		String processingClass = impl.findChidClassByScalId(scaleId);
		try {
			Class<?> class1 = Class.forName(processingClass);
			Constructor<?> constructor = class1.getConstructor(String.class);
			Method method = class1.getMethod("setTare", String.class,String.class,String.class);
			info = (String)method.invoke(constructor.newInstance(scaleId), scaleId,tareValue,uom);			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return info;
		
	}

	@Override
	public String setClear(String scaleId) {
		String info = null;
		ScaleServiceImpl impl = new ScaleServiceImpl();
		String processingClass = impl.findChidClassByScalId(scaleId);
		try {
			Class<?> class1 = Class.forName(processingClass);
			Constructor<?> constructor = class1.getConstructor(String.class);
			Method method = class1.getMethod("setClear", String.class);
			info = (String)method.invoke(constructor.newInstance(scaleId), scaleId);			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public String getDeviceSeqNo(String scaleId) {
		String info = null;
		ScaleServiceImpl impl = new ScaleServiceImpl();
		String processingClass = impl.findChidClassByScalId(scaleId);
		try {
			Class<?> class1 = Class.forName(processingClass);
			Constructor<?> constructor = class1.getConstructor(String.class);
			Method method = class1.getMethod("getDeviceSeqNo", String.class);
			info = (String)method.invoke(constructor.newInstance(scaleId), scaleId);			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return info;
	}

	@Override
	public String getScaleInfo(String scaleId) {
		String info = null;
		ScaleServiceImpl impl = new ScaleServiceImpl();
		String processingClass = impl.findChidClassByScalId(scaleId);
		try {
			Class<?> class1 = Class.forName(processingClass);
			Constructor<?> constructor = class1.getConstructor(String.class);
			Method method = class1.getMethod("getScaleInfo", String.class);
			info = (String)method.invoke(constructor.newInstance(scaleId), scaleId);			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return info;
	}
	
	
	public void setLog(String opt,String info,HttpServletRequest request,String scaleId) {
		
		/*Socket socket = ScaleSocketUtil.getSocket(scaleId, new File(xmlPath));
		Map<String, String> map1 = ScaleSocketUtil.scaleSocket(socket, "I4");*/
		
		ScaleSocketServiceImpl service = new ScaleSocketServiceImpl(scaleId, new File(CommConstant.xmlPath));
		service.connect();
		Map<String, String> map1 = service.sendCmd("I4");
		
		String info1Bak = map1.get("result");
		String info1 = StringFormatUtil.getDeviceSeqNoFormat(info1Bak);
		
		IScaleCommService iScaleCommService = CommServiceConstructor.getIScaleCommService(scaleId);
		String ipAddr = iScaleCommService.getIpAddr(request);
		
		ScaleLog scaleLog = new ScaleLog();
		scaleLog.setRecCreatorTime(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));//发生时间
		scaleLog.setLogGrade("信息");//日志等级
		scaleLog.setOperationObject(info1);//操作对象
		scaleLog.setOperationType(opt);//操作类型
		scaleLog.setOperationSource(ipAddr);//来源
		scaleLog.setOperationDesc(info);//日志内容
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			File file = new File(CommConstant.LogXmlPath);
			DocumentBuilder documentBuilder = factory.newDocumentBuilder();
			Document document = documentBuilder.parse(file);
			Element root = document.getDocumentElement();
			Element createElement = document.createElement("scaleLogs");
			root.appendChild(createElement);
			NodeList nodeList = root.getElementsByTagName("scaleLogs");
			Element ele = (Element)nodeList.item(nodeList.getLength()-1);
			ele.setAttribute("recCreatorTime", scaleLog.getRecCreatorTime());
			ele.setAttribute("logGrade", scaleLog.getLogGrade());
			ele.setAttribute("operationObject", scaleLog.getOperationObject());
			ele.setAttribute("operationType", scaleLog.getOperationType());
			ele.setAttribute("operationSource", scaleLog.getOperationSource());
			ele.setAttribute("operationDesc", scaleLog.getOperationDesc());
			
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");  
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			Source source = new DOMSource(document);
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
			
	}


	@Override
	public String showMethods(String scaleId) {
		String info = null;
		ScaleServiceImpl impl = new ScaleServiceImpl();
		String processingClass = impl.findChidClassByScalId(scaleId);
		try {
			Class<?> class1 = Class.forName(processingClass);
			Constructor<?> constructor = class1.getConstructor(String.class);
			Method method = class1.getMethod("showMethods", String.class);
			info = (String)method.invoke(constructor.newInstance(scaleId), scaleId);			
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return info;
	}
	
	

}

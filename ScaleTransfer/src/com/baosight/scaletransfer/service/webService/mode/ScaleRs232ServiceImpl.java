package com.baosight.scaletransfer.service.webService.mode;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;
import com.baosight.scaletransfer.service.webService.IScaleCommService;

import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;

public class ScaleRs232ServiceImpl implements IScaleCommService  {


	private CommPortIdentifier com1 = null;
	private CommPortIdentifier com2 = null;
	private SerialPort serialcom1 = null;
	private SerialPort serialcom2 = null;
	private PrintWriter pw;
	private InputStream is;
	private BufferedReader br = null;
	private Map<String, String> communicationMap = null;
	private static Map<String, SerialPort> serialPortMap = null;
	private String scaleId;


	static{
		serialPortMap = new HashMap<>();
	}

	public static void main(String[] args) {
		ScaleRs232ServiceImpl s = new ScaleRs232ServiceImpl("testScale5",new File(CommConstant.xmlPath));
		s.connect();
		s.send("hello man");

	}
	public ScaleRs232ServiceImpl(){
		CommPortIdentifier portIdentifier = null;
		//1.2.记录所有端口的变量
		Enumeration<?> allPorts = CommPortIdentifier.getPortIdentifiers();
		//1.3.输出每一个端口
		while(allPorts.hasMoreElements()){
			portIdentifier = (CommPortIdentifier) allPorts.nextElement();
			System.out.println("串口：" + portIdentifier.getName());
		}
	}
	public ScaleRs232ServiceImpl(String scaleId,File file){	
		this.scaleId = scaleId;
		communicationMap = ScaleXMLUtil.getCommunication(scaleId, file);	
		//1.获取本地所有的端口并输出其名称：
		//1.1.用于标识端口的变量
		CommPortIdentifier portIdentifier = null;
		//1.2.记录所有端口的变量
		Enumeration<?> allPorts = CommPortIdentifier.getPortIdentifiers();
		//1.3.输出每一个端口
		while(allPorts.hasMoreElements()){
			portIdentifier = (CommPortIdentifier) allPorts.nextElement();
			System.out.println("串口：" + portIdentifier.getName());
		}

	}


	@Override
	public void connect() {
		serialcom2 = serialPortMap.get(scaleId);
		if(serialcom2 == null){
			try {
				com2 = CommPortIdentifier.getPortIdentifier(communicationMap.get("SerialPort_num"));
			} catch (NoSuchPortException e) {
				e.printStackTrace();
			}
			if(com2 != null){
				try {
					serialcom2 = (SerialPort)com2.open("OpenerAndCloser", 1000);
					serialcom2.setSerialPortParams(
							Integer.parseInt(communicationMap.get("SerialPort_baudrate")), //波特率
							Integer.parseInt(communicationMap.get("SerialPort_standarddatabit")),//数据位数
							Integer.parseInt(communicationMap.get("SerialPort_stopbit")),//停止位
							Integer.parseInt(communicationMap.get("SerialPort_paritybit"))//奇偶位
							);
					serialPortMap.put(scaleId, serialcom2);
				} catch (PortInUseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				} catch (UnsupportedCommOperationException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		

	}


	@Override
	public void send(String info) {
		try {
			pw = new PrintWriter(serialcom2.getOutputStream());
			pw.write(info+"\r\n");
			pw.flush();
			System.out.println(info);
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			pw.close();
		}


	}

	@Override
	public String recv() {
		String readLine = null;
		BufferedReader reader = null;		
		try {
			reader = new BufferedReader(new InputStreamReader(serialcom2.getInputStream()));
			readLine = reader.readLine();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			try {
				reader.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
		return readLine;
	}


	@Override
	public void disConnect() {
		if(serialcom1 != null){
			serialcom1.close();	
			serialcom1 = null;
			com1 = null;
		}
		if(serialcom2 != null){
			serialcom2.close();	
			serialcom2 = null;
			com2 = null;
		}	
	}

	@Override
	public Map<String, String> sendCmd(String cmd) {
		// TODO 自动生成的方法存根
		Map<String, String> map = new HashMap<>();
		try {		
			pw = new PrintWriter(serialcom2.getOutputStream());
			pw.write(cmd+"\r\n");
			pw.flush();
			map.put("result","success");
			map.put("desc", "命令已成功执行");
		} catch (IOException e) {
			e.printStackTrace();
			map.put("desc", "命令执行失败");
		}		
		return map;
	}

	@Override
	public Map<String, String> sendCmd(String cmd, String endIdentification) {
		Map<String, String> map = new HashMap<>();
		String info = null;
		try {		
			pw = new PrintWriter(serialcom1.getOutputStream());
			pw.write(cmd+"\r\n");
			pw.flush();
			is = serialcom2.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			while((info=br.readLine()) != null && !info.equals(endIdentification)){
				map.put("desc", "error");
			}
			map.put("desc","success");
		} catch (IOException e) {
			e.printStackTrace();
		}

		return map;	
	}

	@Override
	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		if (ip.equals("0:0:0:0:0:0:0:1")) {
			ip = request.getRemoteAddr();
		}
		if (ip.split(",").length > 1) {
			ip = ip.split(",")[0];
		}
		return ip;
	}

}

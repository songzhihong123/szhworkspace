package com.baosight.scaletransfer.service.webService.mode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;
import com.baosight.scaletransfer.service.webService.IScaleCommService;

public class ScaleSocketServiceImpl implements IScaleCommService{
	
	private static String xmlPath; /* scale数据地址*/
	private static Map<String, String> erroInfo;	/* scale 异常信息*/
	private static Map<String, Socket> socketMap;	 /*缓存socket*/
	private Socket socket;
    private InputStream is;
    private OutputStream os;
    private BufferedReader br;
    private PrintWriter pw;
    private String scaleId;
    private Map<String, String> scaleInfo;/*获取秤的信息*/
    private Map<String, String> scaleEthernet;/*获取ip和port的信息*/
    
	static {
		xmlPath = CommConstant.xmlPath;
		erroInfo = ScaleXMLUtil.getScaleErroInfo(new File(xmlPath));
		socketMap = new HashMap<>();
	}

	public ScaleSocketServiceImpl(String scaleId,File file){
		this.scaleId = scaleId;
		scaleInfo = ScaleXMLUtil.getScaleInfo(scaleId, file);
		scaleEthernet = ScaleXMLUtil.getCommunication(scaleId, file);
	}
	
	
		
	@Override
	public void connect() {
		synchronized (Object.class) {
		socket = socketMap.get(scaleId);
		if(socket == null){
			try {
				socket = new Socket(scaleEthernet.get("Ethernet_ip"), Integer.parseInt(scaleEthernet.get("Ethernet_port")));
				socketMap.put(scaleId, socket);
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
           		
		}	
	}
	
	
	

	@Override
	public void send(String info) {	
		synchronized(Object.class){
			if(os != null){
				pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
				pw.write(info);
				pw.flush();		
			}else{
				try {
					os = socket.getOutputStream();
					pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(os)));
					pw.write(info);
					pw.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}
				
		}		
	}

	@Override
	public String recv() {		
		synchronized (Object.class) {			
			String readLine = null;
			if(is != null){
				try {
					br = new BufferedReader(new InputStreamReader(is));
					readLine = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}else{
				try {
					is = socket.getInputStream();
					br = new BufferedReader(new InputStreamReader(is));
					readLine = br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}		
			return readLine;
		}
			
	}

	@Override
	public void disConnect() {
		synchronized (Object.class) {
	        if(is!=null){
	        	try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        
	        if(os!=null){
	        	try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        
	        if(br!=null){
	        	try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        	        
	        if(socket!=null){
	        	try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        if(socketMap.get(scaleId) != null){
	        	socketMap.remove(scaleId);
	        }
	        
		}
		
	}

	
	
	@Override
	public Map<String, String> sendCmd(String cmd) {
		
		synchronized (Object.class) {
			Map<String, String> map = new HashMap<>();
			String info = null;
			try {
				os = socket.getOutputStream();
				pw =new PrintWriter(os);
				pw.write(cmd + "\r\n");
				pw.flush();
				is = socket.getInputStream();
				br = new BufferedReader(new InputStreamReader(is));
				while((info=br.readLine()) != null){
					System.out.println("我是客户端，服务器说："+info);
					for(Map.Entry<String, String> entry : erroInfo.entrySet()) {
						if(info.equals(entry.getKey())) {
							map.put("desc", entry.getValue());
							map.put("result", "");
							break;
						}
					}
					if(map.size() == 0){
						map.put("desc", "执行成功");
						map.put("result", info);
					}
					break;
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return map;
		}
		
	}


	@Override
	public Map<String, String> sendCmd(String cmd, String endIdentification) {
		Map<String, String> map = new HashMap<>();
		String info = null;
		try {
			os = socket.getOutputStream();
			pw =new PrintWriter(os);
			pw.write(cmd + "\r\n");
			pw.flush();
			is = socket.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			String strs="";
			while((info=br.readLine()) != null && !info.equals(endIdentification)){
			 System.out.println("我是客户端，服务器说："+info);
			 for(Map.Entry<String, String> entry : erroInfo.entrySet()) {
					if(info.equals(entry.getKey())) {
						map.put("desc", entry.getValue());
						map.put("result", "");
						break;
					}
				}
			 	strs = strs + "|" + info;
			}
			map.put("desc", "执行成功");
			map.put("result", strs);
		} catch (UnknownHostException e) {
			e.printStackTrace();
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

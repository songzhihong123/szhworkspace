package com.baosight.scaletransfer.service.webService;
import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/WeighService")
@WebService
public interface ScaleService {
	/**
	 * 获取称量重量
	 * */
	@GET
	@Path("/getWeighValue")
	@Produces({MediaType.TEXT_PLAIN+";charset=utf-8"})  
	public String getWeighValue(@QueryParam(value="scaleId") String scaleId);
	/**
	 * 获取秤是否在线
	 * */
	@GET
	@Path("/scaleIsOnline")
	@Produces({MediaType.TEXT_PLAIN+";charset=utf-8"})  
	public String scaleIsOnline(@QueryParam(value="scaleId") String scaleId);
	/**
	 * 设置皮重并去皮
	 * */
	@GET
	@Path("/setTare")
	@Produces({MediaType.TEXT_PLAIN+";charset=utf-8"})  
	public String setTare(	@QueryParam(value="scaleId") String scaleId,
							@QueryParam(value="tareValue") String tareValue,
							@QueryParam(value="uom") String uom);
	/**
	 * 清零
	 * */
	@GET
	@Path("/setClear")
	@Produces({MediaType.TEXT_PLAIN+";charset=utf-8"})  
	public String setClear(@QueryParam(value="scaleId") String scaleId);
	
	/**
	 * 获取秤的序列号
	 * */
	@GET
	@Path("/getDeviceSeqNo")
	@Produces({MediaType.TEXT_PLAIN+";charset=utf-8"})  
	public String getDeviceSeqNo(@QueryParam(value="scaleId") String scaleId);
	/**
	 * 获取秤的信息
	 * */
	@GET
	@Path("/getScaleInfo")
	@Produces({MediaType.TEXT_PLAIN+";charset=utf-8"})  
	public String getScaleInfo(@QueryParam(value="scaleId") String scaleId);
	/**
	 * 获取秤的可用方法
	 * */
	@GET
	@Path("/showMethods")
	@Produces({MediaType.TEXT_PLAIN+";charset=utf-8"})  
	public String showMethods(@QueryParam(value="scaleId") String scaleId);
	
	
	
	
	
}

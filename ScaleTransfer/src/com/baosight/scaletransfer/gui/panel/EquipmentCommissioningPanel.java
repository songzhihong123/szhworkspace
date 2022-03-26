package com.baosight.scaletransfer.gui.panel;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;

import com.alibaba.fastjson.JSONObject;
import com.baosight.scaletransfer.bean.Scale;
import com.baosight.scaletransfer.gui.ConstantsUI;
import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.util.CommScaleCmdConstant;
import com.baosight.scaletransfer.service.EquipmentComService;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;
import com.baosight.scaletransfer.service.util.StringFormatUtil;
import com.baosight.scaletransfer.service.impl.EquipmentComServiceImpl;
import com.baosight.scaletransfer.service.webService.IScaleCommService;
import com.baosight.scaletransfer.service.webService.impl.ScaleServiceImpl;
import com.baosight.scaletransfer.service.webService.mode.ScaleRs232ServiceImpl;
import com.baosight.scaletransfer.service.webService.mode.ScaleSocketServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>设备调试面板类</p>
 * @author tianwei
 * @date 2018年12月27日
 * @version 1.0
 */
public class EquipmentCommissioningPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private String deviceId;
	private EquipmentComService equipmentComService = new EquipmentComServiceImpl();
	private JTextField jTextField;	//数值显示
	private JTextField jTextField1;//电子秤名称
	private JTextField jTextField2; //电子秤是否在线
	private JTextArea area;//日志信息
	private DefaultTableModel model;
	private JTable table;//电子秤列表
	private JTable table1;//功能键
	private Class<?> classInstance;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private List<IScaleCommService> scaleCommServices = new ArrayList<>(); //存放IScaleCommService
	private ScaleServiceImpl scaleServiceImpl = new ScaleServiceImpl();


	public EquipmentCommissioningPanel() {
		initialize();
		addComponent();
	}

	/**
	 * 	初始化面板
	 */
	private void initialize() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setBorder(ConstantsUI.main_panel_border);
	}

	/**
	 * 	为面板添加组件
	 */
	private void addComponent() {
		this.add(getLeftPanel());
		this.add(getRightPanel());

	}

	/**
	 * @return
	 */
	private JPanel getLeftPanel() {
		JPanel leftPanel = new JPanel();
		leftPanel.setLayout(new BorderLayout());
		leftPanel.add(getLeftTopPanel(),BorderLayout.NORTH);
		leftPanel.add(getLeftCenterPanel(),BorderLayout.CENTER);
		leftPanel.add(getLeftBottomPanel(),BorderLayout.SOUTH);
		return leftPanel;
	}

	/**
	 * @return	左边panel顶部面板
	 */
	private JPanel getLeftTopPanel() {

		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JPanel leftTopPanel = new JPanel();
		leftTopPanel.setBackground(ConstantsUI.table_header);
		leftTopPanel.setLayout(new BorderLayout());
		leftTopPanel.setPreferredSize(new Dimension(450, 200));
		leftTopPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "电子秤列表",
				TitledBorder.LEFT, TitledBorder.TOP));

		String[] columnNames  = {"编号", "秤编码", "秤名称", "型号"};
		Object[][] datas = getScaleData();
		DefaultTableModel model = new DefaultTableModel(datas, columnNames);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(450, 200));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				//这个监听器会监听到两次鼠标按下和抬起的事件，当e.getValueIsAdjusting() == false时，表示鼠标抬起时执行
				if(e.getValueIsAdjusting() == false){
					jTextField1.setText("");
					jTextField2.setText("");
					DefaultTableModel model2 = (DefaultTableModel) table1.getModel();
					model2.setValueAt("", 0, 0);
					model2.setValueAt("", 0, 1);
					model2.setValueAt("", 0, 2);
					model2.setValueAt("", 0, 3);
					model2.setValueAt("", 0, 4);
					model2.fireTableStructureChanged();
					jTextField.setText("");
					int row = table.getSelectedRow();
					deviceId = (String)table.getValueAt(row, 1);
					Map<String, String> scaleInfoMap = ScaleXMLUtil.getScaleInfo(deviceId, new File(CommConstant.xmlPath));
					String processingClass = scaleInfoMap.get("processingClass");
					//通过反射来做
					try {
						classInstance =  Class.forName(processingClass);
						Constructor<?> constructor = classInstance.getConstructor(String.class);
						Method method = classInstance.getMethod("showMethods", String.class);
						String methods = (String)method.invoke(constructor.newInstance(deviceId),deviceId);

						if(methods.contains("getWeighValue")){
							jButton1.setEnabled(true);
						}else{
							jButton1.setEnabled(false);
						}

						if(methods.contains("setTare")){
							jButton2.setEnabled(true);
						}else{
							jButton2.setEnabled(false);
						}

						if(methods.contains("setClear")){
							jButton3.setEnabled(true);
						}else{
							jButton3.setEnabled(false);
						}

						if(methods.contains("getDeviceSeqNo")){
							jButton4.setEnabled(true);
						}else{
							jButton4.setEnabled(false);
						}

						if(methods.contains("scaleIsOnline")){
							jButton5.setEnabled(true);
						}else{
							jButton5.setEnabled(false);
						}

						if(methods.contains("getScaleInfo")){
							jButton6.setEnabled(true);
						}else{
							jButton6.setEnabled(false);
						}

						Timer timer = new Timer();
						Map<String, String> scaleInfo = ScaleXMLUtil.getScaleInfo(deviceId, new File(CommConstant.xmlPath));
						if(scaleInfo.get("remark").equals("Rs232")){
							IScaleCommService service = new ScaleRs232ServiceImpl(deviceId, new File(CommConstant.xmlPath));
							service.connect();
							//延迟5000ms，每1000ms执行一次
							timer.schedule(new TimerTask() {
								@Override
								public void run() {
									String recv = service.recv();
									if(recv != null){
										area.append(recv+"\n\r");
									}else{
										timer.cancel();
									}
								}
							}, 5000,1000);
						}
						
					} catch (ClassNotFoundException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO 自动生成的 catch 块
						e1.printStackTrace();
					}
				}
			}
		});





		// 设置表头样式
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(ConstantsUI.table_header);
		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table.getTableHeader().setDefaultRenderer(cellRenderer);
		TableColumn column = null;
		int colunms = table.getColumnCount();
		for (int i = 0; i < colunms; i++) {
			column = table.getColumnModel().getColumn(i);
			if (i == 0) {
				column.setPreferredWidth(54);
			} else {
				column.setPreferredWidth(128);
			}
		}
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(table);
		leftTopPanel.add(scroll);
		jPanel.add(leftTopPanel);
		return jPanel;
	}

	/**
	 * @return	左边panel中部面板
	 */
	private JPanel getLeftCenterPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JPanel leftCenterPanel = new JPanel();
		leftCenterPanel.setBackground(ConstantsUI.table_header);
		leftCenterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		leftCenterPanel.setPreferredSize(new Dimension(450, 130));
		leftCenterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "电子秤数据信息",
				TitledBorder.LEFT, TitledBorder.TOP));

		JLabel label1 = new JLabel("电子秤名称:");
		label1.setPreferredSize(new Dimension(70, 30));
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		jTextField1 = new JTextField();
		jTextField1.setPreferredSize(new Dimension(160, 30));
		jTextField1.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel label2 = new JLabel("是否在线:");
		label2.setPreferredSize(new Dimension(60, 30));
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		jTextField2 = new JTextField();
		jTextField2.setPreferredSize(new Dimension(60, 30));
		jTextField2.setHorizontalAlignment(SwingConstants.LEFT);

		leftCenterPanel.add(label1);
		leftCenterPanel.add(jTextField1);
		leftCenterPanel.add(label2);
		leftCenterPanel.add(jTextField2);

		String[] columnNames  = {"序列号", "设备型号", "称量单位", "最大称量", "最小称量"};
		Object[][] datas = getScaleDataInfo();
		model = new DefaultTableModel(datas, columnNames);
		table1 = new JTable(model);
		table1.setPreferredScrollableViewportSize(new Dimension(430, 40));
		// 设置表头样式
		DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
		cellRenderer.setBackground(ConstantsUI.table_header);
		cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		table1.getTableHeader().setDefaultRenderer(cellRenderer);
		TableColumn column = null;
		int colunms = table1.getColumnCount();
		for (int i = 0; i < colunms; i++) {
			column = table1.getColumnModel().getColumn(i);
			column.setPreferredWidth(86);
		}
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(table1);
		leftCenterPanel.add(scroll);

		jPanel.add(leftCenterPanel);
		return jPanel;
	}

	/**
	 * @return	左边panel底部面板
	 */
	private JPanel getLeftBottomPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);
		jPanel.setBackground(Color.BLACK);

		JPanel leftBottomPanel = new JPanel();
		leftBottomPanel.setBackground(Color.BLACK);
		leftBottomPanel.setLayout(new BorderLayout());
		leftBottomPanel.setPreferredSize(new Dimension(450, 185));
		leftBottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "数值显示",
				TitledBorder.LEFT, TitledBorder.TOP,
				null, Color.GREEN));
		// 称重显示文本框
		jTextField = new JTextField();
		jTextField.setBorder(null);
		jTextField.setBackground(null);
		jTextField.setEditable(false);
		jTextField.setPreferredSize(new Dimension(440,180));
		jTextField.setFont(new Font("宋体",Font.BOLD,28));
		jTextField.setForeground(Color.GREEN);
		leftBottomPanel.add(jTextField,BorderLayout.EAST);

		jPanel.add(leftBottomPanel);
		return jPanel;
	}


	/**
	 * @return
	 */
	private JPanel getRightPanel() {
		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BorderLayout());
		rightPanel.add(getRightTopPanel(),BorderLayout.NORTH);
		rightPanel.add(getRightCenterPanel(),BorderLayout.CENTER);
		rightPanel.add(getRightBottomPanel(),BorderLayout.SOUTH);
		return rightPanel;
	}




	/**
	 * @return	右边panel上面面板
	 */
	private JPanel getRightTopPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(ConstantsUI.table_header);
		rightPanel.setLayout(new GridLayout(3,2));
		rightPanel.setPreferredSize(new Dimension(376, 330));//550
		rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "功能键",
				TitledBorder.LEFT, TitledBorder.TOP));

		jButton1 = new JButton("称重");
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if(deviceId == null){
							JOptionPane.showMessageDialog(null, "请选择一个设备");
							return;
						}						
						String weighValue = scaleServiceImpl.getWeighValue(deviceId);
						Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(weighValue);
						if(jsonInfo.get("Uom").equals("null")){
							jTextField.setText(jsonInfo.get("ResultDesc"));
							area.append("称重 : "+jsonInfo.get("ResultDesc")+"\n\r");
						} else {
							jTextField.setText(jsonInfo.get("Weight")+jsonInfo.get("Uom"));
							area.append("称重 : "+jsonInfo.get("ResultDesc")+"\n\r");
							
						}

					}
				});
			}
		});
		jButton1.setFont(new Font("宋体", Font.BOLD, 22));

		jButton2 = new JButton("去皮");
		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if(deviceId == null){
							JOptionPane.showMessageDialog(null, "请选择一个设备");
							return;
						}
						String setTare = scaleServiceImpl.setTare(deviceId,null,null);
						Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(setTare);
						if(jsonInfo.get("Uom").equals("null") ){
							jTextField.setText(jsonInfo.get("ResultDesc"));
							area.append("去皮 : "+jsonInfo.get("ResultDesc")+"\n\r");
						} else {
							jTextField.setText(jsonInfo.get("tare")+jsonInfo.get("Uom"));
							area.append("去皮 : "+jsonInfo.get("ResultDesc")+"\n\r");
						}
					}
				});
			}
		});
		jButton2.setFont(new Font("宋体", Font.BOLD, 22));

		jButton3 = new JButton("清零");
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if(deviceId == null){
							JOptionPane.showMessageDialog(null, "请选择一个设备");
							return;
						}
						String setClearInfo = scaleServiceImpl.setClear(deviceId);
						Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(setClearInfo);
						if(setClearInfo != null){
							jTextField.setText("0.00");
							area.append("清零 : "+jsonInfo.get("ResultDesc")+"\n\r");
						} else{
							jTextField.setText("");
							area.append("清零 : "+"发生错误"+"\n\r");
						}
						
					}
				});
			}
		});
		jButton3.setFont(new Font("宋体", Font.BOLD, 22));
		jButton4 = new JButton("秤序列号");
		jButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "请选择一个设备");
					return;
				}
				String getDeviceSeqNo = scaleServiceImpl.getDeviceSeqNo(deviceId);
				Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(getDeviceSeqNo);
				if(jsonInfo.get("ResultDesc") != ""){
					jTextField.setText("");
					area.append("获取序列号 : "+jsonInfo.get("ResultDesc")+"\n\r");
					DefaultTableModel model2 = (DefaultTableModel) table1.getModel();
					model2.setValueAt(jsonInfo.get("deviceSeqNo") , 0, 0);
					jTextField1.setText(jsonInfo.get("deviceSeqNo") );
					model2.fireTableStructureChanged();
				} else {
					jTextField.setText("");
					area.append("称重 : "+jsonInfo.get("ResultDesc")+"\n\r");
				}

			}
		});

		jButton4.setFont(new Font("宋体", Font.BOLD, 22));
		jButton5 = new JButton("在线检测");
		jButton5.setFont(new Font("宋体", Font.BOLD, 22));
		jButton5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "请选择一个设备");
					return;
				}
				String scaleIsOnline = scaleServiceImpl.scaleIsOnline(deviceId);
				Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(scaleIsOnline);
				if(jsonInfo.get("ResultDesc") != null){
					area.append("检测秤是否在线："+jsonInfo.get("scaleStatus")+"\n\r");
					jTextField2.setText("在线");
				}else{
					area.append("检测秤是否在线："+jsonInfo.get("scaleStatus")+"\n\r");
					jTextField2.setText("离线");
				}
			}
		});
		jButton6 = new JButton("秤信息");
		jButton6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "请选择一个设备");
					return;
				}
				String getScaleInfo = scaleServiceImpl.getScaleInfo(deviceId);
				Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(getScaleInfo);
				DefaultTableModel model2 = (DefaultTableModel) table1.getModel();
				model2.setValueAt(jsonInfo.get("设备型号"), 0, 1);
				model2.setValueAt(jsonInfo.get("量程单位"), 0, 2);
				model2.setValueAt(jsonInfo.get("最大量程"), 0, 3);
				model2.setValueAt(jsonInfo.get("最小量程"), 0, 4);
				model2.fireTableStructureChanged();
				area.append("获取秤信息："+getScaleInfo+"\n\r");
			}
		});
		jButton6.setFont(new Font("宋体", Font.BOLD, 22));

		rightPanel.add(jButton1);
		rightPanel.add(jButton2);
		rightPanel.add(jButton3);
		rightPanel.add(jButton4);
		rightPanel.add(jButton5);
		rightPanel.add(jButton6);


		jPanel.add(rightPanel);
		return jPanel;
	}


	/**
	 * @return	右边中间panel底部面板
	 */
	private JPanel getRightCenterPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);


		JPanel rightBottomPanel = new JPanel();
		rightBottomPanel.setBackground(ConstantsUI.table_header);
		rightBottomPanel.setLayout(new CardLayout(1,1));
		rightBottomPanel.setPreferredSize(new Dimension(376, 160));
		rightBottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "日志信息",
				TitledBorder.LEFT, TitledBorder.TOP,
				null, Color.BLACK));
		area = new JTextArea();
		area.setSize(new Dimension(300, 100));
		area.setLineWrap(true);

		JScrollPane scroll = new JScrollPane(area); 
		scroll.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 

		rightBottomPanel.add(scroll,BorderLayout.CENTER);




		jPanel.add(rightBottomPanel);
		return jPanel;
	}


	/**
	 * @return	右边下面panel底部面板
	 */
	private JPanel getRightBottomPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JLabel label1 = new JLabel("WebService服务:");
		label1.setFont(new Font("宋体", Font.BOLD, 22));


		JButton jButton1 = new JButton("启动");
		jButton1.setFont(new Font("宋体", Font.BOLD, 22));
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "请选择一个设备");
					return;
				}
				try {
					JAXRSServerFactoryBean factoryBean = ScaleServiceImpl.factoryBean;
					//					Field field = classInstance.getField("factoryBean");		
					//					JAXRSServerFactoryBean factoryBean = (JAXRSServerFactoryBean)field.get(null);
					Server server = factoryBean.getServer();
					if(server.isStarted() == false) {
						server.start();
						area.append("web服务启动成功"+"\n\r");
					}else {
						area.append("web服务正处于启动状态"+"\n\r");
					}
				}  catch (SecurityException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} 
			}
		});

		JButton jButton2 = new JButton("关闭");
		jButton2.setFont(new Font("宋体", Font.BOLD, 22));
		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "请选择一个设备");
					return;
				}
				try {
					JAXRSServerFactoryBean factoryBean = ScaleServiceImpl.factoryBean;
					//	Field field = classInstance.getField("factoryBean");		
					// JAXRSServerFactoryBean factoryBean = (JAXRSServerFactoryBean)field.get(null);n;
					Server server = factoryBean.getServer();
					if(server.isStarted() == true) {
						server.stop();
						area.append("web服务暂停执行成功"+"\n\r");
					}else {
						area.append("web服务正处于停止状态"+"\n\r");
					}
				}catch (SecurityException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
			}
		});



		jPanel.add(label1);
		jPanel.add(jButton1);
		jPanel.add(jButton2);
		return jPanel;
	}

	/**
	 *	获取所有设备数据信息
	 * @return
	 */
	private Object[][] getScaleDataInfo() {
		// 执行sql获取list<Scale>
		List<Scale> scaleList = new ArrayList<>();
		Scale scale = new Scale();
		scaleList.add(scale);

		int scaleSize = scaleList.size();
		Object[][] scales = new Object[scaleSize][5];
		for (int i = 0; i < scaleSize; i++) {
			scales[i][0] = scaleList.get(i).getDeviceSeqNo();
			scales[i][1] = scaleList.get(i).getDeviceId();
			scales[i][2] = scaleList.get(i).getDeviceCname();
			scales[i][3] = scaleList.get(i).getProcessingClass();
			scales[i][4] = scaleList.get(i).getDeviceCname();
		}
		return scales;
	}

	/**
	 *	获取所有设备信息
	 * @return
	 */
	private Object[][] getScaleData() {
		// 获取list<Scale>
		List<Scale> scaleList = equipmentComService.loadEquiment();
		int scaleSize = scaleList.size();
		Object[][] scales = new Object[scaleSize][4];
		for (int i = 0; i < scaleSize; i++) {
			scales[i][0] = i + 1;
			scales[i][1] = scaleList.get(i).getDeviceId();
			scales[i][2] = scaleList.get(i).getDeviceCname();
			scales[i][3] = scaleList.get(i).getDeviceSeqNo();
		}
		return scales;
	}

}

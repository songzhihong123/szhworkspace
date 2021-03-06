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
 * <p>?????????????????????</p>
 * @author tianwei
 * @date 2018???12???27???
 * @version 1.0
 */
public class EquipmentCommissioningPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private String deviceId;
	private EquipmentComService equipmentComService = new EquipmentComServiceImpl();
	private JTextField jTextField;	//????????????
	private JTextField jTextField1;//???????????????
	private JTextField jTextField2; //?????????????????????
	private JTextArea area;//????????????
	private DefaultTableModel model;
	private JTable table;//???????????????
	private JTable table1;//?????????
	private Class<?> classInstance;
	private JButton jButton1;
	private JButton jButton2;
	private JButton jButton3;
	private JButton jButton4;
	private JButton jButton5;
	private JButton jButton6;
	private List<IScaleCommService> scaleCommServices = new ArrayList<>(); //??????IScaleCommService
	private ScaleServiceImpl scaleServiceImpl = new ScaleServiceImpl();


	public EquipmentCommissioningPanel() {
		initialize();
		addComponent();
	}

	/**
	 * 	???????????????
	 */
	private void initialize() {
		this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		this.setBorder(ConstantsUI.main_panel_border);
	}

	/**
	 * 	?????????????????????
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
	 * @return	??????panel????????????
	 */
	private JPanel getLeftTopPanel() {

		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JPanel leftTopPanel = new JPanel();
		leftTopPanel.setBackground(ConstantsUI.table_header);
		leftTopPanel.setLayout(new BorderLayout());
		leftTopPanel.setPreferredSize(new Dimension(450, 200));
		leftTopPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "???????????????",
				TitledBorder.LEFT, TitledBorder.TOP));

		String[] columnNames  = {"??????", "?????????", "?????????", "??????"};
		Object[][] datas = getScaleData();
		DefaultTableModel model = new DefaultTableModel(datas, columnNames);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(450, 200));
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				//?????????????????????????????????????????????????????????????????????e.getValueIsAdjusting() == false?????????????????????????????????
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
					//??????????????????
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
							//??????5000ms??????1000ms????????????
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
						// TODO ??????????????? catch ???
						e1.printStackTrace();
					} catch (IllegalAccessException e1) {
						// TODO ??????????????? catch ???
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO ??????????????? catch ???
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO ??????????????? catch ???
						e1.printStackTrace();
					} catch (NoSuchMethodException e1) {
						// TODO ??????????????? catch ???
						e1.printStackTrace();
					} catch (SecurityException e1) {
						// TODO ??????????????? catch ???
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO ??????????????? catch ???
						e1.printStackTrace();
					}
				}
			}
		});





		// ??????????????????
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
	 * @return	??????panel????????????
	 */
	private JPanel getLeftCenterPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JPanel leftCenterPanel = new JPanel();
		leftCenterPanel.setBackground(ConstantsUI.table_header);
		leftCenterPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		leftCenterPanel.setPreferredSize(new Dimension(450, 130));
		leftCenterPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "?????????????????????",
				TitledBorder.LEFT, TitledBorder.TOP));

		JLabel label1 = new JLabel("???????????????:");
		label1.setPreferredSize(new Dimension(70, 30));
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		jTextField1 = new JTextField();
		jTextField1.setPreferredSize(new Dimension(160, 30));
		jTextField1.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel label2 = new JLabel("????????????:");
		label2.setPreferredSize(new Dimension(60, 30));
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		jTextField2 = new JTextField();
		jTextField2.setPreferredSize(new Dimension(60, 30));
		jTextField2.setHorizontalAlignment(SwingConstants.LEFT);

		leftCenterPanel.add(label1);
		leftCenterPanel.add(jTextField1);
		leftCenterPanel.add(label2);
		leftCenterPanel.add(jTextField2);

		String[] columnNames  = {"?????????", "????????????", "????????????", "????????????", "????????????"};
		Object[][] datas = getScaleDataInfo();
		model = new DefaultTableModel(datas, columnNames);
		table1 = new JTable(model);
		table1.setPreferredScrollableViewportSize(new Dimension(430, 40));
		// ??????????????????
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
	 * @return	??????panel????????????
	 */
	private JPanel getLeftBottomPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);
		jPanel.setBackground(Color.BLACK);

		JPanel leftBottomPanel = new JPanel();
		leftBottomPanel.setBackground(Color.BLACK);
		leftBottomPanel.setLayout(new BorderLayout());
		leftBottomPanel.setPreferredSize(new Dimension(450, 185));
		leftBottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "????????????",
				TitledBorder.LEFT, TitledBorder.TOP,
				null, Color.GREEN));
		// ?????????????????????
		jTextField = new JTextField();
		jTextField.setBorder(null);
		jTextField.setBackground(null);
		jTextField.setEditable(false);
		jTextField.setPreferredSize(new Dimension(440,180));
		jTextField.setFont(new Font("??????",Font.BOLD,28));
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
	 * @return	??????panel????????????
	 */
	private JPanel getRightTopPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JPanel rightPanel = new JPanel();
		rightPanel.setBackground(ConstantsUI.table_header);
		rightPanel.setLayout(new GridLayout(3,2));
		rightPanel.setPreferredSize(new Dimension(376, 330));//550
		rightPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "?????????",
				TitledBorder.LEFT, TitledBorder.TOP));

		jButton1 = new JButton("??????");
		jButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if(deviceId == null){
							JOptionPane.showMessageDialog(null, "?????????????????????");
							return;
						}						
						String weighValue = scaleServiceImpl.getWeighValue(deviceId);
						Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(weighValue);
						if(jsonInfo.get("Uom").equals("null")){
							jTextField.setText(jsonInfo.get("ResultDesc"));
							area.append("?????? : "+jsonInfo.get("ResultDesc")+"\n\r");
						} else {
							jTextField.setText(jsonInfo.get("Weight")+jsonInfo.get("Uom"));
							area.append("?????? : "+jsonInfo.get("ResultDesc")+"\n\r");
							
						}

					}
				});
			}
		});
		jButton1.setFont(new Font("??????", Font.BOLD, 22));

		jButton2 = new JButton("??????");
		jButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if(deviceId == null){
							JOptionPane.showMessageDialog(null, "?????????????????????");
							return;
						}
						String setTare = scaleServiceImpl.setTare(deviceId,null,null);
						Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(setTare);
						if(jsonInfo.get("Uom").equals("null") ){
							jTextField.setText(jsonInfo.get("ResultDesc"));
							area.append("?????? : "+jsonInfo.get("ResultDesc")+"\n\r");
						} else {
							jTextField.setText(jsonInfo.get("tare")+jsonInfo.get("Uom"));
							area.append("?????? : "+jsonInfo.get("ResultDesc")+"\n\r");
						}
					}
				});
			}
		});
		jButton2.setFont(new Font("??????", Font.BOLD, 22));

		jButton3 = new JButton("??????");
		jButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {
					@Override
					public void run() {
						if(deviceId == null){
							JOptionPane.showMessageDialog(null, "?????????????????????");
							return;
						}
						String setClearInfo = scaleServiceImpl.setClear(deviceId);
						Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(setClearInfo);
						if(setClearInfo != null){
							jTextField.setText("0.00");
							area.append("?????? : "+jsonInfo.get("ResultDesc")+"\n\r");
						} else{
							jTextField.setText("");
							area.append("?????? : "+"????????????"+"\n\r");
						}
						
					}
				});
			}
		});
		jButton3.setFont(new Font("??????", Font.BOLD, 22));
		jButton4 = new JButton("????????????");
		jButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "?????????????????????");
					return;
				}
				String getDeviceSeqNo = scaleServiceImpl.getDeviceSeqNo(deviceId);
				Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(getDeviceSeqNo);
				if(jsonInfo.get("ResultDesc") != ""){
					jTextField.setText("");
					area.append("??????????????? : "+jsonInfo.get("ResultDesc")+"\n\r");
					DefaultTableModel model2 = (DefaultTableModel) table1.getModel();
					model2.setValueAt(jsonInfo.get("deviceSeqNo") , 0, 0);
					jTextField1.setText(jsonInfo.get("deviceSeqNo") );
					model2.fireTableStructureChanged();
				} else {
					jTextField.setText("");
					area.append("?????? : "+jsonInfo.get("ResultDesc")+"\n\r");
				}

			}
		});

		jButton4.setFont(new Font("??????", Font.BOLD, 22));
		jButton5 = new JButton("????????????");
		jButton5.setFont(new Font("??????", Font.BOLD, 22));
		jButton5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "?????????????????????");
					return;
				}
				String scaleIsOnline = scaleServiceImpl.scaleIsOnline(deviceId);
				Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(scaleIsOnline);
				if(jsonInfo.get("ResultDesc") != null){
					area.append("????????????????????????"+jsonInfo.get("scaleStatus")+"\n\r");
					jTextField2.setText("??????");
				}else{
					area.append("????????????????????????"+jsonInfo.get("scaleStatus")+"\n\r");
					jTextField2.setText("??????");
				}
			}
		});
		jButton6 = new JButton("?????????");
		jButton6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "?????????????????????");
					return;
				}
				String getScaleInfo = scaleServiceImpl.getScaleInfo(deviceId);
				Map<String,String> jsonInfo = (Map<String,String>) JSONObject.parse(getScaleInfo);
				DefaultTableModel model2 = (DefaultTableModel) table1.getModel();
				model2.setValueAt(jsonInfo.get("????????????"), 0, 1);
				model2.setValueAt(jsonInfo.get("????????????"), 0, 2);
				model2.setValueAt(jsonInfo.get("????????????"), 0, 3);
				model2.setValueAt(jsonInfo.get("????????????"), 0, 4);
				model2.fireTableStructureChanged();
				area.append("??????????????????"+getScaleInfo+"\n\r");
			}
		});
		jButton6.setFont(new Font("??????", Font.BOLD, 22));

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
	 * @return	????????????panel????????????
	 */
	private JPanel getRightCenterPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);


		JPanel rightBottomPanel = new JPanel();
		rightBottomPanel.setBackground(ConstantsUI.table_header);
		rightBottomPanel.setLayout(new CardLayout(1,1));
		rightBottomPanel.setPreferredSize(new Dimension(376, 160));
		rightBottomPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 1), "????????????",
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
	 * @return	????????????panel????????????
	 */
	private JPanel getRightBottomPanel() {
		JPanel jPanel = new JPanel();
		jPanel.setBorder(ConstantsUI.main_panel_border);

		JLabel label1 = new JLabel("WebService??????:");
		label1.setFont(new Font("??????", Font.BOLD, 22));


		JButton jButton1 = new JButton("??????");
		jButton1.setFont(new Font("??????", Font.BOLD, 22));
		jButton1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "?????????????????????");
					return;
				}
				try {
					JAXRSServerFactoryBean factoryBean = ScaleServiceImpl.factoryBean;
					//					Field field = classInstance.getField("factoryBean");		
					//					JAXRSServerFactoryBean factoryBean = (JAXRSServerFactoryBean)field.get(null);
					Server server = factoryBean.getServer();
					if(server.isStarted() == false) {
						server.start();
						area.append("web??????????????????"+"\n\r");
					}else {
						area.append("web???????????????????????????"+"\n\r");
					}
				}  catch (SecurityException e1) {
					// TODO ??????????????? catch ???
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO ??????????????? catch ???
					e1.printStackTrace();
				} 
			}
		});

		JButton jButton2 = new JButton("??????");
		jButton2.setFont(new Font("??????", Font.BOLD, 22));
		jButton2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(deviceId == null){
					JOptionPane.showMessageDialog(null, "?????????????????????");
					return;
				}
				try {
					JAXRSServerFactoryBean factoryBean = ScaleServiceImpl.factoryBean;
					//	Field field = classInstance.getField("factoryBean");		
					// JAXRSServerFactoryBean factoryBean = (JAXRSServerFactoryBean)field.get(null);n;
					Server server = factoryBean.getServer();
					if(server.isStarted() == true) {
						server.stop();
						area.append("web????????????????????????"+"\n\r");
					}else {
						area.append("web???????????????????????????"+"\n\r");
					}
				}catch (SecurityException e1) {
					// TODO ??????????????? catch ???
					e1.printStackTrace();
				} catch (IllegalArgumentException e1) {
					// TODO ??????????????? catch ???
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
	 *	??????????????????????????????
	 * @return
	 */
	private Object[][] getScaleDataInfo() {
		// ??????sql??????list<Scale>
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
	 *	????????????????????????
	 * @return
	 */
	private Object[][] getScaleData() {
		// ??????list<Scale>
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

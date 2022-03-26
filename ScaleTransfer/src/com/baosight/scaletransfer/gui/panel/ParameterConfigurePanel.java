package com.baosight.scaletransfer.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.baosight.scaletransfer.bean.Scale;
import com.baosight.scaletransfer.gui.ConstantsUI;
import com.baosight.scaletransfer.service.util.CommConstant;
import com.baosight.scaletransfer.service.ParameterConfigureService;
import com.baosight.scaletransfer.service.util.ScaleXMLUtil;
import com.baosight.scaletransfer.service.impl.ParameterConfigureServiceImpl;
import com.eltima.components.ui.DatePicker;
/**
 * <p>属性配置面板类</p>
 * @author tianwei
 * @date 2018年12月18日
 * @version 1.0
 */
public class ParameterConfigurePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JPanel panelUp;//上部面板
	private JPanel panelLeftDown; //下面左边面板
	private JPanel panelRightDown; // 控制切换panel
	private JPanel panelRightDown_net;	// 以太网panel
	private JPanel panelRightDown_ser;	//串口panel
	private String deviceId;
	private ParameterConfigureService parameterService = new ParameterConfigureServiceImpl();
	private JTable table; /* 显示设备信息table*/
	private DefaultTableModel model; /* 模型*/
	private JTextField jTextField1 ; //ip地址对应
	private JTextField jTextField2 ; //port对应
	private JTextField serialPort_num;//串口号
	private JTextField serialPort_strlen;//字符串长度
	private JTextField serialPort_baudrate;//波特位
	private JTextField serialPort_standarddatabit;//标准数据位
	private JTextField serialPort_paritybit;//奇偶校验位
	private JTextField serialPort_stopbit;//停止位
	private JTextField serialPort_unitbitlen;//单位长度
	private JTextField serialPort_unitstartbit;//单位起始位
	private JTextField serialPort_digitalbitlen;//数字为长度
	private JTextField serialPort_digitalstartbit;//数字为起始位
	private ListSelectionListener x;//model 的监听器
	private JList<String> list; // 下面左部面板默认选中
	public ParameterConfigurePanel() {
		initialize();
		addComponent();
	}
	
	/**
	 * 	初始化面板
	 */
	private void initialize() {
		this.setLayout(new BorderLayout());
		this.setBorder(ConstantsUI.main_panel_border);
	}
	
	/**
	 * 	为面板添加组件
	 */
	private void addComponent() {
		this.add(getUpPanel(),BorderLayout.NORTH);
		this.add(getDownPanel(),BorderLayout.CENTER);
	}
	
	private JPanel getUpPanel() {
		panelUp = new JPanel();
		panelUp.setBackground(ConstantsUI.table_header);
		panelUp.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelUp.setPreferredSize(new Dimension(600, 280));
		panelUp.setBorder(BorderFactory.createTitledBorder(ConstantsUI.panel_border, "电子秤基本属性",
				TitledBorder.LEFT, TitledBorder.TOP));
		String[] columnNames  = {"编号", "秤编码", "秤名称", "处理类","通信方式"};
		Object[][] datas = getScaleData();
		model = new DefaultTableModel(datas, columnNames);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(838, 200));
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
        		column.setPreferredWidth(100);
        	} else  if(i == 1 || i == 2){
        		column.setPreferredWidth(200);
        	}else if(i == 4){
        		column.setPreferredWidth(92);
        	}else{
        		column.setPreferredWidth(246);
        	}
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ListSelectionListener x = new ListSelectionListener() {			
        	@Override
			public void valueChanged(ListSelectionEvent e) {
				
				int row = table.getSelectedRow();
				String scaleId = table.getValueAt(row, 1).toString();
				Map<String, String> scaleEthernet = ScaleXMLUtil.getCommunication(scaleId, new File(CommConstant.xmlPath));
				
				String valueAt = table.getValueAt(row, 4).toString();
				if(valueAt.equals("Rs232")){
					panelRightDown.removeAll();
					panelRightDown.add(getDownRightPanel1());
					panelRightDown.revalidate();
					panelRightDown.repaint();
					//设置下部左边面板的选中状态
					list.setSelectedIndex(0);
					 
					serialPort_num.setText(scaleEthernet.get("SerialPort_num"));//串口号
					serialPort_strlen.setText(scaleEthernet.get("SerialPort_strlen"));//字符串长度
					serialPort_baudrate.setText(scaleEthernet.get("SerialPort_baudrate"));//波特位
					serialPort_standarddatabit.setText(scaleEthernet.get("SerialPort_standarddatabit"));//标准数据位
					serialPort_paritybit.setText(scaleEthernet.get("SerialPort_paritybit"));//奇偶校验位
					serialPort_stopbit.setText(scaleEthernet.get("SerialPort_stopbit"));//停止位
					serialPort_unitbitlen.setText(scaleEthernet.get("SerialPort_unitbitlen"));//单位长度
					serialPort_unitstartbit.setText(scaleEthernet.get("SerialPort_unitstartbit"));//单位起始位
					serialPort_digitalbitlen.setText(scaleEthernet.get("SerialPort_digitalbitlen"));//数字为长度
					serialPort_digitalstartbit.setText(scaleEthernet.get("SerialPort_digitalstartbit"));//数字为起始位					
				}else if(valueAt.equals("socket")){
					panelRightDown.removeAll();
					panelRightDown.add(getDownRightPanel2());
					panelRightDown.revalidate();
					panelRightDown.repaint();
					//设置下部左边面板的选中状态
					list.setSelectedIndex(1);
					 
					String ip = scaleEthernet.get("Ethernet_ip");
					String port = scaleEthernet.get("Ethernet_port");
					jTextField1.setText(ip);
					jTextField2.setText(port);
				}
								
				System.out.println(row);
			}
		};
        table.getSelectionModel().addListSelectionListener(x);
        
		JScrollPane scroll = new JScrollPane(table);
		panelUp.add(scroll);
		
		JButton insertButton = new JButton("新增");
		insertButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame("新增信息窗口");
	            frame.setVisible(true);
	            GridLayout gird = new GridLayout(4, 3);
	            gird.setHgap(30);
	            gird.setVgap(10);
	            frame.setLayout(gird);
	            frame.setSize(700,200);
	            frame.setLocationRelativeTo(null);
	             
	             JLabel lable1 = new JLabel("  秤编码:"); 
	     		 JTextField jTextField1 = new JTextField(20);
	             JLabel lable2 = new JLabel("  秤名称:"); 
	             JTextField jTextField2 = new JTextField(20);
	             JLabel lable3 = new JLabel("  处理类:"); 
	             JTextField jTextField3 = new JTextField(20);
	             JLabel lable5 = new JLabel("记录创建者:"); 
	             JTextField jTextField5 = new JTextField(20);
	             JLabel lable6 = new JLabel("记录创建时刻:"); 
	             DatePicker datePicker1 = getMonthAgoDatePicker();
	             datePicker1.setEnabled(false);
	             JLabel lable11 = new JLabel("通信方式：");
	             String[] listData = new String[]{" ","socket", "Rs232"};
	             JComboBox comboBox = new JComboBox<String>(listData);
	             
	             
	             /*JLabel lable12 = new JLabel("Port:"); 
	             JTextField jTextField9 = new JTextField(20);*/
	             
	 
	             JButton button = new JButton("确定");
	             button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						if(jTextField1.getText().trim().equals("") || jTextField2.getText().trim().equals("") || jTextField3.getText().trim().equals("")
								|| jTextField5.getText().trim().equals("") || comboBox.getSelectedItem().toString().trim().equals("")){
							JOptionPane.showMessageDialog(null, "请将信息填充完整");
						}else{
							Map<String,String> map = new HashMap<>();
							map.put("deviceId", jTextField1.getText());
							map.put("deviceCname", jTextField2.getText());
							map.put("processingClass", jTextField3.getText());						
							map.put("recCreator", jTextField5.getText());
							map.put("recCreatorTime", datePicker1.getText());						
							map.put("remark", comboBox.getSelectedItem().toString());
							
							map.put("recRevisor", "");
							map.put("recReviseTime", "");
							map.put("recDeleteor", "");
							map.put("recDeleteTime", "");			
							map.put("archiveFlag", "");
							map.put("recStatus", "");
							map.put("companyCode", "");
							map.put("deleteFlag", "");
							map.put("deviceSeqNo", "");
							map.put("orgUnitCode", "");
							map.put("recId", "");
							map.put("recLineNo", "0");
							map.put("recWstId", "");
							
							
							
							
							String info = parameterService.addConfig(map);
							frame.dispose();
							
							Object[][] datas = getScaleData();
							model.addRow(datas[datas.length-1]);
							
							
							JOptionPane.showMessageDialog(null, info);
							
							
						}	
					}
				});
	                
	                
	             frame.add(lable1);
	             frame.add(jTextField1);
	             frame.add(lable2);
	             frame.add(jTextField2);
	             frame.add(lable3);
	             frame.add(jTextField3);
	             frame.add(lable5);
	             frame.add(jTextField5);
	             frame.add(lable6);
	             frame.add(datePicker1);
	             frame.add(lable11);
	             frame.add(comboBox);
	             /*frame.add(lable12);
	             frame.add(jTextField9);*/
	             frame.add(button);
	             
	             
			}
		});
		
		
		
		
		
		
		JButton updateButton = new JButton("修改");
		updateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectedRow = table.getSelectedRows();
				if(selectedRow.length == 0){
					JOptionPane.showMessageDialog(null, "请选择一个设备");
					return;
				}
				

				JFrame frame = new JFrame("修改信息窗口");
	            frame.setVisible(true);
	            GridLayout gird = new GridLayout(4, 3);
	            gird.setHgap(30);
	            gird.setVgap(10);
	            frame.setLayout(gird);
	            frame.setSize(700,200);
	            frame.setLocationRelativeTo(null);
	             
	             JLabel lable1 = new JLabel("  秤编码:"); 
	     		 JTextField jTextField1 = new JTextField(20);
	             JLabel lable2 = new JLabel("  秤名称:"); 
	             JTextField jTextField2 = new JTextField(20);
	             JLabel lable3 = new JLabel("  处理类:"); 
	             JTextField jTextField3 = new JTextField(20);
	             JLabel lable5 = new JLabel("记录创建者:"); 
	             JTextField jTextField5 = new JTextField(20);
	             JLabel lable6 = new JLabel("记录创建时刻:"); 
	             JTextField jTextField4 = new JTextField(20);
	             jTextField4.setEnabled(false);
	             JLabel lable7 = new JLabel("记录修改者:"); 
	             JTextField jTextField6 = new JTextField(20);
	             JLabel lable8 = new JLabel("记录修改时刻:"); 
	             DatePicker datePicker2 = getMonthAgoDatePicker();
	             datePicker2.setEnabled(false);
	           
	             
	             
	             JButton button = new JButton("确定");
	             button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						int result = JOptionPane.showConfirmDialog(null, "确认修改？","提示",JOptionPane.YES_NO_OPTION);
						
						if(result == 0){
							Map<String, String> map = ScaleXMLUtil.getScaleInfo(jTextField1.getText().toString(),new File(CommConstant.xmlPath));
							map.put("deviceId", jTextField1.getText());
							map.put("deviceCname", jTextField2.getText());
							map.put("processingClass", jTextField3.getText());
							map.put("recCreator", jTextField5.getText());
							map.put("recCreatorTime", jTextField4.getText());						
							map.put("recRevisor", jTextField6.getText());
							map.put("recReviseTime", datePicker2.getText());
													
							List<String> deviceIds = new ArrayList<String>();
							for(int j = 0; j < selectedRow.length; j++) {
								deviceIds.add(table.getValueAt(selectedRow[j], 1).toString());
							}
							parameterService.deleteEquiment(deviceIds);
							parameterService.addConfig(map);
							frame.dispose();
							
							//让penalUp面板的监听器失效
							ListSelectionModel selectionModel = table.getSelectionModel();
							selectionModel.removeListSelectionListener(x);
							
							System.out.println(model.getRowCount());
							model.removeRow(model.getRowCount()-1);
							
							
							Object[][] datas = getScaleData();
							model.addRow(datas[datas.length-1]);
							/*for(int i = 0;i<datas.length;i++){
								model.addRow(datas[i]);
							}*/							
							//让penalUp面板的监听器重新启用
							selectionModel.addListSelectionListener(x);

							JOptionPane.showMessageDialog(null, "修改成功！");
							
							
							
						}else{
							JOptionPane.showMessageDialog(null, "修改失败！");
						}
					}
				});
	                  
	             frame.add(lable1);
	             frame.add(jTextField1);
	             frame.add(lable2);
	             frame.add(jTextField2);
	             frame.add(lable3);
	             frame.add(jTextField3);
	             frame.add(lable5);
	             frame.add(jTextField5);
	             frame.add(lable6);
	             frame.add(jTextField4);
	             frame.add(lable7);
	             frame.add(jTextField6);
	             frame.add(lable8);
	             frame.add(datePicker2);
	            /* frame.add(jTextField7);
	             frame.add(jTextField8);*/
	             frame.add(button);
	             jTextField1.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
	             jTextField2.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
	             jTextField3.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
	             Map<String, String> scaleAttrsMap = ScaleXMLUtil.getScaleInfo(table.getValueAt(table.getSelectedRow(), 1).toString(), new File(CommConstant.xmlPath));
	             jTextField5.setText(scaleAttrsMap.get("recCreator"));//回显创建者
	             jTextField4.setText(scaleAttrsMap.get("recCreatorTime"));//回显创建时间
	             	             
	             
	             
	             
			}
		});
		

		JButton deleteButton = new JButton("删除");
		deleteButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "确认删除？","提示", JOptionPane.YES_NO_OPTION);
				if(result == 0) {
					int numRow = table.getSelectedRows().length;
					if(numRow == 0) {
						JOptionPane.showMessageDialog(null, "请选择一个设备");
						return;
					}
					int[] selectedRow = table.getSelectedRows();
					List<String> deviceIds = new ArrayList<String>();
					for(int j = 0; j < selectedRow.length; j++) {
						deviceIds.add(table.getValueAt(selectedRow[j], 1).toString());
					}
					String info = parameterService.deleteEquiment(deviceIds);
					ListSelectionModel selectionModel = table.getSelectionModel();
					if(info.equals("success")) {
						//让penalUp面板的监听器失效						
						selectionModel.removeListSelectionListener(x);
						for(int i = 0; i < numRow; i++) {
							model.removeRow(table.getSelectedRow());
						}
					}
						//让penalUp面板的监听器重新启用
						selectionModel.addListSelectionListener(x);
						JOptionPane.showMessageDialog(null, info);
					
					
				}
			}
		});
		
		panelUp.add(insertButton);
		panelUp.add(updateButton);
		panelUp.add(deleteButton);
		
		return panelUp;
	}
	
	/**
	 *	获取所有设备信息
	 * @return
	 */
	private Object[][] getScaleData() {
		// 获取list<Scale>
		List<Scale> scaleList = parameterService.loadEquiment();
		int scaleSize = scaleList.size();
		Object[][] scales = new Object[scaleSize][5];
		for (int i = 0; i < scaleSize; i++) {
			scales[i][0] = i + 1;
			scales[i][1] = scaleList.get(i).getDeviceId();
			scales[i][2] = scaleList.get(i).getDeviceCname();
 			scales[i][3] = scaleList.get(i).getProcessingClass();
 			scales[i][4] = scaleList.get(i).getRemark();
		}
		return scales;
	}
	
	/**
	 * @return 获取下部panle
	 */
	private JPanel getDownPanel() {
		
		JPanel panelDown = new JPanel();
		panelDown.setBackground(ConstantsUI.table_header);
		panelDown.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelDown.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "电子秤通信参数",
				TitledBorder.LEFT, TitledBorder.TOP));
		panelDown.add(getDownLeftPanel());
		panelDown.add(getDownRightPanel());
		return panelDown;
	}
	
	/**
	 * @return 获取下部左边panle
	 */
	private JPanel getDownLeftPanel() {
		
		panelLeftDown = new JPanel();
		panelLeftDown.setLayout(new GridLayout(1, 8));
		panelLeftDown.setPreferredSize(new Dimension(170, 250));
		panelLeftDown.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "接口类型",
				TitledBorder.LEFT, TitledBorder.TOP));
		list = new JList<String>();
		list.setPreferredSize(new Dimension(150, 25));
		list.setBorder(BorderFactory.createLineBorder(ConstantsUI.table_header, 5));
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list.setListData(new String[]{"MT-RS232","MT-以太网"});
		// 添加选项选中状态被改变的监听器
		list.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int a = list.getSelectedIndex();
				if(a == 0) {
					panelRightDown.removeAll();
					panelRightDown.add(getDownRightPanel1());
					panelRightDown.revalidate();
					panelRightDown.repaint();
				}else {
					panelRightDown.removeAll();
					panelRightDown.add(getDownRightPanel2());
					panelRightDown.revalidate();
					panelRightDown.repaint();
				}	
				System.out.println(a);
			}
		});
		//list.setSelectedIndex(0);
		panelLeftDown.add(list);
		return panelLeftDown;
	}
	
	/**
	 * @return 获取下部右边panle
	 */
	private JPanel getDownRightPanel() {
		panelRightDown = new JPanel();
//		panelRightDown.setLayout(new FlowLayout(FlowLayout.LEFT));
//		panelRightDown.setPreferredSize(new Dimension(600, 250));
//		panelRightDown.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "通信配置参数",
//				TitledBorder.LEFT, TitledBorder.TOP));
		panelRightDown.add(getDownRightPanel1());
		return panelRightDown;
		
	}
	
	/**
	 * @return 获取下部右边panle1
	 */
	private JPanel getDownRightPanel1() {
		
		panelRightDown_net = new JPanel();
		panelRightDown_net.setLayout(null);
		panelRightDown_net.setPreferredSize(new Dimension(600, 250));
		panelRightDown_net.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "通信配置参数",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		JLabel label1 = new JLabel("串口号");
		label1.setBounds(20, 60, 60, 30);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_num = new JTextField();
		serialPort_num.setBounds(90,60,60,30);
		
		JLabel label2 = new JLabel("字符串长度");
		label2.setBounds(160, 60, 60, 30);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_strlen = new JTextField();
		serialPort_strlen.setBounds(230,60,60,30);
		
		JLabel label3 = new JLabel("数字起始位");
		label3.setBounds(300, 60, 60, 30);
		label3.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_digitalstartbit = new JTextField();
		serialPort_digitalstartbit.setBounds(370,60,60,30);
		
		JLabel label4 = new JLabel("数字位长度");
		label4.setBounds(440, 60, 60, 30);
		label4.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_digitalbitlen= new JTextField();
		serialPort_digitalbitlen.setBounds(510,60,60,30);
		
		JLabel label5 = new JLabel("单位起始位");
		label5.setBounds(20, 100, 60, 30);
		label5.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_unitstartbit = new JTextField();
		serialPort_unitstartbit.setBounds(90,100,60,30);
		
		JLabel label6 = new JLabel("单位长度");
		label6.setBounds(160, 100, 60, 30);
		label6.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_unitbitlen = new JTextField();
		serialPort_unitbitlen.setBounds(230,100,60,30);
		
		JLabel label7 = new JLabel("波特率");
		label7.setBounds(300, 100, 60, 30);
		label7.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_baudrate = new JTextField();
		serialPort_baudrate.setBounds(370,100,60,30);
		
		JLabel label8 = new JLabel("标准数据位");
		label8.setBounds(440, 100, 60, 30);
		label8.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_standarddatabit = new JTextField();
		serialPort_standarddatabit.setBounds(510,100,60,30);
		
		JLabel label9 = new JLabel("奇偶效验位");
		label9.setBounds(20, 140, 60, 30);
		label9.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_paritybit = new JTextField();
		serialPort_paritybit.setBounds(90,140,60,30);
		
		JLabel label10 = new JLabel("停止位");
		label10.setBounds(160, 140, 60, 30);
		label10.setHorizontalAlignment(SwingConstants.RIGHT);
		serialPort_stopbit = new JTextField();
		serialPort_stopbit.setBounds(230,140,60,30);
		
		
		
		panelRightDown_net.add(label1);
		panelRightDown_net.add(serialPort_num);
		panelRightDown_net.add(label2);
		panelRightDown_net.add(serialPort_strlen);
		panelRightDown_net.add(label3);
		panelRightDown_net.add(serialPort_digitalstartbit);
		panelRightDown_net.add(label4);
		panelRightDown_net.add(serialPort_digitalbitlen);
		
		panelRightDown_net.add(label5);
		panelRightDown_net.add(serialPort_unitstartbit);
		panelRightDown_net.add(label6);
		panelRightDown_net.add(serialPort_unitbitlen);
		panelRightDown_net.add(label7);
		panelRightDown_net.add(serialPort_baudrate);
		panelRightDown_net.add(label8);
		panelRightDown_net.add(serialPort_standarddatabit);
		
		panelRightDown_net.add(label9);
		panelRightDown_net.add(serialPort_paritybit);
		panelRightDown_net.add(label10);
		panelRightDown_net.add(serialPort_stopbit);
		
		JButton jButton = new JButton("更新");
		jButton.setBounds(20, 200, 60, 30);
		panelRightDown_net.add(jButton);
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							
				Map<String, String> map = new HashMap<>();
				map.put("scaleId", table.getValueAt(table.getSelectedRow(), 1).toString());				
				map.put("SerialPort_num", serialPort_num.getText());
				map.put("SerialPort_baudrate", serialPort_baudrate.getText());
				map.put("SerialPort_standarddatabit", serialPort_standarddatabit.getText());
				map.put("SerialPort_stopbit", serialPort_stopbit.getText());
				map.put("SerialPort_paritybit", serialPort_paritybit.getText());
				map.put("SerialPort_strlen", serialPort_strlen.getText());
				map.put("SerialPort_digitalstartbit", serialPort_digitalstartbit.getText());
				map.put("SerialPort_digitalbitlen", serialPort_digitalbitlen.getText());
				map.put("SerialPort_unitstartbit", serialPort_unitstartbit.getText());
				map.put("SerialPort_unitbitlen", serialPort_unitbitlen.getText());				
								
				String info = parameterService.updateEquimentInfo(map);
								
				JOptionPane.showMessageDialog(null, info);
								
			}
		});
		return panelRightDown_net;
	}
	
	/**
	 * @return 获取下部右边panle2
	 */
	private JPanel getDownRightPanel2() {
		
		panelRightDown_ser = new JPanel();
		panelRightDown_ser.setLayout(null);
		panelRightDown_ser.setPreferredSize(new Dimension(600, 250));
		panelRightDown_ser.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "通信配置参数",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		JLabel label1 = new JLabel("IP地址");
		label1.setBounds(20, 100, 60, 30);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		jTextField1 = new JTextField();
		jTextField1.setBounds(90,100,100,30);
		
		JLabel label2 = new JLabel("端口号");
		label2.setBounds(200, 100, 60, 30);
		label2.setHorizontalAlignment(SwingConstants.RIGHT);
		jTextField2 = new JTextField();
		jTextField2.setBounds(290,100,60,30);
		
		JButton jButton = new JButton("更新");
		jButton.setBounds(20, 200, 60, 30);
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
							
				Map<String, String> map = new HashMap<>();
				map.put("scaleId", table.getValueAt(table.getSelectedRow(), 1).toString());
				
				map.put("Ethernet_ip", jTextField1.getText());
				map.put("Ethernet_port", jTextField2.getText());
														
				String info = parameterService.updateEquimentInfo(map);
				
				
				JOptionPane.showMessageDialog(null, info);
								
			}
		});
		
		panelRightDown_ser.add(label1);
		panelRightDown_ser.add(jTextField1);
		panelRightDown_ser.add(label2);
		panelRightDown_ser.add(jTextField2);
		
		panelRightDown_ser.add(jButton);
		
		/**	获取配置数据,放入jTextField*/
		Map<String, String> map = parameterService.loadConfig();
		jTextField1.setText(map.get("Ethernet_ip"));
		jTextField2.setText(map.get("Ethernet_port"));
		return panelRightDown_ser;
	}
	
	
	private static DatePicker getMonthAgoDatePicker() {
		String defaultFormat = "yyyy-MM-dd HH:mm:ss";
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -6);
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		date = calendar.getTime();
		DatePicker datePicker = new DatePicker(date, defaultFormat, null, null);
		datePicker.setLocale(Locale.CHINA);
		datePicker.setTimePanleVisible(true);
		return datePicker;
	}
	
}

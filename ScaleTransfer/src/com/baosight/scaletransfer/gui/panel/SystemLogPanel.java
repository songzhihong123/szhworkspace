package com.baosight.scaletransfer.gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.baosight.scaletransfer.bean.ScaleLog;
import com.baosight.scaletransfer.gui.ConstantsUI;
import com.baosight.scaletransfer.service.SystemLogService;
import com.baosight.scaletransfer.service.impl.SystemLogServiceImpl;
import com.eltima.components.ui.DatePicker;

/**
 * 	<p>系统日志面板类</p>
 * @author tianwei
 * @date 2018年12月28日
 * @version 1.0
 */
public class SystemLogPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	private SystemLogService systemLog;	/* 系统日志service*/
	private DatePicker datePicker;	/* 开始日期*/
	private DatePicker datePicker2;	/* 结束日期*/
	JComboBox<String> comboBox;	/* log等级下拉框*/
	JTable table; /* log信息显示table*/
	
	public SystemLogPanel() {
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
		this.add(getCenterPanel(),BorderLayout.CENTER);
	}
	
	private Component getUpPanel() {
		JPanel upPanel = new JPanel();
		upPanel.setLayout(new FlowLayout(FlowLayout.LEFT,10,10));
		upPanel.setPreferredSize(new Dimension(880, 80));
		upPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "通信配置参数",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		JLabel label1 = new JLabel("开始时间");
		label1.setPreferredSize(new Dimension(55, 30));
		label1.setHorizontalAlignment(SwingConstants.LEFT);
		datePicker = getMonthAgoDatePicker();
		
		JLabel label2 = new JLabel("结束时间");
		label2.setPreferredSize(new Dimension(55, 30));
		label2.setHorizontalAlignment(SwingConstants.LEFT);
		datePicker2 = getDatePicker();
		
		JLabel label3 = new JLabel("日志等级");
		label3.setPreferredSize(new Dimension(55, 30));
		label3.setHorizontalAlignment(SwingConstants.LEFT);
		String[] listData = new String[]{"信息", "错误"};
		comboBox = new JComboBox<String>(listData);
		comboBox.setSelectedIndex(0);
		
		JButton jButton = new JButton("查询");
		/* 查询刷新log*/
		jButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Date parse1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(datePicker.getText());
					Date parse2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(datePicker2.getText());
					long day = (parse2.getTime()-parse1.getTime())/(3600*24*1000);
					if(day > 30){
						JOptionPane.showMessageDialog(null, "您选择的日期相隔太大，请选择相隔30天的日期");
						return;
					}
				} catch (ParseException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
				
				HashMap<String, String> hashMap = new HashMap<>();
				hashMap.put("startTime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(datePicker.getValue()));
				hashMap.put("endTime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(datePicker2.getValue()));
				hashMap.put("logGrade",comboBox.getSelectedItem().toString());
				DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
				tableModel.setRowCount(0);
				// 查询相应时间段对应log等级的log
				systemLog = new SystemLogServiceImpl();
				List<ScaleLog> logs = systemLog.query(hashMap);
				for(int i = 0; i < logs.size(); i++) {
					String[] data = new String[7];
					data[0] = String.valueOf(i + 1);
					data[1] = logs.get(i).getRecCreatorTime();
					data[2] = logs.get(i).getLogGrade();
					data[3] = logs.get(i).getOperationObject();
					data[4] = logs.get(i).getOperationType();
					data[5] = logs.get(i).getOperationSource();
					data[6] = logs.get(i).getOperationDesc();
					
					tableModel.addRow(data);
				}
				table.setModel(tableModel);
			} 
		});
		
		upPanel.add(label1);
		upPanel.add(datePicker);
		upPanel.add(label2);
		upPanel.add(datePicker2);
		upPanel.add(label3);
		upPanel.add(comboBox);
		upPanel.add(jButton);
		
		return upPanel;
	}
	
	private Component getCenterPanel() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		//centerPanel.setPreferredSize(new Dimension(880, 30));
		centerPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GREEN, 1), "通信配置参数",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		String[] columnNames  = {"编号", "发生时间", "日志等级", "操作对象", "操作类型", "来源", "日志内容"};
		Object[][] datas = getLogData();
		DefaultTableModel model = new DefaultTableModel(datas, columnNames);
		table = new JTable(model);
		//table.setPreferredScrollableViewportSize(new Dimension(450, 50));
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
        		column.setPreferredWidth(65);
        	} else {
        		column.setPreferredWidth(125);
        	}
        }
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane scroll = new JScrollPane(table);
		centerPanel.add(scroll);
		
		return centerPanel;
	}
	
	private Object[][] getLogData() {
		HashMap<String, String> hashMap = new HashMap<>();
		hashMap.put("startTime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(datePicker.getValue()));
		hashMap.put("endTime", new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(datePicker2.getValue()));
		hashMap.put("logGrade",comboBox.getSelectedItem().toString());
		SystemLogServiceImpl systemLog = new SystemLogServiceImpl();
		List<ScaleLog> logs = systemLog.query(hashMap);
		List<ScaleLog> scaleLogList = new ArrayList<>();
		for(ScaleLog scaleLog : logs){
			scaleLogList.add(scaleLog);
		}
		int scaleSize = scaleLogList.size();
		Object[][] scales = new Object[scaleSize][7];
		for (int i = 0; i < scaleSize; i++) {
			scales[i][0] = i + 1;
			scales[i][1] = scaleLogList.get(i).getRecCreatorTime();
			scales[i][2] = scaleLogList.get(i).getLogGrade();
 			scales[i][3] = scaleLogList.get(i).getOperationObject();
 			scales[i][4] = scaleLogList.get(i).getOperationType();
 			scales[i][5] = scaleLogList.get(i).getOperationSource();
 			scales[i][6] = scaleLogList.get(i).getOperationDesc();
		}
		return scales;
	}

	private static DatePicker getDatePicker() {
		String defaultFormat = "yyyy-MM-dd HH:mm:ss";
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 10);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		date = calendar.getTime();
		DatePicker datePicker = new DatePicker(date, defaultFormat, null, null);
		datePicker.setLocale(Locale.CHINA);
		datePicker.setTimePanleVisible(true);
		return datePicker;
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

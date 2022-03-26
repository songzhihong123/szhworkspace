package com.baosight.scaletransfer.gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import com.baosight.scaletransfer.gui.panel.EquipmentCommissioningPanel;
import com.baosight.scaletransfer.gui.panel.ParameterConfigurePanel;
import com.baosight.scaletransfer.gui.panel.SystemLogPanel;
import com.baosight.scaletransfer.service.webService.impl.ScaleServiceImpl;
import com.baosight.scaletransfer.service.webService.impl.TMain;

/**
 * APP入口
 * @author tianwei
 * @date 2019年1月2日
 * @version 1.0
 */
public class AppMainWindow {
	private final String TAB_NAME1 = "参数配置";
	private final String TAB_NAME2 = "设备调试";
	private final String TAB_NAME3 = "系统日志";
	private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				AppMainWindow window = new AppMainWindow();
				window.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				window.frame.setResizable(false);
				window.frame.setVisible(true);
			}
		});
	}
	
	public AppMainWindow() {
		initialize();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				ScaleServiceImpl.beginSocket();
				
			}
		});
	}
	
	/**
	 * 	初始化frame内容
	 */
	public void initialize() {
		// 设置系统默认样式
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 初始化主窗口  
		frame = new JFrame();
		frame.setSize(ConstantsUI.MAIN_WINDOW_WIDTH,ConstantsUI.MAIN_WINDOW_HEIGHT);
	    frame.setLocation(ConstantsUI.SCREEN_WIDTH/2 - ConstantsUI.MAIN_WINDOW_WIDTH/2,
	    		ConstantsUI.SCREEN_HEIGHT/2 - ConstantsUI.MAIN_WINDOW_HEIGHT/2); //设置窗口居中显示
		frame.setTitle(ConstantsUI.APP_NAME);
		frame.setIconImage(ConstantsUI.IMAGE_ICON);
		frame.setBackground(ConstantsUI.MAIN_BACK_COLOR);
		
		JTabbedPane tab = new JTabbedPane();
		tab.setBorder(ConstantsUI.tab_border);
		/** 向tab添加分页component*/
		tab.add(TAB_NAME1, new ParameterConfigurePanel());
		tab.add(TAB_NAME2, new EquipmentCommissioningPanel());
		tab.add(TAB_NAME3, new SystemLogPanel());
		tab.setSelectedIndex(0);
		
		frame.setContentPane(tab);
	}
	
}

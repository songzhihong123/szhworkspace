package com.baosight.scaletransfer.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author tianwei
 * @date 2018年12月18日
 * @version 1.0
 */
public class ConstantsUI {
	
	public final static String APP_NAME = "电子秤中转程序"; /**软件名称 */
	public final static String APP_VERSION = "v_1.0"; /** 软件版本 */
	
	/**
	 *	窗口大小
	 */
	public final static int SCREEN_WIDTH = ConstantsUI.getScreenWidth();
	public final static int SCREEN_HEIGHT = ConstantsUI.getScreenHeight();
	public final static int MAIN_WINDOW_WIDTH = 885;
	public final static int MAIN_WINDOW_HEIGHT = 636;
	
	/**
	 * 	颜色
	 */
	public final static Color WHITE = Color.WHITE;
	public final static Color LightSkyBlue = new Color(135,206,250);
	public final static Color HIGH_COLOR = Color.CYAN;
	public final static Color table_header = new Color(240, 240, 240);
	/**
	 * 	组件间隔 
	 */
	public final static int MAIN_H_GAP = 25;
	public final static int MAIN_W_GAP = 5;
	
	/**
	 * 	边框样式
	 */
	public final static Border tab_border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
	public final static Border main_panel_border = BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(128, 128, 128));
	public final static Border panel_border = BorderFactory.createLineBorder(new Color(120, 234, 248),1);

    /**
     * 	主窗口背景色
     */
    public final static Color MAIN_BACK_COLOR = Color.WHITE;
    
    /**
     * 	主窗口图标
     */
    public final static Image IMAGE_ICON = Toolkit.getDefaultToolkit()
            .getImage(AppMainWindow.class.getResource("/ico/ScaleTransfer.ico"));
    
    /**
     * @return	当前设备的屏幕宽度
     */
    public static int getScreenWidth() {
	    Toolkit kit = Toolkit.getDefaultToolkit();
	    Dimension screenSize = kit.getScreenSize();
	    return screenSize.width;
    }
    
    /**
     * @return	当前设备的屏幕高度
     */
    public static int getScreenHeight() {
	    Toolkit kit = Toolkit.getDefaultToolkit();              //定义工具包
	    Dimension screenSize = kit.getScreenSize();             //获取屏幕的尺寸
	    return screenSize.height;								//获取屏幕的高
    }
}

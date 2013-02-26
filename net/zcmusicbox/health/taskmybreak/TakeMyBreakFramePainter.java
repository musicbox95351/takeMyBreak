package net.zcmusicbox.health.taskmybreak;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.JSONObject;

import net.zcmusicbox.util.file.MyFileFilter;
import net.zcmusicbox.util.regex.Judger;
import net.zcmusicbox.util.ui.jcombobox.JComboBoxItem;

public class TakeMyBreakFramePainter {

	private JFrame frame;

	private static final String DEFAULT_IMAGE_URL = "net/zcmusicbox/health/taskmybreak/Waterlilies.jpg";
	private static final String IMAGE_RIGHT = "net/zcmusicbox/health/taskmybreak/setting.png";
	private static final String IMAGE_LEFT = "net/zcmusicbox/health/taskmybreak/hide.png";
	
	private URL url;
	private ImageIcon icon;
	private JPanel panel ;
	
	private JLabel timeSpanLabel = new JLabel();
	private JTextField textTimeSpan = new JTextField(String.valueOf(TakeMyBreakTask.DEFAULT_TIME_SPAN));
	
	private JButton fileChooserButton = new JButton("Choose Image");
	//文件浏览器
	private JFileChooser fc = new JFileChooser();
	
	private JComboBox defaultImages;
	
	private JButton setting;
	private JButton hide;
	private JButton saveButton;
	public TakeMyBreakFramePainter(JFrame frame) {
		setting = new JButton();
		Icon iconRight = new ImageIcon(getClass().getClassLoader().getResource(IMAGE_RIGHT));
		setting.setIcon(iconRight);
		setting.setBounds(0, 0, 20, 20);
		ActionListener actionListener = new ActionListener() {   
		      public void actionPerformed(ActionEvent actionEvent) {  
		    	 setVisible(true);
		       }   
		     };   
		setting.addActionListener(actionListener);
		setting.setVisible(false);
		
		hide = new JButton();
		Icon iconLeft = new ImageIcon(getClass().getClassLoader().getResource(IMAGE_LEFT));
		hide.setIcon(iconLeft);
		hide.setBounds(0, 0, 20, 20);
		ActionListener actionListenerHide = new ActionListener() {   
		      public void actionPerformed(ActionEvent actionEvent) {  
		    	 setVisible(false);
		       }   
		     };   
		hide.addActionListener(actionListenerHide);
		
		url  = getClass().getClassLoader().getResource(DEFAULT_IMAGE_URL);
		panel = new JPanel(){  
			@Override
			protected void paintComponent(Graphics g){
				super.paintComponent(g); 
				if(url == null){
					url = getClass().getClassLoader().getResource(DEFAULT_IMAGE_URL);
				}
				icon = new ImageIcon(url);
				Image img = icon.getImage();
				img.getWidth(panel);
				img.getHeight(panel);
				int x = (panel.getWidth() - img.getWidth(panel))/2;
				int y = (panel.getHeight() - img.getHeight(panel))/2;
				if(url.getFile().endsWith(".gif")){
					icon.paintIcon(panel, g, x, y);
				}else{
					g.drawImage(img, x, y, this);
				}
			}  
			
			@Override
			protected void paintChildren(Graphics g){
				super.paintChildren(g); 
			}  
			
		};  
		
		this.frame = frame;
		panel.setOpaque(Boolean.FALSE);
		panel.setLayout(null);
		panel.add(setting);
		panel.add(hide);
		this.frame.add(panel);
		
	}
	public void addTextArea() {
		timeSpanLabel.setText("Time Span(Min)");
		timeSpanLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		timeSpanLabel.setBackground(new Color(228, 237, 245));
		timeSpanLabel.setOpaque(Boolean.TRUE);
		timeSpanLabel.setName("label");
		timeSpanLabel.setBounds(20, 0, 100, 18);
		panel.add(timeSpanLabel);
		JSONObject o = new JSONObject();
		textTimeSpan.setBounds(130, 0, 30, 18);
		panel.add(textTimeSpan);
		saveButton = new JButton("Save");
		saveButton.setBounds(170, 0, 80, 18);
		panel.add(saveButton);
		ActionListener actionListener = new ActionListener() {   
		      public void actionPerformed(ActionEvent actionEvent) {  
		    	 try{
		    	 TakeMyBreakFrame takeMyBreakFrame = ((TakeMyBreakFrame)frame);
		         if(textTimeSpan.getText().length()<10 && Judger.match(Judger.DIGITAL_POSATIVE, textTimeSpan.getText())){
		        	 if(Long.valueOf(textTimeSpan.getText())<TakeMyBreakTask.MAX_TIME_SPAN){
		        		 //重新设定弹出提示页面的周期并隐藏当前界面
		        		 takeMyBreakFrame.getTimer().setPeriod(Long.valueOf(textTimeSpan.getText())*60l*1000l);
		        		 takeMyBreakFrame.getTimer().setTime(Long.valueOf(textTimeSpan.getText())*60l*1000l);
		        		 takeMyBreakFrame.getTimer().start();
		        		 takeMyBreakFrame.setVisible(false);
		        	 }else{
			        	 JOptionPane.showMessageDialog(null, "只能输入1-60的整数！");
			        	 return;
			         }
		         }
		    	 }catch(Exception ex){
		    		 ex.printStackTrace();
		    	 }
		       }   
		     };   
		     saveButton.addActionListener(actionListener);
		frame.add(panel);
		
	}

	public void addFileChooser(){
		MyFileFilter fileFilter = new MyFileFilter(MyFileFilter.IMAGE_DESCRIPTION,MyFileFilter.IMAGE_FILE);
		fc.setFileFilter(fileFilter);
		fc.setAcceptAllFileFilterUsed(false);
		fileChooserButton.setBounds(20, 20, 230, 18);
		panel.add(fileChooserButton);
		ActionListener actionListener = new ActionListener() {   
		  public void actionPerformed(ActionEvent actionEvent) {
			int returnVal = fc.showOpenDialog(panel);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
			    File file = fc.getSelectedFile();
			    if(file.exists()){
			    	try{
						url = file.toURL();
						panel.repaint();
			    	}catch(MalformedURLException ex){
			    		ex.printStackTrace();
			    	}
			    }else{
			    	JOptionPane.showMessageDialog(null, "文件不存在！");
			    }
		   } 
		  }
		};   
		fileChooserButton.addActionListener(actionListener);
	}
	
	public void addImageSelect(){
		defaultImages = new JComboBox();
		//为选项添加显示内容
		//http://docs.oracle.com/javase/tutorial/uiswing/components/combobox.html#renderer
		defaultImages.addItem(new JComboBoxItem<String, String>("Waterlilies.jpg", "Waterlilies"));
		defaultImages.addItem(new JComboBoxItem<String, String>("tree.jpg", "Tree"));
		defaultImages.addItem(new JComboBoxItem<String, String>("leaves.jpg", "Leaves"));
		defaultImages.addItem(new JComboBoxItem<String, String>("green1.jpg", "greenFlower"));
		defaultImages.setLocation(20, 40);
		defaultImages.setSize(200, 18);
		panel.add(defaultImages);
		
		ActionListener actionListener = new ActionListener() {   
		      public void actionPerformed(ActionEvent actionEvent) {  
		    	  url = getClass().getClassLoader().getResource("net/zcmusicbox/health/taskmybreak/"+((JComboBoxItem)(defaultImages.getSelectedItem())).getKey());
		    	  panel.repaint();
		       }   
		     };   
		     defaultImages.addActionListener(actionListener);
	}
	
	public void setVisible(boolean visible){
		timeSpanLabel.setVisible(visible);
		textTimeSpan.setVisible(visible);
		fileChooserButton.setVisible(visible);
		fc.setVisible(visible);
		defaultImages.setVisible(visible);
		saveButton.setVisible(visible);
		if(visible){
			setting.setVisible(false);
			hide.setVisible(true);
		}else{
			setting.setVisible(true);
			hide.setVisible(!false);
		}
	}
	
	public void setSize(int width, int height) {
		frame.setSize(width, height);
	}

	public void setText(String text) {
		timeSpanLabel.setText(text);
	}
}
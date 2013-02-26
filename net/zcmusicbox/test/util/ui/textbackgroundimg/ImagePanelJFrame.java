package net.zcmusicbox.test.util.ui.textbackgroundimg;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImagePanelJFrame extends JFrame implements ActionListener{
	public ImagePanelJFrame() {
		init();
	}
	
	public void init() {
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImagePanel imagePanel = new ImagePanel();
		imagePanel.setOpaque(true); //设置imagePanel组件是透明的
		imagePanel.setBackground(Color.white); //设置面板的背景色
		
		this.getContentPane().add(imagePanel);
		this.setVisible(true);
	}
	
	 public void actionPerformed(ActionEvent e){
		 if(e.getSource() instanceof JButton){
			 JButton button = (JButton)e.getSource();
			 
			 if(button.getName().equals("Save")){
				 
			 }
		 }
	 }
	
	public static void main(String[] args) {
		ImagePanelJFrame f = new ImagePanelJFrame();
	}
	
	
}

class ImagePanel extends JPanel {
	public ImagePanel() {
		super(new BorderLayout());
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon img = new ImageIcon("D:\\workspace\\test\\src\\net\\zcmusicbox\\health\\taskmybreak\\Waterlilies.jpg");
		img.paintIcon(this, g, 0, 0);
	}
}

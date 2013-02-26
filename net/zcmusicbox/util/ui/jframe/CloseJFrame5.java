package net.zcmusicbox.util.ui.jframe;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class CloseJFrame5 extends JFrame {

	//5.间接实现WindowListener接口

	//Frame1.java

	public class Frame1 extends Frame {

		public Frame1() {

			this.setSize(new Dimension(400, 300));

			this.setTitle("Frame1");

			this.addWindowListener(new winEventHandle());

			this.setVisible(true);

		}

		//    public static void main(String[] s){
		//
		//    new Frame1();
		//
		//    }

	}

	class winEventHandle implements WindowListener {

		public void windowClosing(WindowEvent windowEvent) {

			System.exit(0);

		}

		public void windowOpened(WindowEvent windowEvent) {
		}

		public void windowClosed(WindowEvent windowEvent) {
		}

		public void windowIconified(WindowEvent windowEvent) {
		}

		public void windowDeiconified(WindowEvent windowEvent) {
		}

		public void windowActivated(WindowEvent windowEvent) {
		}

		public void windowDeactivated(WindowEvent windowEvent) {
		}

	}

}
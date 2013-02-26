package net.zcmusicbox.util.ui.jframe;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class CloseJFrame3 extends JFrame {

	//3.÷±Ω”ºÃ≥–¥∞ÃÂ  ≈‰∆˜WindowAdapter

	//Frame1.java

	public class Frame1 extends WindowAdapter {

		public Frame1() {

			Frame f = new Frame();

			f.setSize(new Dimension(400, 300));

			f.setTitle("Frame1");

			f.addWindowListener(this);

			f.setVisible(true);

		}

		//		public static void main(String[] s) {
		//
		//			new Frame1();
		//
		//		}

		public void windowClosing(WindowEvent windowEvent) {

			System.exit(0);

		}

	}

}
package net.zcmusicbox.util.ui.jframe;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class CloseJFrame4 extends JFrame {

	//4.º‰Ω”ºÃ≥–¥∞ÃÂ  ≈‰∆˜WindowAdapter

	//Frame1.java

	public class Frame1 extends Frame {

		public Frame1() {

			this.setSize(new Dimension(400, 300));

			this.setTitle("Frame1");

			this.addWindowListener(new winAdapter());

			this.setVisible(true);

		}

		//		public static void main(String[] s) {
		//
		//			new Frame1();
		//
		//		}

	}

	class winAdapter extends WindowAdapter {

		public void windowClosing(WindowEvent windowEvent) {

			System.exit(0);

		}

	}

}
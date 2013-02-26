package net.zcmusicbox.util.ui.jframe;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class CloseJFrame2 extends JFrame {

	class Frame1 extends Frame implements WindowListener {

		public Frame1() {

			this.setSize(new Dimension(400, 300));

			this.setTitle("Frame1");

			this.addWindowListener(this);

		}

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
package net.zcmusicbox.util.ui.jframe;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CloseJFrame6 {

	public Frame1 getFrame() {
		return new Frame1();
	}

	class Frame1 {

		public Frame1() {

			Frame f = new Frame();

			f.addWindowListener(new WindowAdapter() {

				public void windowClosing(WindowEvent e) {

					System.exit(0);

				}

			});

			f.setSize(new Dimension(400, 300));

			f.setVisible(true);

		}

		//Jframe的关闭方法：

		//setDefaultCloseOperation(EXIT_ON_CLOSE);

		// frame的关闭方法如下：

		//this.addWindowListener(new java.awt.event.WindowAdapter() {

		//    public void windowClosing(java.awt.event.WindowEvent e) {
		//
		//    System.exit(0);
		//
		//    }

		//    });
	}

	public static void main(String[] s) {

		(new CloseJFrame6()).getFrame();

	}

}
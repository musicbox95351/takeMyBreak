package net.zcmusicbox.util.ui.jframe;

import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class CloseJFrame extends JFrame {

	private static final long serialVersionUID = 2222014404942835250L;

	class CloseJFrameEnableEvents extends JFrame {
		private static final long serialVersionUID = -7077954130403333597L;

		public CloseJFrameEnableEvents() {

			enableEvents(AWTEvent.WINDOW_EVENT_MASK);

			this.setSize(new Dimension(400, 300));

			this.setTitle("Frame1");

		}

		protected void processWindowEvent(WindowEvent e) {

			super.processWindowEvent(e);

			if (e.getID() == WindowEvent.WINDOW_CLOSING) {

				System.exit(0);

			}

		}
	}

}
package net.zcmusicbox.health.taskmybreak;

import java.util.TimerTask;

import javax.swing.JFrame;

/**
 * һ������ƻ�ִ����
 *
 */
public class TakeMyBreakTask extends TimerTask {
	public static final long MAX_TIME_SPAN = 61l;//���60����
	public static final long DEFAULT_TIME_SPAN = 20l;//���60����
	
	public static TakeMyBreakFrame frame = new TakeMyBreakFrame();

	public TakeMyBreakTask() {
		super();
	}

	@Override
	public void run() {
		frame.setState(JFrame.NORMAL);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

}

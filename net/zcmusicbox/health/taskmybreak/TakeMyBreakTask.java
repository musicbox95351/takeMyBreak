package net.zcmusicbox.health.taskmybreak;

import java.util.TimerTask;

import javax.swing.JFrame;

/**
 * 一个任务计划执行器
 *
 */
public class TakeMyBreakTask extends TimerTask {
	public static final long MAX_TIME_SPAN = 61l;//最多60分钟
	public static final long DEFAULT_TIME_SPAN = 20l;//最多60分钟
	
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

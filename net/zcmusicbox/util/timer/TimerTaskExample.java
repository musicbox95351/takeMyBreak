package net.zcmusicbox.util.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 一个任务计划执行器
 *
 */
public class TimerTaskExample extends TimerTask {
	private Timer timer;
	private boolean cancel;

	public TimerTaskExample(Timer timer, boolean cancelAfterRun) {
		super();
		this.timer = timer;
		cancel = cancelAfterRun;
	}

	@Override
	public void run() {
		System.out.println("-----run");
		if (cancel) {
			timer.cancel();
		}
	}

}

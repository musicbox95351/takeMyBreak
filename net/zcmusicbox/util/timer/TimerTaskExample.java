package net.zcmusicbox.util.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * һ������ƻ�ִ����
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

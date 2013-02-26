package net.zcmusicbox.util.timer;

import java.util.Timer;

import net.zcmusicbox.health.taskmybreak.TakeMyBreakTask;

/**
 * 一个任务计划执行器
 *
 */
public class ScheduleTimer {

	public static final long MINUTUE = 60l * 1000l;

	private Timer timer;

	private long time;

	private long period;

	public ScheduleTimer(  long time, long period) {
		this.time = time;
		this.period = period;
	}

	public void start() {
		if(timer!=null){
			timer.cancel();
		}
		timer = new Timer();
		TakeMyBreakTask task = new TakeMyBreakTask();
		timer.schedule(task, time, period);
	}

	public long getPeriod() {
		return period;
	}

	public void setPeriod(long period) {
		this.period = period;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	
	
//	public static void main(String args[]) {
//		Timer timer = new Timer();
//		ScheduleTimer sch = new ScheduleTimer(timer, new TimerTaskExample(timer, true), 2000l);
//		sch.start();
//	}
}

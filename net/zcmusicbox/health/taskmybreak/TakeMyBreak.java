package net.zcmusicbox.health.taskmybreak;

import net.zcmusicbox.util.timer.ScheduleTimer;

public class TakeMyBreak {

	public TakeMyBreak() {
	}

	public static void main(String args[]) {
		TakeMyBreakFramePainter painter = new TakeMyBreakFramePainter(TakeMyBreakTask.frame);
		painter.addTextArea();
		painter.addFileChooser();
		painter.addImageSelect();
		ScheduleTimer sch = new ScheduleTimer(1l*1000l, TakeMyBreakTask.DEFAULT_TIME_SPAN*60l*1000l);
		TakeMyBreakTask.frame.setTimer(sch);
		sch.start();
	}
}
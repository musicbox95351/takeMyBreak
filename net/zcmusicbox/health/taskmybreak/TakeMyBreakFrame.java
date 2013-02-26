package net.zcmusicbox.health.taskmybreak;

import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import net.zcmusicbox.util.timer.ScheduleTimer;

public class TakeMyBreakFrame extends JFrame{

	private static final long serialVersionUID = 4146896915216372174L;

	private ScheduleTimer timer ;
	
	public TakeMyBreakFrame() {

		this.setSize(new Dimension(400, 300));
		this.setTitle("Take my break!");

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
	}

	public ScheduleTimer getTimer() {
		return timer;
	}

	public void setTimer(ScheduleTimer timer) {
		this.timer = timer;
	}
}
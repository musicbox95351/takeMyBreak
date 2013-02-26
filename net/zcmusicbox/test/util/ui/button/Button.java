package net.zcmusicbox.test.util.ui.button;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import net.zcmusicbox.util.ui.jframe.CloseJFrame;

public class Button {

	public Button() {
	}

	public static void main(String args[]) {
		CloseJFrame jf = new CloseJFrame();
		jf.setSize(new Dimension(400, 300));

		jf.setTitle("Frame1");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();

		JButton jb = new JButton("单击");
		JButton jb2 = new JButton("双击击");
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "弹出对话框");
			}
		});
		jb2.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				if ((e.getClickCount() == 2) && (e.getButton() == MouseEvent.BUTTON1))
					JOptionPane.showMessageDialog(null, "双击弹出对话框");
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});
		jb.setActionCommand("test");
		jp.add(jb);
		jp.add(jb2);
		jf.add(jp);
		jf.setVisible(true);
	}
}

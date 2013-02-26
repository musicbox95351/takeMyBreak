package net.zcmusicbox.test.util.ui.layout;

/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * this software is provided by the copyright holders and contributors "as
 * is" and any express or implied warranties, including, but not limited to,
 * the implied warranties of merchantability and fitness for a particular
 * purpose are disclaimed.  in no event shall the copyright owner or
 * contributors be liable for any direct, indirect, incidental, special,
 * exemplary, or consequential damages (including, but not limited to,
 * procurement of substitute goods or services; loss of use, data, or
 * profits; or business interruption) however caused and on any theory of
 * liability, whether in contract, strict liability, or tort (including
 * negligence or otherwise) arising in any way out of the use of this
 * software, even if advised of the possibility of such damage.
 */

import java.awt.Component;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Spring;
import javax.swing.SpringLayout;

public class SpringDemo4 {
	/**
	* Create the GUI and show it.  For thread safety,
	* this method should be invoked from the
	* event-dispatching thread.
	*/
	private static void createAndShowGUI() {
		//Create and set up the window.
		JFrame frame = new JFrame("SpringDemo4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Set up the content pane.
		Container contentPane = frame.getContentPane();
		SpringLayout layout = new SpringLayout();
		contentPane.setLayout(layout);

		//Create and add the components.
		JLabel label = new JLabel("Label: ");
		JTextField textField = new JTextField("Text field", 15);
		contentPane.add(label);
		contentPane.add(textField);

		//Adjust constraints for the label so it's at (5,5).
		SpringLayout.Constraints contentPaneCons = layout.getConstraints(label);
		contentPaneCons.setX(Spring.sum(Spring.constant(5), contentPaneCons.getConstraint(SpringLayout.WEST)));
		contentPaneCons.setY(Spring.sum(Spring.constant(5), contentPaneCons.getConstraint(SpringLayout.NORTH)));

		//Adjust constraints for the text field so it's at
		//(<label's right edge> + 5, 5).
		SpringLayout.Constraints textFieldCons = layout.getConstraints(textField);
		textFieldCons.setX(Spring.sum(Spring.constant(5), contentPaneCons.getConstraint(SpringLayout.EAST)));
		textFieldCons.setY(Spring.constant(5));

		//Adjust constraints for the content pane.
		setContainerSize(contentPane, 5);

		//Display the window.
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		//Schedule a job for the event-dispatching thread:
		//creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	public static void setContainerSize(Container parent, int pad) {
		SpringLayout layout = (SpringLayout) parent.getLayout();
		Component[] components = parent.getComponents();
		Spring maxHeightSpring = Spring.constant(0);
		SpringLayout.Constraints pCons = layout.getConstraints(parent);

		//Set the container's right edge to the right edge
		//of its rightmost component + padding.
		Component rightmost = components[components.length - 1];
		SpringLayout.Constraints rCons = layout.getConstraints(rightmost);
		pCons
				.setConstraint(SpringLayout.EAST, Spring.sum(Spring.constant(pad), rCons
						.getConstraint(SpringLayout.EAST)));

		//Set the container's bottom edge to the bottom edge
		//of its tallest component + padding.
		for (int i = 0; i < components.length; i++) {
			SpringLayout.Constraints cons = layout.getConstraints(components[i]);
			maxHeightSpring = Spring.max(maxHeightSpring, cons.getConstraint(SpringLayout.SOUTH));
		}
		pCons.setConstraint(SpringLayout.SOUTH, Spring.sum(Spring.constant(pad), maxHeightSpring));
	}
}

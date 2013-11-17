package dev.macrobug.asmodeo.gui;

import javax.swing.JFrame;

public class Gui implements AbstractGui {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Gui(String[] args) {
		// TODO Show Splash screen
		initialize();
		// TODO Hide Splash screen
  }

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
  public void show() {
	  frame.setVisible(true);
  }

}

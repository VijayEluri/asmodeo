package dev.macrobug.asmodeo.gui;

import java.awt.SplashScreen;

import javax.swing.JFrame;

public class Gui implements AbstractUI {

	private JFrame frame;

	/**
	 * Create the application.
	 */
	public Gui() {
		SplashScreen splash = SplashScreen.getSplashScreen();
		initialize();
/*
 *  Graphics2D g = splash.createGraphics();
 *  if (g == null) {
 *      System.out.println("g is null");
 *      return;
 *  }
 *  for(int i=0; i<100; i++) {
 *      renderSplashFrame(g, i);
 *      splash.update();
 *      try {
 *          Thread.sleep(90);
 *      }
 *      catch(InterruptedException e) {
 *      }
 *  }
 */
		if(splash!=null) splash.close();
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
  public void start(String[] args) {
	  frame.setVisible(true);
  }

}

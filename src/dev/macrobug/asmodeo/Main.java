package dev.macrobug.asmodeo;

import java.awt.EventQueue;

import dev.macrobug.asmodeo.gui.AbstractUI;
import dev.macrobug.asmodeo.gui.Gui;

public class Main {
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractUI ui = new Gui();
					ui.start(args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

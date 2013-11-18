package dev.macrobug.asmodeo;

import java.awt.EventQueue;

import dev.macrobug.asmodeo.gui.AbstractGui;
import dev.macrobug.asmodeo.gui.Gui;

public class Main {
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractGui window = new Gui(args);
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

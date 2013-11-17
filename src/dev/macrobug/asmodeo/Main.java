package dev.macrobug.asmodeo;

import java.awt.EventQueue;

import dev.macrobug.asmodeo.gui.AbstractGui;
import dev.macrobug.asmodeo.gui.Gui;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AbstractGui window = new Gui();
					window.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

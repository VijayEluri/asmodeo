package org.macrobug.asmodeo.gui;

import java.util.EventListener;


interface ChangeCellListener extends EventListener {
	public void cellEmptied(ChangeCellEvent e);
	public void cellFulled(ChangeCellEvent e);
	public void rowEmptied(ChangeCellEvent e);
	public void rowFulled(ChangeCellEvent e);
}

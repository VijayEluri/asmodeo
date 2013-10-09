package dev.macrobug.asmodeo.gui2;

import java.util.EventListener;

import dev.macrobug.asmodeo.gui2.EdiTable.ChangeCellEvent;


interface ChangeCellListener extends EventListener {
	public void cellEmptied(ChangeCellEvent e);
	public void cellFulled(ChangeCellEvent e);
	public void rowEmptied(ChangeCellEvent e);
	public void rowFulled(ChangeCellEvent e);
}

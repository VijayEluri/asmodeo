package dev.macrobug.asmodeo.gui;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;

public class Gui implements AbstractGui{

	private JFrame frmAsmodeo;

	/**
	 * Create the application.
	 */
	public Gui() {
		// TODO Show Splash screen
		initialize();
		// TODO Hide Splash screen
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAsmodeo = new JFrame();
		frmAsmodeo.setTitle("Asmodeo");
		frmAsmodeo.setIconImage(Toolkit.getDefaultToolkit().getImage(Gui.class.getResource("/image/logo.gif")));
		frmAsmodeo.setBounds(100, 100, 450, 300);
		frmAsmodeo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAsmodeo.getContentPane().setLayout(new BoxLayout(frmAsmodeo.getContentPane(), BoxLayout.Y_AXIS));
		
		SaveOnExitListener soel=new SaveOnExitListener();
		frmAsmodeo.addWindowListener(soel);
		
		Box horizontalBox = Box.createHorizontalBox();
		frmAsmodeo.getContentPane().add(horizontalBox);
		
		JComboBox<JCoder> comboBox = new JComboBox<JCoder>();
		horizontalBox.add(comboBox);
		
		JButton button = new JButton("+");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setToolTipText("add new alphabet");
		horizontalBox.add(button);
		
		JTextArea txtrEncodetext = new JTextArea();
		frmAsmodeo.getContentPane().add(txtrEncodetext);
		
		JProgressBar progressBar = new JProgressBar();
		frmAsmodeo.getContentPane().add(progressBar);
		
		JTextArea txtrDecodedtext = new JTextArea();
		frmAsmodeo.getContentPane().add(txtrDecodedtext);
		
		JMenuBar menuBar = new JMenuBar();
		frmAsmodeo.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic('f');
		menuBar.add(mnFile);
		
		JMenu mnImport = new JMenu("Load");
		mnImport.setIcon(new ImageIcon(Gui.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		mnImport.setMnemonic('l');
		mnFile.add(mnImport);
		
		JMenuItem mntmLoadIntoEncoded = new JMenuItem("Load encoded text");
		mntmLoadIntoEncoded.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnImport.add(mntmLoadIntoEncoded);
		
		JMenuItem mntmLoadDecodedText = new JMenuItem("Load decoded text");
		mntmLoadDecodedText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnImport.add(mntmLoadDecodedText);
		
		JMenu mnExport = new JMenu("Save");
		mnExport.setIcon(new ImageIcon(Gui.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		mnExport.setMnemonic('s');
		mnFile.add(mnExport);
		
		JMenuItem mntmSaveEncodedText = new JMenuItem("Save encoded text");
		mntmSaveEncodedText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnExport.add(mntmSaveEncodedText);
		
		JMenuItem mntmSaveDecodedText = new JMenuItem("Save decoded text");
		mntmSaveDecodedText.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnExport.add(mntmSaveDecodedText);
		
		JMenuItem mntmClose = new JMenuItem("Quit");
		mntmClose.setIcon(new ImageIcon(Gui.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mntmClose.addActionListener(soel);
		mnFile.add(mntmClose);
		
		JMenu mnTools = new JMenu("Tools");
		mnTools.setMnemonic('t');
		menuBar.add(mnTools);
		
		JMenuItem mntmEncode = new JMenuItem("Encode");
		mntmEncode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnTools.add(mntmEncode);
		
		JMenuItem mntmDecode = new JMenuItem("Decode");
		mntmDecode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnTools.add(mntmDecode);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setMnemonic('h');
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setIcon(new ImageIcon(Gui.class.getResource("/image/help.gif")));
		mntmAbout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnHelp.add(mntmAbout);
	}

	@Override
  public void show() {
		frmAsmodeo.setVisible(true);
  }
	
	private class SaveOnExitListener implements WindowListener, ActionListener{
		private File getFile(){
			// TODO da fare
			return null;
		}
		
		private void save(JFrame frame){
			// TODO da fare
			File file=getFile();
			return;
		}

		@Override
    public void actionPerformed(ActionEvent e) {
			save((JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource()));
    }

		@Override
    public void windowOpened(WindowEvent e) {}

		@Override
    public void windowClosing(WindowEvent e) {
	    save((JFrame) e.getWindow());
    }

		@Override
    public void windowClosed(WindowEvent e) {}

		@Override
    public void windowIconified(WindowEvent e) {}

		@Override
    public void windowDeiconified(WindowEvent e) {}

		@Override
    public void windowActivated(WindowEvent e) {}

		@Override
    public void windowDeactivated(WindowEvent e) {}
	}
}

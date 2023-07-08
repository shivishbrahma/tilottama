/**
 * 
 */
package com.shivishbrahma.tilottama.test.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.shivishbrahma.tilottama.main.App;
import com.shivishbrahma.tilottama.main.gui.par.GuiMenuItem;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class Notepad extends Gui implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2463055845497330400L;
	protected JMenu fileMenu, editMenu, formatMenu, viewMenu;

	public Notepad(App app) {
		super(app, "Notepad");
		initMenuBar();
		initFileMenu();
	}

	private void initMenuBar() {
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic('F');

		editMenu = new JMenu("Edit");
		editMenu.setMnemonic('E');

		viewMenu = new JMenu("View");
		viewMenu.setMnemonic('V');

		formatMenu = new JMenu("Format");
		formatMenu.setMnemonic('O');

		helpMenu.setMnemonic('H');
		windowMenu.setMnemonic('W');
		utilitiesMenu.setMnemonic('U');

		menu.add(formatMenu, 0);
		menu.add(viewMenu, 0);
		menu.add(editMenu, 0);
		menu.add(fileMenu, 0);
	}

	private void initFileMenu() {
		JMenuItem newFile = new GuiMenuItem("New");
		fileMenu.add(newFile);

	}

	/*
	 * Helper Functions
	 */
	JMenuItem createMenuItem(String s, int key, JMenu toMenu, int aclKey, ActionListener al) {
		JMenuItem temp = new JMenuItem(s, key);
		temp.addActionListener(al);
		temp.setAccelerator(KeyStroke.getKeyStroke(aclKey, ActionEvent.CTRL_MASK));
		toMenu.add(temp);

		return temp;
	}

	JMenuItem createMenuItem(String s, int key, JMenu toMenu, ActionListener al) {
		JMenuItem temp = new JMenuItem(s, key);
		temp.addActionListener(al);
		toMenu.add(temp);

		return temp;

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}

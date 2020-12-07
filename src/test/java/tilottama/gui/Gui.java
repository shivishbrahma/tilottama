/**
 * 
 */
package tilottama.gui;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import tilottama.App;
import tilottama.gui.par.GuiMenuItem;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class Gui extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9174476999612229384L;
	protected App app;
	protected JMenuBar menu;
	protected JMenu helpMenu, windowMenu, utilitiesMenu;
	protected GuiMenuItem aboutItem, exitItem, calcItem;
	protected Gui frame;

	public Gui(App app) {
		this(app, "");
	}

	public Gui(App app, String name) {
		this.app = app;
		this.setSize(1000, 800);
		if (name != "")
			name = name + " - " + app.getAPP_NAME();
		else
			name = app.getAPP_NAME();
		this.setTitle(name);
		this.setIconImage(app.getAPP_ICON().getImage());
		this.setResizable(false);
		// Display in the center of the screen
		this.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getSize().width) / 2,
				(Toolkit.getDefaultToolkit().getScreenSize().height - getSize().height) / 2);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = this;
		initMenuBar();
		this.setJMenuBar(menu);
	}

	private void initMenuBar() {
		menu = new JMenuBar();

		utilitiesMenu = new JMenu("Utilities");
		calcItem = new GuiMenuItem("Calculator");
		calcItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
				app.getFrames().get("calculator").setVisible(true);
			}
		});
		utilitiesMenu.add(calcItem);

		windowMenu = new JMenu("Window");
		exitItem = new GuiMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
				System.exit(0);
			}
		});
		windowMenu.add(exitItem);

		helpMenu = new JMenu("Help");
		aboutItem = new GuiMenuItem("About...");
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
				app.getFrames().get("about").setVisible(true);
			}
		});
		helpMenu.add(aboutItem);

		menu.add(utilitiesMenu);
		menu.add(windowMenu);
		menu.add(helpMenu);
	}

	/**
	 * @return the app
	 */
	public App getApp() {
		return app;
	}

	/**
	 * @param app the app to set
	 */
	public void setApp(App app) {
		this.app = app;
	}

}

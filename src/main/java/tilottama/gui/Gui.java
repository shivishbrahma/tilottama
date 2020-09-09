/**
 * 
 */
package tilottama.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import tilottama.App;

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
	private App app;
	private JMenuBar menu;
	private JMenu helpMenu;
	private JMenuItem aboutItem;
	private Gui frame;
	

	public Gui(App app) {
		this(app, "");
	}

	public Gui(App app, String name) {
		this.app = app;
		this.setSize(600, 500);
		this.setTitle(app.getAPP_NAME());
		this.setIconImage(app.getAPP_ICON().getImage());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame = this;
		initMenuBars();
		this.setJMenuBar(menu);
	}

	private void initMenuBars() {
		menu = new JMenuBar();

		helpMenu = new JMenu("Help");
		aboutItem = new JMenuItem("About...");
		aboutItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				frame.dispose();
				app.getFrames().get("about").setVisible(true);
			}
		});
		helpMenu.add(aboutItem);

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

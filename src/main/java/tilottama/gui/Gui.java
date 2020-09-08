/**
 * 
 */
package tilottama.gui;

import javax.swing.JFrame;

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
	public App app;

	public Gui(App app) {
		this.app = app;
		this.setSize(600, 500);
		this.setTitle(app.getAPP_NAME());
		this.setIconImage(app.getAPP_ICON().getImage());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

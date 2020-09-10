/**
 * 
 */
package tilottama.gui.par;

import java.awt.Dimension;

import javax.swing.JMenuItem;

/**
 * @author Purbayan Chowdhury<a href="mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class GuiMenuItem extends JMenuItem{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8352238449713699828L;

	public GuiMenuItem(String name){
		super(name);
		this.setPreferredSize(new Dimension(100, this.getPreferredSize().height));
	}
}

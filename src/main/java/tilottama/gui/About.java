/**
 * 
 */
package tilottama.gui;

import javax.swing.JLabel;

import tilottama.App;

/**
 * @author Purbayan Chowdhury<a href="mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class About extends Gui{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5811233931592753088L;

	/**
	 * @param app
	 */
	public About(App app) {
		super(app);
		
		JLabel nameLabel = new JLabel(app.getAPP_NAME());
		this.add(nameLabel);
		for(String author:app.getAuthors()) {
			this.add(new JLabel(author));
		}
		
		
	}

}

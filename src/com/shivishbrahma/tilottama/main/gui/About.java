/**
 * 
 */
package com.shivishbrahma.tilottama.main.gui;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.shivishbrahma.tilottama.main.App;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class About extends Gui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5811233931592753088L;

	/**
	 * @param app
	 */
	public About(App app) {
		super(app);
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(grid);
		// App Name
		JLabel nameLabel = new JLabel(app.getAPP_NAME());
		nameLabel.setBounds(100, 100, 500, 50);
		nameLabel.setFont(new Font(Font.SERIF, Font.BOLD, 16));
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 20;
		gbc.fill = GridBagConstraints.NORTH;
		this.add(nameLabel, gbc);
		// App Logo
		Image logo = app.getAPP_ICON().getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		JLabel appLogo = new JLabel(new ImageIcon(logo));
		appLogo.setSize(100, 100);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipady = 10;
		this.add(appLogo, gbc);
		// App Version
		JPanel versionPanel = new JPanel(grid);
		JLabel versionLabel = new JLabel("Version: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		versionPanel.add(versionLabel, gbc);
		JLabel versionName = new JLabel(app.getVersion());
		versionName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
		gbc.gridx = 1;
		gbc.gridy = 0;
		versionPanel.add(versionName, gbc);
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipady = 10;
		this.add(versionPanel, gbc);
		// App Authors
		JPanel authorsPanel = new JPanel(grid);
		JLabel authorLabel = new JLabel("Developed by:");
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		authorsPanel.add(authorLabel, gbc);
		int c = 1;
		for (String author : app.getAuthors()) {
			JLabel authorName = new JLabel(author);
			authorName.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 12));
			nameLabel.setSize(500, 50);
			gbc.gridx = 0;
			gbc.gridy = c++;
			authorsPanel.add(authorName, gbc);
		}
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipady = 10;
		this.add(authorsPanel, gbc);

	}
}

/**
 * 
 */
package tilottama.gui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tilottama.App;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class Converter extends Gui {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1761841530029285776L;
	private JLabel nameLabel, toLabel, fromLabel;
	GridBagLayout grid;
	GridBagConstraints gbc;
	private JPanel typePanel, convPanel;
	private JComboBox<String> typeSelect, toSelect, fromSelect;
	private JTextField toText, fromText;
	private JButton convBtn;
	private ActionListener tempConv;

	/**
	 * @param app
	 */
	public Converter(App app) {
		super(app, "Converter");
		String typeList[] = { "Temperature", "Currency", "Length" };

		grid = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(grid);

		initTemperature();
		initCurrency();

		typePanel = new JPanel(grid);
		nameLabel = new JLabel("Type: ");
		nameLabel.setPreferredSize(new Dimension(100, 50));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipadx = 5;
		gbc.gridwidth = 1;
		typePanel.add(nameLabel, gbc);

		typeSelect = new JComboBox<>(typeList);
		typeSelect.setPreferredSize(new Dimension(150, 20));
		gbc.gridx = 1;
		gbc.ipadx = 5;
		typePanel.add(typeSelect, gbc);

		gbc.gridx = gbc.gridy = 0;
		gbc.ipady = 5;
		this.add(typePanel, gbc);
	}

	public char getCharTemperature(String s) {
		ArrayList<String> tempUnits = new ArrayList<>();
		tempUnits.add("Kelvin(K)");
		tempUnits.add("Fahrenheit(℉)");
		tempUnits.add("Celsius(℃)");
		ArrayList<Character> charUnits = new ArrayList<>();
		charUnits.add('K');
		charUnits.add('F');
		charUnits.add('C');
		return charUnits.get(tempUnits.indexOf(s));
	}

	public void initTemperature() {
		convPanel = new JPanel(grid);
		String tempUnits[] = { "Kelvin(K)", "Fahrenheit(℉)", "Celsius(℃)" };

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(convPanel, gbc);

		toLabel = new JLabel("To: ");
		toLabel.setPreferredSize(new Dimension(250, 20));
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		convPanel.add(toLabel, gbc);

		toText = new JTextField(8);
		toText.setPreferredSize(new Dimension(80, 20));
		toText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		toText.setEnabled(false);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 5;
		gbc.gridwidth = 1;
		convPanel.add(toText, gbc);

		toSelect = new JComboBox<>(tempUnits);
		toSelect.setPreferredSize(new Dimension(150, 20));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.ipadx = 5;
		gbc.gridwidth = 1;
		convPanel.add(toSelect, gbc);

		fromLabel = new JLabel("From: ");
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.ipady = 5;
		gbc.gridwidth = 2;
		convPanel.add(fromLabel, gbc);

		fromText = new JTextField(8);
		fromText.setPreferredSize(new Dimension(80, 20));
		fromText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipadx = 5;
		gbc.gridwidth = 1;
		convPanel.add(fromText, gbc);

		fromSelect = new JComboBox<>(tempUnits);
		fromSelect.setPreferredSize(new Dimension(150, 20));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		convPanel.add(fromSelect, gbc);

		convBtn = new JButton("Convert");
		convBtn.setPreferredSize(new Dimension(100, 20));
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		convPanel.add(convBtn, gbc);

		tempConv = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				String fromUnit = (String) fromSelect.getSelectedItem(), toUnit = (String) toSelect.getSelectedItem();
				double fromValue = Double.parseDouble(fromText.getText());
				if (fromUnit.equalsIgnoreCase(toUnit)) {
					toText.setText(Double.toString(fromValue));
				} else {
					toText.setText(Double.toString(tilottama.par.Temperature
							.temperatureConv(getCharTemperature(fromUnit), getCharTemperature(toUnit), fromValue)));
				}
			}
		};
		convBtn.addActionListener(tempConv);
	}

	public void initCurrency() {

	}

}

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
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import tilottama.App;
import tilottama.util.CurrencyConvertor;
import tilottama.util.currencyconv.api.Currency;

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
	private JLabel nameLabel, toLabel, toVal, fromLabel, fromVal;
	GridBagLayout grid;
	GridBagConstraints gbc;
	private JPanel typePanel, convPanel, equalsPanel;
	private JComboBox<String> typeSelect, toSelect, fromSelect;
	private JTextField toText, fromText;
	private JButton convBtn;
	private ActionListener tempConv, currConv;

	/**
	 * @param app
	 */
	public Converter(App app) {
		super(app, "Converter");
		String typeList[] = { "Temperature", "Currency", "Length" };

		grid = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(grid);

		initPanels();
		initTemperature();

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

		typeSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				switch (typeSelect.getSelectedIndex()) {
				case 0:
					initTemperature();
					break;
				case 1:
					initCurrency();
					break;
				}
			}
		});
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

	public void initPanels() {
		convPanel = new JPanel(grid);

		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(convPanel, gbc);

		fromLabel = new JLabel("From: ");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 5;
		gbc.ipadx = 5;
		gbc.gridwidth = 2;
		convPanel.add(fromLabel, gbc);

		fromText = new JTextField(8);
		fromText.setPreferredSize(new Dimension(80, 20));
		fromText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.ipadx = 5;
		gbc.gridwidth = 1;
		convPanel.add(fromText, gbc);

		fromSelect = new JComboBox<>();
		fromSelect.setMinimumSize(new Dimension(200, 20));
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		convPanel.add(fromSelect, gbc);

		toLabel = new JLabel("To: ");
		toLabel.setPreferredSize(new Dimension(250, 20));
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		convPanel.add(toLabel, gbc);

		toText = new JTextField(8);
		toText.setPreferredSize(new Dimension(80, 20));
		toText.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		toText.setEnabled(false);
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.ipadx = 5;
		gbc.gridwidth = 1;
		convPanel.add(toText, gbc);

		toSelect = new JComboBox<>();
		toSelect.setMinimumSize(new Dimension(200, 20));
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.ipadx = 5;
		gbc.gridwidth = 1;
		convPanel.add(toSelect, gbc);

		equalsPanel = new JPanel(grid);

		fromVal = new JLabel("(fromValue)");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.ipady = 5;
		gbc.ipadx = 5;
		equalsPanel.add(fromVal, gbc);

		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipady = 5;
		gbc.ipadx = 5;
		equalsPanel.add(new JLabel("="), gbc);

		toVal = new JLabel("(toValue)");
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.ipady = 5;
		gbc.ipadx = 5;
		equalsPanel.add(toVal, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(20, 20, 20, 20);
		convPanel.add(equalsPanel, gbc);

		convBtn = new JButton("Convert");
		convBtn.setPreferredSize(new Dimension(100, 20));
		gbc.insets = new Insets(20, 20, 20, 20);
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 2;
		convPanel.add(convBtn, gbc);
	}

	public void initTemperature() {
		String tempUnits[] = { "Kelvin(K)", "Fahrenheit(℉)", "Celsius(℃)" };
		fromSelect.removeAllItems();
		for (String item : tempUnits) {
			fromSelect.addItem(item);
		}
		toSelect.removeAllItems();
		for (String item : tempUnits) {
			toSelect.addItem(item);
		}
		// Remove all Action Listeners
		for (ActionListener l : convBtn.getActionListeners()) {
			convBtn.removeActionListener(l);
		}
		tempConv = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				String fromUnit = (String) fromSelect.getSelectedItem(), toUnit = (String) toSelect.getSelectedItem();
				double fromValue = Double.parseDouble(fromText.getText());
				if (fromUnit.equalsIgnoreCase(toUnit)) {
					toText.setText(Double.toString(fromValue));
					fromVal.setText(tilottama.par.Temperature.temperatureFormat(fromUnit.charAt(0), fromValue));
					toVal.setText(tilottama.par.Temperature.temperatureFormat(toUnit.charAt(0), fromValue));
				} else {
					double toValue = tilottama.par.Temperature.temperatureConv(getCharTemperature(fromUnit),
							getCharTemperature(toUnit), fromValue);
					toText.setText(String.format("%.3f", toValue));
					fromVal.setText(tilottama.par.Temperature.temperatureFormat(fromUnit.charAt(0), fromValue));
					toVal.setText(tilottama.par.Temperature.temperatureFormat(toUnit.charAt(0), toValue));
				}
			}
		};
		convBtn.addActionListener(tempConv);
	}

	public void initCurrency() {
		List<Currency> currList = tilottama.par.CurrencyHandler.getCurrencies();
		fromSelect.removeAllItems();
		for (Currency curr : currList) {
			fromSelect.addItem(curr.toString());
		}
		toSelect.removeAllItems();
		for (Currency curr : currList) {
			toSelect.addItem(curr.toString());
		}
		// Remove all Action Listeners
		for (ActionListener l : convBtn.getActionListeners()) {
			convBtn.removeActionListener(l);
		}
		currConv = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				CurrencyConvertor c = new CurrencyConvertor(app, "Currency");
				int fromUnit = fromSelect.getSelectedIndex(), toUnit = toSelect.getSelectedIndex();
				double fromValue = Double.parseDouble(fromText.getText());
				if (fromUnit == toUnit) {
					toText.setText(Double.toString(fromValue));
					fromVal.setText(tilottama.par.CurrencyHandler
							.getCurrencyString(currList.get(fromUnit).getCurrencyCode(), fromValue));
					toVal.setText(tilottama.par.CurrencyHandler
							.getCurrencyString(currList.get(fromUnit).getCurrencyCode(), fromValue));
				} else {
					double toValue = c.convertCurrency(currList.get(fromUnit).getCurrencyCode(),
							currList.get(toUnit).getCurrencyCode(), fromValue);
					toText.setText(String.format("%.2f", toValue));
					fromVal.setText(tilottama.par.CurrencyHandler
							.getCurrencyString(currList.get(fromUnit).getCurrencyCode(), fromValue));
					toVal.setText(tilottama.par.CurrencyHandler
							.getCurrencyString(currList.get(toUnit).getCurrencyCode(), toValue));
				}
			}
		};
		convBtn.addActionListener(currConv);
	}

	public void initLength() {

	}

}

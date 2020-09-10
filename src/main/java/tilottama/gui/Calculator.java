/**
 * 
 */
package tilottama.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tilottama.App;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class Calculator extends Gui {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4234320234152962794L;
	private JButton numBtn[] = new JButton[12];
	private JPanel numKeyPad, optKeyPad;
	private JButton optBtn[] = new JButton[5];
	private JLabel calDis;
	GridBagLayout grid;
	GridBagConstraints gbc;

	/**
	 * 
	 */
	public Calculator(App app) {
		super(app);
		grid = new GridBagLayout();
		gbc = new GridBagConstraints();
		this.setLayout(grid);
		this.initDisplay();
		this.initNumKeys();
		this.initOptKeys();
	}
	
	public void initDisplay() {
		calDis = new JLabel("0");
		calDis.setPreferredSize(new Dimension(300, 70));
		calDis.setForeground(new Color(235, 240, 254));
		calDis.setBackground(new Color(0,129,72));
		calDis.setBorder(new EmptyBorder(20, 20, 10, 10));
		calDis.setOpaque(true);
		calDis.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth=2;
		this.add(calDis, gbc);	
		gbc.gridwidth=1;
	}

	public void initNumKeys() {
		int i;
		numKeyPad = new JPanel(grid);
		for (i = 9; i >= 0; i--) {
			numBtn[i + 2] = new JButton(Integer.toString(i));
			numBtn[i].addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					String s=calDis.getText();
//					s=s+Integer.toString(i);
					calDis.setText(s);
				}
			});
		}
		numBtn[1] = numBtn[2];
		numBtn[2] = new JButton(".");
		numBtn[0] = new JButton("±");
		for (i = 11; i >= 0; i--) {
			numBtn[i].setForeground(new Color(33, 34, 39));
			numBtn[i].setBackground(new Color(255, 255, 255));
			numBtn[i].setPreferredSize(new Dimension(75, 50));
			numBtn[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
			gbc.gridx = 3 - (11 - i) % 3;
			gbc.gridy = (11 - i) / 3;
			numKeyPad.add(numBtn[i], gbc);
		}
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(numKeyPad, gbc);
	}

	public void initOptKeys() {
		optKeyPad = new JPanel(grid);
		optBtn[0]=new JButton("/");
		optBtn[1]=new JButton("*");
		optBtn[2]=new JButton("-");
		optBtn[3]=new JButton("+");
		optBtn[4]=new JButton("=");
		for(int i=0;i<5;i++) {
			optBtn[i].setForeground(new Color(255, 255, 255));
			optBtn[i].setBackground(new Color(239, 41, 23));
			optBtn[i].setPreferredSize(new Dimension(75, 40));
			optBtn[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
			gbc.gridx=0;
			gbc.gridy=i;
			optKeyPad.add(optBtn[i], gbc);
		}
		gbc.fill=GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		this.add(optKeyPad, gbc);
	}

}

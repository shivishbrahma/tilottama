/**
 * 
 */
package com.shivishbrahma.tilottama.test.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.shivishbrahma.tilottama.main.App;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class Calculator extends Gui{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4234320234152962794L;
	private JButton numBtn[] = new JButton[12];
	private JButton optBtn[] = new JButton[5];
	private JButton sysBtn[] = new JButton[4];
	private JPanel disPad, numKeyPad, optKeyPad, sysKeyPad;
	private JLabel calDis, stepDis, optDis;
	private boolean isOptPressed;
	GridBagLayout grid;
	GridBagConstraints gbc;
	Stack<Double> numStack;
	Stack<Character> optStack;

	/**
	 * 
	 */
	public Calculator(App app) {
		super(app, "Calculator");
		grid = new GridBagLayout();
		gbc = new GridBagConstraints();
		numStack = new Stack<>();
		optStack = new Stack<>();
		this.setLayout(grid);
		isOptPressed = false;
		this.initDisplay();
		this.initNumKeys();
		this.initOptKeys();
		this.initSysKeys();
		this.addKeyListener(new CalcKey());
	}

	public void initDisplay() {
		disPad = new JPanel(grid);
		gbc.fill=GridBagConstraints.HORIZONTAL;
		calDis = new JLabel("0");
		calDis.setPreferredSize(new Dimension(300, 60));
		calDis.setForeground(new Color(235, 240, 254));
		calDis.setBackground(new Color(0, 129, 72));
		calDis.setBorder(new EmptyBorder(20, 20, 20, 20));
		calDis.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
		calDis.setOpaque(true);
		calDis.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx=0;
		gbc.gridy=0;
		gbc.gridwidth=2;
		disPad.add(calDis,gbc);
		
		stepDis = new JLabel("0");
		stepDis.setPreferredSize(new Dimension(150,25));
		stepDis.setForeground(new Color(235, 240, 254));
		stepDis.setBackground(new Color(0, 129, 72));
		stepDis.setBorder(new EmptyBorder(5, 30, 5, 30));
		stepDis.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
		stepDis.setOpaque(true);
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.gridwidth=1;
		disPad.add(stepDis,gbc);
		
		optDis = new JLabel("");
		optDis.setPreferredSize(new Dimension(150, 25));
		optDis.setForeground(new Color(235, 240, 254));
		optDis.setBackground(new Color(0, 129, 72));
		optDis.setBorder(new EmptyBorder(5, 30, 20, 30));
		optDis.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
		optDis.setOpaque(true);
		optDis.setHorizontalAlignment(JLabel.RIGHT);
		gbc.gridx=1;
		gbc.gridy=1;
		gbc.gridwidth=1;
		disPad.add(optDis,gbc);
		
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		this.add(disPad, gbc);
		gbc.gridwidth = 1;
	}

	public void initSysKeys() {
		int i;
		sysKeyPad = new JPanel(grid);
		sysBtn[0] = new JButton("AC");
		sysBtn[1] = new JButton("CE");
//		sysBtn[2] = new JButton("00");
		sysBtn[2] = new JButton("⇐");
		for (i = 0; i < 3; i++) {
			sysBtn[i].setForeground(new Color(255, 255, 255));
			sysBtn[i].setBackground(new Color(14, 52, 160));
			sysBtn[i].setPreferredSize(new Dimension(75, 50));
			sysBtn[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 16));
			sysBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					String s = calDis.getText(), key = ((AbstractButton) evt.getSource()).getText();
					if (key.equalsIgnoreCase("AC")) {
						s = "";
						numStack.clear();
						optStack.clear();
						stepDis.setText("");
						optDis.setText("");
					}
					if (key.equalsIgnoreCase("CE")) {
						s = "";
					}
					if (key.equalsIgnoreCase("⇐")) {
						int len = s.length();
						s = s.substring(0, len - 1);
					}
					calDis.setText(s);
				}
			});
			gbc.gridx = i;
			gbc.gridy = 0;
			sysKeyPad.add(sysBtn[i], gbc);
		}
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 2;
		this.add(sysKeyPad, gbc);
	}

	public void initNumKeys() {
		int i;
		numKeyPad = new JPanel(grid);
		for (i = 9; i >= 0; i--) {
			numBtn[i + 2] = new JButton(Integer.toString(i));
		}
		numBtn[1] = numBtn[2];
		numBtn[2] = new JButton(".");
		numBtn[0] = new JButton("±");
		for (i = 11; i >= 0; i--) {
			numBtn[i].setForeground(new Color(33, 34, 39));
			numBtn[i].setBackground(new Color(246, 244, 243));
			numBtn[i].setPreferredSize(new Dimension(75, 50));
			numBtn[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
			numBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					updateStep();
					String s = calDis.getText();
					char key = ((AbstractButton) evt.getSource()).getText().charAt(0);
					// Change sign of number
					if (key == '±' && s!="0") {
						if (s.startsWith("-"))
							s = s.replace("-", "");
						else
							s = "-" + s;
					} // Decimal can be pressed only once
					else if (s.indexOf('.') == -1 || key != '.') {
						// First time when the key press occur after an operation press or new start
						if ((!isOptPressed && s != "0") || key == '.')
							s = s + key;
						else {
							s = "" + key;
							isOptPressed = false;
						}
					}
					calDis.setText(s);
				}
			});
			gbc.gridx = 3 - (11 - i) % 3;
			gbc.gridy = (11 - i) / 3;
			numKeyPad.add(numBtn[i], gbc);
		}
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 0;
		gbc.gridy = 1;
		this.add(numKeyPad, gbc);
	}

	public void initOptKeys() {
		optKeyPad = new JPanel(grid);
		optBtn[0] = new JButton("/");
		optBtn[1] = new JButton("*");
		optBtn[2] = new JButton("-");
		optBtn[3] = new JButton("+");
		optBtn[4] = new JButton("=");
		for (int i = 0; i < 5; i++) {
			optBtn[i].setForeground(new Color(255, 255, 255));
			optBtn[i].setBackground(new Color(239, 41, 23));
			optBtn[i].setPreferredSize(new Dimension(75, 50));
			optBtn[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14));
			optBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent evt) {
					updateStep();
					String s = calDis.getText();
					char key = ((AbstractButton) evt.getSource()).getText().charAt(0);
					numStack.push(Double.parseDouble(s));
					isOptPressed = true;
					if (optStack.size() > 0 && optStack.lastElement() != '=')
						operate(optStack.lastElement());
					optStack.push(key);
					optDis.setText(""+key);
				}
			});
			gbc.gridx = 0;
			gbc.gridy = i;
			optKeyPad.add(optBtn[i], gbc);
		}
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridheight = 2;
		this.add(optKeyPad, gbc);
	}

	public boolean isInteger(double d) {
		return d == Math.round(d);
	}
	
	public void updateStep() {
		stepDis.setText(String.format("%d", numStack.size()+1));
	}

	public void operate(char c) {
		int len = numStack.size();
		double num2 = numStack.get(len - 1), num1 = numStack.get(len - 2), res = 0;
		switch (c) {
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case '/':
			res = num1 / num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		}
		if (!isInteger(res))
			calDis.setText(Double.toString(res));
		else
			calDis.setText(String.format("%.0f", res));
		numStack.push(res);
	}

	class CalcKey implements KeyListener{
		@Override
		public void keyPressed(KeyEvent kev) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent kev) {
			System.out.println(kev.getKeyChar());
			System.out.println(kev.getKeyCode());
			
		}

		@Override
		public void keyTyped(KeyEvent kev) {
			// TODO Auto-generated method stub
			
		}
	}

}

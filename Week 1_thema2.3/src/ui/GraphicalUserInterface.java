package ui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JButton;

import exceptions.NumberBaseException;
import multiformat.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class GraphicalUserInterface extends JFrame {
	public JTextArea textArea = new JTextArea("", 1, 1);
	public ArrayList<String> current = new ArrayList<String>();
	boolean resultIsPressed = false;
	boolean operatorStatus = false;
	JLabel label_format = new JLabel("FIXED");
	JLabel label_base = new JLabel("DEC");
	public static void main(String[] args){
		new GraphicalUserInterface();
	}
	
	public GraphicalUserInterface(){
		/*
		 * Create frame
		 * Create panels
		 * Create all buttons
		 * Add buttons to panels
		 * Add panels to mainpanel
		 * Add mainpanel to frame
		 * Create calculator
		 * 
		 */
	Calculator calc = new Calculator();
	JFrame calculations = new JFrame();
	JPanel calculationsPanel = new JPanel();
	JLabel calculationsLabel = new JLabel();
	calculationsLabel.setText("Nog geen berekeningen gedaan.");
	
	
	calculationsPanel.add(calculationsLabel);
	calculations.add(calculationsPanel);
	
	calculations.pack();
	calculationsPanel.setVisible(true);
	calculations.setVisible(true);
	
	
	JFrame userInterface = new JFrame();
	JPanel panelMain = new JPanel();
	JPanel panelZero = new JPanel();
	JPanel panelOne = new JPanel();
	JPanel panelTwo = new JPanel();
	JPanel panelThree = new JPanel();
	
	
	textArea.setFont(new Font("Verdana", Font.BOLD, 25));		
	textArea.setEditable(false);
	// Buttons 0-F
	JButton button_0 = new JButton("0"); 
	
	JButton button_1 = new JButton("1"); JButton button_2 = new JButton("2"); JButton button_3 = new JButton("3"); 
	JButton button_4 = new JButton("4"); JButton button_5 = new JButton("5"); JButton button_6 = new JButton("6"); JButton button_7 = new JButton("7"); 
	JButton button_8 = new JButton("8"); JButton button_9 = new JButton("9"); JButton button_A = new JButton("A"); JButton button_B = new JButton("B");
	JButton button_C = new JButton("C"); JButton button_D = new JButton("D"); JButton button_E = new JButton("E"); JButton button_F = new JButton("F");
	// Buttons Operators
	JButton button_div = new JButton("/"); JButton button_mul =    new JButton("*"); JButton button_sub = new JButton("-");
	JButton button_add = new JButton("+"); JButton button_result = new JButton("=");
	// Buttons RAT, FIXED, FLOAT, DOT(.), semiL, semiR and NEGATE(-/+)
	JButton button_rat = new JButton("RAT"); JButton button_fixed = new JButton("FIXED"); JButton button_float = new JButton("FLOAT");
	JButton button_semiL = new JButton("("); JButton button_semiR = new JButton(")");
	JButton button_dot = new JButton(".");   JButton button_neg =   new JButton("-/+");
	// Buttons BIN, OCT, DEC, HEX, CLEAR, SAVE, INSERT
	JButton button_bin = new JButton("BIN"); JButton button_oct = new JButton("OCT")  ; JButton button_dec = new JButton("DEC"); 
	JButton button_hex = new JButton("HEX"); JButton button_clr = new JButton("CLEAR"); JButton button_save = new JButton("SAVE");
	JButton button_ins = new JButton("INSERT");
	userInterface.setResizable(false);
	// Butons Dummy, dummy, dummy and next
	JButton button_dummy = new JButton("Dummy");
	JButton button_dummy1 = new JButton("Dummy");
	JButton button_dummy2 = new JButton("Dummy");
	JButton button_dummy3 = new JButton("Dummy");
	JButton button_next = new JButton("NEXT"); // in command.java this is equal to (op n) where n is a number. (op 5 would load 5 on operand 1.)
	
	/*
	 * Huge list of action listeners, one for every button...
	 */
	button_0.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText("");	calc.clearStacks();	}
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("0");
			System.out.println("LOGGER:: '0' has been appended to textArea");
		}
	});
	
	button_1.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("1");
			System.out.println("LOGGER:: '1' has been appended to textArea");
		}
	});
	
	button_2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("2");
			System.out.println("LOGGER:: '2' has been appended to textArea");
		}
	});
	
	button_3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("3");
			System.out.println("LOGGER:: '3' has been appended to textArea");
			
		}
	});
	
	button_4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("4");
			System.out.println("LOGGER:: '4' has been appended to textArea");
			
		}
	});
	
	button_5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("5");
			System.out.println("LOGGER:: '5' has been appended to textArea");
			
		}
	});
	
	button_6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("6");
			System.out.println("LOGGER:: '6' has been appended to textArea");
			
		}
	});
	
	button_7.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("7");
			System.out.println("LOGGER:: '7' has been appended to textArea");
			
		}
	});
	
	button_8.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("8");
			System.out.println("LOGGER:: '8' has been appended to textArea");
			
		}
	});
	
	button_9.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("9");
			System.out.println("LOGGER:: '9' has been appended to textArea");
			
		}
	});
	
	button_A.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("A");
			System.out.println("LOGGER:: 'A' has been appended to textArea");
			
		}
	});
	
	button_B.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("B");
			System.out.println("LOGGER:: 'B' has been appended to textArea");
			
		}
	});
	
	button_C.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("C");
			System.out.println("LOGGER:: 'C' has been appended to textArea");
			
		}
	});
	
	button_D.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("D");
			System.out.println("LOGGER:: 'D' has been appended to textArea");
			
		}
	});
	
	button_E.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("E");
			System.out.println("LOGGER:: 'E' has been appended to textArea");
			
		}
	});
	
	button_F.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			if(resultIsPressed && !operatorStatus) { textArea.setText(""); calc.clearStacks(); }
			if(operatorStatus) { textArea.setText(""); }
			operatorStatus = false;
			resultIsPressed = false;
			appendText("F");
			System.out.println("LOGGER:: 'F' has been appended to textArea");
			
		}
	});
	
	
	
	// OPERATOR BUTTONS
	
	
	button_mul.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				System.out.println("Stack size BEFORE is: " + calc.getOperandStack().size());
				calc.addOperandToStack(calc.createOperand(textArea.getText()));
				System.out.println("Stack size AFTER is: " + calc.getOperandStack().size());
			} catch (FormatException e1) {
				e1.printStackTrace();
			}
			textArea.setText("");
			resultIsPressed = false;
			operatorStatus = true;
			textArea.append("*");
			calc.addOperatorToStack("*");
			System.out.println("Method finished, stack size is: " + calc.getOperandStack().size());
		}
	});
	
	button_add.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				calc.addOperandToStack(calc.createOperand(textArea.getText()));
				
			} catch (FormatException e1) {
				e1.printStackTrace();
			}
			textArea.setText("");
			resultIsPressed = false;
			operatorStatus = true;
			textArea.append("+");
			calc.addOperatorToStack("+");
		}
	});
	
	button_sub.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				calc.addOperandToStack(calc.createOperand(textArea.getText()));
			} catch (FormatException e1) {
				e1.printStackTrace();
			}
			textArea.setText("");
			resultIsPressed = false;
			operatorStatus = true;
			textArea.append("-");
			calc.addOperatorToStack("-");
		}
	});
	
	button_div.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				calc.addOperandToStack(calc.createOperand(textArea.getText())); // 0 = 5;
			} catch (FormatException e1) {
				e1.printStackTrace();
			}
			textArea.setText("");
			resultIsPressed = false;
			operatorStatus = true;
			textArea.append("/");
			calc.addOperatorToStack("/"); // 0 = /
		}
	});
	
	// RESULT BUTTON
	
	button_result.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			try {
				calc.addOperandToStack(calc.createOperand(textArea.getText())); // 1 = 10
			} catch (FormatException e1) {
				e1.printStackTrace();
			}
			System.out.println("Stack size BEFORE RESULT is: " + calc.getOperandStack().size());
			textArea.setText(calc.OperandToString(calc.parseStacks(),calc.getBase()));
			System.out.println("Stack size AFTER PROCESSING is: " + calc.getOperandStack().size());
			try {
				calc.addOperandToStack(calc.createOperand(textArea.getText()));
			} catch (FormatException e1) {
				e1.printStackTrace();
			}
			resultIsPressed = true;
			operatorStatus = false;
			calc.incrementCalculations();
			calculationsLabel.setText("Aantal berekeningen: " + calc.getCalculations());
		}
	});
	
	// more buttons! Buttons like.. BIN, OCT, DEC, HEX, CLEAR, SAVE, INSERT
	button_bin.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Base base = new BinaryBase();
			calc.setBase(base);
			label_base.setText("BIN");
		}
	});
	
	button_oct.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Base base = new OctalBase();
			calc.setBase(base);
			label_base.setText("OCT");
		}
	});
	
	button_dec.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Base base = new DecimalBase();
			calc.setBase(base);
			label_base.setText("DEC");
		}
	});

	button_hex.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			Base base = new HexBase();
			calc.setBase(base);
			label_base.setText("HEX");
		}
	});
	
	button_clr.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			calc.clearStacks();
			textArea.setText("");
		}
	});
	
	button_save.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			calc.setVariable(textArea.getText());
			textArea.setText("");
		}
	});
	
	button_ins.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			textArea.setText(calc.getVariable());
		}
	});
	
	
	
	
	/*
	 * Set layouts for panels;
	 * 
	 */
	panelMain.setLayout(new BorderLayout());
	panelZero.setLayout(new GridLayout(1,2));
	panelOne.setLayout(new GridLayout(1,1));
	panelTwo.setLayout(new GridLayout(1,8));
	panelThree.setLayout(new GridLayout(4,8));
	panelThree.setBorder(BorderFactory.createEmptyBorder(25,0,0,0));
	
	/* 
	 * Add components to the panels.
	 */
	panelZero.add(label_base);
	panelZero.add(label_format);
	
	
	panelOne.add(textArea);
		
	
	panelTwo.add(button_bin);
	panelTwo.add(button_oct);
	panelTwo.add(button_dec);
	panelTwo.add(button_hex);
	panelTwo.add(button_clr);
	panelTwo.add(button_save);
	panelTwo.add(button_ins);
	panelTwo.add(button_dummy);
	
	

	
	panelThree.add(button_1);
	panelThree.add(button_2);
	panelThree.add(button_3);
	panelThree.add(button_A);
	panelThree.add(button_B);
	panelThree.add(button_div);
	panelThree.add(button_rat);
	panelThree.add(button_dummy1);
	panelThree.add(button_4);
	panelThree.add(button_5);
	panelThree.add(button_6);
	panelThree.add(button_C);
	panelThree.add(button_D);
	panelThree.add(button_mul);
	panelThree.add(button_fixed);
	panelThree.add(button_dummy2);
	panelThree.add(button_7);
	panelThree.add(button_8);
	panelThree.add(button_9);
	panelThree.add(button_E);
	panelThree.add(button_F);
	panelThree.add(button_sub);
	panelThree.add(button_float);
	panelThree.add(button_dummy3);
	panelThree.add(button_neg);
	panelThree.add(button_0);
	panelThree.add(button_dot);
	panelThree.add(button_semiL);
	panelThree.add(button_semiR);
	panelThree.add(button_add);
	panelThree.add(button_result);
	panelThree.add(button_next);
	
	panelMain.add(panelZero, BorderLayout.EAST);
	panelMain.add(panelOne, BorderLayout.NORTH);
	panelMain.add(panelTwo, BorderLayout.CENTER);
	panelMain.add(panelThree, BorderLayout.SOUTH);
	
	userInterface.add(panelMain);
	userInterface.pack();
	userInterface.setVisible(true);
	}
	public JTextArea getTextArea(){
			return this.textArea;
	}
	
	public void setText(String text){	
			this.textArea.setText(text);
	}
	
	public void appendText(String text){
		System.out.println("Logger: Method appendText has been called.");
		this.getTextArea().append(text);
		System.out.println("Logger: textfield has been updated." + text);
	}
	
}

/*
 * (C) Copyright 2005 Davide Brugali, Marco Torchiano
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA
 * 02111-1307  USA
 */
package multiformat;

import java.util.Stack;

import exceptions.NumberBaseException;

/**
 * The multiformat calculator
 */
public class Calculator {
	private Rational operand_0 = new Rational();
	private Rational operand_1 = new Rational();
	private String variable;
	private int calculations = 0;
	private Stack<String> operators = new Stack<String>();
	private Stack<Rational> operands = new Stack<Rational>();
	// The current format of the calculator
	private Format format = new FixedPointFormat();
	// The current numberbase of the calculator
	private Base base = new DecimalBase();

	public void addOperand(String newOperand) throws FormatException, NumberBaseException {
		String pattern = getPattern(base);
		if (base.getName() == "hex") {
			pattern = "-?[0-9A-F.]+";
		} else if (base.getName() == "oct") {
			pattern = "-?[0-7.]+";
		} else if (base.getName() == "dec") {
			pattern = "-?[0-9.]+";
		} else if (base.getName() == "bin") {
			pattern = "-?[0-1.]+";
		}
		if (newOperand.matches(pattern)) {
			operand_1 = operand_0;
			operand_0 = format.parse(newOperand, base);
		} else {
			throw new NumberBaseException("This character does not meet the standards of base:" + base.getName());
		}
	}

	// Methods which probably will be deprecated.
	public void add() {
		operand_0 = operand_1.plus(operand_0);
		operand_1 = new Rational();
	}

	public void subtract() {
		operand_0 = operand_1.minus(operand_0);
		operand_1 = new Rational();
	}

	public void multiply() {
		operand_0 = operand_1.mul(operand_0);
		operand_1 = new Rational();
	}

	public void divide() {
		operand_0 = operand_1.div(operand_0);
		operand_1 = new Rational();
	}

	public void delete() {
		operand_0 = operand_1;
		operand_1 = new Rational();
	}

	/*
	 * Method: addMethod
	 * @param: Rational, Rational;
	 * @return: Rational
	 * 
	 * Adds two rationals together. (Example: 5, 5 = 10;
	 */
	public Rational addMethod(Rational one, Rational two) {
		return one.plus(two);
	}
	
	/*
	 * Method: substractMethod
	 * @param: Rational, Rational;
	 * @return: Rational
	 * 
	 * substracts two rationals from each other. (Example: 5, 5 = 0;
	 */
	public Rational substractMethod(Rational one, Rational two) {
		return one.minus(two);
	}

	/*
	 * Method: multiplyMethod
	 * @param: Rational, Rational;
	 * @return: Rational
	 * 
	 * Multiplies two rationals. (Example: 5, 5 = 25;
	 */
	public Rational multiplyMethod(Rational one, Rational two) {
		return one.mul(two);
	}
	
	/*
	 * Method: addMethod
	 * @param: Rational, Rational;
	 * @return: Rational
	 * 
	 * Divides two rationals. (Example: 5, 5 = 1;
	 */
	public Rational divideMethod(Rational one, Rational two) {
		return one.div(two);
	}

	/*
	 * Method: getPattern
	 * @param: Base;
	 * @return: String
	 * 
	 * Detects the patern for given base, for example a hexadecimal base can contain 0-F whereas a binary base could only contain 0 and 1.
	 */
	public String getPattern(Base base) {
		String pattern = null;
		if (base.getName() == "hex") {
			pattern = "-?[0-9A-F]+";
		} else if (base.getName() == "oct") {
			pattern = "-?[0-7]+";
		} else if (base.getName() == "dec") {
			pattern = "-?[0-9]+";
		} else if (base.getName() == "bin") {
			pattern = "-?[0-1]+";
		}
		return pattern;
	}

	public String firstOperand() {
		return format.toString(operand_1, base);
	}

	public String secondOperand() {
		return format.toString(operand_0, base);
	}

	public void setBase(Base newBase) {
		base = newBase;
	}

	public Base getBase() {
		return base;
	}

	public void setFormat(Format newFormat) {
		format = newFormat;
	}

	public Format getFormat() {
		return format;
	}

	/*
	 * Method: clearStacks()
	 * Empties the operands and operators stacks.
	 */
	public void clearStacks(){
		operands.clear();
		operators.clear();
	}
	
	/*
	 * Method: parseStacks()
	 * @Return Rational 
	 * 
	 * This method parses both stacks until one Rational is left.
	 * It returns this rational as it's the final answer.
	 * 
	 */
	public Rational parseStacks() {

		while (this.operands.size() > 1 && this.operators.size() > 0) {
			String operator = this.operators.pop();
			Rational two = operands.pop();
			Rational one = operands.pop();
			
			if (operator == "-") {
				operands.push(substractMethod(one, two));
			} else if (operator == "+") {
				operands.push(addMethod(one, two));
			} else if (operator == "/") {
				operands.push(divideMethod(one, two));
			} else if (operator == "*") {
				operands.push(multiplyMethod(one, two));
			}
		}
		// one value on the stack right now, return this as final answer.
		return this.operands.pop();
	}

	// Adds operand to stack.
	// @param Rational
	public void addOperandToStack(Rational item) {
		this.operands.push(item);
	}

	// Adds operator to stack.
	// @param String
	public void addOperatorToStack(String item) {
		this.operators.push(item);
	}

	/*
	 * method createOperand
	 * @Param String
	 * @Return Rational
	 * This method creates a new rational based on the current base of the calculator.
	 */
	public Rational createOperand(String newOperand) throws FormatException {
		String pattern = getPattern(base);
		if (base.getName() == "hex") {
			pattern = "-?[0-9A-F.]+";
		} else if (base.getName() == "oct") {
			pattern = "-?[0-7.]+";
		} else if (base.getName() == "dec") {
			pattern = "-?[0-9.]+";
		} else if (base.getName() == "bin") {
			pattern = "-?[0-1.]+";
		}
		if (newOperand.matches(pattern)) {
			return format.parse(newOperand, base);
		} else {
			throw new FormatException("Does not match requirements.");
		}
	}
	// get stack for testing purposes.
	public Stack<Rational> getOperandStack(){
		return this.operands;
	}
	// get stack for testing purposes.
	public Stack<String> getOperatorStack(){
		return this.operators;
	}
	
	/*
	 * method: OperandToString
	 * @Param: Rational, Base
	 * @Return: String
	 * Turns an operand into a string.
	 */
	public String OperandToString(Rational number, Base base) {
		return format.toString(number, base);
	}
	
	// sets variable to a number, this allows a person to save one variable to the calculator.
	public void setVariable(String number){
		this.variable = number;
	}
	
	// inserts the saved variable into the textarea of the GUI.
	public String getVariable(){
		return variable;
	}
	
	// increases amount of calculations by 1.
	public void incrementCalculations(){
		calculations++;
	}
	
	// returns the amount of calculations
	public int getCalculations(){
		return calculations;
	}
	
}
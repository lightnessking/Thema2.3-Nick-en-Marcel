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

	// new methods
	public Rational addMethod(Rational one, Rational two) {
		return one.plus(two);
	}

	public Rational substractMethod(Rational one, Rational two) {
		return one.minus(two);
	}

	public Rational multiplyMethod(Rational one, Rational two) {
		return one.mul(two);
	}

	public Rational divideMethod(Rational one, Rational two) {
		return one.div(two);
	}

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

	public void clearStacks(){
		operands.clear();
		operators.clear();
	}
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

	public void addOperandToStack(Rational item) {
		this.operands.push(item);
	}

	public void addOperatorToStack(String item) {
		this.operators.push(item);
	}

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
	// get stacks for testing purposes.
	public Stack<Rational> getOperandStack(){
		return this.operands;
	}
	
	public Stack<String> getOperatorStack(){
		return this.operators;
	}
	
	public String OperandToString(Rational number, Base base) {
		return format.toString(number, base);
	}
	
	public void setVariable(String number){
		this.variable = number;
	}
	
	public String getVariable(){
		return variable;
	}
	
	public void incrementCalculations(){
		calculations++;
	}
	
	public int getCalculations(){
		return calculations;
	}
	
}
package test;

import static org.junit.Assert.*;

import multiformat.Calculator;
import multiformat.DecimalBase;
import multiformat.FormatException;
import multiformat.OctalBase;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

/**
 * JUnit Testcase to test Rational. 
 * Note that this class uses 'annotations' (the @...). This is a Java 1.5 feature. 
 * @author gebruiker
 *
 */
public class TestOctalBase extends TestCase {
	OctalBase o;
	
	public TestOctalBase(String args){
		super(args);
		setUp();
		testDecimalToOctal();
	}
	
	@Before
	public void setUp(){
		o = new OctalBase();
	}
	
	@Test
	public void testDecimalToOctal(){
		
		Calculator calc = new Calculator();
		
		try{
		calc.addOperand("12.0");
		calc.setBase(new OctalBase());
		assertEquals("0.0",calc.firstOperand());
		assertEquals("14.0",calc.secondOperand());

		calc.setBase(new DecimalBase());
		calc.addOperand("18.0");
		calc.setBase(new OctalBase());
		assertEquals("14.0",calc.firstOperand());
		assertEquals("22.0",calc.secondOperand());
		
		calc.add();
		assertEquals("0.0",calc.firstOperand());
		assertEquals("36.0",calc.secondOperand());
		}catch(FormatException e){
			fail("Unexpected format exception");
		}
	}
}

package es.uniovi.asw;

/**
 * Simplest calculator class
 * @author labra
 *
 */
public class Calculator {

	public Integer add(final Integer x, final Integer y) {
		return x + y;
	}
	
	public Integer substract(final Integer x, final Integer y) {
		return x - y;
	}

	public Integer multiply(final Integer x, final Integer y) {
		return x * y;
	}
	
	public Integer divide(final Integer x, final Integer y) {
		if(y == 0) throw new IllegalArgumentException("Division by zero not allowed");
		return x / y;
	}
	
}

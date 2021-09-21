package szamologepszervlet.model;

public class Szamologep {
	public Double calculate(Double a, Double b, String operator) {
		if ("+".equals(operator)) {
			return a + b;
		} else if ("-".equals(operator)) {
			return a - b;
		} else 	if ("*".equals(operator)) {
			return a * b;
		} else 	if ("/".equals(operator)) {
			return a / b;
		} else throw new NotSupportedOperationException();
	}
}

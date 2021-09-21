package szamologepszervlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import szamologepszervlet.model.Szamologep;

@WebServlet("/szamologep.do")
public class SzamologepServlet extends HttpServlet{

	private Double checkAndGetValueAsDouble(HttpServletRequest req, String parameterName, List<String> errorList) {
		Double value = 0.0;
		String stringValue = req.getParameter(parameterName);
		if (stringValue == null) {
			errorList.add("a(z) " + parameterName + " parameter nem lehet lehet ures");
		} else {
			try {
				value = Double.parseDouble(stringValue);
			} catch (NumberFormatException ex) {
				errorList.add("a(z) " + parameterName + " parameter szam kell legyen");
			}
		}
		
		return value;
	}
	
	
	private void checkOperator(String operator, List<String> errorList) {
		
		if (operator == null) {
			errorList.add("az operator parameter nem lehet ures");
		} else {
			if (!Arrays.asList(new String[]{"+", "-", "*", "/"}).contains(operator)) {
				errorList.add("nem tamogatott muvelet");
			}
		} 
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ResultDto resultDto = new ResultDto();
		List<String> errorList = new ArrayList<String>();
		
		Double a = checkAndGetValueAsDouble(req, "a", errorList);
		resultDto.setA(req.getParameter("a"));
		
		Double b = checkAndGetValueAsDouble(req, "b", errorList);
		resultDto.setB(req.getParameter("b"));
		
		String operator = req.getParameter("operator");
		resultDto.setOperator(operator);

		checkOperator(operator, errorList);
		
		
		Double result = 0.0;
		if (errorList.isEmpty()) {
			result = new Szamologep().calculate(a, b, operator);
		}
		
		resultDto.setResult(result);
		resultDto.setErrorList(errorList);
		// eltarolja a keres attributumba az osszes infot, 
		// hogy a jsp is elerje
		req.setAttribute("result", resultDto);
		
		// forward
		RequestDispatcher rd = req.getSession()
				.getServletContext( )
				.getRequestDispatcher("/");
		
		rd.forward(req, resp);
	}

}

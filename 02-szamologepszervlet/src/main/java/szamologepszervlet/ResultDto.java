package szamologepszervlet;

import java.util.List;

public class ResultDto {
	private String a;
	private String b;
	private String operator;
	private List<String> errorList;
	private boolean error;
	private Double result;
	
	
	public String getA() {
		return (a != null) ? a : "";
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return (b != null) ? b : "";
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public List<String> getErrorList() {
		return errorList;
	}
	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	
	public Double getResult() {
		return result;
	}
	public void setResult(Double result) {
		this.result = result;
	}
	
	
	
}

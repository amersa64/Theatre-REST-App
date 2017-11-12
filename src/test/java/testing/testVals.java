package testing;


public class testVals {

	private String val1;
	private String val2;
	private testVals val3;
	
	public testVals(){
		this.val1 = "Value 1";
		this.val2 = "Value 2";
		val3 = new testVals("Value 3");
	}
	
	public testVals(String valnew){
		this.val1 = valnew;
		this.val2 = valnew;
	}

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public String getVal2() {
		return val2;
	}

	public void setVal2(String val2) {
		this.val2 = val2;
	}
	
	

	public testVals getVal3() {
		return val3;
	}

	public void setVal3(testVals val3) {
		this.val3 = val3;
	}

	@Override
	public String toString() {
		return "testVals [val1=" + val1 + ", val2=" + val2 + ", val3=" + val3 + "]";
	}

	

	
	
}
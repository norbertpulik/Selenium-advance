package enumeratios;

public enum SinType {

	MURDER("murder"), HIJACK("hijack"), BLACKMAIL("blackmail"), CAR_ACCIDENT("car accident"), ROBBERY("robbery");

	private String xpathValue;

	public String getXpathValue() {
		return xpathValue;
	}

	public void setXpathValue(String xpathValue) {
		this.xpathValue = xpathValue;
	}

	SinType(String xpathValue) {
		this.xpathValue = xpathValue;

	}
}

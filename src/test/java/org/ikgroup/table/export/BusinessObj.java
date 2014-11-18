package org.ikgroup.table.export;

import java.math.BigDecimal;

public class BusinessObj {
	
	private int intValue;
	
	private String strValue;
	
	private BigDecimal floatValue;

	public BusinessObj(int intValue, String strValue, BigDecimal floatValue) {
		this.intValue = intValue;
		this.strValue = strValue;
		this.floatValue = floatValue;
	}

	@Export(label="INT VALUE", order = 1, transformer="demoTransformer")
	public int getIntValue() {
		return intValue;
	}

	public void setIntValue(int intValue) {
		this.intValue = intValue;
	}

	@Export(label="STR VALUE", order = 0)
	public String getStrValue() {
		return strValue;
	}

	public void setStrValue(String strValue) {
		this.strValue = strValue;
	}

	@Export(label="FLOAT VALUE", order = 2)
	public BigDecimal getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(BigDecimal floatValue) {
		this.floatValue = floatValue;
	}
	
}

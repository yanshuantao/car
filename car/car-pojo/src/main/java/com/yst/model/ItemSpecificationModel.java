package com.yst.model;

import com.yst.pojo.ItemSpecification;

public class ItemSpecificationModel extends ItemSpecification{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6147040134043351792L;
	
	private String fixPriceStr;

    private String nowPriceStr;
    
    private String displacementStr;
    
    private String energyStr;
    
    private String seatNumberStr;
    
    private String stockStr;
    

	public String getFixPriceStr() {
		return fixPriceStr;
	}

	public void setFixPriceStr(String fixPriceStr) {
		this.fixPriceStr = fixPriceStr;
	}

	public String getNowPriceStr() {
		return nowPriceStr;
	}

	public void setNowPriceStr(String nowPriceStr) {
		this.nowPriceStr = nowPriceStr;
	}

	public String getDisplacementStr() {
		return displacementStr;
	}

	public void setDisplacementStr(String displacementStr) {
		this.displacementStr = displacementStr;
	}

	public String getEnergyStr() {
		return energyStr;
	}

	public void setEnergyStr(String energyStr) {
		this.energyStr = energyStr;
	}

	public String getSeatNumberStr() {
		return seatNumberStr;
	}

	public void setSeatNumberStr(String seatNumberStr) {
		this.seatNumberStr = seatNumberStr;
	}

	public String getStockStr() {
		return stockStr;
	}

	public void setStockStr(String stockStr) {
		this.stockStr = stockStr;
	}

    
}

package com.yst.pojo;

import java.io.Serializable;

public class ItemDesc  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7550307726722373096L;

	private Integer itemId;

    private String itemDescription;

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription == null ? null : itemDescription.trim();
    }
}
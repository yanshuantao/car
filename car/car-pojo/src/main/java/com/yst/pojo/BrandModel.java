package com.yst.pojo;

import java.io.Serializable;

public class BrandModel  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8080587056202052211L;

	private Integer id;

    private Integer brandId;

    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}
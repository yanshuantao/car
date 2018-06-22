package com.yst.pojo;

import java.io.Serializable;

public class Brand  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8918835325705438127L;

	private Integer id;

    private String name;

    private String country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }
}
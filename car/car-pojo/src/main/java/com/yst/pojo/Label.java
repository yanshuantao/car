package com.yst.pojo;

import java.io.Serializable;

public class Label implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1866082316783069097L;

	private Integer id;

    private String name;

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
}
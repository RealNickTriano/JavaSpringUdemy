package com.in28minutes.rest.webservices.restfulwepservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

// ignore field at class level
//@JsonIgnoreProperties("field1")
// for dynamic filtering in controller
@JsonFilter("SomeBeanFilter")
public class SomeBean {

	private String field1;
	
	// ignore field in response
	//@JsonIgnore
	private String field2;
	private String field3;

	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public String getField2() {
		return field2;
	}

	public String getField3() {
		return field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}

}

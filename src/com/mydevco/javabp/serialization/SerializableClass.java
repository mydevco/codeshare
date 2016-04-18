package com.mydevco.javabp.serialization;

import java.io.Serializable;
import java.util.UUID;

public class SerializableClass implements Serializable{
	
	private static final long serialVersionUID = -3794339634847926614L;
	
	private String id = UUID.randomUUID().toString();
	private String genericName;

	public SerializableClass(String genericName) {
		super();
		this.genericName = genericName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	@Override
	public String toString() {
		return "SerializableClass [id=" + id + ", genericName=" + genericName
				+ "]";
	}
	

}

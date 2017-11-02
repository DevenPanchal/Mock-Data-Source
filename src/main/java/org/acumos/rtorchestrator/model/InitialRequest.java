package org.acumos.rtorchestrator.model;

import java.io.Serializable;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class InitialRequest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1912423544959147490L;

	@JsonProperty("operation")
	private String operation = null;
	
	@JsonProperty("binarydata")
	private byte[] binarydata = null;
	
	
	public InitialRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getOperation() {
		return operation;
	}
	
	public void setOperation(String operation) {
		this.operation = operation;
	}
	
	public byte[] getBinarydata() {
		return binarydata;
	}
	
	public void setBinarydata(byte[] binarydata) {
		this.binarydata = binarydata;
	}

	@Override
	public String toString() {
		return "InitialRequest [operation=" + operation + ", binarydata=" + Arrays.toString(binarydata) + "]";
	}
	
	
}

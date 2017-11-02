package org.acumos.rtorchestrator.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OperationSignature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8176878378145971860L;
	
	public OperationSignature() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public OperationSignature(String returnType, String operation, String inputType) {
		super();
		this.returnType = returnType;
		this.operation = operation;
		this.inputType = inputType;
	}


	@JsonProperty("return_type")
	private String returnType = null;
	
	@JsonProperty("operation")
	private String operation = null;
	
	@JsonProperty("input_type") 
	private String inputType = null;

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getInputType() {
		return inputType;
	}

	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	@Override
	public String toString() {
		return "OperationSignature [returnType=" + returnType + ", operation=" + operation + ", inputType=" + inputType
				+ "]";
	}
	
	
	
}

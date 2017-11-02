package org.acumos.rtorchestrator.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Component implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5749775315078650369L;

	
	public Component() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Component(String name, List<OperationSignature> operationSignatures) {
		super();
		this.name = name;
		this.operationSignatures = operationSignatures;
	}


	@JsonProperty("name")
	private String name = null;

	@JsonProperty("operation_signature")
	private List<OperationSignature> operationSignatures = null;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<OperationSignature> getOperationSignatures() {
		return operationSignatures;
	}

	public void setOperationSignatures(List<OperationSignature> operationSignatures) {
		this.operationSignatures = operationSignatures;
	}

	@Override
	public String toString() {
		return "Component [name=" + name + ", operationSignatures=" + operationSignatures + "]";
	}

	
}

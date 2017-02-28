package com.hibernate.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Message_retour")
@XmlType(propOrder= {"result", "message", "id"})
public class ResultMsg {

	private int id;
	private String result;
	private String message;
	
	public ResultMsg() {
		}

	public ResultMsg(int id, String result, String message) {
		super();
		this.id = id;
		this.result = result;
		this.message = message;
	}
	
	@XmlElement(name = "Id_insere")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@XmlElement(name = "message")
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@XmlElement(name = "description")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

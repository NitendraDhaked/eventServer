package com.eventserver.response;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Component;

import com.eventserver.model.Deal;

@Component
public class EventServerResponse {
	
	private String message;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public List<Deal> getResult() {
		return result;
	}
	public void setResult(List<Deal> result) {
		this.result = result;
	}
	private boolean success = false;
	private List<Deal> result = null;
}

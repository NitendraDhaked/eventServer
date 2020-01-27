package com.eventserver.model;

import org.springframework.stereotype.Component;

@Component
public class Deal {
	
	
	public int getDealId() {
		return dealId;
	}
	public void setDealId(int dealId) {
		this.dealId = dealId;
	}
	public String getPeril() {
		return peril;
	}
	public void setPeril(String peril) {
		this.peril = peril;
	}
	public String getZone() {
		return zone;
	}
	public void setZone(String zone) {
		this.zone = zone;
	}
	public int getMaxLoss() {
		return maxLoss;
	}
	public void setMaxLoss(int maxLoss) {
		this.maxLoss = maxLoss;
	}
	int dealId;
	String peril;
	String zone;
	int maxLoss;
}

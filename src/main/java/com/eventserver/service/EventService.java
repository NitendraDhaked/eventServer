package com.eventserver.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eventserver.model.Data1;
import com.eventserver.model.Deal;
import com.eventserver.response.EventServerResponse;

@Service
public class EventService {


	
	@Autowired
	Deal deal;
	
	@Autowired
	Data1 data;
	
	@Autowired
	EventServerResponse evntSrvrResp;
	
	public EventServerResponse calculate(Integer eventId) {
		
		List <Deal> dealLoss = new ArrayList();
		HashMap <Integer, String> perilMap = new HashMap();
		perilMap.put(1, "hurricane");
		perilMap.put(2, "earthquake");
		perilMap.put(3, "flood");
		
		HashMap <Integer, String> zoneMap = new HashMap();
		
		zoneMap.put(1, "California");
		zoneMap.put(2, "Louisiana");
		zoneMap.put(3, "florida");
		int [][] events = data.getEvents();
		
		int id = eventId;
		if(eventId>4 || eventId<=0) {
			
			evntSrvrResp.setMessage("No deals available for this event");
			evntSrvrResp.setSuccess(false);
			evntSrvrResp.setResult(dealLoss);
			return evntSrvrResp;
		}
		
		int maxLoss = Integer.MIN_VALUE;
		if(zoneMap.get(1).equals(zoneMap.get(events[id-1][2])) && perilMap.get(2).equals(perilMap.get(events[id-1][1])) ) {
			
			int deal1Ret=100;
			int deal1MaxLoss = 500;
			maxLoss = deal1MaxLoss < events[id-1][3]-deal1Ret ? deal1MaxLoss : events[id-1][3]-deal1Ret;
			deal.setDealId(1);
			deal.setPeril(perilMap.get(events[id-1][1]));
			deal.setZone(zoneMap.get(events[id-1][2]));
			deal.setMaxLoss(maxLoss);
			dealLoss.add(deal);
		} if(zoneMap.get(3).equals(zoneMap.get(events[id-1][2])) && perilMap.get(1).equals(perilMap.get(events[id-1][1])) ) {
			
			deal = new Deal();
			int deal2Ret=1000;
			int deal2MaxLoss = 3000;	 
			maxLoss = deal2MaxLoss < events[id-1][3]-deal2Ret ? deal2MaxLoss : events[id-1][3]-deal2Ret;
			deal.setDealId(2);
			deal.setPeril(perilMap.get(events[id-1][1]));
			deal.setZone(zoneMap.get(events[id-1][2]));
			deal.setMaxLoss(maxLoss);
			dealLoss.add(deal);
		} 
		if(zoneMap.get(3).equals(zoneMap.get(events[id-1][2])) || 
				zoneMap.get(2).equals(zoneMap.get(events[id-1][2])) &&
				perilMap.get(1).equals(perilMap.get(events[id-1][1])) || 
				perilMap.get(3).equals(perilMap.get(events[id-1][1]))) {		
			deal = new Deal();
			int deal3Ret=250;
			int deal3MaxLoss = 250;	 
			maxLoss = deal3MaxLoss < events[id-1][3]-deal3Ret ? deal3MaxLoss : events[id-1][3]-deal3Ret;
			deal.setDealId(3);
			deal.setPeril(perilMap.get(events[id-1][1]));
			deal.setZone(zoneMap.get(events[id-1][2]));
			deal.setMaxLoss(maxLoss);
			dealLoss.add(deal);
		}
		
		evntSrvrResp.setMessage("Deals and reinsurance company loss is added");
		evntSrvrResp.setSuccess(true);
		evntSrvrResp.setResult(dealLoss);
		
		return evntSrvrResp;
	}

	
}

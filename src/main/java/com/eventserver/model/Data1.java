package com.eventserver.model;

import org.springframework.stereotype.Component;

@Component
public class Data1 {
	
	public static int [][] events = new int [][] {
		{1,2,1,1000},
		{2,3,2,500},
		{3,3,3,750},
		{4,1,3,2000}		
	};
	
	public static int[][] getEvents(){
		return events;
	}

}

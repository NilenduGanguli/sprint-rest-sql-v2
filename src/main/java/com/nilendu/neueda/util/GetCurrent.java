/**
 * 
 */
package com.nilendu.neueda.util;

import java.util.*;

/**
 * @author nilen
 *
 */
public class GetCurrent {
	
	
	public static double cashValue(String currency) {
		
		Map<String,Double> cashDict = new HashMap<>();
		cashDict.put("eur",0.9791);
		cashDict.put("gbp",0.8278);
		cashDict.put("jpy",134.99);
		cashDict.put("inr",79.53);
		cashDict.put("cny",6.76);
		cashDict.put("usd",1.0);
		
		return cashDict.get(currency.toLowerCase());
	}
	
	public static double stocksValue(String company) {
		
		Map<String,Double> stockDict = new HashMap<>();
		stockDict.put("aapl",164.92);
		stockDict.put("abnb",114.44);
		stockDict.put("amzn",137.83);
		stockDict.put("intc",34.52);
		stockDict.put("googl",116.63);
		
		return stockDict.get(company.toLowerCase());
	}
	
	public static double cryptoValue(String coin) {
		
		Map<String,Double> cryptDict = new HashMap<>();
		cryptDict.put("btc",22943.0);
		cryptDict.put("eth",1678.0);
		cryptDict.put("usdt",1.0);
		cryptDict.put("doge",0.0681);
		cryptDict.put("ltc",58.62);
		
		return cryptDict.get(coin.toLowerCase());
	}

}

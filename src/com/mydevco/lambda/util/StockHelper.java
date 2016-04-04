/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mydevco.lambda.util;

    
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.mydevco.lambda.model.Stock;

/**
 *
 * @author gkmek_000
 */
public class StockHelper {

    private static final Log Log = LogFactory.getLog(StockHelper.class);
    private static final StockHelper stockHelper = new StockHelper();
    private static HashMap<String, Stock> stocks = new HashMap<>();
    private static final long TWENTY_MIN = 1200000;
 
    private StockHelper() {}
 
    public static StockHelper getInstance() {
        return stockHelper;
    }
 
    /**
     *
     * @param symbol
     * @return StockBean
     * will return null if unable to retrieve information
     */
    public Stock getStockPrice(String symbol) {
        Stock stock;
        long currentTime = (new Date()).getTime();
        // Check last updated and only pull stock on average every 20 minutes
        if (stocks.containsKey(symbol)) {
            stock = stocks.get(symbol);
            if(currentTime - stock.getLastUpdated() > TWENTY_MIN) {
                stock = refreshStockInfo(symbol, currentTime);
            }
        } else {
            stock = refreshStockInfo(symbol, currentTime);
        }
        return stock;
    }
 
    //This is synched so we only do one request at a time
    //If yahoo doesn't return stock info we will try to return it from the map in memory
    private synchronized Stock refreshStockInfo(String symbol, long time) {
        URLConnection yc  = null;
        BufferedReader in = null;
        URL yahoofin = null;
        try {
            yahoofin = new URL("http://finance.yahoo.com/d/quotes.csv?s=" + symbol + "&f=sl1d1t1c1ohgvx0n&e=.csv");
            yc = yahoofin.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                String[] yahooStockInfo = inputLine.split(",");
                Stock stockInfo = new Stock();
                stockInfo.setTicker(yahooStockInfo[0].replaceAll("\"", ""));
                stockInfo.setPrice(Float.valueOf(yahooStockInfo[1]));
                stockInfo.setChange(Float.valueOf(yahooStockInfo[4]));
                stockInfo.setLastUpdated(time);
                stockInfo.setExchange(yahooStockInfo[9]);
                stockInfo.setName(yahooStockInfo[10]);
                stocks.put(symbol, stockInfo);
                break;
            }
        } catch (Exception ex) {
            Log.error("Unable to get stockinfo for: " + symbol + ex);
        } finally {
                 if(null!=in) {
                     try {
                         in.close();
                     } catch (IOException ex) {
                         Log.error(ex);
                     }
                 }
        }
        return stocks.get(symbol);
     }
    
    public List<Stock> getAllStocks() {
        return new ArrayList<>(stocks.values());
    }
}
    

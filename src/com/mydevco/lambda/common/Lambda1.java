package com.mydevco.lambda.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.mydevco.lambda.model.Stock;
import com.mydevco.lambda.util.StockHelper;

//Multiple examples on Lambda

public class Lambda1 {

    public static Predicate<Stock> isGreater(double val) {
        return p -> p.getPrice() > val;
    }

    public static Predicate<Stock> isLower(double val) {
        return p -> p.getPrice() < val;
    }

    public static List<Stock> filterStocks(List<Stock> stocks, Predicate<Stock> predicate) {
        return stocks.stream().filter(predicate).collect(Collectors.<Stock>toList());
    }

    public static void main(String[] args) {
        FunctionalInterface1 fi;

        fi = () -> Math.random() * 500;

        System.out.println("\n\nValue = " + fi.getLongValue());

        //fi = () -> "Lambda 8"; //incompitable type error
        String symbols[] = {"GOOG", "AAPL", "MSFT", "SAPE", "AKAM", "ACOR", "ACFN", "ACTS", "ACPW", "BSTC", "BSPM", "BOTA", "AAN", "ABB", "ABT", "ABBV", "ANF", "GCH", "LPL", "USA", "ASG", "YELP", "ADT", "ATT", "BP", "BT", "K", "G"
        };

        List<String> tickers = Arrays.asList(symbols);

        //get stock prices
        tickers.forEach(t -> StockHelper.getInstance().getStockPrice(t));

        System.out.println("\n\nStocks with price greater than $50>>>>>>>>>>>>");
        filterStocks(StockHelper.getInstance().getAllStocks(), isGreater(50)).forEach(p -> System.out.println(p.toString()));

        System.out.println("\n\nStocks with price less than $30<<<<<<<<<<<<<<<");
        filterStocks(StockHelper.getInstance().getAllStocks(), isLower(30)).forEach(p -> System.out.println(p.toString()));

        List<Stock> allStocks = StockHelper.getInstance().getAllStocks();

        allStocks.sort(Comparator.comparing((stock) -> stock.getTicker()));

        System.out.println("\n\nStocks sorted with ticker name<<<<<<<<<<<<<<<");
        allStocks.forEach(p -> System.out.println(p.toString()));
        //OR
        //StockHelper.getInstance().getAllStocks().sort(Comparator.comparing(Stock::getTicker)); //"::" is method reference operator
        
        //comparator can be chained and run in parallel
        List<Stock> newStocks = StockHelper.getInstance().getAllStocks();
        
        //Sorting on multiple fields; Group by.
        Comparator<Stock> multiLevelComparator = Comparator.comparing(Stock::getExchange)
                                                    .thenComparing(Stock::getPrice);

        //Parallel Sorting (only Arrays has parallelSort, not Collections most likely because
        //Collections would not know about underlying storage of List and could lead to inefficient duplicate copies of list
        Stock[] stockArray = newStocks.toArray(new Stock[newStocks.size()]);
 
        //Parallel sorting
        Arrays.parallelSort(stockArray, multiLevelComparator);
 
        System.out.println("\n\nStocks sorted parallel with exchange and price<<<<<<<<<<<<<<<");
        for(Stock st: stockArray) {
            System.out.println(st.toString());
        }
    }

}

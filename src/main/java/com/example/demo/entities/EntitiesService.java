package com.example.demo.entities;

import com.opencsv.CSVWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class EntitiesService {

    private final EntitiesRepository entitiesRepository;

    @Autowired
    public EntitiesService(EntitiesRepository entitiesRepository) {
        this.entitiesRepository = entitiesRepository;
    }

    public String getDailyOrders() throws IOException {
        List<DailyOrder> dailyOrders = entitiesRepository.dailyOrders();
        CSVWriter writer = new CSVWriter(new FileWriter(System.getProperty("java.io.tmpdir")+"daily_orders.csv"),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String[] header = {"TraderCode", "TraderName", "OrderID", "Ticker", "Qty", "AVGPrice"};
        writer.writeNext(header);
        for (DailyOrder dailyOrder:
             dailyOrders) {
            writer.writeNext(dailyOrder.returnStringList());
        }
        writer.close();
        return System.getProperty("java.io.tmpdir")+"daily_orders.csv";

    }

    public List<TradersData> financialByTrader() {
        return entitiesRepository.tradersData();
    }

}

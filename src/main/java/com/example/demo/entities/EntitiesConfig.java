package com.example.demo.entities;

import org.springframework.context.annotation.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Configuration
public class EntitiesConfig {

    @Bean(name = "entities-config")
    CommandLineRunner commandLineRunner(TraderRepository traderRepository,
                                        OrderRepository orderRepository,
                                        TradeRepository tradeRepository) {
        return args -> {

            Trade t1 = new Trade(Timestamp.valueOf("2022-01-01 13:00:00"), 200, BigDecimal.valueOf(1.99));
            Trade t2 = new Trade(Timestamp.valueOf("2022-01-01 14:00:00"), 300, BigDecimal.valueOf(2.99));
            Trade t3 = new Trade(Timestamp.valueOf("2022-01-01 15:00:00"), 400, BigDecimal.valueOf(4.99));
            Trade t4 = new Trade(Timestamp.valueOf("2022-01-01 16:00:00"), 500, BigDecimal.valueOf(8.99));

            Order o1 = new Order("PETR4");
            o1.addTrade(t1);
            o1.addTrade(t2);
            Order o2 = new Order("ITUB4");
            o2.addTrade(t3);
            Order o3 = new Order("ITUB4");
            o3.addTrade(t4);

            Trader jdo = new Trader("JDO", "John Doe");
            jdo.addOrder(o1);
            jdo.addOrder(o3);
            Trader jsm = new Trader("JSM", "John Smith");
            jsm.addOrder(o2);

            traderRepository.saveAll(List.of(jdo, jsm));
            orderRepository.saveAll(List.of(o1, o2, o3));
            tradeRepository.saveAll(List.of(t1, t2, t3, t4));

        };
    }

}

package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EntitiesRepository {

    private final EntityManager em;

    @Autowired
    public EntitiesRepository(EntityManager em) {
        this.em = em;
    }

    public List<DailyOrder> dailyOrders() {
        String sql = "SELECT code, NAME, oid, ticker, total_qt, avg_price FROM (select oid, ticker, total_qt, avg_price, trader_id from (select order_id AS oid, sum(price*quantity)/sum(quantity) as avg_price, SUM(quantity) AS total_qt FROM trades GROUP BY order_id) join orders o on oid = o.id) R JOIN traders T ON R.trader_id = T.id";
        Query query = em.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        List<DailyOrder> result = new ArrayList<>();
        for (Object[] q1 : list) {
            String code = q1[0].toString();
            String name = q1[1].toString();
            Long oid = Long.parseLong(q1[2].toString());
            String ticker = q1[3].toString();
            Integer total_qt = Integer.parseInt(q1[4].toString());
            BigDecimal avg_price = new BigDecimal(q1[5].toString());
            DailyOrder dailyorder = new DailyOrder(code, name, oid, ticker, total_qt, avg_price);
            result.add(dailyorder);
        }
        return result;
    }

    public List<TradersData> tradersData() {
        String sql = "select CODE, SUM(PRICE*QUANTITY) from traders JOIN ORDERS O on traders.ID = O.TRADER_ID JOIN trades T on O.ID = T.ORDER_ID GROUP BY CODE";
        Query query = em.createNativeQuery(sql);
        List<Object[]> list = query.getResultList();
        List<TradersData> result = new ArrayList<>();
        for (Object[] q1 : list) {
            String code = q1[0].toString();
            BigDecimal total_value = new BigDecimal(q1[1].toString());
            TradersData tradersData = new TradersData(code, total_value);
            result.add(tradersData);
        }
        return result;
    }


}

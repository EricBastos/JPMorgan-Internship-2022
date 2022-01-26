package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String Ticker;

    @ManyToOne(fetch = FetchType.LAZY)
    private Trader trader;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Trade> trades = new ArrayList<>();

    public Order() {

    }

    public Order(String ticker) {
        Ticker = ticker;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", Ticker='" + Ticker + '\'' +
                ", trader=" + trader +
                '}';
    }

    public void addTrade(Trade trade) {
        trades.add(trade);
        trade.setOrder(this);
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public Trader getTrader() {
        return trader;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public Long getId() {
        return id;
    }

    public String getTicker() {
        return Ticker;
    }
}

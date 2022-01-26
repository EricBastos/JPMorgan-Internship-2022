package com.example.demo.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name="trades")
public class Trade {

    @Id
    @SequenceGenerator(
            name = "trade_sequence",
            sequenceName = "trade_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trade_sequence"
    )
    private Long id;

    private Timestamp Timestamp;
    private Integer Quantity;
    private BigDecimal Price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Order order;

    public Trade() {

    }

    public Trade(Timestamp timestap, Integer quantity, BigDecimal price) {
        Timestamp = timestap;
        Quantity = quantity;
        Price = price;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", Timestamp=" + Timestamp +
                ", Price=" + Price +
                ", order=" + order +
                '}';
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public BigDecimal getPrice() {
        return Price;
    }
}

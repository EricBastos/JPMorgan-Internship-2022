package com.example.demo.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "traders")
public class Trader {
    @Id
    @SequenceGenerator(
            name = "trader_sequence",
            sequenceName = "trader_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trader_sequence"
    )
    @Column(name = "id")
    private Long id;
    private String Code;
    private String Name;

    @OneToMany(mappedBy = "trader", cascade = CascadeType.ALL, orphanRemoval = true)
    private final List<Order> orders = new ArrayList<>();

    public Trader() {

    }

    public Trader(String code, String name) {
        Code = code;
        Name = name;
    }

    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", Code='" + Code + '\'' +
                ", Name='" + Name + '\'' +
                '}';
    }

    public void addOrder(Order order) {
        orders.add(order);
        order.setTrader(this);
    }

    public String getCode() {
        return Code;
    }

    public String getName() {
        return Name;
    }
}

package com.example.demo.entities;

import java.math.BigDecimal;

public class TradersData {
    private String TraderCode;
    private BigDecimal TotalValue;

    public TradersData() {
    }

    public TradersData(String traderCode, BigDecimal totalValue) {
        TraderCode = traderCode;
        TotalValue = totalValue;
    }

    public String getTraderCode() {
        return TraderCode;
    }

    public void setTraderCode(String traderCode) {
        TraderCode = traderCode;
    }

    public BigDecimal getTotalValue() {
        return TotalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        TotalValue = totalValue;
    }

    @Override
    public String toString() {
        return "TradersData{" +
                "TraderCode='" + TraderCode + '\'' +
                ", TotalValue=" + TotalValue +
                '}';
    }
}

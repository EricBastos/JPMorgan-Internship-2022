package com.example.demo.entities;

import java.math.BigDecimal;

public class DailyOrder {
    private String TraderCode;
    private String TraderName;
    private Long OrderId;
    private String OrderTicker;
    private Integer TotalQuantity;
    private BigDecimal AveragePrice;

    public DailyOrder(String traderCode, String traderName, Long orderId, String orderTicker, Integer totalQuantity, BigDecimal averagePrice) {
        TraderCode = traderCode;
        TraderName = traderName;
        OrderId = orderId;
        OrderTicker = orderTicker;
        TotalQuantity = totalQuantity;
        AveragePrice = averagePrice;
    }

    @Override
    public String toString() {
        return "DailyOrder{" +
                "TraderCode='" + TraderCode + '\'' +
                ", TraderName='" + TraderName + '\'' +
                ", OrderId=" + OrderId +
                ", OrderTicker='" + OrderTicker + '\'' +
                ", TotalQuantity=" + TotalQuantity +
                ", AveragePrice=" + AveragePrice +
                '}';
    }

    public String[] returnStringList() {
        return new String[]{TraderCode, TraderName, OrderId.toString(),
                OrderTicker, TotalQuantity.toString(), AveragePrice.toString()};
    }

    public String getTraderCode() {
        return TraderCode;
    }

    public void setTraderCode(String traderCode) {
        TraderCode = traderCode;
    }

    public String getTraderName() {
        return TraderName;
    }

    public void setTraderName(String traderName) {
        TraderName = traderName;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    public String getOrderTicker() {
        return OrderTicker;
    }

    public void setOrderTicker(String orderTicker) {
        OrderTicker = orderTicker;
    }

    public Integer getTotalQuantity() {
        return TotalQuantity;
    }

    public void setTotalQuantity(Integer totalQuantity) {
        TotalQuantity = totalQuantity;
    }

    public BigDecimal getAveragePrice() {
        return AveragePrice;
    }

    public void setAveragePrice(BigDecimal averagePrice) {
        AveragePrice = averagePrice;
    }
}

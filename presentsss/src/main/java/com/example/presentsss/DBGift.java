package com.example.presentsss;

import java.sql.ResultSet;
import java.sql.SQLException;


public class DBGift {
    private String name;
    private double cost;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public void readGift(ResultSet resultSet) throws SQLException {
        String productName = resultSet.getString("productName");
        double productCost = resultSet.getDouble("productCost");
        setName(productName);
        setCost(productCost);
    }


}
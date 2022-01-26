package com.example.demo.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping()
public class EntitiesController {

    private final EntitiesService entitiesService;

    @Autowired
    public EntitiesController(EntitiesService entitiesService) {
        this.entitiesService = entitiesService;
    }

    @GetMapping(path="CreateNewFile")
    public String createNewFile() throws IOException {
        return entitiesService.getDailyOrders();
    }

    @GetMapping(path="financialByTrader")
    public List<TradersData> financialByTrader() {
        return entitiesService.financialByTrader();
    }

}

package com.barclays.programmingassessment.controllers;


import com.barclays.programmingassessment.entities.TradeStore;
import com.barclays.programmingassessment.services.TradeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TradeStoreController {

    @Autowired
    TradeStoreService tradeStoreService;

    @GetMapping("trade-store")
    public List<TradeStore> getAllTrades(){
        return tradeStoreService.getAllTradeStore();
    }

    @PostMapping("trade-store")
    public TradeStore saveTrade(@RequestBody TradeStore tradeStore)throws Exception{
        return tradeStoreService.saveTradeStore(tradeStore);
    }
}

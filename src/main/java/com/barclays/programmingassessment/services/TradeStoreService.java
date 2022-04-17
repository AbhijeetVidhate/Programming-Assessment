package com.barclays.programmingassessment.services;

import com.barclays.programmingassessment.entities.TradeStore;
import com.barclays.programmingassessment.exceptions.MinorVersionException;
import com.barclays.programmingassessment.repositories.TradeStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TradeStoreService {

    @Autowired
    TradeStoreRepository tradeStoreRepository;

    public List<TradeStore> getAllTradeStore(){
        List<TradeStore> allTradeStore = new ArrayList<>();
            tradeStoreRepository.findAll().forEach(allTradeStore::add);
        return allTradeStore;
    }


    public TradeStore saveTradeStore(TradeStore tradeStore)throws Exception{

        if(tradeStore == null)
            throw new NullPointerException("Trade should not empty");



        Integer version = tradeStoreRepository.findMaxVersionByTradeId(tradeStore.getTradeId());

            if(version != null && tradeStore.getVersion().compareTo(version) < 0)
                throw new MinorVersionException();
            else if(version != null && tradeStore.getVersion().compareTo(version) == 0 &&
                    LocalDate.now().compareTo(tradeStore.getMaturityDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) <= -1) {
                Optional<TradeStore> anotherTradeStore = tradeStoreRepository.findByTradeIdAndVersion(tradeStore.getTradeId(), version);
                tradeStore.setId(anotherTradeStore.get().getId());
                tradeStoreRepository.saveAndFlush(tradeStore);
                return tradeStore;
            }

            if(tradeStore != null &&
                    LocalDate.now().compareTo(tradeStore.getMaturityDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate()) <= -1){
                tradeStoreRepository.save(tradeStore);
                return tradeStore;
            }
        return null;

    }

    public void updateExpiredFlag(){
        tradeStoreRepository.updateExpiredFlag();
    }
}

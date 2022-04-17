package com.barclays.programmingassessment.repositories;

import com.barclays.programmingassessment.entities.TradeStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TradeStoreRepository extends JpaRepository<TradeStore , Integer> {


    @Query(value = "select MAX(version)" +
            " from trade_store where trade_id=?1",nativeQuery = true)
    Integer findMaxVersionByTradeId(String tradeId);

    @Query(value = "select id,trade_id,version,country_party_id,book_id,maturity_date,created_date,expired from trade_store where trade_id=?1 and version=?2",nativeQuery = true)
    Optional<TradeStore> findByTradeIdAndVersion(String tradeId, Integer version);

    @Query(value = "update set expired='Y' where maturity_date < CURRENT_DATE()",nativeQuery = true)
    void updateExpiredFlag();
}

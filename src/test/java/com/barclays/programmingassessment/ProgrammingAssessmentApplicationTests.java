package com.barclays.programmingassessment;

import com.barclays.programmingassessment.entities.TradeStore;
import com.barclays.programmingassessment.repositories.TradeStoreRepository;
import com.barclays.programmingassessment.services.TradeStoreService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@SpringBootTest
class ProgrammingAssessmentApplicationTests {

	@Autowired
	TradeStoreService tradeStoreService;

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Test
	void contextLoads() {
	}


	@Test
	void testMinorVersion()throws Exception{

		TradeStore tradeStore = new TradeStore();

			tradeStore.setTradeId("T2");
			tradeStore.setVersion(1);
			tradeStore.setExpired("N");
			tradeStore.setMaturityDate(simpleDateFormat.parse("20/05/2022"));
			tradeStore.setBookId("B12");
			tradeStore.setCreatedDate(new Date());

		tradeStoreService.saveTradeStore(tradeStore);
	}

	@Test
	void testUpdateIfVersionSame()throws Exception{
		TradeStore tradeStore = new TradeStore();

		tradeStore.setTradeId("T2");
		tradeStore.setVersion(2);
		tradeStore.setExpired("N");
		tradeStore.setMaturityDate(simpleDateFormat.parse("20/05/2022"));
		tradeStore.setBookId("B12");
		tradeStore.setCreatedDate(new Date());

		tradeStoreService.saveTradeStore(tradeStore);
	}

	@Test
	void testSaveTradeStore()throws Exception{
		TradeStore tradeStore = new TradeStore();

		tradeStore.setTradeId("T7");
		tradeStore.setVersion(1);
		tradeStore.setExpired("N");
		tradeStore.setMaturityDate(simpleDateFormat.parse("20/05/2022"));
		tradeStore.setBookId("B12");
		tradeStore.setCreatedDate(new Date());

		tradeStoreService.saveTradeStore(tradeStore);
	}

}

package com.barclays.programmingassessment;

import com.barclays.programmingassessment.repositories.TradeStoreRepository;
import com.barclays.programmingassessment.services.TradeStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ProgrammingAssessmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProgrammingAssessmentApplication.class, args);
	}

	@Autowired
	TradeStoreService service;
	@Scheduled(cron = "0 0 0 * * *" )
	public void updateExpiredFlag(){
		service.updateExpiredFlag();
	}
}

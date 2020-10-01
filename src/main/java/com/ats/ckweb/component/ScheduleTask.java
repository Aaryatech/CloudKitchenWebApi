package com.ats.ckweb.component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ats.ckweb.repository.ItemConfigDetailRepo;

@Component
public class ScheduleTask {

	@Autowired
	ItemConfigDetailRepo itemConfigDetailRepo;
	
	@Scheduled(cron = "0 0 0 * * *")//everyday 12AM midnight
	public void updateInActiveForDayStatusForItem() {
		
		itemConfigDetailRepo.updateInActiveForDayCron();
		itemConfigDetailRepo.updateInActiveForDayCron2();
		
	}
	
	//every 5 sec
	//@Scheduled(cron = "0/5 * * * * *")
	//public void temp() {
	//	SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	//	System.err.println(" Cron ------- "+sdf.format(Calendar.getInstance().getTimeInMillis()));
	//}
	
	
}

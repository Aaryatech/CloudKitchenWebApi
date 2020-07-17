package com.ats.ckweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.ItemDetailNew;
import com.ats.ckweb.repository.ItemDetailNewRepo;

@Service
public class ItemDetailNewServiceImpl implements ItemDetailNewService{

	@Autowired ItemDetailNewRepo itemDetailNewRepo;
	
	@Override
	public ItemDetailNew saveItemDetailNew(ItemDetailNew itemDetailNew) {
		ItemDetailNew res = itemDetailNewRepo.save(itemDetailNew);
		return res;
	}
	

}

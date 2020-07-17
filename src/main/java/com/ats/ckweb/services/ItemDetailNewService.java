package com.ats.ckweb.services;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.ItemDetailNew;

@Service
public interface ItemDetailNewService {

	ItemDetailNew saveItemDetailNew(ItemDetailNew itemDetailNew);
	
}

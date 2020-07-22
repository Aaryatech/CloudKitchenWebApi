package com.ats.ckweb.services;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.ItemConfigHeader;

@Service
public interface ItemConfigHeaderService {
	
	ItemConfigHeader saveItemConfigHeaderAndDetail(ItemConfigHeader itemConfigHeader);

}

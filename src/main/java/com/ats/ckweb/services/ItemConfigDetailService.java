package com.ats.ckweb.services;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.ItemConfigDetail;

@Service
public interface ItemConfigDetailService {
	
	ItemConfigDetail saveItemConfigDetail(ItemConfigDetail itemConfigDetail);

}

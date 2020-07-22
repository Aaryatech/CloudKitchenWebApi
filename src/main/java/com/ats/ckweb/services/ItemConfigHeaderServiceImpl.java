package com.ats.ckweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.ItemConfigDetail;
import com.ats.ckweb.model.ItemConfigHeader;
import com.ats.ckweb.repository.ImagesRepo;
import com.ats.ckweb.repository.ItemConfigDetailRepo;
import com.ats.ckweb.repository.ItemConfigHeaderRepo;

@Service
public class ItemConfigHeaderServiceImpl implements  ItemConfigHeaderService {

	@Autowired ItemConfigHeaderRepo itemConfigHeaderRepo;
	
	@Autowired ItemConfigDetailRepo itemConfigDetailRepo;
	
	@Override
	public ItemConfigHeader saveItemConfigHeaderAndDetail(ItemConfigHeader itemConfigHeader) {
		
		ItemConfigHeader res=new ItemConfigHeader();
		
		try {
			res=itemConfigHeaderRepo.save(itemConfigHeader);
			
			if(res!=null) {
				List<ItemConfigDetail> detailList=new ArrayList<>();
				if(detailList!=null) {
					for(int i=0;i<itemConfigHeader.getItemConfigDetailList().size();i++) {
						ItemConfigDetail detail=itemConfigHeader.getItemConfigDetailList().get(i);
						detail.setItemConfigId(res.getItemConfigId());
						detailList.add(detail);
					}
					
					List<ItemConfigDetail> detailRes=itemConfigDetailRepo.saveAll(detailList);
					res.setItemConfigDetailList(detailRes);
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return res;
	}

}



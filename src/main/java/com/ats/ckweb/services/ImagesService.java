package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Images;
import com.ats.ckweb.model.Info;

@Service
public interface ImagesService {

	Images saveImage(Images images);
	
	Info saveMultipleImages(List<Images> imageList);
	
	List<Images> getImageListByDocIdAndDocType(int id,int type);
	
	Info deletImageById(int imageId);
	
	
	
	
}

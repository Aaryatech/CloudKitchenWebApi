package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Tags;
@Service
public interface TagsServices {

	
	List<Tags> getAllOfferTags();

	Tags getTagById(int tagId);

	Tags saveTag(Tags tag);

	List<Tags> getAllgetAllActiveOfferTags();
}

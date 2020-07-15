package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.Tags;
@Service
public interface TagsServices {

	
	List<Tags> getAllOfferTags();

	Tags getTagById(int tagId);

	Tags saveTag(Tags tag);

	List<Tags> getAllActiveOfferTags();

	int deletTagById(int tagId);

	IngrediantCategory saveingerediant(IngrediantCategory ingerediant);

	List<IngrediantCategory> getAllIngrediantCategory();

	IngrediantCategory getIngrediantCatById(int ingerediantCatId);

	int deletIngerediantCatIdById(int ingerediantCatId);

}

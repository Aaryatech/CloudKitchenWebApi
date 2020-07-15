package com.ats.ckweb.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Ingrediant;
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
	
	List<IngrediantCategory> getAllActiveIngrediantCategory();

	IngrediantCategory getIngrediantCatById(int ingerediantCatId);

	int deletIngerediantCatIdById(int ingerediantCatId);

	Ingrediant insertIngrediant(Ingrediant ingerediant);

	List<Ingrediant> getAllIngrediant();

	Ingrediant getIngrediantById(int ingrediantId);

	int deleteIngerediantById(int ingerediantId);

	

	
}

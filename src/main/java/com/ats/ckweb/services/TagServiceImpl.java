package com.ats.ckweb.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ckweb.model.Ingrediant;
import com.ats.ckweb.model.IngrediantCategory;
import com.ats.ckweb.model.Tags;
import com.ats.ckweb.repository.IngrediantCategoryRepo;
import com.ats.ckweb.repository.IngrediantRepo;
import com.ats.ckweb.repository.TagRepo;

@Service
public class TagServiceImpl implements TagsServices {

	@Autowired TagRepo tagRepo;
	
	@Autowired IngrediantCategoryRepo ingrediantCatRepo;
	
	@Autowired IngrediantRepo ingrediantRepo;
	
	@Override
	public List<Tags> getAllOfferTags() {
		
		List<Tags> taglist = tagRepo.findByTagDeleteStatusOrderByTagIdDesc(1);
		
		return taglist;
	}

	@Override
	public Tags getTagById(int tagId) {
		Tags tag = tagRepo.findByTagIdAndTagDeleteStatus(tagId, 1);
		return tag;
	}

	@Override
	public Tags saveTag(Tags tag) {
		Tags saveTag = tagRepo.save(tag);
		return saveTag;
	}

	@Override
	public List<Tags> getAllActiveOfferTags() {
		
		List<Tags> taglist = tagRepo.findByTagDeleteStatusAndTagIsActive(1, 1);		
		return taglist;
	}

	@Override
	public int deletTagById(int tagId) {
		int res = tagRepo.deleteTagById(tagId);
		return res;
	}

	@Override
	public IngrediantCategory saveingerediant(IngrediantCategory ingerediant) {
		IngrediantCategory saveIngrediantCategory = ingrediantCatRepo.save(ingerediant);
		return saveIngrediantCategory;
	}

	@Override
	public List<IngrediantCategory> getAllIngrediantCategory() {
		
		List<IngrediantCategory> catlist = ingrediantCatRepo.findBydelStatusOrderByIngrediantCatIdDesc(1);		
		return  catlist;
	}

	@Override
	public List<IngrediantCategory> getAllActiveIngrediantCategory() {
		List<IngrediantCategory> list = ingrediantCatRepo.findByDelStatusAndIsActiveOrderByIngrediantCatIdDesc(1, 1);
		return list;
	}
	
	@Override
	public IngrediantCategory getIngrediantCatById(int ingerediantCatId) {
		IngrediantCategory cat = ingrediantCatRepo.findByIngrediantCatIdAndDelStatus(ingerediantCatId, 1);
		return cat;
	}

	@Override
	public int deletIngerediantCatIdById(int ingerediantCatId) {
		int res = ingrediantCatRepo.deleteIngrediantCatById(ingerediantCatId);
		return res;
	}
/***************************************************/

	@Override
	public Ingrediant insertIngrediant(Ingrediant ingerediant) {
		Ingrediant saveIngrdnt = ingrediantRepo.save(ingerediant);
		return saveIngrdnt;
	}

	@Override
	public List<Ingrediant> getAllIngrediant() {
		List<Ingrediant> list = ingrediantRepo.findByDelStatusOrderByIngrediantIdDesc(1);
		return list;
	}

	@Override
	public Ingrediant getIngrediantById(int ingrediantId) {
		Ingrediant ingrediant = ingrediantRepo.findByDelStatusAndIngrediantId(1, ingrediantId);
		return ingrediant;
	}

	@Override
	public int deleteIngerediantById(int ingerediantId) {
		int res = ingrediantRepo.deleteIngerediantById(ingerediantId);
		return res;
	}

	

}

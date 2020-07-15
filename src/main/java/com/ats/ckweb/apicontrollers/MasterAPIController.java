package com.ats.ckweb.apicontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ckweb.model.Tags;
import com.ats.ckweb.services.TagsServices;

@RestController
public class MasterAPIController {

	@Autowired TagsServices tagService;
	
	
	@RequestMapping(value = { "/saveNewTag" }, method = RequestMethod.POST)
	public @ResponseBody Tags saveNewTag(@RequestBody Tags tag){
		System.err.println("tag------------"+tag);
		Tags saveTag = new Tags();
		try {
			saveTag = tagService.saveTag(tag);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return saveTag;		
	}
	
	@RequestMapping(value = { "/getAllTags" }, method = RequestMethod.GET)
	public @ResponseBody List<Tags> getAllTags(){
		
		List<Tags> tagList = new ArrayList<Tags>();
		try {
			tagList = tagService.getAllOfferTags();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;
		
	}
	
	@RequestMapping(value = { "/getAllActiveTags" }, method = RequestMethod.GET)
	public @ResponseBody List<Tags> getAllActiveTags(){
		
		List<Tags> tagList = new ArrayList<Tags>();
		try {
			tagList = tagService.getAllgetAllActiveOfferTags();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tagList;
		
	}
	
	@RequestMapping(value = { "/getTagById" }, method = RequestMethod.POST)
	public @ResponseBody Tags getTagById(@RequestParam int tagId){
		
		Tags tag = new Tags();
		try {
			tag = tagService.getTagById(tagId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return tag;		
	}
}

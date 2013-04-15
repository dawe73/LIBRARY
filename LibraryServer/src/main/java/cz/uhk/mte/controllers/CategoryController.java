package cz.uhk.mte.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.uhk.mte.model.Category;
import cz.uhk.mte.service.impl.CategoryService;
import cz.uhk.mte.service.impl.IEntityService;


@Controller
public class CategoryController {
	@Autowired
	private IEntityService entityService;
	
	private List<Category> categories = new ArrayList<Category>();

	
	@RequestMapping(value = "admin/category", method = RequestMethod.GET)
	public String home(Model model) {
		
		if (categories.size() == 0) {
			Category c = new Category();
			c.setTitle("UHK");
			c.setLevel(0);
			entityService.insertEntity(c);
			categories.addAll((Collection<? extends Category>) entityService.getAllEntities());
		}
    	model.addAttribute("categories", categories);
    	return "admin/category";
	}
	
	@RequestMapping(value = "admin/newCategory", method = RequestMethod.GET)
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		//kategorie vždy tahat z db a ukládat do listu aby se z nich pak dalo natáhnout podle id a nemuselo se poøád sahat do db
		
		Category cat = (Category)entityService.getAllEntities().get(0);
		System.out.println(cat.getDescription()+cat.getID()+cat.getTitle());
		model.addAttribute("categories", categories);
		return "admin/newCategory";
	}
	
	
	@RequestMapping(value = "admin/category.add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category")
    @Valid Category category,BindingResult result,
    @RequestParam("categoryID") int categoryID,  Model model) {
		//tady se bude tahat podle ID dané kategorie, napø pošleme do nìjaké service list a získáme kategorii getByID
		if (result.hasErrors()) {
			model.addAttribute("categoryID", categoryID);
			model.addAttribute("category",category);
			model.addAttribute("categories", categories);
			return "newCategory";
		}else {
			category.setParentCategory(categories.get(categoryID));
			category.setLevel(category.getParentCategory().getLevel()+1);
			
			categories.add(category);
			entityService.insertEntity(category);
			return "redirect:/admin//category";
		}
    }
	
	
	@RequestMapping(value = "admin/category.info", method = RequestMethod.GET)
    public String categoryInfo(@RequestParam("id") int id, Model model) {
			Category category = categories.get(id);
        	model.addAttribute("category", category);
        	return "/admin/categoryInfo";
    }
	
	@RequestMapping(value = "admin/category.edit", method = RequestMethod.GET)
    public String categoryEdit(@RequestParam("id") int id, Model model) {
			Category category = categories.get(id);
        	model.addAttribute("category", category);
        	return "/admin/newCategory";
    }
	
	@RequestMapping(value = "admin/category.delete", method = RequestMethod.GET)
    public String categoryDelete(@RequestParam("id") int id, Model model) {
			categories.remove(id);
        	return "redirect:/admin/category";
    }
	
}

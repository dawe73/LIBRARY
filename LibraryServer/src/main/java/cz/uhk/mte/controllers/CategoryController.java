package cz.uhk.mte.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.uhk.mte.model.Category;


@Controller
public class CategoryController {
	private List<Category> categories = new ArrayList<Category>(); 
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String home(Model model) {
    	model.addAttribute("categories", categories);
    	return "category";
	}
	
	@RequestMapping(value = "/newCategory", method = RequestMethod.GET)
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("parentCategory", new Category());
		model.addAttribute("categories", categories);
		return "newCategory";
	}
	
	
	@RequestMapping(value = "/category.add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("parentCategory")Category parentCategory,@ModelAttribute("category")
    Category category, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "newCategory";
        } else {
        	if (category.getParentCategory() != null) {
				category.setLevel(category.getParentCategory().getLevel()+1);
			}else{
				category.setLevel(1);
			}
        	categories.add(category);
        	model.addAttribute("categories", categories);
        	return "redirect:/category";
        }
    }
	
	
	@RequestMapping(value = "/category.info", method = RequestMethod.GET)
    public String categoryInfo(@RequestParam("id") int id, Model model) {
			Category category = categories.get(id);
        	model.addAttribute("category", category);
        	return "categoryInfo";
    }
	
	@RequestMapping(value = "/category.edit", method = RequestMethod.GET)
    public String categoryEdit(@RequestParam("id") int id, Model model) {
			Category category = categories.get(id);
        	model.addAttribute("category", category);
        	return "newCategory";
    }
	
}

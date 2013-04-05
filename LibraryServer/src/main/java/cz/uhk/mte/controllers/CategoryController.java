package cz.uhk.mte.controllers;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;



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
	//pouze pro tes v DB je generov�no tak�e smazat!!!
	private static int ID = 1;
	
	
	@RequestMapping(value = "/category", method = RequestMethod.GET)
	public String home(Model model) {
    	model.addAttribute("categories", categories);
    	return "category";
	}
	
	@RequestMapping(value = "/newCategory", method = RequestMethod.GET)
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		//kategorie v�dy tahat z db a ukl�dat do listu aby se z nich pak dalo nat�hnout podle id a nemuselo se po��d sahat do db
		if (categories.size() == 0) {
			Category c = new Category();
			c.setTitle("neza�azen�");
			c.setLevel(0);
			categories.add(c);
		}
		for (Category c : categories) {
			if (c.getParentCategory() != null) {
				
				System.out.println(c.getParentCategory().getTitle());
			}
		}
		model.addAttribute("categories", categories);
		return "newCategory";
	}
	
	
	@RequestMapping(value = "/category.add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category")
    @Valid Category category,BindingResult result,
    @RequestParam("categoryID") int categoryID,  Model model) {
		//tady se bude tahat podle ID dan� kategorie, nap� po�leme do n�jak� service list a z�sk�me kategorii getByID
		if (result.hasErrors()) {
			model.addAttribute("categoryID", categoryID);
			model.addAttribute("category",category);
			model.addAttribute("categories", categories);
			return "newCategory";
		}else {
			category.setParentCategory(categories.get(categoryID));
			category.setLevel(category.getParentCategory().getLevel()+1);
			category.setID(ID);
			ID+=1;
			
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
	
	@RequestMapping(value = "/category.delete", method = RequestMethod.GET)
    public String categoryDelete(@RequestParam("id") int id, Model model) {
			categories.remove(id);
        	return "redirect:/category";
    }
	
}

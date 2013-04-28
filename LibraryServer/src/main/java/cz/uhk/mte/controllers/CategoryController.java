package cz.uhk.mte.controllers;


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
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.CategoryService;


@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value = "admin/", method = RequestMethod.GET)
	public String sign(Model model) {
    	model.addAttribute("categories", categoryService.getAllCategories());
    	return "admin/category";
	}
	
	
	@RequestMapping(value = "admin/category", method = RequestMethod.GET)
	public String home(Model model) {
    	model.addAttribute("categories", categoryService.getAllCategories());
    	return "admin/category";
	}
	
	@RequestMapping(value = "admin/newCategory", method = RequestMethod.GET)
	public String createCategory(Model model) {
		model.addAttribute("category", new Category());
		model.addAttribute("categories", categoryService.getAllCategories());;
		return "admin/newCategory";
	}
	
	
	@RequestMapping(value = "admin/category.add", method = RequestMethod.POST)
    public String addCategory(@ModelAttribute("category")
    @Valid Category category,BindingResult result,
    @RequestParam("categoryID") int categoryID,  Model model) {
		if (result.hasErrors()) {
			model.addAttribute("categoryID", categoryID);
			model.addAttribute("category",category);
			model.addAttribute("categories", categoryService.getAllCategories());
			return "admin/newCategory";
		}else {
			Category parenCategory = categoryService.getCategoryByID(categoryID);
			category.setParentCategory(parenCategory);
			category.setLevel(parenCategory.getLevel()+1);
			categoryService.insertCategory(category);
			return "redirect:/admin/category";
		}
    }
	
	
	@RequestMapping(value = "admin/category.info", method = RequestMethod.GET)
    public String categoryInfo(@RequestParam("id") int id, Model model) {
			Category c = categoryService.getCategoryByID(id);
        	model.addAttribute("category", c);
        	model.addAttribute("books", bookService.getBooksByCategory(c));
        	return "/admin/categoryInfo";
    }
	
	@RequestMapping(value = "admin/category.edit", method = RequestMethod.GET)
    public String categoryEdit(@RequestParam("id") int id, Model model) {
		model.addAttribute("category", categoryService.getCategoryByID(id));
		model.addAttribute("categories", categoryService.getAllCategories());
        return "/admin/newCategory";
    }
	
	@RequestMapping(value = "admin/category.saveEdit", method = RequestMethod.GET)
    public String categorySaveEdit(int id, Model model) {
		model.addAttribute("category", categoryService.getCategoryByID(id));
		model.addAttribute("categories", categoryService.getAllCategories());
        	return "/admin/newCategory";
    }
	
	
	@RequestMapping(value = "admin/category.delete", method = RequestMethod.GET)
    public String categoryDelete(@RequestParam("id") int id, Model model) {
		if (categoryService.getByParentCategory(categoryService.getCategoryByID(id)).size() < 1) {
			categoryService.delete(categoryService.getCategoryByID(id));
		}
        return "redirect:/admin/category";
    }
	
}

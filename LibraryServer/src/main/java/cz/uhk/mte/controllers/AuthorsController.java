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

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Category;

@Controller
public class AuthorsController {
	
	private List<Author> authors = new ArrayList<Author>();
	//pouze pro tes v DB je generováno takže smazat!!!
	private static int ID = 1;
	
	
	@RequestMapping(value = "admin/authors", method = RequestMethod.GET)
	public String authors(Model model) {
    	model.addAttribute("authors", authors);
    	return "admin/authors";
	}
	
	@RequestMapping(value = "admin/newAuthor", method = RequestMethod.GET)
	public String createAuthor(Model model) {
		model.addAttribute("author", new Author());
		return "admin/newAuthor";
	}
	
	
	@RequestMapping(value = "admin/author.add", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author")
    @Valid Author author,BindingResult result,Model model) {
		//doplnit zachyceni parametru strink a zmìnit na date
		if (result.hasErrors()) {
			model.addAttribute("author", author);
			return "admin/newAuthor";
		}else {
			ID+=1;
			authors.add(author);
			return "redirect:admin/authors";
		}
    }
	
	
	@RequestMapping(value = "admin/author.info", method = RequestMethod.GET)
    public String authorInfo(@RequestParam("id") int id, Model model) {
			Author author = authors.get(id);
        	model.addAttribute("author", author);
        	return "admin/authorInfo";
    }
	
	@RequestMapping(value = "admin/author.edit", method = RequestMethod.GET)
    public String authorEdit(@RequestParam("id") int id, Model model) {
			Author author = authors.get(id);
        	model.addAttribute("author", author);
        	return "admin/newAuthor";
    }
	
	@RequestMapping(value = "admin/author.delete", method = RequestMethod.GET)
    public String authorDelete(@RequestParam("id") int id, Model model) {
			authors.remove(id);
        	return "redirect:admin/authors";
    }
}

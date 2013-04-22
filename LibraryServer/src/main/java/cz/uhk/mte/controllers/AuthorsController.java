package cz.uhk.mte.controllers;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
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

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.service.AuthorService;
import cz.uhk.mte.utils.DateConvertor;

@Controller
public class AuthorsController {
	@Autowired
	AuthorService authorService;
	
	@Autowired
	DateConvertor dateConvertor;

	@RequestMapping(value = "admin/authors", method = RequestMethod.GET)
	public String authors(Model model) {
		model.addAttribute("authors", authorService.getAllAuthors());
		return "admin/authors";
	}

	@RequestMapping(value = "admin/newAuthor", method = RequestMethod.GET)
	public String createAuthor(Model model) {
		model.addAttribute("author", new Author());
		model.addAttribute("birthDay", "dd.MM.yy");
		return "admin/newAuthor";
	}

	@RequestMapping(value = "admin/author.add", method = RequestMethod.POST)
	public String addAuthor(@ModelAttribute("author") @Valid Author author,
			BindingResult result, @RequestParam("birthDay") String birthDate,
			Model model) {	
		Date date;
		try {
			date = dateConvertor.stringToDate(birthDate);
		} catch (ParseException e) {
			model.addAttribute("author", author);
			model.addAttribute("birthDay", "dd.MM.yy");
			return "admin/newAuthor";
		}
		
		if (result.hasErrors()) {
			model.addAttribute("author", author);
			model.addAttribute("birthDay",birthDate);
			return "admin/newAuthor";
		} else {
			author.setBirthDate(date);
			authorService.insertAuthor(author);
			return "redirect:/admin/authors";
		}
	}

	@RequestMapping(value = "admin/author.info", method = RequestMethod.GET)
	public String authorInfo(@RequestParam("id") int id, Model model) {
		model.addAttribute("author", authorService.getAuthorByID(id));
		return "admin/authorInfo";
	}

	@RequestMapping(value = "admin/author.edit", method = RequestMethod.GET)
	public String authorEdit(@RequestParam("id") int id, Model model) {
		model.addAttribute("author", authorService.getAuthorByID(id));
		model.addAttribute("birthDay", dateConvertor.dateTOString(authorService.getAuthorByID(id).getBirthDate()));
		return "admin/newAuthor";
	}

	@RequestMapping(value = "admin/author.delete", method = RequestMethod.GET)
	public String authorDelete(@RequestParam("id") int id, Model model) {
		authorService.delete(authorService.getAuthorByID(id));
		return "redirect:/admin/authors";
	}
}

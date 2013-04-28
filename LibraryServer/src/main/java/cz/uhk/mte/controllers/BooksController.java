package cz.uhk.mte.controllers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
import cz.uhk.mte.model.Book;
import cz.uhk.mte.service.AuthorService;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.CategoryService;
import cz.uhk.mte.utils.DateConvertor;

@Controller
public class BooksController {
	@Autowired
	BookService bookService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	DateConvertor dateConvertor;

	@RequestMapping(value = "admin/books", method = RequestMethod.GET)
	public String books(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "admin/books";
	}

	@RequestMapping(value = "admin/newBook", method = RequestMethod.GET)
	public String createBook(Model model) {
		model.addAttribute("numberOfAuthors",1);
		model.addAttribute("authors",authorService.getAllAuthors());
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("releasedDate", "dd.MM.yy");
		return "admin/newBook";
	}
	

	@RequestMapping(value = "admin/book.add", method = RequestMethod.POST)
	public String addBook(@ModelAttribute("book") @Valid Book book,
			BindingResult result, @RequestParam("releasedDate") String releasedDate,
			@RequestParam("categoryID") int categoryID,
			@RequestParam("authorsID[]")int[] authorsID,
			@RequestParam("action") String action,
			Model model) {
		List<Author> listOfAuthor = new ArrayList<Author>();
		for (int i : authorsID) {
			listOfAuthor.add(authorService.getAuthorByID(i));
		}
		if (action.equals("Add book")) {
			Date date;
			try {
				date = dateConvertor.stringToDate(releasedDate);
			} catch (ParseException e) {
				model.addAttribute("categories", categoryService.getAllCategories());
				model.addAttribute("book", book);
				model.addAttribute("releasedDate", "dd.MM.yy");
				model.addAttribute("authors",authorService.getAllAuthors());
				model.addAttribute("numberOfAuthors",authorsID.length);
				return "admin/newBook";
			}
			
			if (result.hasErrors()) {
				model.addAttribute("book", book);
				model.addAttribute("categories", categoryService.getAllCategories());
				model.addAttribute("releasedDate",releasedDate);
				model.addAttribute("numberOfAuthors",authorsID.length);
				model.addAttribute("authors",authorService.getAllAuthors());
				return "admin/newBook";
			} else {
				book.setReleased(date);
				book.setCategory(categoryService.getCategoryByID(categoryID));
				for (Author author : listOfAuthor) {
					author.getBooks().remove(book);
					authorService.insertAuthor(author);
				}
				book.setAuthors(listOfAuthor);
				book.setAvailableCount(book.getCount());
				bookService.insertBook(book);
				return "redirect:/admin/books";
			}
		} else if(action.equals("Next author")) {
			model.addAttribute("numberOfAuthors",1+authorsID.length);
			model.addAttribute("authors",authorService.getAllAuthors());
			model.addAttribute("book", book);
			model.addAttribute("categories", categoryService.getAllCategories());
			model.addAttribute("releasedDate", releasedDate);
			model.addAttribute("selectedAuthors",listOfAuthor);
			return "admin/newBook";
		} else if (action.equals("Remove last")){
			if (authorsID.length > 1) {
				model.addAttribute("numberOfAuthors",authorsID.length-1);
			}else {
				model.addAttribute("numberOfAuthors",1);
			}
			model.addAttribute("authors",authorService.getAllAuthors());
			model.addAttribute("book", book);
			model.addAttribute("categories", categoryService.getAllCategories());
			model.addAttribute("releasedDate", releasedDate);
			model.addAttribute("selectedAuthors",listOfAuthor);
			return "admin/newBook";
		}
		return "redirect:/admin/books";
	}

	@RequestMapping(value = "admin/book.info", method = RequestMethod.GET)
	public String bookInfo(@RequestParam("id") int id, Model model) {
		model.addAttribute("book",bookService.getBookByID(id));
		return "admin/bookInfo";
	}

	@RequestMapping(value = "admin/book.edit", method = RequestMethod.GET)
	public String bookEdit(@RequestParam("id") int id, Model model) {
		Book book = bookService.getBookByID(id);
		model.addAttribute("numberOfAuthors",book.getAuthors().size());
		model.addAttribute("authors",authorService.getAllAuthors());
		model.addAttribute("book", book);
		model.addAttribute("categories", categoryService.getAllCategories());
		model.addAttribute("selectedAuthors",book.getAuthors());
		model.addAttribute("releasedDate", dateConvertor.dateTOString(bookService.getBookByID(id).getReleased()));
		return "admin/newBook";
	}

	@RequestMapping(value = "admin/book.delete", method = RequestMethod.GET)
	public String bookDelete(@RequestParam("id") int id, Model model) {
		bookService.delete(bookService.getBookByID(id));
		return "redirect:/admin/books";
	}
}

package cz.uhk.mte.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Borrowing;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.BorrowingService;

@Controller
public class BorrowingController {
	@Autowired
	BorrowingService borrowingService;
	
	@Autowired
	BookService bookService;
	
	@RequestMapping(value = "admin/borrowing", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("borrowing", borrowingService.getAllBorrowings());
		return "admin/borrowing";
	}
	
	@RequestMapping(value = "admin/borrowing.end", method = RequestMethod.GET)
	public String finishBorrowing(@RequestParam("id")int id, Model model) {
		Borrowing b = borrowingService.getBorrowingByID(id);
		b.setDateReceived(new Date());
		b.setActive(false);
		Book book = b.getBook();
		int ava = book.getAvailableCount()+1;
		book.setAvailableCount(ava);
		bookService.update(book);
		borrowingService.update(b);
		return "redirect:/admin/borrowing";
	}
	
}

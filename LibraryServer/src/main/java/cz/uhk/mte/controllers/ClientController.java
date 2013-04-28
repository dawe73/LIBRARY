package cz.uhk.mte.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.uhk.mte.model.Android.BookAndroid;
import cz.uhk.mte.model.Android.CategoryAndroid;
import cz.uhk.mte.model.Android.ReservationAndroid;
import cz.uhk.mte.service.webService.LibraryWebService;


@Controller
public class ClientController implements LibraryWebService {
	
	@Autowired
	LibraryWebService convertor;
	
	@Override
	@RequestMapping(value = "/getCategoriesByParentCategoryID", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<CategoryAndroid> getCategoriesByParentCategoryID(
			@RequestBody int parentCategoryID) {
		return convertor.getCategoriesByParentCategoryID(parentCategoryID);
	}

	@Override
	@RequestMapping(value = "/getCategoriesBySearchExpression", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<CategoryAndroid> getCategoriesBySearchExpression(
			@RequestBody String searchExpression) {
		System.out.println("hleda " + searchExpression);
		return convertor.getCategoriesBySearchExpression(searchExpression);
	}

	@Override
	@RequestMapping(value = "/getBookByID", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody BookAndroid getBookByID(@RequestBody int bookID) {
		return convertor.getBookByID(bookID);
	}

	@Override
	@RequestMapping(value = "/getBooksByCategoryID", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<BookAndroid> getBooksByCategoryID(@RequestBody int categoryID) {
		System.out.println("kategorie"+categoryID);
		return convertor.getBooksByCategoryID(categoryID);
	}

	@Override
	@RequestMapping(value = "/getBooksBySearchExpression", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody List<BookAndroid> getBooksBySearchExpression(@RequestBody String searchExpression) {
		return convertor.getBooksBySearchExpression(searchExpression);
	}
	
	@Override
	@RequestMapping(value = "/insertReservation", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody int InsertReservation(@RequestBody ReservationAndroid reservation) {
		return convertor.InsertReservation(reservation);
	}

	
	@Override
	@RequestMapping(value = "/getAllBook", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<BookAndroid> getAllBook() {
		return convertor.getAllBook();
	}

	@Override
	@RequestMapping(value = "/getCategoryByID", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody CategoryAndroid getCategoryByID(@RequestBody int categoryID) {
		System.out.println("kategorie"+categoryID);
		return convertor.getCategoryByID(categoryID);
	}

}

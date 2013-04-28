package cz.uhk.mte.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import cz.uhk.mte.global.Helpers;
import cz.uhk.mte.entity.BookAndroid;
import cz.uhk.mte.entity.CategoryAndroid;
import cz.uhk.mte.entity.ReservationAndroid;

public class TestLibraryWebService implements ILibraryWebService {

	@Override
	public ArrayList<CategoryAndroid> getCategoriesByParentCategoryID(
			int parentCategoryID) {
		ArrayList<CategoryAndroid> categories = new ArrayList<CategoryAndroid>();
		Random r = new Random();
		boolean isTopLevel = parentCategoryID == 0;
		for (int i = 1; i < 10; i++) {
			CategoryAndroid c = new CategoryAndroid();
			c.setBooksCount(r.nextInt(1000));
			c.setDescription("Popis kategorie " + Integer.toString(i));
			c.setID(i);
			c.setLevel(parentCategoryID);
			c.setParentCategoryTitle("NadKategorie");
			c.setTitle("Kategorie " + Integer.toString(i));
			c.setTopLevelCategory(isTopLevel);
			categories.add(c);	
			
			Helpers.Wait(1);
		}
		return categories;
	}

	@Override
	public ArrayList<CategoryAndroid> getCategoriesBySearchExpression(
			String searchExpression) {
		ArrayList<CategoryAndroid> categories = new ArrayList<CategoryAndroid>();
		Random r = new Random();
		for (int i = 1; i < 10; i++) {
			CategoryAndroid c = new CategoryAndroid();
			c.setBooksCount(r.nextInt(1000));
			c.setDescription("Popis kategorie " + Integer.toString(i));
			c.setID(i);
			c.setLevel(0);
			c.setParentCategoryTitle("NadKategorie");
			c.setTitle(Integer.toString(i) + "Kategorie " + searchExpression + " ");
			c.setTopLevelCategory(false);
			categories.add(c);
			
			//Globals.Wait(1);
		}
		return categories;
	}

	@Override
	public BookAndroid getBookByID(int bookID) {
		Random r = new Random();
		BookAndroid book = new BookAndroid();
		
		book.setAvailableCount(r.nextInt(100));
		book.setCategoryTitle("Kategorie knihy scifi ");
		book.setCount(r.nextInt(1000));
		book.setID(bookID);
		book.setISBN("GHFSDG");
		book.setKeywords("klicova, slova, teto, knihy");
		book.setMainAuthors("John Brown, Jessie James");
		book.setPageCount(r.nextInt(5000));
		book.setPrinterInfo("Nakladatelstvi bla bla");
		book.setRelease(new Date(2000, 6, 18));
		book.setTitle("Kniha smrti " + Integer.toString(bookID));
		
		Helpers.Wait(3);
		
		return book;
	}

	@Override
	public ArrayList<BookAndroid> getBooksByCategoryID(int categoryID) {
		Random r = new Random();
		ArrayList<BookAndroid> books = new ArrayList<BookAndroid>();
		
		for (int i = 1; i < 10; i++) {
			
			BookAndroid book = new BookAndroid();
			
			book.setAvailableCount(r.nextInt(100));
			book.setCategoryTitle("Kategorie knihy scifi ");
			book.setCount(r.nextInt(1000));
			book.setID(i);
			book.setISBN("GHFSDG");
			book.setKeywords("klicova, slova, teto, knihy");
			book.setMainAuthors("John Brown, Jessie James");
			book.setPageCount(r.nextInt(5000));
			book.setPrinterInfo("Nakladatelstvi bla bla");
			book.setRelease(new Date(2000, 6, 18));
			book.setTitle(Integer.toString(book.getID()) + " Kniha");
			
			books.add(book);
			
			Helpers.Wait(1);
		}
				
		return books;
	}

	@Override
	public ArrayList<BookAndroid> getBooksBySearchExpression(String searchExpression) {
		Random r = new Random();
		ArrayList<BookAndroid> books = new ArrayList<BookAndroid>();
		
		for (int i = 1; i < 10; i++) {
			
			BookAndroid book = new BookAndroid();
			
			book.setAvailableCount(r.nextInt(100));
			book.setCategoryTitle("Kategorie knihy scifi ");
			book.setCount(r.nextInt(1000));
			book.setID(i);
			book.setISBN("GHFSDG");
			book.setKeywords("klicova, slova, teto, knihy");
			book.setMainAuthors("John Brown, Jessie James");
			book.setPageCount(r.nextInt(5000));
			book.setPrinterInfo("Nakladatelstvi bla bla");
			book.setRelease(new Date(2000, 6, 18));
			book.setTitle(Integer.toString(i) + " Kniha " + searchExpression);
			
			books.add(book);
			
			//Globals.Wait(1);
		}
				
		return books;
	}

	@Override
	public int InsertReservation(ReservationAndroid reservation) {
		if (reservation.getName().equals(reservation.getSurname())) {
			return -1;
		}
		Random r = new Random();
		Helpers.Wait(3);
		return r.nextInt(100);
	}

	@Override
	public CategoryAndroid getCategoryByID(int categoryID) {
		Random r = new Random();
		
		CategoryAndroid c = new CategoryAndroid();
		c.setBooksCount(r.nextInt(1000));
		c.setDescription("Popis kategorie ");
		c.setID(categoryID);
		c.setLevel(0);
		c.setParentCategoryTitle("NadKategorie");
		c.setTitle("Tøeba Skripta " + Integer.toString(categoryID));
		c.setTopLevelCategory(categoryID == 0);
		
		return c;
	}

}

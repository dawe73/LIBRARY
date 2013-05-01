package cz.uhk.mte.service.android.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.Reservation;
import cz.uhk.mte.model.Student;
import cz.uhk.mte.model.Android.BookAndroid;
import cz.uhk.mte.model.Android.CategoryAndroid;
import cz.uhk.mte.model.Android.ReservationAndroid;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.service.CategoryService;
import cz.uhk.mte.service.ReservationService;
import cz.uhk.mte.service.StudentService;
import cz.uhk.mte.service.webService.LibraryWebService;

public class ConvertorToAndroidModelImpl implements LibraryWebService {
	@Autowired
	BookService bookService;
	
	@Autowired
	ReservationService reservationService;
	
	@Autowired
	StudentService studentService;
	
	@Autowired
	CategoryService categoryService;

	@Override
	public List<CategoryAndroid> getCategoriesByParentCategoryID(
			int parentCategoryID) {
		List<Category> categories = categoryService.getByParentCategory(categoryService.getCategoryByID(parentCategoryID));
		List<CategoryAndroid> androidC = new ArrayList<CategoryAndroid>();
		if (categories.size() > 0 ) {
			for (Category c : categories) {
				androidC.add(new CategoryAndroid(c));
			}
		}
		return androidC;
	}

	@Override
	public List<CategoryAndroid> getCategoriesBySearchExpression(
			String searchExpression) {
		searchExpression = searchExpression.replace("\"", "");
		List<Category> categories = categoryService.getCategoriesBySearchExpression(searchExpression);
		List<CategoryAndroid> androidC = new ArrayList<CategoryAndroid>();
		if (categories.size() > 0 ) {
			for (Category c : categories) {
				androidC.add(new CategoryAndroid(c));
			}
		}
		return androidC;
	}

	@Override
	public BookAndroid getBookByID(int bookID) {
		Book book = bookService.getBookByID(bookID);
		return new BookAndroid(book);
	}

	@Override
	public List<BookAndroid> getBooksByCategoryID(int categoryID) {
		List<Book> books = bookService.getBooksByCategory(categoryService.getCategoryByID(categoryID));
		List<BookAndroid> bookAndroid = new ArrayList<BookAndroid>();
		if (books.size() > 0) {
			for (Book book : books) {
				bookAndroid.add(new BookAndroid(book));
			}
		}
		return bookAndroid;
	}

	@Override
	public List<BookAndroid> getBooksBySearchExpression(String searchExpression) {
		searchExpression = searchExpression.replace("\"", "");
		List<Book> books = bookService.getBooksBySearchExpression(searchExpression);
		List<BookAndroid> bookAndroid = new ArrayList<BookAndroid>();
		if (books.size() > 0) {
			for (Book book : books) {
				bookAndroid.add(new BookAndroid(book));
			}
		}
		return bookAndroid;
	}

	@Override
	public List<BookAndroid> getAllBook() {
		List<BookAndroid> books = new ArrayList<BookAndroid>();
		for (Book book : bookService.getAllBooks()) {
			books.add(new BookAndroid(book));
		}
		return books;
	}

	@Override
	public int InsertReservation(ReservationAndroid reservation) {
		Reservation res = new Reservation();
		res.setBook(bookService.getBookByID(reservation.getBookID()));
		Date dateFrom = new Date();
		res.setDateFrom(dateFrom);
		Calendar c = Calendar.getInstance();
		c.setTime(dateFrom);
		c.add(Calendar.DATE, 1);  // number of days to add
		res.setDateTo(c.getTime());
		Student s = studentService.getStudentByMail(reservation.getEmail());
		if (s == null) {
			s = new Student();
			s.setMail(reservation.getEmail());
			s.setSurname(reservation.getSurname());
			s.setName(reservation.getName());
			studentService.insertStudent(s);
		}
		s.getReservations().add(res);
		res.setStudent(s);
		res.setActive(false);
		Book b = bookService.getBookByID(reservation.getBookID());
		int ava = b.getAvailableCount()-1;
		b.setAvailableCount(ava);
		bookService.update(b);
		reservationService.insertReservation(res);
		return reservationService.getLastInsertedID(res);
	}

	@Override
	public CategoryAndroid getCategoryByID(int categoryID) {
		return new CategoryAndroid(categoryService.getCategoryByID(categoryID));
	}
	
	public BookService getBookService() {
		return bookService;
	}

	public void setBookService(BookService bookService) {
		this.bookService = bookService;
	}

	public ReservationService getReservationService() {
		return reservationService;
	}

	public void setReservationService(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public CategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}


	
	
}

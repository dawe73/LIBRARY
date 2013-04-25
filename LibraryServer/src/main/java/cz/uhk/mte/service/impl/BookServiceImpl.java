package cz.uhk.mte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.service.AuthorService;
import cz.uhk.mte.service.BookService;

public class BookServiceImpl implements BookService {

	@Autowired
	BookService bookDao;
	
	@Autowired
	AuthorService authorService;
	
	@Override
	public void delete(Book book) {
		bookDao.delete(book);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}

	@Override
	public Book getBookByID(int ID) {
		return bookDao.getBookByID(ID);
	}

	@Override
	public void insertBook(Book book) {
		bookDao.insertBook(book);
//		for (Author a : book.getAuthors()) {
//			a.getBooks().add(book);
//			authorService.insertAuthor(a);
//		}
	}

	@Override
	public void update(Book book) {
		bookDao.update(book);

	}

	public BookService getBookDao() {
		return bookDao;
	}

	public void setBookDao(BookService bookDao) {
		this.bookDao = bookDao;
	}

	@Override
	public List<Book> getBooksByCategory(Category category) {
		return bookDao.getBooksByCategory(category);
	}

	
}

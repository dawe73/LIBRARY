package cz.uhk.mte.service;

import java.util.List;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.IEntity;

public interface BookService {

	public void delete(Book book);

	public List<Book> getAllBooks();

	public Book getBookByID(int ID);

	public void insertBook(Book book);

	public void update(Book book);
	
	public List<Book> getBooksByCategory(Category category);
	
}

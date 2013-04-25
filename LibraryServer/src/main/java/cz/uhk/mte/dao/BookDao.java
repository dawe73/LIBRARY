package cz.uhk.mte.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Book;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.service.AuthorService;
import cz.uhk.mte.service.BookService;
import cz.uhk.mte.utils.SearchService;

public class BookDao extends HibernateDaoSupport implements BookService,SearchService {

	@Override
	public void delete(Book book) {
		getHibernateTemplate().delete(book);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		return getHibernateTemplate().find("from Book");
	}

	@Override
	public Book getBookByID(int ID) {
		return (Book) getHibernateTemplate().get(Book.class, ID);
	}

	@Override
	public void insertBook(Book book) {
		getHibernateTemplate().saveOrUpdate(book);

	}

	@Override
	public void update(Book book) {
		insertBook(book);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getBooksByCategory(Category category) {
		return getHibernateTemplate().find("from Book b where b.category = ?", category);
	}

	@Override
	public List<Book> getBookByString(String search) {
		// TODO Auto-generated method stub
		return null;
	}

}


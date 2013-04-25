package cz.uhk.mte.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cz.uhk.mte.model.Book;
import cz.uhk.mte.service.BookService;


public class SearchServiceImpl implements SearchService {

	@Autowired
	SearchService bookDao;
	
	@Override
	public List<Book> getBookByString(String search) {
		return bookDao.getBookByString(search);
	}

	public SearchService getBookDao() {
		return bookDao;
	}

	public void setBookDao(SearchService bookDao) {
		this.bookDao = bookDao;
	}

	
	
}

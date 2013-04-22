package cz.uhk.mte.utils;

import java.util.List;

import cz.uhk.mte.model.Book;

public interface SearchService {

	public List<Book> getBookByString(String search);
}

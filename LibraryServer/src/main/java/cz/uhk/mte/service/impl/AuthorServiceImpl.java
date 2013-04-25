package cz.uhk.mte.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.service.AuthorService;
import cz.uhk.mte.service.CategoryService;

public class AuthorServiceImpl implements AuthorService {
	@Autowired
	private AuthorService authorDao;
	
	@Override
	public void delete(Author author) {
		authorDao.delete(author);
	}

	@Override
	public List<Author> getAllAuthors() {
		return authorDao.getAllAuthors();
	}

	@Override
	public Author getAuthorByID(int ID) {
		return authorDao.getAuthorByID(ID);
	}

	@Override
	public void insertAuthor(Author author) {
		authorDao.insertAuthor(author);

	}

	@Override
	public void update(Author author) {
		authorDao.insertAuthor(author);

	}

	public AuthorService getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(AuthorService authorDao) {
		this.authorDao = authorDao;
	}


	

	
	
}

package cz.uhk.mte.service;

import java.util.List;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.model.IEntity;

public interface AuthorService {

	public void delete(Author author);

	public List<Author> getAllAuthors();

	public Author getAuthorByID(int ID);

	public void insertAuthor(Author author);

	public void update(Author author);
	
}

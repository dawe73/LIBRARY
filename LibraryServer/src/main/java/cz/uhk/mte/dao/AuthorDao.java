package cz.uhk.mte.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cz.uhk.mte.model.Author;
import cz.uhk.mte.model.Category;
import cz.uhk.mte.service.AuthorService;

public class AuthorDao extends HibernateDaoSupport implements AuthorService {

	@Override
	public void delete(Author author) {
		getHibernateTemplate().delete(author);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> getAllAuthors() {
		return getHibernateTemplate().find("from Author");
	}

	@Override
	public Author getAuthorByID(int ID) {
		return (Author) getHibernateTemplate().get(Author.class, ID);
	}

	@Override
	public void insertAuthor(Author author) {
		getHibernateTemplate().saveOrUpdate(author);

	}

	@Override
	public void update(Author author) {
		insertAuthor(author);
	}


}

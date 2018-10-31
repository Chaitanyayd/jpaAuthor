package com.cg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.cg.bean.Author;
import com.cg.util.JPAUtil;

public class AuthorDaoImpl {

	EntityTransaction tran = null;
	EntityManager em = null;
	public AuthorDaoImpl(){
		em = JPAUtil.getEntityManager();
	}
	public Author addAuthor(Author at) {
		// TODO Auto-generated method stub	
		tran = em.getTransaction();
		tran.begin();
		em.persist(at);
		tran.commit();
		return at;
	}

	public List<Author> getAuthorById(int i) {
		// TODO Auto-generated method stub
		String selQry = "SELECT st FROM Author st";
		TypedQuery myQry = em.createQuery(selQry, Author.class);
		List<Author> autList = myQry.getResultList();
		return autList;
	}
	public Author updateAuthorName(int i, String string1, String string2,
			String string3, String string4) {
		// TODO Auto-generated method stub
		Author at = new Author();
		at.setAuthorId(i);
		at.setFirstName(string1);
		at.setMiddleName(string2);
		at.setLastName(string3);
		at.setPhoneNo(string4);
		tran.begin();
		em.merge(at);
		tran.commit();
		return at;
	}
	public Author deleteAuthor(int i) {
		// TODO Auto-generated method stub
		Author at = em.find(Author.class,i);
		tran.begin();
		em.remove(at);
		tran.commit();
		return at;
	}
	public List<Author> getAllAuthors() {
		// TODO Auto-generated method stub
		String selQry = "SELECT at FROM Author at";
		TypedQuery myQry = em.createQuery(selQry, Author.class);
		List<Author> autList = myQry.getResultList();
		return autList;
	}

}

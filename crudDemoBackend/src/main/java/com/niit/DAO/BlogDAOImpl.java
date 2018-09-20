package com.niit.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.models.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
public BlogDAOImpl() {
	System.out.println("BlogDAOImpl bean is created");
}
	
	
	public boolean addBlog(Blog blog) {

     sessionFactory.getCurrentSession().save(blog);
      return true;
		  }

	public boolean deleteBlog(Blog blog) {
		sessionFactory.getCurrentSession().delete(blog);
		return true;
	}

	public boolean updateBlog(Blog blog) {
		sessionFactory.getCurrentSession().update(blog);
		return true;
	}


	public List<Blog> getAll() {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog");
		List<Blog> blogs=query.list();
		
		return blogs;
	}


	public List<Blog> getByAuthorName(String blogAuthor) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where blogAuthor=:blogAuthor").setParameter("blogAuthor", blogAuthor);
		List<Blog> blogs=query.list();
		return blogs;
	}


	public Blog getByBlogId(int Id) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Blog where blogId=:blogId").setParameter("blogId", Id);
		Blog blogs=(Blog) query.list();
		return blogs;
	}

}

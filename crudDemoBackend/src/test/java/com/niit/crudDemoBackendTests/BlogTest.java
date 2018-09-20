package com.niit.crudDemoBackendTests;

import static org.junit.Assert.assertTrue;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DAO.BlogDAO;
import com.niit.models.Blog;

public class BlogTest {
	private static AnnotationConfigApplicationContext context=null;
	private static BlogDAO blogDAO=null;
	private Blog blog=null;
	

	@BeforeClass
	public static void setUpBeforeClass() {
		context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		blogDAO=(BlogDAO) context.getBean("blogDAO");
	}
	
	
	
	@Ignore
	@Test
	public void addBlogTest() {
		blog=new Blog();
		
		blog.setBlogTitle("Devops2");
		blog.setBlogContent("devops Description");
		blog.setBlogAuthor("Anshu");
		blog.setStatus("NA");
		blog.setCreatedDate(new Date());
		System.out.println("Blog details saved ");
		assertTrue("Could not save Blog details", blogDAO.addBlog(blog));
	}
	
	
	@Ignore
	@Test
	public void updateBlogTest() {
		
		blog=new Blog();
		blog.setBlogId(6);
		blog.setBlogTitle("Blog1");
		blog.setBlogContent("Blog Content");
		blog.setBlogAuthor("Anamika");
		blog.setStatus("A");
		blog.setCreatedDate(new Date());
		System.out.println("Blog deatils updated");
		assertTrue("could not update blog details", blogDAO.updateBlog(blog));
	}
	
	
	@Ignore
	@Test
	public void deleteBlogTest() {
		blog=new Blog();
		blog.setBlogId(6);
		assertTrue("Could not delete blog details", blogDAO.deleteBlog(blog));
	}
	
	
	@Test
	public void getAllTest() {
		List<Blog> blogs=blogDAO.getAll();
		assertTrue("Could not list the blog details", blogs.size()>0);
		for(Blog blogObj:blogs)
		{
			System.out.print(blogObj.getBlogId()+"::");
			System.out.print(blogObj.getBlogTitle()+"::");
			System.out.print(blogObj.getBlogContent()+"::");
			System.out.print(blogObj.getBlogAuthor()+"::");
			System.out.println(blogObj.getStatus()+"::");
		}
	}
	
	
}

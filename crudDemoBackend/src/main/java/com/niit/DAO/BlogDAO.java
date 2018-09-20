package com.niit.DAO;

import java.util.List;

import com.niit.models.Blog;

public interface BlogDAO {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public List<Blog> getAll();
	public List<Blog> getByAuthorName(String blogAuthor);
	public Blog getByBlogId(int Id);
}

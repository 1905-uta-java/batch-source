package com.company.delegates;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.model.News;
import com.company.services.NewsService;

public class NewsDelegate {
	private NewsService ns = new NewsService();
	
	//Get all the news information
	public List<News> getNewsInfo(HttpServletRequest request,HttpServletResponse response){
		
		return null;
	}
	
	//Create New News 
	public int createNews(HttpServletRequest request,HttpServletResponse response) {
		
		return 0;
	}
	
	//Update a current news
	public int updateNews(HttpServletRequest request,HttpServletResponse response) {
		
		return 0;
	}
	
	//Delete a news item
	public int deleteNews(HttpServletRequest request,HttpServletResponse response) {
		
		return 0;
	}
}

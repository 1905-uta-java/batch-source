package com.company.dao;

import java.util.List;

import com.company.model.News;

public interface NewsDao {
	public List<News> getNews();
	public int createNews(News n);
	public int updateNews(News n);
	public int deleteNews(int newsId);

}

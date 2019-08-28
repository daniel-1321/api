package com.coffee.management.service;

import com.coffee.management.entity.News;

import java.util.List;

public interface NewsService {
    News createNewNews(News news);
    List<News> getAllNews();

    News getNews(long id);

    void deleteNews(long id);

    void updateNews(News newNews, long id);
}

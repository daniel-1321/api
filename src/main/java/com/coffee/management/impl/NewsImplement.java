package com.coffee.management.impl;

import com.coffee.management.entity.News;
import com.coffee.management.repository.NewsRepository;
import com.coffee.management.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: NewsImplement.java
 */
@Service
@Transactional
public class NewsImplement implements NewsService {
    @Autowired
    NewsRepository newsRepository;
    @Override
    public News createNewNews(News news) {
        return newsRepository.save(news);
    }

    @Override
    public List<News> getAllNews() {
        return newsRepository.findAll();
    }

    @Override
    public News getNews(long id) {
        return newsRepository.getOne(id);
    }

    @Override
    public void deleteNews(long id) {
        newsRepository.deleteById(id);
    }

    @Override
    public void updateNews(News newNews, long id) {
        newsRepository.findById(id).map(news ->{
            news.setNws_title(newNews.getNws_title());
            news.setNws_content(newNews.getNws_content());
            news.setNws_image(  newNews.getNws_image());
            return  newsRepository.save(newNews);
        });
    }
}

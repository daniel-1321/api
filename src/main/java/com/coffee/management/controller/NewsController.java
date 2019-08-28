package com.coffee.management.controller;

import com.coffee.management.entity.News;
import com.coffee.management.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;

/**
 * Author: TiDi
 * Created on 16/08/2019.
 * Class: NewsController.java
 */
@CrossOrigin
@RestController
@RequestMapping("api/admin/news")
public class NewsController {
    @Autowired
    private NewsService newsService;

    @PostMapping
    public ResponseEntity<News> createNewNews (@Valid @RequestBody News news){
        News persistedNews = newsService.createNewNews(news);
        return new ResponseEntity<>(persistedNews, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<News>> getNews(){
        List<News> news = newsService.getAllNews();
        if (CollectionUtils.isEmpty(news)){
            throw new EntityNotFoundException();
        }
        return new ResponseEntity<>(news,HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<News> getNewsById(@PathVariable long id){
        News news = newsService.getNews(id);
        return new ResponseEntity<>(news, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<News> updateNews(@Valid @RequestBody News news, @PathVariable long id){
        newsService.updateNews(news,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<News> deleteNews(@PathVariable long id){
        newsService.deleteNews(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

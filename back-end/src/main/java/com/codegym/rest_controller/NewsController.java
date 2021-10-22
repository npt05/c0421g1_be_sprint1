package com.codegym.rest_controller;

import com.codegym.entity.about_news.News;
import com.codegym.service.news.INewsService;
import com.codegym.service.news.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private INewsService iNewsService;
    @Autowired
    private ITypeService iTypeService;

    @GetMapping(value = "/list")
    public ResponseEntity<List<News>> findAllNews() {
        List<News> newsList = this.iNewsService.findAll();

        if (newsList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(newsList, HttpStatus.OK);
    };

    @GetMapping(value = "/read/{id}")
    public ResponseEntity<News> findById(@PathVariable int id) {
        News readNews = this.iNewsService.getById(id);

        if (readNews == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(readNews, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        News deleteNews = this.iNewsService.getById(id);

        if (deleteNews != null) {
            this.iNewsService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

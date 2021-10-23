package com.codegym.service.news;

import com.codegym.entity.about_news.News;
import com.codegym.service.GeneralService;

import java.util.List;

public interface INewsService  {

    List<News> findAll();

    News findById(int id);

    void saveNews(News news);

    void deleteNews(int id);
}

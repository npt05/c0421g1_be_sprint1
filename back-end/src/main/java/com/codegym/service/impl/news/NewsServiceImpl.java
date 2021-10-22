package com.codegym.service.impl.news;

import com.codegym.entity.about_news.News;
import com.codegym.repository.news.INewsRepository;
import com.codegym.service.news.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements INewsService {

    @Autowired
    private INewsRepository iNewsRepository;

    @Override
    public List<News> findAll() {
        return this.iNewsRepository.findAllNews();
    }

    @Override
    public News getById(Integer id) {
        return this.iNewsRepository.findNewsById(id);
    }

    @Override
    public News save(News news) {
        this.iNewsRepository.save(news.getNewTitle(), news.getNewsBrief(), news.getNewsContent(), news.getImageUrl(), news.getPostDate(), news.getType().getTypeId());
        return null;
    }

    @Override
    public void delete(Integer id) {
        this.iNewsRepository.delete(id);
    }

    @Override
    public List<News> search(String search) {
        return null;
    }
}

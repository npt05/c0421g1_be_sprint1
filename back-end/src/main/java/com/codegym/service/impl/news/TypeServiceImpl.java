package com.codegym.service.impl.news;

import com.codegym.entity.about_news.Type;
import com.codegym.repository.news.ITypeRepository;
import com.codegym.service.news.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements ITypeService {

    @Autowired
    private ITypeRepository iTypeRepository;

    @Override
    public List<Type> findAll() {
        return this.iTypeRepository.getAllType();
    }

    @Override
    public Type getById(Integer id) {
        return null;
    }

    @Override
    public Type save(Type type) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public List<Type> search(String search) {
        return null;
    }
}

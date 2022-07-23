package com.halana.service.quizz.level;


import com.halana.model.quizz.Level;
import com.halana.repository.ILevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LevelService implements ILevelService{
    @Autowired
    ILevelRepository levelRepository;

    @Override
    public Iterable<Level> findAll() {
        return levelRepository.findAll();
    }

    @Override
    public Level save(Level level) {
        return levelRepository.save(level);
    }

    @Override
    public Optional<Level> findById(Long id) {
        return levelRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        levelRepository.deleteById(id);
    }
}

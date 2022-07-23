package com.halana.service.color;

import com.halana.model.color.Color;
import com.halana.repository.IColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ColorService implements IColorService{
    @Autowired
    private IColorRepository colorRepository;

    @Override
    public Iterable<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Color save(Color color) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }
}

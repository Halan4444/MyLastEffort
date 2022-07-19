package com.diosa.controller.quizz;


import com.diosa.model.quizz.Level;
import com.diosa.model.quizz.Test;
import com.diosa.service.quizz.level.ILevelService;
import com.diosa.service.quizz.test.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("levels")
public class LevelController {
    @Autowired
    private ITestService testService;

    @Autowired
    private ILevelService levelService;

    @GetMapping
    public ResponseEntity<Iterable<Level>> listLevel() {
        Iterable<Level> levels = levelService.findAll();
        if (levels != null) {
            return new ResponseEntity<>(levels, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}/tests")
    public ResponseEntity<Iterable<Test>> findTestByLevel(@PathVariable Optional<String> id) {
        Optional<Level> categoryOptional = levelService.findById(Long.valueOf(id.get()));
        Iterable<Test> tests = testService.findAllByLevel(categoryOptional.get());
        return new ResponseEntity<>(tests, HttpStatus.OK);
    }


}

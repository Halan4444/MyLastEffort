package com.halana.controller;

import com.halana.model.board.Board;
import com.halana.model.board.BoardResponse;
import com.halana.model.project.Project;
import com.halana.model.user.User;
import com.halana.model.user.UserPrinciple;
import com.halana.service.board.IBoardService;
import com.halana.service.project.IProjectService;
import com.halana.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/boards")
public class BoardController {

    @Autowired
    private IBoardService boardService;

    @Autowired
    private IProjectService projectService;

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<Iterable<Board>> getAll() {
        return new ResponseEntity<>(boardService.findAll(), HttpStatus.OK);
    }


    @GetMapping("/{id}/get-user")
    public ResponseEntity<List<User>> getAllUser(@PathVariable Long id) {
        List<User> users = userService.findAllByBoardId(id);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoardResponse> getBoard(@PathVariable Long id,
                                                  @RequestParam(required = false) String title,
                                                  Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        List<Project> projects = projectService.findProjectByUserId(userPrinciple.getId());
        Optional<Board> boardOptional = boardService.findById(id);
        for (Project project : projects) {
            if (project.getId().equals(boardOptional.get().getProject().getId())) {
                if (title != null && !title.isEmpty()) {
                    return new ResponseEntity<>(boardService.findByBoardIdAndTitleTask(id, title), HttpStatus.OK);
                }
                return new ResponseEntity<>(boardService.findBoardById(id), HttpStatus.OK);
            }
        }
        User user = new User();
        user.setId(userPrinciple.getId());
        List<Project> myProjects = projectService.findProjectByProjectOwner(user);
        for (Project project : myProjects) {
            if (project.getId().equals(boardOptional.get().getProject().getId())) {
                if (title != null && !title.isEmpty()) {
                    return new ResponseEntity<>(boardService.findByBoardIdAndTitleTask(id, title), HttpStatus.OK);
                }
                return new ResponseEntity<>(boardService.findBoardById(id), HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board) {
        return new ResponseEntity<>(boardService.save(board), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> editBoard(@PathVariable Long id, @RequestBody Board board) {
        Optional<Board> boardOptional = boardService.findById(id);
        if (!boardOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        board.setId(id);
        return new ResponseEntity<>(boardService.save(board),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Board> delete(@PathVariable Long id, Authentication authentication) {
        UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
        Optional<Board> boardOptional = boardService.findById(id);
        if (!boardOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        boardService.remove(id);
        return new ResponseEntity<>(boardOptional.get(), HttpStatus.OK);
    }

}
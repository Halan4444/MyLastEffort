package com.halana.service.board;

import com.halana.model.board.Board;
import com.halana.model.board.BoardResponse;
import com.halana.model.project.Project;
import com.halana.model.status.StatusResponse;
import com.halana.repository.IBoardRepository;
import com.halana.service.label.ILabelService;
import com.halana.service.status.IStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BoardService implements IBoardService{

    @Autowired
    private IBoardRepository boardRepository;

    @Autowired
    private IStatusService statusService;

    @Autowired
    private ILabelService labelService;

    @Override
    public Iterable<Board> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardRepository.findById(id);
    }

    @Override
    public Board save(Board board) {
        return boardRepository.save(board);
    }

    @Override
    public void remove(Long id) {
        labelService.deleteAllByBoardId(id);
        statusService.deleteAllByBoardId(id);
        boardRepository.deleteById(id);
    }

    @Override
    public List<Board> findAllByProjectId(Long projectId) {
        return boardRepository.findAllByProjectId(projectId);
    }

    @Override
    public Board saveBoardResponse(BoardResponse boardResponse, Long projectId) {
        Project project = new Project();
        project.setId(projectId);
        Board board = new Board();
        board.setId(boardResponse.getId());
        board.setTitle(boardResponse.getTitle());
        board.setProject(project);
        return boardRepository.save(board);
    }

    @Override
    public BoardResponse findBoardById(Long boardId) {
        Board board =  boardRepository.findById(boardId).get();
        return convertToBoardResponse(board);
    }

    @Override
    public BoardResponse findByBoardIdAndTitleTask(Long boardId, String title) {
        Board board =  boardRepository.findById(boardId).get();
        return convertToBoardResponse(board, title);
    }

    private BoardResponse convertToBoardResponse(Board board, String title) {
        BoardResponse boardResponse = new BoardResponse();
        boardResponse.setId(board.getId());
        boardResponse.setTitle(board.getTitle());
        boardResponse.setProject(board.getProject().getId());
        List<StatusResponse> statusResponses = statusService.findByBoardIdAndTitleTask(board.getId(), title);
        Set<StatusResponse> statusResponseSet = new LinkedHashSet<>();
        for(StatusResponse statusResponse : statusResponses) {
            statusResponseSet.add(statusResponse);
        }
        boardResponse.setStatuses(statusResponseSet);
        return boardResponse;
    }

    private BoardResponse convertToBoardResponse(Board board) {
        List<StatusResponse> statusResponses = statusService.findByBoardId(board.getId());
        Set<StatusResponse> statusResponseSet = new LinkedHashSet<>();
        for (StatusResponse statusResponse : statusResponses) {
            statusResponseSet.add(statusResponse);
        }
        BoardResponse boardResponse = new BoardResponse();
        boardResponse.setId(board.getId());
        boardResponse.setTitle(board.getTitle());
        boardResponse.setProject(board.getProject().getId());
        boardResponse.setStatuses(statusResponseSet);
        return boardResponse;
    }
}

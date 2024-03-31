package com.example.hecto_project.repository;

import com.example.hecto_project.domain.Board;
import com.example.hecto_project.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private final BoardMapper mapper;


    public List<Board> findAll() {
        return mapper.findAll();
    }

    public Board findById(Long id) {
        return mapper.findById(id);
    }

    public void save(Board board) {
        mapper.save(board);
    }

    public int update(Board board) {
        return mapper.update(board);
    }

    public int delete(Long id) {
        return mapper.delete(id);
    }

    public List<Board> selectBoardList(int pageStart, int pageEnd) {
        return mapper.selectBoardList(pageStart, pageEnd);
    }
}

package com.example.hecto_project.app;

import com.example.hecto_project.domain.Board;
import com.example.hecto_project.dto.BoardDTO;
import com.example.hecto_project.dto.BoardUpdateDTO;
import com.example.hecto_project.dto.IdxDTO;
import com.example.hecto_project.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service

@RequiredArgsConstructor
public class appService {

    private final BoardRepository boardRepository;

    public Flux<String> fluxCall(Integer time) {
        WebClient client = WebClient.create();

        if (time == null || time == 0)
            time = 5;

       return  Flux.range(1, time)
                .delayElements(Duration.ofSeconds(1))
                .flatMap(i -> client.get()
                        .uri("http://date.jsontest.com/")
                        .retrieve()
                        .bodyToMono(String.class));
    }

    public Mono<String> monoCall() {
        WebClient client = WebClient.create();

        return client.get()
                .uri("http://date.jsontest.com/")
                .retrieve()
                .bodyToMono(String.class);
    }

    public Board insertBoard(BoardDTO dto) {
        Board board = Board.of(dto.getContent());
        boardRepository.save(board);
        return board;

    }

    public Board updateBoard(BoardUpdateDTO dto) throws NotFoundException {

        Board board = boardRepository.findById(dto.getId());
        if (board == null) {
            throw new NotFoundException("게시물 Id를 확인해주세요");
        }
        board.setContent(dto.getContent());
        boardRepository.update(board);
        return board;
    }

    public String deleteBoard(IdxDTO dto) throws NotFoundException {

        Board board = boardRepository.findById(dto.getId());
        if (board == null) {
            throw new NotFoundException("게시물 Id를 확인해주세요");
        }

        boardRepository.delete(dto.getId());
        return "삭제완료";
    }

    public List<Board> selectBoard(int pageSize, int pageNum) {
        int pageStart = 0, pageEnd = 0;
        pageStart = (pageNum -1) * pageSize;
        pageEnd = pageSize;

        return boardRepository.selectBoardList(pageStart, pageEnd);
    }
}
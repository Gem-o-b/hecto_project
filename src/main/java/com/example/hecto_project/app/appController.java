package com.example.hecto_project.app;

import com.example.hecto_project.dto.BoardDTO;
import com.example.hecto_project.dto.BoardUpdateDTO;
import com.example.hecto_project.dto.IdxDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import com.example.hecto_project.domain.Board;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class appController {

    private final appService appService;

    @GetMapping("/flux")
    public Flux<String> getDates(@RequestParam(required = false) Integer time) {

        return appService.fluxCall(time);
    }

    @GetMapping("/mono")
    public Mono<String> getDate() {

        return appService.monoCall();
    }

    @PostMapping("/board")
    public Mono<Board> insertBoard(@RequestBody @Valid BoardDTO dto){

        return Mono.just(appService.insertBoard(dto));

    }

    @PutMapping("/board")
    public Mono<Board> updateBoard(@RequestBody @Valid BoardUpdateDTO dto) throws NotFoundException {

        return Mono.just(appService.updateBoard(dto));

    }

    @DeleteMapping("/board")
    public Mono<String> deleteBoard(@RequestBody @Valid IdxDTO dto) throws NotFoundException {

        return Mono.just(appService.deleteBoard(dto));

    }

    @GetMapping("/board")
    public Mono<List<Board>> selectBoard(@RequestParam int pageSize, @RequestParam int pageNum) throws NotFoundException {

        return Mono.just(appService.selectBoard(pageSize, pageNum));

    }


}
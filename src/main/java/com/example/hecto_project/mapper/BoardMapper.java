package com.example.hecto_project.mapper;

import com.example.hecto_project.domain.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BoardMapper {
    @Select("SELECT * FROM board")
    List<Board> findAll();

    @Select("SELECT * FROM board WHERE id=#{id}")
    Board findById(@Param("id") Long id);

    @Insert("INSERT INTO board (content) VALUES (#{content})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(Board board);

    @Update("UPDATE board SET content = #{content} WHERE id = #{id}")
    int update(Board board);

    @Delete("DELETE FROM board WHERE id = #{id}")
    int delete(Long id);

    @Select("SELECT * FROM board ORDER BY id DESC LIMIT #{pageStart}, #{pageEnd}")
    List<Board> selectBoardList(int pageStart, int pageEnd);

}




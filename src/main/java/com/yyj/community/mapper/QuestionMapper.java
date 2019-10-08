package com.yyj.community.mapper;

import com.yyj.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,tag,creator) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{tag},#{creator})")
    void create(Question question);

    @Select("select * from question limit #{offset},#{size}")
    List<Question> getList(@RequestParam(name = "offset") Integer offset, @RequestParam(name = "size") Integer size);

    @Select("select count(1) from question")
    Integer countQuestion();

    @Select("select * from question creator = #{userId} limit #{offset},#{size}")
    List<Question> list(@RequestParam(name = "userId") Integer userId, @RequestParam(name = "offset") Integer offset, @RequestParam(name = "size") Integer size);
}

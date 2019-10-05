package com.yyj.community.service;

import com.yyj.community.dto.QuestionDTO;
import com.yyj.community.mapper.QuestionMapper;
import com.yyj.community.mapper.UserMapper;
import com.yyj.community.model.Question;
import com.yyj.community.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    UserMapper userMapper;
    @Autowired
    QuestionMapper questionMapper;

    public List<QuestionDTO> getList(){
        List<Question> questionList = questionMapper.getList();
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for(Question question : questionList){
            User user = userMapper.findUserById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question,questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        return questionDTOList;
    }
}

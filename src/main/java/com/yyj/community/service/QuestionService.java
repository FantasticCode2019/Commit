package com.yyj.community.service;

import com.yyj.community.dto.PaginationDTO;
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

    public PaginationDTO getList(Integer page, Integer size) {
        Integer totalCount = questionMapper.countQuestion();
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.getList(offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
            User user = userMapper.findUserById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }

    public PaginationDTO list(Integer userId, Integer page, Integer size) {
        Integer totalCount = questionMapper.countQuestion();
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setPagination(totalCount, page, size);
        if (page < 1) {
            page = 1;
        }
        if (page > paginationDTO.getTotalPage()) {
            page = paginationDTO.getTotalPage();
        }
        Integer offset = size * (page - 1);
        List<Question> questionList = questionMapper.list(userId, offset, size);
        List<QuestionDTO> questionDTOList = new ArrayList<>();
        for (Question question : questionList) {
            User user = userMapper.findUserById(question.getCreator());
            QuestionDTO questionDTO = new QuestionDTO();
            BeanUtils.copyProperties(question, questionDTO);
            questionDTO.setUser(user);
            questionDTOList.add(questionDTO);
        }
        paginationDTO.setQuestions(questionDTOList);
        return paginationDTO;
    }
}

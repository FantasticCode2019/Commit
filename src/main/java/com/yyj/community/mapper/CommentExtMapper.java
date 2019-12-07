package com.yyj.community.mapper;

import com.yyj.community.model.Comment;

public interface CommentExtMapper {
    int incCommentCount(Comment comment);
}
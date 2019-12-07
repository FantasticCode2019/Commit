package com.yyj.community.dto;

import lombok.Data;

import java.util.List;

/**
 * Created by on 2019/6/5.
 */
@Data
public class TagDTO {
    //分类名
    private String categoryName;
    //一个分类名下的所属标签
    private List<String> tags;
}

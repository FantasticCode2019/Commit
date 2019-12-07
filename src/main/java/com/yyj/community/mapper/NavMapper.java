package com.yyj.community.mapper;

import com.yyj.community.model.Nav;
import com.yyj.community.model.NavExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface NavMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    long countByExample(NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int deleteByExample(NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int insert(Nav record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int insertSelective(Nav record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    List<Nav> selectByExampleWithRowbounds(NavExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    List<Nav> selectByExample(NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    Nav selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByExampleSelective(@Param("record") Nav record, @Param("example") NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByExample(@Param("record") Nav record, @Param("example") NavExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByPrimaryKeySelective(Nav record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table NAV
     *
     * @mbg.generated Thu Sep 05 06:46:42 CST 2019
     */
    int updateByPrimaryKey(Nav record);
}
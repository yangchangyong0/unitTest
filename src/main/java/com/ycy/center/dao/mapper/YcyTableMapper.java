package com.ycy.center.dao.mapper;

import com.ycy.center.dao.entity.YcyTable;
import com.ycy.center.dao.entity.YcyTableExample;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface YcyTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int countByExample(YcyTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int deleteByExample(YcyTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int insert(YcyTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int insertSelective(YcyTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    List<YcyTable> selectByExample(YcyTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    YcyTable selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int updateByExampleSelective(@Param("record") YcyTable record, @Param("example") YcyTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int updateByExample(@Param("record") YcyTable record, @Param("example") YcyTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int updateByPrimaryKeySelective(YcyTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ycy_table
     *
     * @mbggenerated Wed Jul 20 01:22:03 CST 2016
     */
    int updateByPrimaryKey(YcyTable record);
}
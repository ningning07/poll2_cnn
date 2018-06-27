package com.briup.apps.poll.dao;

import com.briup.apps.poll.bean.Qq;
import com.briup.apps.poll.bean.QqExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QqMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    long countByExample(QqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int deleteByExample(QqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int insert(Qq record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int insertSelective(Qq record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    List<Qq> selectByExample(QqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    Qq selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int updateByExampleSelective(@Param("record") Qq record, @Param("example") QqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int updateByExample(@Param("record") Qq record, @Param("example") QqExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int updateByPrimaryKeySelective(Qq record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table poll_qq
     *
     * @mbg.generated Wed Jun 27 10:22:48 CST 2018
     */
    int updateByPrimaryKey(Qq record);
}
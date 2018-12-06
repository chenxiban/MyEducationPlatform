package com.cxb.cyj.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

import com.cxb.cyj.model.Shipin;

@Mapper
@Component
public interface ShiPinDao {

    //插入
    @Insert({"INSERT INTO shipins (url,NAME,lujing) VALUES (#{url},#{name},#{lujing})"})
    public int insertUrl(@Param("name")String name,@Param("lujing")String lujing,@Param("url")String url);

    //查询
    @Select("select * from shipins")
    public List<Shipin> selectShipin();
}

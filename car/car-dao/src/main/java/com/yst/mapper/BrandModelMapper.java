package com.yst.mapper;

import com.yst.pojo.BrandModel;
import com.yst.pojo.BrandModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BrandModelMapper {
    int countByExample(BrandModelExample example);

    int deleteByExample(BrandModelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BrandModel record);

    int insertSelective(BrandModel record);

    List<BrandModel> selectByExample(BrandModelExample example);

    BrandModel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BrandModel record, @Param("example") BrandModelExample example);

    int updateByExample(@Param("record") BrandModel record, @Param("example") BrandModelExample example);

    int updateByPrimaryKeySelective(BrandModel record);

    int updateByPrimaryKey(BrandModel record);
}
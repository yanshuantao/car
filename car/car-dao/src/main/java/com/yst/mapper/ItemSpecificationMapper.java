package com.yst.mapper;

import com.yst.pojo.ItemSpecification;
import com.yst.pojo.ItemSpecificationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemSpecificationMapper {
    int countByExample(ItemSpecificationExample example);

    int deleteByExample(ItemSpecificationExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ItemSpecification record);

    int insertSelective(ItemSpecification record);

    List<ItemSpecification> selectByExampleWithBLOBs(ItemSpecificationExample example);

    List<ItemSpecification> selectByExample(ItemSpecificationExample example);

    ItemSpecification selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ItemSpecification record, @Param("example") ItemSpecificationExample example);

    int updateByExampleWithBLOBs(@Param("record") ItemSpecification record, @Param("example") ItemSpecificationExample example);

    int updateByExample(@Param("record") ItemSpecification record, @Param("example") ItemSpecificationExample example);

    int updateByPrimaryKeySelective(ItemSpecification record);

    int updateByPrimaryKeyWithBLOBs(ItemSpecification record);

    int updateByPrimaryKey(ItemSpecification record);
}
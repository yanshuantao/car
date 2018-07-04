package com.yst.mapper;

import com.yst.pojo.ItemBrandModel;
import com.yst.pojo.ItemBrandModelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemBrandModelMapper {
    int countByExample(ItemBrandModelExample example);

    int deleteByExample(ItemBrandModelExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ItemBrandModel record);

    int insertSelective(ItemBrandModel record);

    List<ItemBrandModel> selectByExample(ItemBrandModelExample example);

    ItemBrandModel selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ItemBrandModel record, @Param("example") ItemBrandModelExample example);

    int updateByExample(@Param("record") ItemBrandModel record, @Param("example") ItemBrandModelExample example);

    int updateByPrimaryKeySelective(ItemBrandModel record);

    int updateByPrimaryKey(ItemBrandModel record);
    
    String getBrandName(long id);
}
package com.ten.air.back.dao;

import com.ten.air.back.entity.AirRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AirRecordDao {

    int insert(@Param("pojo") AirRecord pojo);

    int insertList(@Param("pojos") List<AirRecord> pojo);

    List<AirRecord> select(@Param("pojo") AirRecord pojo);

    int update(@Param("pojo") AirRecord pojo);

}

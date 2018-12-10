package com.ten.air.back.service;

import com.ten.air.back.entity.AirRecord;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.ten.air.back.dao.AirRecordDao;

@Service
public class AirRecordService {

    @Resource
    private AirRecordDao airRecordDao;

    public int insert(AirRecord pojo){
        return airRecordDao.insert(pojo);
    }

    public int insertList(List< AirRecord> pojos){
        return airRecordDao.insertList(pojos);
    }

    public List<AirRecord> select(AirRecord pojo){
        return airRecordDao.select(pojo);
    }

    public int update(AirRecord pojo){
        return airRecordDao.update(pojo);
    }

}

package com.ten.air.back.service;

import com.ten.air.back.entity.AirDevice;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import com.ten.air.back.dao.AirDeviceDao;

@Service
public class AirDeviceService {

    @Resource
    private AirDeviceDao airDeviceDao;

    public int insert(AirDevice pojo){
        return airDeviceDao.insert(pojo);
    }

    public int insertList(List< AirDevice> pojos){
        return airDeviceDao.insertList(pojos);
    }

    public List<AirDevice> select(AirDevice pojo){
        return airDeviceDao.select(pojo);
    }

    public int update(AirDevice pojo){
        return airDeviceDao.update(pojo);
    }

}

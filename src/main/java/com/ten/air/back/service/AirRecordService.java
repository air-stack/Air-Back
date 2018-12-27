package com.ten.air.back.service;

import com.ten.air.back.entity.AirRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import com.ten.air.back.dao.AirRecordDao;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AirRecordService {

    @Resource
    private AirRecordDao airRecordDao;

    public int insert(AirRecord pojo) {
        return airRecordDao.insert(pojo);
    }

    public int insertList(List<AirRecord> pojos) {
        return airRecordDao.insertList(pojos);
    }

    public List<AirRecord> select(AirRecord pojo) {
        return airRecordDao.select(pojo);
    }

    @Transactional
    public AirRecord selectLast() {
        List<AirRecord> result = airRecordDao.selectLast();
        AirRecord last = new AirRecord();
        last.setImei(result.get(0).getImei());

        result.forEach((item) -> {
            if (!"0.0".equals(item.getTemperature())) {
                last.setTemperature(item.getTemperature());
            }
            if (!"0.0".equals(item.getHumidity())) {
                last.setHumidity(item.getHumidity());
            }
            if (!"0".equals(item.getPm25())) {
                last.setPm25(item.getPm25());
            }
        });

        return last;
    }

    public int update(AirRecord pojo) {
        return airRecordDao.update(pojo);
    }

}

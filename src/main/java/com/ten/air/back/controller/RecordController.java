package com.ten.air.back.controller;

import com.ten.air.back.model.ResponseCode;
import com.ten.air.back.model.ResultModel;
import com.ten.air.back.service.AirRecordService;
import com.ten.air.back.entity.AirRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Record 记录控制器
 */
@RestController
@RequestMapping(value = "/air/record")
public class RecordController extends BaseController<AirRecord> {
    private static final Logger logger = Logger.getLogger("Record");

    private final AirRecordService service;

    @Autowired
    public RecordController(AirRecordService service) {
        this.service = service;
    }

    /**
     * 获取AirRecord记录信息
     */
    @Override
    public ResultModel get(AirRecord airRecord) {
        logger.info("RECORD GET :" + airRecord);

        // 设置查询条件
        airRecord.setIsDeleted(NO_DELETED);

        List<AirRecord> recordList = service.select(airRecord);
        return new ResultModel(ResponseCode.OK, recordList);
    }

    /**
     * 创建新的AirRecord记录信息
     */
    @Override
    public ResultModel post(@RequestBody AirRecord airRecord) {
        logger.info("RECORD POST :" + airRecord);

        // 新增记录属性
        airRecord.setRecordTime(timeGenerator.currentTime());
        airRecord.setIsDeleted(0);

        Integer result = service.insert(airRecord);
        if (result > 0) {
            return new ResultModel(ResponseCode.OK, airRecord);
        }
        return new ResultModel(ResponseCode.ERROR, airRecord);
    }

    /**
     * TODO 更新
     */
    @Override
    public ResultModel update(AirRecord airRecord) {
        logger.info("RECORD UPDATE :" + airRecord);
        Integer result = service.update(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }

    /**
     * TODO 删除
     */
    @Override
    public ResultModel delete(AirRecord airRecord) {
        logger.info("RECORD DELETE :" + airRecord);
        Integer result = service.update(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }
}

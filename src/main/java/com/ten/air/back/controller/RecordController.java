package com.ten.air.back.controller;

import com.ten.air.back.entity.AirRecord;
import com.ten.air.back.model.ResponseCode;
import com.ten.air.back.model.ResultModel;
import com.ten.air.back.service.AirRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/air/record")
public class RecordController extends BaseController<AirRecord> {
    private static final Logger logger = Logger.getLogger("Record");

    private final AirRecordService service;

    @Autowired
    public RecordController(AirRecordService service) {
        this.service = service;
    }

    @Override
    public ResultModel get(AirRecord airRecord) {
        logger.info("RECORD GET :" + airRecord);
        List<AirRecord> recordList = service.select(airRecord);
        return new ResultModel(ResponseCode.OK, recordList);
    }

    @Override
    public ResultModel post(@RequestBody AirRecord airRecord) {
        logger.info("RECORD POST :" + airRecord);
        Integer result = service.insert(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }

    @Override
    public ResultModel update(AirRecord airRecord) {
        logger.info("RECORD UPDATE :" + airRecord);
        Integer result = service.update(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }

    @Override
    public ResultModel delete(AirRecord airRecord) {
        logger.info("RECORD DELETE :" + airRecord);
        Integer result = service.update(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }
}

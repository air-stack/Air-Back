package com.ten.air.back.controller;

import com.ten.air.back.entity.AirDevice;
import com.ten.air.back.entity.AirRecord;
import com.ten.air.back.model.ResponseCode;
import com.ten.air.back.model.ResultModel;
import com.ten.air.back.service.AirRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/air/record")
public class RecordController extends BaseController<AirRecord> {

    private final AirRecordService service;

    @Autowired
    public RecordController(AirRecordService service) {
        this.service = service;
    }

    @Override
    public ResultModel get(AirRecord airRecord) {
        List<AirRecord> recordList = service.select(airRecord);
        return new ResultModel(ResponseCode.OK, recordList);
    }

    @Override
    public ResultModel post(AirRecord airRecord) {
        Integer result = service.insert(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }

    @Override
    public ResultModel update(AirRecord airRecord) {
        Integer result = service.update(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }

    @Override
    public ResultModel delete(AirRecord airRecord) {
        Integer result = service.update(airRecord);
        return new ResultModel(ResponseCode.OK, result);
    }
}

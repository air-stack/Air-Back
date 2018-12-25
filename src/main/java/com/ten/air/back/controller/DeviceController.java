package com.ten.air.back.controller;

import com.ten.air.back.entity.AirDevice;
import com.ten.air.back.model.ResponseCode;
import com.ten.air.back.model.ResultModel;
import com.ten.air.back.service.AirDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;

/**
 * Device 设备控制器
 */
@RestController
@RequestMapping(value = "/air/device")
public class DeviceController extends BaseController<AirDevice> {
    private static final Logger logger = Logger.getLogger("Device");

    private final AirDeviceService service;

    @Autowired
    public DeviceController(AirDeviceService service) {
        this.service = service;
    }

    /**
     * 获取AirDevice设备信息
     */
    @Override
    public ResultModel get(AirDevice airDevice) {
        logger.info("DEVICE GET :" + airDevice);

        // 设置查询条件
        airDevice.setIsDeleted(NO_DELETED);

        List<AirDevice> deviceList = service.select(airDevice);
        return new ResultModel(ResponseCode.OK, deviceList);
    }

    /**
     * 创建新的AirDevice设备信息
     */
    @Override
    public ResultModel post(@RequestBody AirDevice airDevice) {
        logger.info("DEVICE POST :" + airDevice);

        // 新增设备属性
        airDevice.setAlias("新增嵌入式设备");
        airDevice.setDeviceStatus(0);
        airDevice.setBjCreateTime(timeGenerator.currentTime());
        airDevice.setIsDeleted(0);

        Integer result = service.insert(airDevice);
        if (result > 0) {
            return new ResultModel(ResponseCode.OK, airDevice);
        }
        return new ResultModel(ResponseCode.ERROR, airDevice);
    }

    /**
     * TODO 更新记录信息
     */
    @Override
    public ResultModel update(AirDevice airDevice) {
        logger.info("DEVICE UPDATE :" + airDevice);
        Integer result = service.update(airDevice);
        return new ResultModel(ResponseCode.OK, result);
    }

    /**
     * TODO 删除
     */
    @Override
    public ResultModel delete(AirDevice airDevice) {
        logger.info("DEVICE DELETE :" + airDevice);
        Integer result = service.update(airDevice);
        return new ResultModel(ResponseCode.OK, result);
    }
}

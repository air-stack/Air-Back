-- auto Generated on 2018-11-29 09:22:25 
-- DROP TABLE IF EXISTS `air_record`; 
CREATE TABLE air_record(
    `id` INTEGER(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
    `source` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'Device Source 设备来源 0:真机 1:虚拟',
    `imei` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'Record Imei 记录设备',
    `temperature` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'Temperature 温度',
    `humidity` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'Humidity 湿度',
    `pm25` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'PM 2.5 Concentration PM25浓度',
    `undefined_data` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'Undefined data 待定义数据',
    `record_time` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'Record Time 记录时间',
    `update_time` VARCHAR(50) NOT NULL DEFAULT '' COMMENT 'updateTime',
    `is_deleted` INTEGER(12) NOT NULL DEFAULT -1 COMMENT 'is deleted 0:n 1:y',
    PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT 'air_record';

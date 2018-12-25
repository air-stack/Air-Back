# Air Back

> 基于SpringBoot搭建后台数据交互服务，对外提供REST接口调用，基于Mybatis实现数据操作。

## 技术栈

> SpringBoot + Mybatis

## REST API

设备 "/air/device"

记录 "/air/record"

## 调用者

[Air-Server](https://github.com/kevinten10/Air-Server)：发送HTTP请求到BACK服务

## 使用

```txt
# 1. 下载项目到本地
# git clone https://github.com/kevinten10/Air-Back.git

# 2. 创建数据库 resources/sql

# 3. 配置数据库 application.yml

# 5. 启动项目 8090端口
```

## 服务器部署

1. 打包成JAR

File -> Project Structure -> Artifacts -> Add -> JAR -> from modules with dependencies

配置“Directory for META-INF/MAINFEST.MF”，此项配置的缺省值是：..Project\src\main\java，需要改成：..Project(项目目录)

选择“Build - Build Artifacts”下的“Build”或者“Rebuild”即可生成最终的可运行的jar，在..\Project\out\artifacts\Project_jar下面找到生成的目标jar，(JAR名与项目名相同的一项)

2. 配置JAR

打开JAR，找到META-INF/MAINFEST.MF文件，检查 "Main-Class" 配置是否正确

正确配置为 Main-Clas: com...(包名)...AirBackApplication(main函数类)

3. 上传JAR

通过winscp工具上传jar所在文件到服务器中

运行 

    java -jar project.jar (即运行主JAR包)
    
检查是否启动成功

### 快速部署

已将打包好的jar包放在目录下，将Air_Back_jar拷贝到服务器文件下即可，进入目录，输入

    java -jar Air-Back.jar
    
即可运行服务
## 系统简介

LibraryDemo是一个简单的图书管理系统（只有后端接口），有完整的项目框架（登录、权限控制、日志、缓存、数据库、swagger、基于环境的配置分离等），但是只实现了对图书的基本增删改查。所以与其说是系统不如说一个web项目的基础模板。

## 技术选型

Spring boot、Mybatis、Sa-Token、Swagger、log4j2

## 开发环境

语言：Java 8

依赖管理：Maven 3.6

数据库：MySQL 5.7

缓存：Redis 3.2

版本管理：git

## 启动方式

1、在MySQL执行script目录下的sql脚本

2、在application.yml修改端口和选择环境启动（默认8080端口，开发环境。dev为开发环境，prod为生产环境。生产环境禁用了swagger，开发环境不会将日志写入磁盘）

3、系统存在三个账号：
    超级管理员(username:root pwd:与账号一样，下同)：系统最高权限，但是由于没有开发用户管理模块，所以权限跟图书管理员一样。
    图书管理员(bookManager):能够对图书进行增删改查。
    普通用户(test1):只能够查询，不能增删改。
# SchoolLink学校管理系统
基于springboot的简易学生管理系统  
[vue前端仓库地址](https://gitee.com/weiyin2002/schoollink-front)
## 技术栈和版本
### 主要技术栈
主要技术栈和对应版本如下：  

| 名称    | 版本     |
|-------|--------|
| Vue   | 2.7.6  |
| MySQL | 8.0.31 |

### 框架使用
项目使用的主要框架技术如下：

| 名称           | 介绍                              | 文档地址                                       |
|--------------|---------------------------------|--------------------------------------------| 
| Mybatis-Plus | 基于mybatis的增强持久层框架，减少编码，快速拼接查询语句 | [mybatis-plus](https://baomidou.com/)      |
| Swagger      | 快速生成API文档                       | [swagger](https://swagger.io/)             |
| Sa-Token     | 快速实现鉴权功能                        | [Sa-Token](https://sa-token.cc/index.html) |
| flyway       | 数据库版本同步                         | [flyway](https://flywaydb.org/)            |
| logback      | 日志                              | 略                                          |
| lombok       | 快速生成javaBean代码                  | 略                                          |

## 基本使用
### 开发环境使用
#### 配置数据库环境  
修改`application-dev.yml`中的数据库账号密码
```yaml
spring:
  datasource:
    password: root
    username: root
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/schoollink?&useSSL=false&serverTimezone=UTC
...
```
在本地数据库中新建库
```mysql
create database schoollink
```
随后即可启动。
#### 启动项目  
运行`SchoollinkDevApplication.java`即可启动项目，数据库会通过flyway框架自动同步  
在不修改其他任何配置的情况下，通过**开发环境配置**启动，访问[localhost:8090/swagger-ui/index.html](localhost:8090/swagger-ui/index.html)
可以打开swagger api信息页面
### 生产环境使用
在`application.yml`中，可以切换生产环境配置启动
```yaml
spring:
  profiles:
    active: dev # 开发环境
#    active: prod # 生产环境
```
在生产环境中会有如下变化：
- swagger页面被禁用
- 日志被配置为INFO级别
- token的有效期受限，且不能再多账号登录  

其他功能方面没有差别。
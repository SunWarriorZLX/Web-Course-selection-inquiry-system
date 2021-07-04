# 工程简介
网络程序课程实验，基于 SpringBoot+Mysql+MVC+BootStrap4.6.0 的选课查询系统，实现简单的用户登录、登出、选课查询等功能
# 系统界面
### 登录界面
![登录界面](/images/登录界面.jpg)
### 查询界面
![查询界面](/images/查询界面.jpg)
# 安装与使用
运行此项目需要`mysql`和`redis`环境
数据库配置完成后，在`mysql`中导入`database`文件夹下的`sql`脚本
###修改配置文件`application.properties`
```properties
# 数据库连接地址
spring.datasource.url=

# 数据库用户名&密码：
spring.datasource.username=
spring.datasource.password=

#设置 Spring Session 使用 Redis 进行存储
#此处redis采用默认配置，可根据您的环境进行修改
spring.session.store-type=redis
```
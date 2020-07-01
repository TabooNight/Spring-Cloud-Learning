# Spring-Cloud-Learning

## 1. scl-eureka-server

需在hosts文件中添加如下配置

```
127.0.0.1 test1
127.0.0.1 test2
127.0.0.1 test3
```

## 2. scl-hystrix-dashboard

Hystrix Dashboard可视化监控数据

新版本的Hystrix Dashboard源码存在问题，需要修改如下内容才可正常展示监控图表

* 用解压缩工具打开maven本地仓库里的spring-cloud-netflix-hystrix-dashboard-2.2.3.RELEASE.jar文件，找到`templates.hystrix/monitor.ftlh`文件并打开
* 将文件里所有的`$(window).load(function() {`修改为`$(window).on("load", function() {`
* 将更改后的文件重新打成jar包
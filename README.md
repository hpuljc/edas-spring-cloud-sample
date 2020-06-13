# Spring cloud demo for EDAS
>1.  edas-api：通用接口依赖，定义微服务接口
>2.  edas-producer：注册中心及负载均衡示例，简单服务提供者
>3.  edas-consumer：注册中心、负载均衡及配置中心示例，简单服务消费者
>4.  edas-gateway：网关示例，spring cloud gateway
>5.  edas-sentinel：限流降级示例
>6.  alibaba-sentinel：sentinel-dashboard构建项目

此项目需要安装[Docker](https://www.docker.com/products/docker-desktop)。

## edas-api
定义了接口，方便服务提供者与服务消费者调用。

## 注册中心演示
使用nacos作为注册中心。

### 启动注册中心
执行以下命令启动注册中心

```text
> git clone --depth 1 https://github.com/nacos-group/nacos-docker.git
> cd nacos-docker
> docker-compose -f example/standalone-derby.yaml up
```

默认端口为8848。

### 启动项目进行注册
启动edas-producer，成功后，打开
> http://127.0.0.1:8848/nacos/ 

查看服务是否已注册。可不同端口启动多个。

## 负载均衡演示
前流程如上，此时需要启动多个edas-producer，然后启动edas-consumer。访问:
> http://127.0.0.1:8081/feign?name=test

或
> http://127.0.0.1:8081/rest?name=test

刷新，可以看到此时负载均衡生效。

## 配置中心演示
前流程如上，此时只需打开nacos配置管理页面，配置。
dataid: consumer.yml
格式：yaml
内容为：
```yaml
refresh:
  name: zhangsan
```
访问:
> http://127.0.0.1:8081/refresh

查看返回值。然后修改内容中name属性的值，再次刷新页面，看返回值是否是更改后的值。

## 网关演示
注意网关默认使用8083接口，如上述流程已使用8083，请自行更改，以下流程使用默认端口。
启动edas-gateway，访问：
> http://127.0.0.1:8083/test/hello/word

查看返回值。

## 限流与降级演示
使用阿里开源sentinel进行限流与降级。

### 启动sentinel-dashboard
sentinel支持图形化配置限流降级，需要sentinel-dashboard server进行配置。

#### docker启动
在alibaba-sentinel根目录下执行以下命令完成启动：
> docker-compose up
 
#### jar启动
在alibaba-sentinel根目录下执行以下命令完成启动：
> java -Dserver.port=7777 -Dcsp.sentinel.dashboard.server=localhost:7777 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.6.0.jar

#### 验证是否成功
打开以下网址，查看控制台是否启动成功：
> http://127.0.0.1:7777

账号密码均为sentinel

### 启动edas-sentinel
启动edas-sentinel，可启动多个。此时刷新sentinel dashboard，即可使用。
将接口注册到sentinel上。在sentinel控制面板可选择对已注册的接口进行限流。
资源名：如果未在注解中定义，则为uri路径。如注解中定义，则为注解中的值。
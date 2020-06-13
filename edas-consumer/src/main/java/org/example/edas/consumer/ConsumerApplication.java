/**
 * COPYRIGHT ©2020/3/12 浙江零跑科技有限公司 https://www.leapmotor.com/
 * <p>
 * author yang_long@leapmotor.com
 */
package org.example.edas.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Package org.example.edas.consumer
 * ClassName: ConsumerAppliection
 * Description:
 *
 * @author YangLong [yang_long@leapmotor.com]
 * @version V1.0
 * @date 2020/3/12
 */
@EnableFeignClients(basePackages = "org.example.edas.api")
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"org.example.edas.consumer"})
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

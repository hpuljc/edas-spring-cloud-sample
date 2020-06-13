/**
 * COPYRIGHT ©2020/3/12 浙江零跑科技有限公司 https://www.leapmotor.com/
 * <p>
 * author yang_long@leapmotor.com
 */
package org.example.edas.consumer.controller;

import org.example.edas.api.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Package org.example.edas.consumer.controller
 * ClassName: HelloController
 * Description:
 *
 * @author YangLong [yang_long@leapmotor.com]
 * @version V1.0
 * @date 2020/3/12
 */
@RestController
public class HelloController {
    @Autowired
    private EchoService echoService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RefreshBean refreshBean;

    @GetMapping("feign")
    public String feign(String name) {
        return echoService.hello(name);
    }

    @GetMapping("rest")
    public String rest(String name) {
        return restTemplate.getForObject("http://test-server/hello/" + name, String.class);
    }

    @GetMapping("refresh")
    public String refresh() {
        return refreshBean.getRefresh();
    }
}

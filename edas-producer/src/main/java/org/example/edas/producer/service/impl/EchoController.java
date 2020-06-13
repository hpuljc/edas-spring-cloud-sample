/**
 * COPYRIGHT ©2020/3/12 浙江零跑科技有限公司 https://www.leapmotor.com/
 * <p>
 * author yang_long@leapmotor.com
 */
package org.example.edas.producer.service.impl;

import org.example.edas.api.EchoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: EchoController
 * Description:
 *
 * @author YangLong [yang_long@leapmotor.com]
 * @version V1.0
 * @date 2020/3/12
 */
@RestController
public class EchoController implements EchoService {
    @Value("${server.port}")
    private Integer port;

    @Override
    public String hello(String name) {
        return "hello " + name + " from server:" + port;
    }
}

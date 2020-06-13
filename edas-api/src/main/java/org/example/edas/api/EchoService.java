/**
 * COPYRIGHT ©2020/3/12 浙江零跑科技有限公司 https://www.leapmotor.com/
 * <p>
 * author yang_long@leapmotor.com
 */
package org.example.edas.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * ClassName: EchoService
 * Description: 服务
 *
 * @author YangLong [yang_long@leapmotor.com]
 * @version V1.0
 * @date 2020/3/12
 */
@Service
@FeignClient(name = "test-server")
public interface EchoService {

    @RequestMapping(value = "/hello/{name:\\w+}", method = RequestMethod.GET)
    String hello(@PathVariable(value = "name") String name);

}

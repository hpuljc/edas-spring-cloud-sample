/**
 * COPYRIGHT ©2020/3/13 浙江零跑科技有限公司 https://www.leapmotor.com/
 * <p>
 * author yang_long@leapmotor.com
 */
package org.example.edas.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Package org.example.edas.sentinel.controller
 * ClassName: FlowController
 * Description: 
 *
 * @author YangLong [yang_long@leapmotor.com]
 * @date 2020/3/13
 *
 * @version V1.0
 */
@RestController
public class FlowController {

    @GetMapping("flow")
    public String flow(){
        return "success";
    }

    @GetMapping("/save")
    @SentinelResource(value = "test", blockHandler = "block")
    public String save() {
        return "test";
    }

    public String block(BlockException e) {
        return "block";
    }
}

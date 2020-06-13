/**
 * COPYRIGHT ©2020/3/12 浙江零跑科技有限公司 https://www.leapmotor.com/
 * <p>
 * author yang_long@leapmotor.com
 */
package org.example.edas.consumer.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * Package org.example.edas.consumer.controller
 * ClassName: RefreshBean
 * Description:
 *
 * @author YangLong [yang_long@leapmotor.com]
 * @version V1.0
 * @date 2020/3/12
 */
@Data
@RefreshScope
@Component
public class RefreshBean {
    @Value("${refresh.name}")
    private String refresh;
}

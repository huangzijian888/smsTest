package cn.huangzijian888.smstest.controller;

import cn.huangzijian888.smstest.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzijian888
 */
@RestController
public class CheckPhoneController {
    @PostMapping("/checkPhone")
    public CommonResult checkPhone() {
        CommonResult result = new CommonResult();
        result.setCode(0);
        result.setMsg("success");
        return result;
    }
}

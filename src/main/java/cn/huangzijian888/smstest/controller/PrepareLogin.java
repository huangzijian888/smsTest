package cn.huangzijian888.smstest.controller;

import cn.huangzijian888.smstest.util.CommonResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author huangzijian888
 */
@RestController
public class PrepareLogin {
    @PostMapping("/plogin")
    public CommonResult prepareLogin(@RequestParam("phone") String phone,
                                     @RequestParam("code") String code,
                                     HttpServletRequest request) {
        HttpSession session = request.getSession();
        String sPhone = (String) session.getAttribute("phone");
        String sSmsCode = (String) session.getAttribute("smsCode");
        CommonResult commonResult = new CommonResult();
        if (phone.equals(sPhone) && code.equals(sSmsCode)) {
            commonResult.setCode(0);
            commonResult.setMsg("登录成功！");
        } else {
            commonResult.setCode(1);
            commonResult.setMsg("错误");
        }
        return commonResult;
    }

}

package cn.huangzijian888.smstest.controller;

import cn.huangzijian888.smstest.util.CommonResult;
import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author huangzijian888
 */
@RestController
public class SmsController {
    private final Integer ZERO = 0;
    /**
     * SDK AppID
     */
    @Value("${sms.appId}")
    private Integer appId;
    /**
     * AppKey
     */
    @Value("${sms.appKey}")
    private String appKey;
    /**
     * 短信模板ID
     */
    @Value("${sms.templateId}")
    private Integer templateId;

    @PostMapping("/getCode")
    public CommonResult getCode(@RequestParam("phone") String phone,
                                HttpServletRequest request) {
        SmsSingleSender sender = new SmsSingleSender(appId, appKey);
        String smsCode = RandomStringUtils.random(4, "0123456789");
        String[] params = {smsCode, "2"};

        CommonResult commonResult = new CommonResult();
        SmsSingleSenderResult result = new SmsSingleSenderResult();
        try {
            result = sender.sendWithParam("86", phone,
                    templateId, params, "", "", "");


        } catch (HTTPException e) {

        } catch (IOException e) {
        }
        HttpSession session = request.getSession();
        if (ZERO == result.result) {
            commonResult.setMsg(result.errMsg);
            commonResult.setCode(result.result);
            session.setAttribute("smsCode", smsCode);
            session.setAttribute("phone", phone);
            session.setMaxInactiveInterval(120);
        }

        return commonResult;

    }
}

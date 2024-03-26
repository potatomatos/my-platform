package cn.cxnxs.security.utils;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * 阿里云短信工具类
 */
@Slf4j
public class SMSUtil {

    // 签名
    private static final String signName = "某某公司";

    // 模板
    private static final String templateCode = "SMS_22*****04";

    // 阿里云短信配置信息
    private static final String accessKeyId = "LTA*************9Cf";
    private static final String accessKeySecret = "1GjBfyf*****************SDlP";
    private static final String REGION_ID = "cn-hangzhou";
    private static final String PRODUCT = "Dysmsapi";
    private static final String DOMAIN = "dysmsapi.aliyuncs.com";

    /**
     * 发送短信通知
     *
     * @param mobile   手机号
     * @param userName 用户名
     * @param money    金额
     * @return 执行结果
     */
    public static boolean sendSMS(String mobile, String userName, Long money) {
        try {
            IClientProfile profile = DefaultProfile.getProfile(REGION_ID, accessKeyId, accessKeySecret);

            DefaultProfile.addEndpoint(REGION_ID, REGION_ID, PRODUCT, DOMAIN);

            IAcsClient acsClient = new DefaultAcsClient(profile);

            SendSmsRequest request = new SendSmsRequest();

            request.setMethod(MethodType.POST);

            // 手机号可以单个也可以多个（多个用逗号隔开，如：15*******13,13*******27,17*******56）
            request.setPhoneNumbers(mobile);

            request.setSignName(signName);

            request.setTemplateCode(templateCode);

            /*  例如签名内容为：某某公司
            例如模板内容为：亲爱的同事,很高兴的通知您，您抽中了由领导${userName}派发的大饼奖励${money}元，请及时找财务领取！
            变量属性：userName-其他；money-其他；
            则短信内容为：【某某公司】 亲爱的同事,很高兴的通知您，您抽中了由领导${userName}派发的大饼奖励${money}元，请及时找财务领取！*/
            request.setTemplateParam("{\"userName\":\"" + userName + "\",\"money\":\"" + money + "\"}");

            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if ((sendSmsResponse.getCode() != null) && (sendSmsResponse.getCode().equals("OK"))) {
                log.info("发送成功,code:" + sendSmsResponse.getCode());
                return true;
            } else {
                log.info("发送失败,code:" + sendSmsResponse.getCode());
                return false;
            }
        } catch (ClientException e) {
            log.error("发送失败,系统错误！", e);
            return false;
        }
    }

    /**
     * 获取逗号分隔的拼接字符串
     *
     * @param str 用于拼接的字符串集合
     * @return String
     */
    public static String getSplitString(List<String> str) {
        StringBuilder newS = new StringBuilder();
        if (str != null && str.size() > 0) {
            for (String s : str) {
                newS.append(s).append(",");
            }
        }
        if (newS.length() > 0)
            newS.deleteCharAt(newS.length() - 1);// 删除最后一个多余的逗号
        return newS.toString();
    }

    public static void main(String[] args) {
//        多发
        List<String> mobiles = new ArrayList<>();
        mobiles.add("15*******13");
        mobiles.add("13*******27");
        mobiles.add("17*******56");
        String s = getSplitString(mobiles);
        System.out.println(SMSUtil.sendSMS(s, "谢广坤", -2000L));
//         单发
//        System.out.println(SendSmsUtil.sendSMS("177******56", "赵四",  -2000L));
    }

}

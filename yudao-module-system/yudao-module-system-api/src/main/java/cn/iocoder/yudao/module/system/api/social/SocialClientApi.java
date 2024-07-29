package cn.iocoder.yudao.module.system.api.social;

import cn.iocoder.yudao.module.system.api.social.dto.*;
import cn.iocoder.yudao.module.system.enums.social.SocialTypeEnum;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Map;

/**
 * 社交应用的 API 接口
 *
 * @author 芋道源码
 */
public interface SocialClientApi {

    /**
     * 获得社交平台的授权 URL
     *
     * @param socialType  社交平台的类型 {@link SocialTypeEnum}
     * @param userType    用户类型
     * @param redirectUri 重定向 URL
     * @return 社交平台的授权 URL
     */
    String getAuthorizeUrl(Integer socialType, Integer userType, String redirectUri);

    /**
     * 创建微信公众号 JS SDK 初始化所需的签名
     *
     * @param userType 用户类型
     * @param url      访问的 URL 地址
     * @return 签名
     */
    SocialWxJsapiSignatureRespDTO createWxMpJsapiSignature(Integer userType, String url);

    /**
     * 获得微信小程序的手机信息
     *
     * @param userType  用户类型
     * @param phoneCode 手机授权码
     * @return 手机信息
     */
    SocialWxPhoneNumberInfoRespDTO getWxMaPhoneNumberInfo(Integer userType, String phoneCode);

    /**
     * 获得小程序二维码
     *
     * @param reqVO 请求信息
     * @return 小程序二维码
     */
    byte[] getWxaQrcode(@Valid SocialWxQrcodeReqDTO reqVO);

    /**
     * 获得微信小程订阅模板
     *
     * @return 小程序订阅消息模版
     */
    List<SocialWxSubscribeTemplateRespDTO> getSubscribeTemplateList(Integer userType);

    /**
     * 发送微信小程序订阅消息
     *
     * @param reqDTO 请求
     */
    void sendSubscribeMessage(SocialWxSubscribeMessageSendReqDTO reqDTO, Integer userType);

    /**
     * 发送微信小程序订阅消息
     *
     * @param templateTitle 模版标题
     * @param messages      消息
     * @param userType      用户类型
     * @param userId        用户编号
     * @param socialType    社交客服端类型
     * @param path          点击模板卡片后的跳转页面，仅限本小程序内的页面
     */
    void sendSubscribeMessage(String templateTitle, Map<String, String> messages, Integer userType, Long userId,
                              Integer socialType, String path);

}

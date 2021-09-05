package org.pjsip.pjsua2.app;

/**
 * 常量
 *
 * @author Alex
 * 参考：https://www.jianshu.com/p/17b37644fa7c
 */
public final class Constants {
    /**
     * SIP域
     */
    public static String sipDomain = "4300000080";

    /**
     * SIP服务器地址
     */
    public static String sipHost = "106.13.40.177";

    /**
     * SIP服务器端口
     */
    public static int sipPort = 5061;

    /**
     * 代理服务器
     */
    public static String proxy = "";

    /**
     * 用户名
     */
    public static String username = "43000000801320008064";

    /**
     * 密码
     */
    public static String password = "123456";

    /**
     * 设备索引
     */
    public static String cameraDeviceId = "13000000441320000026";

    /**
     * @return 客户端SIP索引
     */
    public static String getSipAccountId() {
        return "SIP:" + username + "@" + sipHost + ":" + sipPort;
    }

    /**
     * @return 注册服务器索引
     */
    public static String getRegistrar() {
        return "SIP:" + sipHost + ":" + sipPort;
    }
}

package com.esioner.myapplication.neihan;

import com.esioner.myapplication.MyApplication;
import com.esioner.myapplication.utils.SPUtils;

public class _URL {
    /**
     * 获取 content_type
     */
    public static String URL_CONTENT_TYPE = "http://lf.snssdk.com/neihan/service/tabs/?";
    /**
     * 获取推荐
     * 获取视频也是此 URL
     * 获取图片
     * 获取段子
     */
    public static String URL_RECOMMEND = "http://iu.snssdk.com/neihan/stream/mix/v1/?";
    /**
     * 获取段友秀
     */
    public static String URL_FRIEND_SHOW = "http://iu.snssdk.com/neihan/stream/mix/v1/";
    /**
     * 获取直播
     */
    public static String URL_PLAY_LIVE = "http://hotsoon.snssdk.com/hotsoon/feed/";

    //获取 contentType json 需要拼接的内容
    public static String getJointContentTypeParameter() {
        String suffixString =
                "&essence=1" +      //固定值 1
                        "&iid=" + SPUtils.getString("iid") +//一个长度为10的纯数字字符串，用于标识用户唯一性
                        "&device_id=" + MyApplication.getDeviceId() +//设备 id，一个长度为11的纯数字字符串
                        "&ac=wifi" +//网络环境，可取值 wifi
                        "&channel = 360" +//下载渠道，可360、tencent等
                        "&aid = 7" +//固定值7
                        "&app_name=joke_essay" +//固定值joke_essay
                        "&versionCode=" + MyApplication.removePoint(MyApplication.getVersionCode
                        ()) +//版本号去除小数点，例如612
                        "&version_name=" + MyApplication.getVersionCode() +//版本号，例如6.1.2
                        "&device_platform=android" +//设备平台，android 或 ios
                        "&ssmix=a" +//固定值 a
                        "&device_type" + MyApplication.getDeviceModel() +//设备型号，例如 hongmi
                        "&device_brand=" + MyApplication.getManufacturer() +//设备品牌，例如 xiaomi
                        "&os_api=" + MyApplication.getOSCode() +//设备品牌，例如 xiaomi
                        "&os_version=" + MyApplication.getVersionCode() +//操作系统版本号，例如7.1.0
                        "&uuid=" + SPUtils.getString("uuid") +//用户 id，一个长度为15的纯数字字符串
                        "&openudid=" + SPUtils.getString("openudid") +//一个长度为16的数字和小写字母混合字符串
                        "&manifest_version_code=" + MyApplication.removePoint(MyApplication
                        .getVersionCode()) +//版本号去除小数点，例如612
                        "&resolution=" + MyApplication.getScreenHeight() + "*" + MyApplication
                        .getScreenWidth() +//屏幕宽高，例如 1920*1080
                        "&dpi=" + MyApplication.getScreenDPI() +//手机 dpi
                        "&update_version_code=" + MyApplication.removePoint(MyApplication
                        .getVersionCode()) + "0";//版本号去除小数点后乘10，例如6120
        return suffixString;
    }

    //获取段子拼接参数

    /**
     * @param count   请求数量
     * @param minTime 上次请求的时间
     * @return
     */
    public static String getJokeJointUrlParameter(String count, String
            minTime) {
        String suffixString = "mpic=1" +
                "content_type=-102" +
                "webp=1" +          //固定值 1
                "&essence=1" +      //固定值 1
                "&message_cursor=-1" + //固定值-1
                "&am_longitude=" +//经度。可为空
                "&am_latitude=" +//纬度。可为空
                "&am_city=" +//城市名，例如：北京市。可为空
                "&am_loc_time=" + MyApplication.getUnixTime() +//当前时间 Unix 时间戳，毫秒为单位
                "&count=" + count +//返回数量
                "&min_time=" + minTime +//上次更新时间的 Unix 时间戳，秒为单位
                "&screen_width=" + MyApplication.getScreenWidth() +//屏幕宽度，px为单位
                "&double_col_mode=0" +//固定值0
                "&iid=" + SPUtils.getString("iid") +//一个长度为10的纯数字字符串，用于标识用户唯一性
                "&device_id=" + MyApplication.getDeviceId() +//设备 id，一个长度为11的纯数字字符串
                "&ac=wifi" +//网络环境，可取值 wifi
                "&channel=360" +//下载渠道，可360、tencent等
                "&aid=7" +//固定值7
                "&app_name=joke_essay" +//固定值joke_essay
                "&versionCode=" + MyApplication.removePoint(MyApplication.getVersionCode
                ()) +//版本号去除小数点，例如612
                "&version_name=" + MyApplication.getVersionCode() +//版本号，例如6.1.2
                "&device_platform=android" +//设备平台，android 或 ios
                "&ssmix=a" +//固定值 a
                "&device_type=" + MyApplication.getDeviceModel().replace(" ", "") +//设备型号，例如 hongmi
                "&device_brand=" + MyApplication.getManufacturer() +//设备品牌，例如 xiaomi
                "&os_api=" + MyApplication.getOSCode() +//设备品牌，例如 xiaomi
                "&os_version=" + MyApplication.getVersionCode() +//操作系统版本号，例如7.1.0
                "&uuid=" + SPUtils.getString("uuid") +//用户 id，一个长度为15的纯数字字符串
                "&openudid=" + SPUtils.getString("openudid") +//一个长度为16的数字和小写字母混合字符串
                "&manifest_version_code=" + MyApplication.removePoint(MyApplication
                .getVersionCode()) +//版本号去除小数点，例如612
                "&resolution=" + MyApplication.getScreenHeight() + "*" + MyApplication
                .getScreenWidth() +//屏幕宽高，例如 1920*1080
                "&dpi=" + MyApplication.getScreenDPI() +//手机 dpi
                "&update_version_code=" + MyApplication.removePoint(MyApplication
                .getVersionCode()) + "0";//版本号去除小数点后乘10，例如6120
        return suffixString;
    }


    /**
     * 拼接字符串
     *
     * @param contentType 从获取 content_type 中获取得到的 list_id 字段值。
     * @param count       返回数量
     * @param minTime     上次更新时间的 Unix 时间戳，秒为单位
     *                    //     * @param iid         一个长度为10的纯数字字符串，用于标识用户唯一性
     *                    //     * @param uuid        用户 id，一个长度为15的纯数字字符串
     *                    //     * @param openudid    一个长度为16的数字和小写字母混合字符串
     * @return
     */
    public static String getJointUrlParameter(String contentType, String count, String minTime) {
        String suffixString = "webp=1" +          //固定值 1
                "&essence=1" +      //固定值 1
                "&content_type=" + contentType +    //从获取 content_type 中获取得到的 list_id 字段值。
                "&message_cursor=-1" + //固定值-1
                "&am_longitude=" +//经度。可为空
                "&am_latitude=" +//纬度。可为空
                "&am_city=" +//城市名，例如：北京市。可为空
                "&am_loc_time=" + MyApplication.getUnixTime() +//当前时间 Unix 时间戳，毫秒为单位
                "&count=" + count +//返回数量
                "&min_time=" + minTime +//上次更新时间的 Unix 时间戳，秒为单位
                "&screen_width=" + MyApplication.getScreenWidth() +//屏幕宽度，px为单位
                "&double_col_mode=0" +//固定值0
                "&iid=" + SPUtils.getString("iid") +//一个长度为10的纯数字字符串，用于标识用户唯一性
                "&device_id=" + MyApplication.getDeviceId() +//设备 id，一个长度为11的纯数字字符串
                "&ac=wifi" +//网络环境，可取值 wifi
                "&channel = 360" +//下载渠道，可360、tencent等
                "&aid = 7" +//固定值7
                "&app_name=joke_essay" +//固定值joke_essay
                "&versionCode=" + MyApplication.removePoint(MyApplication.getVersionCode
                ()) +//版本号去除小数点，例如612
                "&version_name=" + MyApplication.getVersionCode() +//版本号，例如6.1.2
                "&version_name=android" +//设备平台，android 或 ios
                "&ssmix=a" +//固定值 a
                "&device_type" + MyApplication.getDeviceModel() +//设备型号，例如 hongmi
                "&device_brand=" + MyApplication.getManufacturer() +//设备品牌，例如 xiaomi
                "&os_api=" + MyApplication.getOSCode() +//设备品牌，例如 xiaomi
                "&os_version=" + MyApplication.getVersionCode() +//操作系统版本号，例如7.1.0
                "&uuid=" + SPUtils.getString("uuid") +//用户 id，一个长度为15的纯数字字符串
                "&openudid=" + SPUtils.getString("openudid") +//一个长度为16的数字和小写字母混合字符串
                "&manifest_version_code=" + MyApplication.removePoint(MyApplication
                .getVersionCode()) +//版本号去除小数点，例如612
                "&resolution=" + MyApplication.getScreenHeight() + "*" + MyApplication
                .getScreenWidth() +//屏幕宽高，例如 1920*1080
                "&dpi=" + MyApplication.getScreenDPI() +//手机 dpi
                "&update_version_code=" + MyApplication.removePoint(MyApplication
                .getVersionCode()) + "0";//版本号去除小数点后乘10，例如6120
        return suffixString;
    }
}

package com.hanclouds.image;

import com.hanclouds.image.exception.HanCloudsException;
import com.hanclouds.image.model.DeviceImgProcessDTO;
import com.hanclouds.image.req.DeviceImageGetLatestOneRequest;
import com.hanclouds.image.resp.DeviceImageGetOneResponse;

/**
 * sdk获取最新图片数据示例
 * @author luolh
 * @version 1.0
 * @date 2019/3/7 10:10
 */
public class DeviceImageGetLatestOneTest  {

    //请求的图片网关服务url
    private static String serverUrl = "https://api.hanclouds.com/image/v1";

    /**
     * 为了更好的体验hanClouds image-sdk demo，请根据需要运行的Demo方法配置以下参数。
     * 如不了解鉴权参数，打开https://www.hanclouds.com/doc/2-authentication/index。
     * */
    //设备查询鉴权token
    private static String deviceKey = "";
    private static String queryToken = "";

    //产品查询鉴权密钥
    private static String productKey = "";
    private static String queryKey = "";
    private static String querySecret = "";

    //用户鉴权密钥
    private static String userKey = "";
    private static String authKey = "";
    private static String authSecret = "";

    public static void main(String[] args) {
        String deviceKey = "";
        String dataName = "";
        //缩略参数 以下三种方式根据实际情况选择其中一种
        String resize = "200,200";
        String forcesize = "200,200";
        String rescale = "0.1,0.1";

        /**
         * 通过用户鉴权获取最新图片数据。
         * 请初始化userKey,authKey,authSecret 变量即可调用
         */
        getLatestImageByUserAuth(deviceKey, dataName, resize, forcesize, rescale);

        /**
         * 通过产品查询密钥鉴权获取最新图片数据。
         * 请初始化productKey,queryKey,querySecret 变量即可调用
         */
        getLatestImageByProductAuth(deviceKey, dataName, resize, forcesize, rescale);

        /**
         * 通过设备查询密钥鉴权获取最新图片数据。
         * 请初始化deviceKey,queryToken 变量即可调用
         */
        getLatestImageByDeviceAuth(deviceKey, dataName, resize, forcesize, rescale);
    }

    /**
     * 通过用户鉴权获取最新图片数据
     *
     * @param deviceKey
     * @param dataName
     */
    private static void getLatestImageByUserAuth(String deviceKey, String dataName, String resize, String forcesize, String rescale) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置用户鉴权参数
        client.putUserAuthParams(userKey, authKey, authSecret);

        DeviceImageGetLatestOneRequest request = new DeviceImageGetLatestOneRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);

        //设置缩略参数 以下三种方式根据实际情况选择其中一种
        request.setResize(resize);
        request.setForcesize(forcesize);
        request.setRescale(rescale);

        try {
            DeviceImageGetOneResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后处理代码示例

                //获取设备图片数据结果
                DeviceImgProcessDTO result = response.getResponse();
                //图片数据
                byte[] imageData = result.getData();
                //图片名
                String name = result.getName();
            } else {
                //失败是的异常信息获取
                System.out.printf("error code: %s  error msg: %s", response.getErrorMessage().getCode(), response.getErrorMessage().getMessage());
            }

            //response可以获取其它信息，具体请查看方法列表。
        } catch (HanCloudsException e) {
            e.printStackTrace();
            System.out.printf("system error: %s", e.getMessage());
        }
    }

    /**
     * 通过产品查询密钥鉴权获取最新图片数据
     *
     * @param deviceKey
     * @param dataName
     */
    private static void getLatestImageByProductAuth(String deviceKey, String dataName, String resize, String forcesize, String rescale) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置产品鉴权参数
        client.putProductAuthParams(productKey, queryKey, querySecret);

        DeviceImageGetLatestOneRequest request = new DeviceImageGetLatestOneRequest();
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);

        //设置缩略参数 以下三种方式根据实际情况选择其中一种
        request.setResize(resize);
        request.setForcesize(forcesize);
        request.setRescale(rescale);

        try {
            DeviceImageGetOneResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后处理代码示例

                //获取设备图片数据结果
                DeviceImgProcessDTO result = response.getResponse();
                //图片数据
                byte[] imageData = result.getData();
                //图片名
                String name = result.getName();
            } else {
                //失败是的异常信息获取
                System.out.printf("error code: %s  error msg: %s", response.getErrorMessage().getCode(), response.getErrorMessage().getMessage());
            }

            //response可以获取其它信息，具体请查看方法列表。
        } catch (HanCloudsException e) {
            e.printStackTrace();
            System.out.printf("system error: %s", e.getMessage());
        }
    }

    /**
     * 通过设备查询密钥鉴权获取最新图片数据
     *
     * @param deviceKey
     * @param dataName
     */
    private static void getLatestImageByDeviceAuth(String deviceKey, String dataName, String resize, String forcesize, String rescale) {
        HancloudsImageClient client = new HancloudsImageClient(serverUrl);
        //设置设备鉴权参数
        client.putDeviceAuthParams(deviceKey, queryToken);

        DeviceImageGetLatestOneRequest request = new DeviceImageGetLatestOneRequest();
        /**
         * 为什么我们授权那里设置了deviceKey，这里还需要设置呢？
         * 因为这里的deviceKey同时做了鉴权参数和调用参数，授权参数与调用参数要独立分开，互不影响。
         */
        request.setDeviceKey(deviceKey);
        request.setDataName(dataName);

        //设置缩略参数 以下三种方式根据实际情况选择其中一种
        request.setResize(resize);
        request.setForcesize(forcesize);
        request.setRescale(rescale);

        try {
            DeviceImageGetOneResponse response = client.execute(request);
            if (response.isSuccess()) {
                //成功后处理代码示例

                //获取设备图片数据结果
                DeviceImgProcessDTO result = response.getResponse();
                //图片数据
                byte[] imageData = result.getData();
                //图片名
                String name = result.getName();
            } else {
                //失败是的异常信息获取
                System.out.printf("error code: %s  error msg: %s", response.getErrorMessage().getCode(), response.getErrorMessage().getMessage());
            }

            //response可以获取其它信息，具体请查看方法列表。
        } catch (HanCloudsException e) {
            e.printStackTrace();
            System.out.printf("system error: %s", e.getMessage());
        }
    }
}

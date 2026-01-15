package com.codenote.util;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * HTTP客户端工具类
 * 用于调用外部API（百度OCR、百度翻译等）
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
    private static final String CHARSET = "UTF-8";

    /**
     * 发送GET请求
     * @param url 请求地址
     * @return 响应内容
     */
    public static String doGet(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpGet httpGet = new HttpGet(url);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (IOException e) {
            logger.error("GET请求失败: {}", url, e);
        } finally {
            closeResources(response, httpClient);
        }
        return null;
    }

    /**
     * 发送POST请求（表单形式）
     * @param url 请求地址
     * @param params 表单参数
     * @return 响应内容
     */
    public static String doPost(String url, Map<String, String> params) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);

            // 构建表单参数
            if (params != null && !params.isEmpty()) {
                List<NameValuePair> pairs = new ArrayList<>();
                for (Map.Entry<String, String> entry : params.entrySet()) {
                    pairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(pairs, CHARSET));
            }

            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (IOException e) {
            logger.error("POST请求失败: {}", url, e);
        } finally {
            closeResources(response, httpClient);
        }
        return null;
    }

    /**
     * 发送POST请求（JSON形式）
     * @param url 请求地址
     * @param json JSON字符串
     * @return 响应内容
     */
    public static String doPostJson(String url, String json) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            HttpPost httpPost = new HttpPost(url);
            httpPost.setHeader("Content-Type", "application/json;charset=UTF-8");

            if (json != null) {
                StringEntity stringEntity = new StringEntity(json, CHARSET);
                httpPost.setEntity(stringEntity);
            }

            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity, CHARSET);
            }
        } catch (IOException e) {
            logger.error("POST JSON请求失败: {}", url, e);
        } finally {
            closeResources(response, httpClient);
        }
        return null;
    }

    /**
     * 关闭资源
     */
    private static void closeResources(CloseableHttpResponse response, CloseableHttpClient httpClient) {
        try {
            if (response != null) {
                response.close();
            }
            if (httpClient != null) {
                httpClient.close();
            }
        } catch (IOException e) {
            logger.error("关闭HTTP资源失败", e);
        }
    }
}

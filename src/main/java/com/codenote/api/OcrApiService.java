package com.codenote.api;

import com.codenote.util.HttpClientUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * 百度OCR服务
 * 用于图片文字识别
 *
 * API文档: https://ai.baidu.com/ai-doc/OCR/zk3h7xz52
 */
@Service
public class OcrApiService {

    private static final Logger logger = LoggerFactory.getLogger(OcrApiService.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    @Value("${baidu.ocr.api.key}")
    private String apiKey;

    @Value("${baidu.ocr.secret.key}")
    private String secretKey;

    @Value("${baidu.ocr.token.url}")
    private String tokenUrl;

    @Value("${baidu.ocr.general.url}")
    private String ocrUrl;

    // 缓存access_token
    private String accessToken;
    private long tokenExpireTime;

    /**
     * 识别图片中的文字
     * @param imageData 图片二进制数据
     * @return 识别出的文字内容
     */
    public String recognizeImage(byte[] imageData) {
        try {
            // 1. 获取access_token
            String token = getAccessToken();
            if (token == null) {
                return "获取百度OCR授权失败，请检查API配置";
            }

            // 2. 将图片转为Base64
            String imageBase64 = Base64.getEncoder().encodeToString(imageData);

            // 3. 调用OCR接口
            String requestUrl = ocrUrl + "?access_token=" + token;
            Map<String, String> params = new HashMap<>();
            params.put("image", URLEncoder.encode(imageBase64, "UTF-8"));

            String response = HttpClientUtil.doPost(requestUrl, params);
            logger.info("OCR响应: {}", response);

            // 4. 解析响应
            return parseOcrResponse(response);
        } catch (Exception e) {
            logger.error("OCR识别失败", e);
            return "OCR识别失败: " + e.getMessage();
        }
    }

    /**
     * 获取百度API的access_token
     */
    private String getAccessToken() {
        // 检查缓存的token是否有效
        if (accessToken != null && System.currentTimeMillis() < tokenExpireTime) {
            return accessToken;
        }

        try {
            String url = tokenUrl + "?grant_type=client_credentials&client_id=" + apiKey + "&client_secret=" + secretKey;
            String response = HttpClientUtil.doGet(url);

            JsonNode jsonNode = mapper.readTree(response);
            if (jsonNode.has("access_token")) {
                accessToken = jsonNode.get("access_token").asText();
                // token有效期30天，这里设置为29天
                tokenExpireTime = System.currentTimeMillis() + 29L * 24 * 60 * 60 * 1000;
                logger.info("获取百度OCR access_token成功");
                return accessToken;
            } else {
                logger.error("获取access_token失败: {}", response);
                return null;
            }
        } catch (Exception e) {
            logger.error("获取access_token异常", e);
            return null;
        }
    }

    /**
     * 解析OCR响应，提取识别的文字
     */
    private String parseOcrResponse(String response) {
        try {
            JsonNode jsonNode = mapper.readTree(response);

            // 检查是否有错误
            if (jsonNode.has("error_code")) {
                return "OCR错误: " + jsonNode.get("error_msg").asText();
            }

            // 提取识别结果
            StringBuilder result = new StringBuilder();
            JsonNode wordsResult = jsonNode.get("words_result");
            if (wordsResult != null && wordsResult.isArray()) {
                for (JsonNode item : wordsResult) {
                    result.append(item.get("words").asText()).append("\n");
                }
            }

            return result.toString().trim();
        } catch (Exception e) {
            logger.error("解析OCR响应失败", e);
            return "解析OCR响应失败";
        }
    }
}

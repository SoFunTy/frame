package com.cn.frame.common.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import org.apache.commons.codec.Charsets;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.net.*;
import java.util.Map;

/**
 * Create By SoFunTy
 * 2020/11/27  11:32
 */
public class HttpUtil {
    public static String httpPost(String url, Object postData, Map<String,String> headerParam) {
        String result = null;
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            httpClient = HttpClients.createDefault();
            RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(600000).setConnectTimeout(600000).build();

            HttpPost post = new HttpPost(url);
            post.setConfig(requestConfig);
            StringEntity stringEntity = new StringEntity(JSONUtil.toJsonStr(postData), Charsets.UTF_8.displayName());
            stringEntity.setContentType("application/json");

            post.addHeader("Content-Type", "application/json");
            post.addHeader("Host",new URL(url).getHost());

            if (ObjectUtil.isNotEmpty(headerParam)) {
                headerParam.entrySet().stream().forEach(one -> {
                    post.addHeader(one.getKey(), one.getValue());
                });
            }

            post.setEntity(stringEntity);

            response = httpClient.execute(post);
            HttpEntity responseEntity = response.getEntity();
            result = EntityUtils.toString(responseEntity);
            EntityUtils.consume(responseEntity);
            if (response != null) {
                response.close();
            }

            if (httpClient != null) {
                httpClient.close();
            }
        }  catch (Exception e) {
            System.out.println(e);
        } finally {
        }
        return result;
    }
}

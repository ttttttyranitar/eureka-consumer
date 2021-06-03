package com.demo.eureka.eurekaconsumer.feign.decoder;

import com.alibaba.fastjson.JSON;
import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

import java.io.IOException;
import java.lang.reflect.Type;

/**
 * copyright (C), 2021, Altaria Studio
 *
 * @author Sancho
 * @version 1.0.0
 * <author>                <time>                  <version>                   <description>
 * Sancho                  2021/5/20 13:46                                      自定义解码器，解码远程调用的返回结果。
 * @program eureka-consumer
 * @description 自定义解码器，解码远程调用的返回结果。
 * @create 2021/5/20 13:46
 */
public class MyDecoder implements Decoder {
    @Override
    public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {

        if (response.body() == null){

            throw new DecodeException(response.status(), "返回结果为空",response.request());
        }
        String res = response.toString();
        return res;

    }
}
package com.atguigu.mpdemo1010.util;

import java.util.HashMap;

/**
 * @Description: 返回的结果集
 * @Company：众阳健康
 * @Author: jiangheng
 * @Date: 2020/7/16 14:01
 * @Version 1.0
 */
public class ResultMap extends HashMap<String, Object> {

    public ResultMap() {

    }


    /**
     * @return
     * @Date 2020/7/16 14:05
     * @Author jiangheng
     * @Description //TODO 返回成功信息
     **/
    public static ResultMap success(String msg, Object data) {
        ResultMap resultMap = new ResultMap();
        resultMap.put("msg", msg);
        resultMap.put("data", data);
        resultMap.put("code'", 200);
        return resultMap;
    }

    public static ResultMap success(String msg) {
        ResultMap resultMap = new ResultMap();
        resultMap.put("msg", msg);
        resultMap.put("code'", 200);
        return resultMap;
    }

    /**
     * @return
     * @Date 2020/7/16 14:15
     * @Author jiangheng
     * @Description //TODO 存放元素
     **/
    @Override
    public ResultMap put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    /**
     * @return
     * @Date 2020/7/16 14:18
     * @Author jiangheng
     * @Description //TODO  请求错误信息
     **/
    public static ResultMap error(String msg) {
        ResultMap resultMap = new ResultMap();
        resultMap.put("msg", msg);
        resultMap.put("code'", 500);
        return resultMap;
    }
}

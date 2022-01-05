package com.ning.server.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 功能: 共返回对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 功能: 成功返回结果
     * * @param message
     * @return {@link RespBean}
     */
    public static RespBean success(String message){
        return new RespBean(200,message,null);
    }
    /**
     * 功能: 成功返回结果
     * * @param message
     * @param obj
     * @return {@link RespBean}
     */
    public static RespBean success(String message,Object obj){
        return new RespBean(200,message,obj);
    }
    /**
     * 功能: 失败返回结果
     * * @param message
     * @return {@link RespBean}
     */
    public static RespBean error(String message){
        return  new RespBean(500,message,null);
    }

    /**
     * 功能: 失败返回结果
     * * @param message
     * @param obj
     * @return {@link RespBean}
     */
    public static RespBean error(String message,Object obj){
        return  new RespBean(500,message,obj);
    }
}

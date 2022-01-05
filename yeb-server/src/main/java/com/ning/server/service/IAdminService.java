package com.ning.server.service;

import com.ning.server.common.entity.RespBean;
import com.ning.server.pojo.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ning.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
/**
 * <p>
 *  服务类
 * </p>
 * @author ChangNing.Wang
 * @since 2021-12-22
 */
public interface IAdminService extends IService<Admin> {

    //登录之后返回token
    //这个带验证码String code参数
//    RespBean login(String username, String password, String code, HttpServletRequest request);
    RespBean login(String username, String password, HttpServletRequest request);

    //根据用户名获取用户详情
    Admin getAdminByUserName(String username);

    //根据用户id查询角色列表
    List<Role> getRoles(Integer id);

    //获取所有操作员(模糊查询)
    List<Admin> getAllAdmin(String keywords);

    //更新操作员角色
    RespBean updateAdminRole(Integer aid, Integer[] rids);

    //更新用户密码
    RespBean updateAdminPassword(String oldPass, String pass, Integer adminId);
}

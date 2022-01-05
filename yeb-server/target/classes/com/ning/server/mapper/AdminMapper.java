package com.ning.server.mapper;

import com.ning.server.pojo.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ning.server.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ChangNing.Wang
//    //根据用户id获取角色
//    List<Role> getRoles(Integer id);
//
//    //获取所有操作员(模糊查询)
//    List<Admin> getAllAdmin(@Param("id") Integer id, @Param("keywords") String keywords);
 * @since 2021-12-22
 */
public interface AdminMapper extends BaseMapper<Admin> {
//    //根据用户id获取角色
//    List<Role> getRoles(Integer id);
//
//    //获取所有操作员(模糊查询)
//    List<Admin> getAllAdmin(@Param("id") Integer id, @Param("keywords") String keywords);
}

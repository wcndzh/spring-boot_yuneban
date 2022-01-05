package com.ning.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ning.server.common.entity.RespBean;

import com.ning.server.config.security.component.JwtTokenUtil;
import com.ning.server.mapper.AdminRoleMapper;
import com.ning.server.pojo.Admin;
import com.ning.server.mapper.AdminMapper;
import com.ning.server.pojo.AdminRole;
import com.ning.server.pojo.Role;
import com.ning.server.service.IAdminRoleService;
import com.ning.server.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChangNing.Wang
 * @since 2021-12-22
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

//    /**
//     * 功能: 登录之后返回token
//     * * @param username
//     * @param password
//     * @param request
//     * @return {@link RespBean}
//     */
    //    //带验证码的验证
//    @Override
//    public RespBean login(String username, String password, String code, HttpServletRequest request) {
//        //校验验证码是否有效
//        String captcha = (String) request.getSession().getAttribute("captcha");
//        if (!captcha.equalsIgnoreCase(code)) {
//            return RespBean.error("验证码错误");
//        }
//        //根据前端传回的username加载UserDetails
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        if (userDetails == null || passwordEncoder.matches(password, userDetails.getPassword())) {
//            return RespBean.error("用户名或密码不正确");
//        }
//        if (!userDetails.isEnabled()) {
//            return RespBean.error("账号被禁用，请联系管理员");
//        }
    // //不带验证码的验证
    /**
     * 功能: 登录之后返回token
     * * @param username
     * @param password
     * @param request
     * @return {@link RespBean}
     */
        @Override
        public RespBean login(String username, String password, HttpServletRequest request) {
            //校验验证码是否有效
//            String captcha = (String) request.getSession().getAttribute("captcha");
            //根据前端传回的username加载UserDetails
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (userDetails == null || passwordEncoder.matches(password, userDetails.getPassword())) {
                return RespBean.error("用户名或密码不正确");
            }
            if (!userDetails.isEnabled()) {
                return RespBean.error("账号被禁用，请联系管理员");
            }

        //（更新security对象）
        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        //将当前对象放在SpringSecurity全局配置中
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        //根据UserDetails生成token
        String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return RespBean.success("登录成功", tokenMap);
    }

    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    @Override
    public Admin getAdminByUserName(String username) {
        return adminMapper.selectOne(new QueryWrapper<Admin>()
                .eq("username", username).eq("enabled", true));
    }

    @Override
    public List<Role> getRoles(Integer id) {
        return null;
    }

    @Override
    public List<Admin> getAllAdmin(String keywords) {
        return null;
    }

    @Override
    public RespBean updateAdminRole(Integer aid, Integer[] rids) {
        return null;
    }

    @Override
    public RespBean updateAdminPassword(String oldPass, String pass, Integer adminId) {
        return null;
    }
}

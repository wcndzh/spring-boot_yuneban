package com.ning.server.service.impl;

import com.ning.server.pojo.Department;
import com.ning.server.mapper.DepartmentMapper;
import com.ning.server.service.IDepartmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ChangNing.Wang
 * @since 2021-12-22
 */
@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {

}

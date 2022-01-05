package com.ning.server.service.impl;

import com.ning.server.pojo.Oplog;
import com.ning.server.mapper.OplogMapper;
import com.ning.server.service.IOplogService;
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
public class OplogServiceImpl extends ServiceImpl<OplogMapper, Oplog> implements IOplogService {

}

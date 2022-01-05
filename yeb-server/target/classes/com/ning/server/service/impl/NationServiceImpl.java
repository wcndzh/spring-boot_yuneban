package com.ning.server.service.impl;

import com.ning.server.pojo.Nation;
import com.ning.server.mapper.NationMapper;
import com.ning.server.service.INationService;
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
public class NationServiceImpl extends ServiceImpl<NationMapper, Nation> implements INationService {

}

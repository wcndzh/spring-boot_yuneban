package com.ning.server.service.impl;

import com.ning.server.pojo.MailLog;
import com.ning.server.mapper.MailLogMapper;
import com.ning.server.service.IMailLogService;
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
public class MailLogServiceImpl extends ServiceImpl<MailLogMapper, MailLog> implements IMailLogService {

}

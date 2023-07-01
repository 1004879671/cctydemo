package com.ccty.service.impl;

import com.ccty.entity.TUser;
import com.ccty.mapper.TUserMapper;
import com.ccty.service.ITUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 张峰
 * @since 2023-07-02
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements ITUserService {

}

package com.example.mybatisplus.service.impl;

import com.example.mybatisplus.dao.entity.User;
import com.example.mybatisplus.dao.mapper.UserMapper;
import com.example.mybatisplus.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xingbo.jie
 * @since 2019-05-28
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}

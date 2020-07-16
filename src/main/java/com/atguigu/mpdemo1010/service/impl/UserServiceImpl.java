package com.atguigu.mpdemo1010.service.impl;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.atguigu.mpdemo1010.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiangheng
 * @since 2020-07-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    /**
     * @return
     * @Date 2020/7/16 13:57
     * @Author jiangheng
     * @Description //TODO 根据id 查询一条记录
     **/
    @Override
    public User getById(Serializable id) {
        return super.getById(id);
    }

    @Override
    public List<User> list(Wrapper<User> queryWrapper) {
        return super.list(queryWrapper);
    }

    @Override
    public boolean save(User entity) {
        return super.save(entity);
    }

    /**
     * @return
     * @Date 2020/7/16 16:21
     * @Author jiangheng
     * @Description //TODO 修改用户信息
     **/
    @Override
    public boolean updateById(User entity) {
        return super.updateById(entity);
    }

    /**
     * @return
     * @Date 2020/7/16 16:34
     * @Author jiangheng
     * @Description //TODO  根据id 删除用户信息
     **/
    @Override
    public boolean removeById(Serializable id) {
        return super.removeById(id);
    }
}


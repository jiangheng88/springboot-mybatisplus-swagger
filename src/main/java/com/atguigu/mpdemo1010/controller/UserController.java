package com.atguigu.mpdemo1010.controller;


import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.service.UserService;
import com.atguigu.mpdemo1010.util.ResultMap;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 * 使用swagger2 来管理文档
 * @author jiangheng
 * @since 2020-07-16
 */
@RestController
@RequestMapping("/mpdemo1010/user")
@Api(tags = "用户管理接口")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * @return
     * @Date 2020/7/16 14:21
     * @Author jiangheng
     * @Description //TODO 根据id 查询 一条记录
     **/
    @ApiOperation(value = "根据id查询用户信息")
    @GetMapping("selectOneById/{id}")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public ResultMap selectOne(@PathVariable(value = "id") Integer id) {
        User user = userService.getById(id);
        if (user != null) {
            return ResultMap.success("查询成功", user);
        } else {
            return ResultMap.error("没有数据");
        }
    }

    /**
     * @return
     * @Date 2020/7/16 15:33
     * @Author jiangheng
     * @Description //TODO 查询所有的用户信息
     **/
    @GetMapping("selectAll")
    @ApiOperation(value = "查询所有的用户信息")
    public ResultMap selectAll() {
        List<User> users = userService.list(null);
        if (users != null && users.size() > 0) {
            return ResultMap.success("查询成功", users);
        } else {
            return ResultMap.error("没有数据");
        }
    }

    /**
     * @return
     * @Date 2020/7/16 15:45
     * @Author jiangheng
     * @Description //TODO 添加用户
     **/
    @PostMapping("/insert")
    @ApiOperation(value = "添加用户")
    @ApiImplicitParam(name = "user", value = "添加的用户信息", required = true)
    public ResultMap insert(@RequestBody User user) {
        boolean flag = userService.save(user);
        if (flag) {
            return ResultMap.success("添加成功");
        } else {
            return ResultMap.error("添加失败");
        }
    }

    /**
     * @return
     * @Date 2020/7/16 16:15
     * @Author jiangheng
     * @Description //TODO 根据id修改用户的信息
     **/
    @PutMapping("update/{id}")
    @ApiOperation(value = "更新用户信息", notes = "根据用户id修改用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "用户id",required = true),
            @ApiImplicitParam(name = "user",value = "用户信息")
    })
    public ResultMap update(@PathVariable("id") Integer id,@RequestBody User user){
        User user1 = userService.getById(id);
        user.setId(user1.getId());
        boolean flag = userService.updateById(user);
        if(flag){
            return ResultMap.success("更新成功");
        }
        return ResultMap.error("更新失败");
    }

    /**
     * @return
     * @Date 2020/7/16 16:28
     * @Author jiangheng
     * @Description //TODO 根据id 删除用户信息
     **/
    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "删除用户信息")
    @ApiImplicitParam(name = "id", value = "用户id", required = true)
    public ResultMap delete(@PathVariable("id") long id){
        boolean flag = userService.removeById(id);
        if(flag){
            return ResultMap.success("删除成功");
        }
        return ResultMap.error("更新失败");
    }
}


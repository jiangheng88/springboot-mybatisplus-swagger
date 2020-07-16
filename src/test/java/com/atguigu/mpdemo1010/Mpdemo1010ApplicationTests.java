package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.User;
import com.atguigu.mpdemo1010.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class Mpdemo1010ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    //查询user表所有数据
    @Test
    public void findAll() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }

    //添加操作
    @Test
    public void addUser() {
        User user = new User();
        user.setName("岳不群1");
        user.setAge(70);
        user.setEmail("lucy@qq.com");

//        user.setCreateTime(new Date());
//        user.setUpdateTime(new Date());

        int insert = userMapper.insert(user);
        System.out.println("insert:" + insert);
    }

    //修改操作
    @Test
    public void updateUser() {

        User user = new User();
        user.setId(1231103936770154497L);
        user.setAge(120);

        int row = userMapper.updateById(user);
        System.out.println(row);
    }

    //测试乐观锁
    @Test
    public void testOptimisticLocker() {
        //根据id查询数据
        User user = userMapper.selectById(1231115382920916994L);
        //进行修改
        user.setAge(200);
        userMapper.updateById(user);
    }

    //多个id批量查询
    @Test
    public void testSelectDemo1() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1L, 2L, 3L));
        System.out.println(users);
    }

    @Test
    public void testSelectByMap() {

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "Jone");
        map.put("age", 18);
        List<User> users = userMapper.selectByMap(map);

        users.forEach(System.out::println);
    }

    /**
     * @return
     * @Date 2020/7/16 10:39
     * @Author jiangheng
     * @Description //TODO 分页查询测试
     **/
    @Test
    public void testPage() {
        //1 创建page对象
        //传入两个参数：当前页 和 每页显示记录数
        Page<User> page = new Page<>(1, 3);
        //调用mp分页查询的方法
        //调用mp分页查询过程中，底层封装
        //把分页所有数据封装到page对象里面
        userMapper.selectPage(page, null);
        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示记录数
        System.out.println(page.getTotal()); //总记录数
        System.out.println(page.getPages()); //总页数

        System.out.println(page.hasNext()); //下一页
        System.out.println(page.hasPrevious()); //上一页

    }

    //删除操作 物理删除
    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1231125349744828417L);
        System.out.println(result);
    }

    //批量删除
    @Test
    public void testDeleteBatchIds() {

        int result = userMapper.deleteBatchIds(Arrays.asList(1, 2));
        System.out.println(result);
    }

    //mp实现复杂查询操作
    @Test
    public void testSelectQuery() {
        //创建QueryWrapper对象
        QueryWrapper<User> wrapper = new QueryWrapper<>();

        //通过QueryWrapper设置条件
        //ge、gt、le、lt
        //查询age>=30记录
        //第一个参数字段名称，第二个参数设置值
//        wrapper.ge("age",30);

        //eq、ne
        //wrapper.eq("name","lilei");
        //wrapper.ne("name","lilei");

        //between
        //查询年龄 20-30
        // wrapper.between("age",20,30);

        //like
        //wrapper.like("name","岳");

        //orderByDesc
        // wrapper.orderByDesc("id");

        //last
        //wrapper.last("limit 1");

        //指定要查询的列
        wrapper.select("id", "name");

        List<User> users = userMapper.selectList(wrapper);
        System.out.println(users);

    }

    /**
     * @return
     * @Date 2020/7/16 9:47
     * @Author jiangheng
     * @Description //TODO 测试所有的查询方法
     **/
    @Test
    public void QueryAll() {
        // 根据 ID 查询
        /*User user = userMapper.selectById(1);
        System.out.println(user);
        //// 根据 entity 条件，查询一条记录,参数不能为空
        User user1 = userMapper.selectOne(new QueryWrapper<User>(user,"name"));
        System.out.println(user1);*/
        // 查询（根据ID 批量查询）
        /*List<User> users = userMapper.selectBatchIds(Arrays.asList(1,2));
        System.out.println(users);*/
        // 根据 entity 条件，查询全部记录,后面的参数是限制条件，根据字段名查询
        /*List<User> users = userMapper.selectList(new QueryWrapper<>(null,"name"));
        System.out.println(users);*/
        // 查询（根据 columnMap 条件）
       /* Map map = new HashMap<String,String>();
        map.put("name", "岳不群1");
        map.put("email", "lucy@qq.com");

        List<User> users =  userMapper.selectByMap(map);

        System.out.println(users);*/

        // 根据 Wrapper 条件，查询全部记录。注意： 只返回第一个字段的值
        List<Object> name = userMapper.selectObjs(new QueryWrapper<>(null,"name"));

    }

    /**
     * @return
     * @Date 2020/7/16 10:46
     * @Author jiangheng
     * @Description //TODO 测试sql 性能插件的作用
     **/
    @Test
    void contextLoads(){
        //参数是一个Wrapper，条件结构器，这里先不用，填null
        //查询全部用户s
        List<User> users =userMapper.selectList(null);
        users.forEach(System.out::println);
    }


}

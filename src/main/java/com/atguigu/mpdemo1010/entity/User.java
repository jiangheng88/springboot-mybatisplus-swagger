package com.atguigu.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 * @author jiangheng
 * @since 2020-07-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

    @ApiModelProperty(value = "邮箱")
    private String email;


    /**
     *   @TableId(type = IdType.ID_WORKER) //mp自带策略，生成19位值，数字类型使用这种策略，比如long
     *   @TableId(type = IdType.ID_WORKER_STR) //mp自带策略，生成19位值，字符串类型使用这种策略
     */

    /**
     * @TableId 注解的作用是自动生成主键Id，IdType.AUTO 主键自增
     */
    //@TableId(type=IdType.AUTO)
    /*@TableId(type = IdType.ID_WORKER) //mp自带策略，生成19位值，数字类型使用这种策略，比如long
    private Long id;

    private String name;
    private Integer age;
    private String email;*/


    /*@TableField(fill = FieldFill.INSERT)
    private Date createTime;

     @TableField 注解的作用;可以动态的改变mybatis-plus 框架封装的sql
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @Version
    @TableField(fill = FieldFill.INSERT)
    //版本号
    private Integer version;


    @TableLogic
    private Integer deleted;*/
    /**
     * @TableLogic 注解可以实现 逻辑删除的功能
     * 加@TableLogic的情况：执行update user set deleted=1 where id =1 and deleted=0。
     * 不加@TableLogic的情况：执行delete from user where deleted=0。
     * <p>
     * 同时你还可以 指定要改成具体的值
     * @TableLogic(value="原值",delval="改值")
     */

/*
   //创建时间
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    //更新时间
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;*/


}

#### swagger2 注解说明 
* @Api() 作用于类，表示这个类是swagger管理的资源
```
属性说明：
tags--表示说明
value-- 同样时表示说明，可以使用tags替换
注:tags可以放多个值，多个值放在数组中
@Api(value="Api的 value 属性值说明",tags={"tags属性说明","tags可以使用数组"})
```
* @ApiOperation() 作用于方法，表示一个http请求的操作
```
属性说明：
value--方法描述
notes--内容提示
tags可以重新分组（视情况而用）

@ApiOperation(value="获取用户信息",tags={"获取用户信息copy"},notes="注意问题点")
```
* @ApiParam() 方法的参数,字段说明；表示对参数添加元数据
```
属性说明：
name--参数名
value--参数说明
required--是否必填
```
* @ApiModel 对类的说明，用于参数用实体类接受
```
属性说明：
value–表示对象名
description–描述
都可省略

@ApiModel(value = "User对象", description = "")
```
* @ApiModelProperty()用于方法，字段； 表示对model属性的说明或者数据操作更改
```
属性说明：
value--字段说明
name-- 重写属性名字
dataType--重写属性类型
required--是否必须填写
example --举例说明
hidden-- 隐藏

@ApiModelProperty(value = "姓名")
private String name;
```
* @ApiIgnore()用于类或者方法上，可以不被swagger显示在页面上
* @ApiImplicitParam() 用于方法(表示单个参数)
```
属性说明：
name–-参数名
value–-参数说明
dataType–-数据类型
paramType–-参数类型
example–-举例说明
@ApiImplicitParam(name = "id",value = "用户id",required = true)
```
* @ApiImplicitParams() 用于方法(表示多个参数)，包含多个 @ApiImplicitParam
```
@ApiImplicitParams({
  @ApiImplicitParam(name="name",value="用户名",dataType="string", paramType = "query"),
  @ApiImplicitParam(name="id",value="用户id",dataType="long", paramType = "query")})
```
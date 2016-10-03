返回参数格式 :

```
{
  "code": 0, //0-成功,1-失败
  "data": {...}
}
```
## 用户 api

### 普通用户注册

POST /user/register

请求参数：

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| password      | string    | true |      |
| nickName         | string    | true |  昵称    |
| phone    | string    | true | 手机，11位数字 |
| sex    | string    | true | 可选值: "男"/"女" |

response:
```
//success
{
  "code": 0,
  "data": {
        "userId":12345  //新用户的用户id
  }
}
```
```
//fail-手机号重复
{
  "code": 1, 
  "data": null,
}
```
```
//fail-手机号格式错误
{
  "code": 2,  
  "data": null,
}
```

### 普通用户登录

POST /user/login

请求参数：

| 参数 | 类型 | 必填 |备注 |
| ------------- |:---------:| ----:|----:|
| phone         | string    | true | 手机，11位数字 |
| password      | string    | true |


### 修改密码

POST /user/pwd/change

请求参数：

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:|----:|
| userId | int  | true |   |
| oldPassword | string  | true |   |
| newPassword      | string    | true |     |

### 用户信息

GET /user/info

请求参数：

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| userId    | int    | true |  |


##首页 api

### 歌曲推荐列表

GET /music/recommendation

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| page      | integer | false |大于等于1|
| size      | integer | false |大于等于1|
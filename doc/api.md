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
//fail-手机号不存在或者密码错误
{
  "code": 1, 
  "data": null,
}
```

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

头部信息:

| 参数 | 类型 | 必选 | 备注|
|:---------:|:---------:|:--------:|:--------:|
|token|int|yes|用户id|

请求参数：
response:
```
//success
{
  "code": 200,
  "data": {
    "id": 0,
    "phone": "yuan",
    "password": null,
    "nickName": null,
    "sex": "男"
  }
}
```


##首页 api

### 歌曲推荐列表

GET /music/all

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| page      | integer | false |大于等于1|
| size      | integer | false |大于等于1|

response:
```
{
  "code": 200,
  "data": [
    {
      "id": 1,
      "musicName": "one",
      "musicUrl": "http://....",
      "picUrl": "",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": null
      }
    },
    {
      "id": 2,
      "musicName": "two",
      "musicUrl": "http://asdfnklsdf",
      "picUrl": "....",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": null
      }
    }   
    
  ]
}
```
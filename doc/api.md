返回参数格式 :

```
{
  "code": 0, //0-成功,1-失败
  "data": {...}
}
```

**服务器ip地址: `http://114.215.97.158/bbtmusic`**


## 用户 api

### 普通用户注册

POST /user/add

请求参数：
**contentType: "application/json; charset=utf-8"**

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
**contentType: "application/json; charset=utf-8"**

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
**contentType: "application/json; charset=utf-8"**

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
    "nickName": "yuan",
    "sex": "男",
    "picUrl": "www.baidu.com",
    "province": "广东",
    "city": "广州",
    "birthday": "2016-10-11"
  }
}
```


##首页 api

### 歌曲推荐列表

GET /music/all
**contentType: "application/x-www-form-urlencoded"**

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| page      | integer | true |大于等于1|
| size      | integer | true |大于等于1|

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

###搜索音乐
GET /music/queries
**contentType: "application/x-www-form-urlencoded"**

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
|musicName|String|true|音乐名字的关键字
| page      | integer | true |大于等于1|
| size      | integer | true |大于等于1|

response:
```
{
  "code": 200,
  "data": [
    {
      "id": 1,
      "musicName": "one",
      "musicUrl": "www.baidu.com",
      "picUrl": "www.1.com",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": "男"
      }
    },
    {
      "id": 2,
      "musicName": "two",
      "musicUrl": "www.baidu.com",
      "picUrl": "www.baidu.com",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": "男"
      }
    }
  ]
}
```




## 评论
###获取当前所有评论
GET /comment/all

response:
```
{
  "code": 200,
  "data": [
  
    //第一条评论
    {
      "user": {
        "id": 1,
        "phone": "yuan",
        "nickName": "yuan",
        "picUrl": "www.baidu.com",
      },
      "music": {
        "id": 1,
        "musicName": "one",
        "musicUrl": "www.baidu.com",
        "picUrl": "www.1.com",
        "artist": {
          "id": 1,
          "name": "ya",
          "sex": "男"
        }
      },
      "id": 1,
      "content": "好听",
      "date": "2016-10-10"
    },
    
    //第二条评论
    {
      "user": {
        "id": 2,
        "phone": "18826077178",
        "nickName": "小米",
      },
      "music": {
        "id": 2,
        "musicName": "two",
        "musicUrl": "www.baidu.com",
        "picUrl": "www.baidu.com",
        "artist": {
          "id": 1,
          "name": "ya",
          "sex": "男"
        }
      },
      "id": 2,
      "content": "美妙",
      "date": "2016-10-19"
    }
  ]
}
```



###获取某一个评论下的所有跟帖信息
GET /comment/{id}/message
**其中id为comment的id,实际发送请求的时候把{id}替换成实际的comment的id**
```
//请求id为1的comment的所有跟帖信息
 /comment/1/message
```
response:
```
{
  "code": 200,
  "data": [
    {
      "id": 1,
      "content": "确实很好听啊",
      "user": {
        "id": 3,
        "nickName": "阿西",
        "picUrl": "www.baidu.com",
      },
      "commentId": 1,
      "date": "2016-10-20"
    },
    {
      "id": 2,
      "content": "interesting!",
      "user": {
        "id": 2,
        "nickName": "小米",
        "picUrl": "www.baidu.com",
      },
      "commentId": 1,
      "date": "2016-10-11"
    }
  ]
}
```


## 收藏
### 获取特定用户所收藏的歌曲
GET /music/favorites/all

头部信息:

| 参数 | 类型 | 必选 | 备注|
|:---------:|:---------:|:--------:|:--------:|
|token|int|yes|用户id|

请求参数：
**contentType: "application/x-www-form-urlencoded"**

| 参数 | 类型 | 必选 | 备注|
|:---------:|:---------:|:--------:|:--------:|
|page|int|yes|page>=1,从第几页开始|
|size|int|yes|size>=1,每一页所包含的最大数量|

response:
```
{
  "code": 200,
  "data": [
    {
      "id": 1,
      "musicName": "one",
      "musicUrl": "www.baidu.com",
      "picUrl": "www.1.com",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": "男"
      }
    },
    {
      "id": 2,
      "musicName": "two",
      "musicUrl": "www.baidu.com",
      "picUrl": "www.baidu.com",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": "男"
      }
    }
  ]
}
```

### 收藏歌曲
POST /music/favorites/add

头部信息:

| 参数 | 类型 | 必选 | 备注|
|:---------:|:---------:|:--------:|:--------:|
|token|int|yes|用户id|

请求参数：
**contentType: "application/x-www-form-urlencoded"**

| 参数 | 类型 | 必选 | 备注|
|:---------:|:---------:|:--------:|:--------:|
| musicId |int|yes|要收藏的音乐的id|

response:
```
{
  "code": 200,
  "data": [
    {
      "id": 1,
      "musicName": "one",
      "musicUrl": "www.baidu.com",
      "picUrl": "www.1.com",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": "男"
      }
    },
    {
      "id": 2,
      "musicName": "two",
      "musicUrl": "www.baidu.com",
      "picUrl": "www.baidu.com",
      "artist": {
        "id": 1,
        "name": "ya",
        "sex": "男"
      }
    }
  ]
}
```
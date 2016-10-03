# API 路由

URL 基本路径:

URL 基本路径: 114.215.97.158

demo 地址:  

demo 后台入口

需要验证的接口要传 auth_token, auth_token 是登录接口返回的, 默认5天后过期, 可以通过 `renew_token` 接口更新

请求和返回的格式都是 json，客户端要注意 content-type 是否声明了

返回参数格式 :

```
{
  "result_code": 0,
  "result_msg": "success",
  "data": ..
}
```

result_code 为 0 代表请求成功，其他代表请求失败

result_msg 为返回说明

data 返回的数据，请求单个对象接口返回是一个 json 键值对，请求列表接口是一个数组



## 用户 api

### 普通用户注册

POST /user/pers_register

请求参数：

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| password      | string    | true |      |
| nick_name         | string    | true |  昵称    |
| Phone_no    | string    | true | 手机，11位数字 |
| sex    | string    | true | 可选值: "男"/"女" |

### 普通用户登录

POST /user/pers_login

请求参数：

| 参数 | 类型 | 必填 |备注 |
| ------------- |:---------:| ----:|----:|
| Phone_no         | string    | true | 手机，11位数字 |
| password      | string    | true |

###登录后可或者用户ID，一下操作均在ID已知的前提下
### 修改密码

POST /user/change_password

请求参数：

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:|----:|
| auth_token    | string    | true |  |
| old_password | string  | true |   |
| new_password      | string    | true |     |

### 用户信息

GET /user/profile

请求参数：

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| auth_token    | string    | true |  |

### 更新用户头像

POST /user/avatar

请求参数：

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| auth_token    | string    | true |  |
| avatar    | integer    | true | 上传图片后返回的 id |

##首页 api

### 歌曲推荐列表

GET /Recommendation_Music

| 参数 | 类型 | 必填 | 备注 |
| ------------- |:---------:| ----:| ----:|
| page_index      | integer | false |大于等于1, 不填默认1|
| page_size      | integer | false |大于等于1, 不填默认是10|


##获取热门动态
GET /statuses/friends_timeline 

**返回参数:**

参数名 | 类型 | 备注

id | int | 动态ID

user_name | string | 用户名

profile\_img_url | string | 用户头像url

create_at | string | 分享发表时间

text | string | 分享正文

song_url | string | 歌曲url

pic_urls | array | 图片地址

attitude_count | int | 点赞数 

comment_count | int | 评论数


**示例**
`{
  "statuses":[
  "id":123456,
  "user_name":"xxx",
  "profile_img_url":"http://xxx.xxx.xxx",
  "create_at": "Tue Nov 30 16:05:41 +0800 2010",
  "text": "红红火火恍恍惚惚"，
  "song_url":"http://xxx.xxx.xxx",
  "pic_urls":[
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    "pic_url":"http://xxx.xxx.xxx",
    ],
   "attitude_count":10,
   "comment_count":1
  ]
}`

###获取评论
GET comment/show

**请求参数**

| 参数 | 类型 | 必填 | 备注 |

| id | int64 | true | 分享的ID |

**返回参数**

参数名 | 类型 | 备注

ID | int | 评论ID

create_at | string | 评论发表时间

user_ID | string | 评论者ID

text | string | 评论内容

profile\_img_url | string | 评论者头像小图

**示例**

`{
  "ID":43210,
  "create_at":"Tue Nov 30 16:05:41 +0800 2010" ,
  "user_ID":"xx",
  "text":"blahblahblah",
  "profile\_img_url":"http://xxx.xxx.xxx"
}`

###点赞

POST attitude/up

**请求参数**

| 参数 | 类型 | 必填 | 备注 |

| ID | int64 | true | 动态的ID |


###评论

POST comment/add

**请求参数**

| 参数 | 类型 | 必填 | 备注 |

| ID | int64 | true | 动态的ID |

| user_ID | int64 | true | 用户的ID |

| text | string | true | 评论内容 |


###用户信息查看

GET user/show

**请求参数**

| 参数 | 类型 | 必填 | 备注 |

| user_ID | int64 | true | 用户的ID |

**返回参数**

| 参数名 | 类型 | 备注

| user_ID | int64 | 用户的ID |

| gender | string | 性别 |

| profile_img_url | string | 用户头像url |


##用户的歌单，音乐

###GetData类

	getData(User user, java.lang.String ID, java.lang.String IDType, javax.tools.JavaFileObject jsonObject) 
          从后台获取数据，得到的数据以jsonobject形式呈现,!!

###类 ListContent

GET/offset/limitlistType

| 参数名 | 类型 | 备注

| user_ID | int64 | 用户的ID |




###类 MusicHandle

**getArtistInformation（）**/*歌手的briefDesc*/

post name

get list

| 参数名 | 类型 | 备注 |

| name | string | 歌手的名字 |

| list | JsonObject | 歌手的相关信息 |


**getAlbumInformation（）**/*查找专辑信息*/
post name

get list

| 参数名 | 类型 | 备注 |

| name | string | 歌手的名字 |

| list | JsonObject | 歌手专辑的相关信息 |


**getArtistSongList（）**/*查找其中一名歌手的歌曲列表*/

post name

get list


| 参数名 | 类型 | 备注 |

| name | string | 歌手的名字 |


| list | JsonObject | 歌手歌曲的相关信息 |

**getAlbumSongList（）**/*查找其中一个专辑中包含的歌曲列表*/

post name,Album

get offset,limit


| 参数名 | 类型 | 备注 |

| name | string | 歌手的名字 |

| Album | string| 专辑名 |

| offset | int | 榜单起始序号 |

| limit | int | 榜单每页最大数 |

**getArtistAlbumList()**/*查找其中一个歌手的专辑列表*/

post ID,Album

get offset,limit

| 参数名 | 类型 | 备注 |

| name | string | 歌手的名字 |

| Album | string| 专辑名 |

| offset | int | 榜单起始序号 |

| limit | int | 榜单每页最大数 |


**getCategoryList()**/*获取分类列表*/


###MusicPlayer类

**此处采用文源的dome**

##我的音乐

###MyMusic类

**addMusicToaMyList**

post ID,songID ,name

| 参数名 | 类型 | 备注 |

| ID | int64 | 用户的ID |

| songID | string| 歌曲ID |

| name | int64 | 歌单名字 |





**addMyList**
post|ID,name

| ID | int64 | 用户的ID |

| name | string | 歌单名字 |

**deleteMyList**
post|ID,name

| ID | int64 | 用户的ID |

| name | string | 歌单名字 |


**downloadMusic**

get|url

| ID | int64 | 用户的ID |

| name | string | 歌曲名字 |


**moveMusic**
post|ID|Sname| Dname|

| ID | int64 | 用户的ID |

| Sname | string | 源歌单名字 |

| Dname | string | 目的歌单名字 |


**uploadMusic**

| ID | int64 | 用户的ID |

| name | string | 歌曲名字 |


##User,Song 

**具体可查看文件“歌单音乐api-解压后查看index”**
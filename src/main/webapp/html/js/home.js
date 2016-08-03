/**
 * Created by yuan on 7/29/16.
 */
window.onload=function () {
    getAllMusic();
}
var music=[];
var ap="";
//请求服务器获取所有音乐
function getAllMusic() {
    var url=serverUrl+"music/all";
    sendAjaxRequest(url,null,showMusic);
}

function showMusic(result) {
    var option={
        element: $("#player4")[0],
        narrow: false,
        autoplay: false,
        showlrc: false,
        mutex: true,
        theme: '#ad7a86',
    };
    if(result.data==null)
        return;
    music=result.data;
    option['music']=music;
    ap=new APlayer(option);
    ap.init();
    
    // ap.init();
}

function addMusic() {
    alert("onclick");
    var item=[{
        title: '2',
        author: '七森中☆ごらく部',
        url: 'http://devtest.qiniudn.com/あっちゅ～ま青春!.mp3',
        pic: 'http://devtest.qiniudn.com/あっちゅ～ま青春!.jpg'
    }];
    // music.push(item);
    ap.music=item;
    ap.init();
    // ap.play();
}
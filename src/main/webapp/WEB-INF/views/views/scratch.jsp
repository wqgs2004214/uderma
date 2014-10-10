<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta  charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="format-detection" content="telephone=no" />
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/wx-gcard.css" />"/>
    
    <script type="text/javascript" src="<c:url value="/resources/script/jquery-1.7.2.min.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/script/scratch.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/script/lotteryCore.js" />"></script>
    <title>福利来喽</title>
</head>

<body>
<div class="wx-gcard-banner"><img src="<c:url value="/resources/images/wx-gcard-banner.jpg" />" width="100%" /></div>
<div class="wx-gcard-bg">
	<img src="<c:url value="/resources/images/wx-gcard-bg.jpg" />" width="100%" />
    <div class="wx-gcard-box">

        <div id="gua1" class="ui-gcard-luck" style="overflow:visible;-webkit-transform: translateZ(0);">
            
        </div>
        <div class="ui-gcard-btn">
            <a href="javascript:void(0)" id="control-button" class="wx-gcard-btn">
                
                开始刮奖
            </a>
        </div>

        <div class="ui-gcard-text">
            <a href="javascript:void(0)" class="ui-gcard-a" onclick="luckPopup('wx-gcard-zero2')">没玩够?点我增加刮奖次数!</a>
            <span class="ui-gcard-s">剩余:<span id="lotteryChance">-</span>次</span>
        </div>

        <div class="ui-gcard-menu">
        	<ul class="ui-gcard-ul">
            	<li style="margin-left:0;" class="active">活动介绍</li>
                <li  id="prizeWinnerShow">中奖用户</li>
                <li id="pickupPrize">我要领奖</li>
            </ul>
        </div>
        <div class="ui-gcard-tab" style="display:block;">
	        <ol style="list-style:disc;margin-left:25px;margin-top:10px;margin-right:20px;">
	        	<li>活动时间：即日-12月31日；</li>
	            <li>10件冰寒老师超轻UPF40透气专业防晒衣、30本林志青博士著作《你买的保养品是垃圾还是宝》，由优德医美深圳寄送，中奖者等小优电话联系；</li>
	            <li>50份10元手机话费直接存入您的手机号；</li>
	            <li>每位粉丝只能绑定1个微信账号参加活动；</li>
                <li>本活动最终解释权归属优德医美。</li>
	        </ol>
        </div>
        <div class="ui-gcard-tab">
        	<div id="prizeWinnerList">
            </div>
        </div>
        <div class="ui-gcard-tab">
            <div id="prizeWinningList">
        	<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#f0af6d" style="margin:0 auto;border-collapse: collapse; margin-top:3px; font-family:'微软雅黑'; color:#666666;">
              <tr>
                <td width="14%" height="30" align="center"><p style="color:#333;">序号</p></td>
                <td width="29%" align="center"><p style="color:#333;">奖品</p></td>
                <td width="28%" align="center"><p style="color:#333;">中奖日期</p></td>
                <td width="29%" align="center"><p style="color:#333;">操作</p></td>
              </tr>
            </table>
            </div>
        </div>
    </div>
</div>
<div class="wx-gcard-tc"></div>

<div class="wx-gcard-zero">
    <div class="wx-gcard-up"><img src="<c:url value="/resources/images/wx-gcard-up.png" />" width="100%" /></div>
    <div class="show-box">
        <p class="show-p-h">点击【查看公众号】并关注</p>
        <!-- <p class="show-p-h">小米手环在向你招手了！</p> -->
    </div>
    <div class="fx-btn"><a href="javascript:void(0)" onclick="javascript:closePopup('wx-gcard-zero')"><img src="<c:url value="/resources/images/wx-gcard-sure.png" />" width="100%" /></a></div>
</div>

<div class="wx-gcard-zero2">
    <div class="wx-gcard-up"><img src="<c:url value="/resources/images/wx-gcard-up.png" />" width="100%" /></div>
    <div class="show-box">
        <p class="show-p-h">分享到【朋友圈】增加刮奖次数</p>
        <p>好友点击1次，就能增加1次刮奖机会！</p>
    </div>
    <div class="fx-btn"><a href="javascript:void(0)" onclick="javascript:closePopup('wx-gcard-zero2')"><img src="<c:url value="/resources/images/wx-gcard-sure.png" />" width="100%" /></a></div>
</div>

<div class="wx-gcard-one">
	<div class="wx-gcard-up"><img src="<c:url value="/resources/images/wx-gcard-up.png" />" width="100%" /></div>
    <div class="show-box" id="prizeAlert">
    	<p class="show-p-h">中奖信息</p>
        <p>真是羡煞旁人啊~~~~</p>
        <p>赶快通知亲朋友好友来抢！</p>
        <p>分享朋友圈后可领奖哈~</p>
    </div>
    <div class="fx-btn"><a href="javascript:void(0)" onclick="javascript:closePopup('wx-gcard-one')"><img src="<c:url value="/resources/images/wx-gcard-f.png" />" width="100%" /></a></div>
</div>
<div class="wx-gcard-two">
	<div  id="userInfo"></div>
	<div class="fx-btn" id="savePlayerInfo"><a href="javascript:void(0)"><img src="<c:url value="/resources/images/wx-gcard-t.png"/>" width="100%" /></a></div>
</div>
<div class="wx-gcard-three">
	<div class="show-box">
    	<p class="show-p-h">妥！</p>
        <p>我们将在3个工作日内联系您！</p>
    </div>
    <div class="fx-btn"><a href="javascript:void(0)" onclick="javascript:closePopup('wx-gcard-three')"><img src="<c:url value="/resources/images/wx-gcard-sure.png"/>" width="100%" /></a></div>
</div>
<div class="wx-gcard-four">
    <div class="show-box" id="commonInfoBox">
        <p class="show-p-h">提示信息</p>
        <!-- <p>你好~让小U给您跳个舞吧~咳咳~</p> -->
    </div>
    <div class="fx-btn"><a href="javascript:void(0)" onclick="javascript:closePopup('wx-gcard-four')"><img src="<c:url value="/resources/images/wx-gcard-sure.png"/>" width="100%" /></a></div>
</div>
<script>
//刮奖弹出层
var oWxCardTc=getByClass(document,"wx-gcard-tc")[0];

function luckPopup(e)
{
	var oWxCardNum=getByClass(document,e)[0];
	oWxCardNum.style.display="block";
	oWxCardTc.style.display="block";
	oWxCardTc.style.height=document.documentElement.clientHeight+"px";
}

//关闭
function closePopup(e)
{
	var oWxCardCon=getByClass(document,e)[0];
	oWxCardCon.style.display="none";
	oWxCardTc.style.display="none";
    $('#gua1').wScratchPad('reset');
    $("#control-button").show();
    $("#masking").show();
}

//tab切换
var oUiCardUl=getByClass(document,"ui-gcard-ul")[0];
var aUiCardUlLi=oUiCardUl.getElementsByTagName("li");
var aUiCardTab=getByClass(document,"ui-gcard-tab");
for(var i=0;i<aUiCardUlLi.length;i++)
{
	aUiCardUlLi[i].index=i;
	aUiCardUlLi[i].onclick=function()
	{
		for(var i=0;i<aUiCardUlLi.length;i++)
		{
			aUiCardUlLi[i].className="";
			aUiCardTab[i].style.display="none";
		}
		this.className="active";
		aUiCardTab[this.index].style.display="block";
	}
}
function appendBorder(obj)
{
	obj.style.border="1px solid #f18d00";
	obj.onblur=function()
	{
		obj.style.border="1px solid #dfdfdf";
	}
}
function getByClass(oParent, sClass)
{
	var aBox = oParent.getElementsByTagName("*");
	var i=0;
	var aResult=[];
	for(i=0;i<aBox.length;i++)
	{
		if(aBox[i].className == sClass)
		{
			aResult.push(aBox[i]);
			}
		}
	return aResult;
}

function pickupMyPrize(goodsId){
	//我要领奖
    var url = "/asdwx/promotion/pickup.do";
    $("#goods"+goodsId).html("领取中...");
    var param = {
        prizeGoodsId:goodsId
    };
    $.post(url,param,function(data){

        var data = JSON.parse(data);
        var status = data.status;
        var statusMsg=data.statusMsg;

        var msg = '';
        msg+=[
            '<p class="show-p-h">提示信息</p>',
            '<p>',statusMsg,'</p>'
        ].join('');

        var tpl = '';
        tpl+=[
            '<div class="show-box" id="commonInfoBox">',
            msg,
            '</div>'
        ].join('');
        $("#commonInfoBox").replaceWith(tpl.toString());


        if(status=="notbind"){
            //未绑定，跳转到绑定页面
            window.location.href="/asdwx/promotion/bindPreProcess.do?prizeGoodsId="+goodsId;
            return;
        }else if(status=="ok"){
            
            luckPopup("wx-gcard-four");
            $("#goods"+goodsId).html("已领取");
            return;
        }else if(status=="error"){
            luckPopup("wx-gcard-four");
            $("#goods"+goodsId).html("<a href=\"javascript:void(0)\" onclick=\"pickupMyPrize('"+goodsId+"')\">领奖</a></td>");
        }else if(status=="syserror"){
            
            luckPopup("wx-gcard-four");
            $("#goods"+goodsId).html("<a href=\"javascript:void(0)\" onclick=\"pickupMyPrize('"+goodsId+"')\">领奖</a></td>");
            return;
        }else if(status=="not1709"){
            
            luckPopup("wx-gcard-four");
            $("#goods"+goodsId).html("<a href=\"javascript:void(0)\" onclick=\"pickupMyPrize('"+goodsId+"')\">领奖</a></td>");
            return;
        }else if(status=="sessionout"){
            
            luckPopup("wx-gcard-four");
            $("#goods"+goodsId).html("<a href=\"javascript:void(0)\" onclick=\"pickupMyPrize('"+goodsId+"')\">领奖</a></td>");
            return;
        }else if (status=="realGoods"){
            
        	var msg = '';
        	  msg+=[
                    '<div class="show-box">',
                    '<div class="infomation-text" id="lxfs">填写联系方式：</div>',
                    '<div class="infomation-box"><span style="letter-spacing:32px;">姓</span>名 <input type="text" class="" value="" name="" onclick="appendBorder(this)" id="userName"/><span style="color:red;">*</span></div>',
					'<div class="infomation-box"><span>联系电话</span> <input type="text" value="" name="" class="" onclick="appendBorder(this)" id="userPhone"/><span style="color:red;">*</span></div>',
					'<input type="hidden" id="prizeGoodsId" value="'+goodsId+'"></div>'
					].join('');
                msg+=[,
                    '</div>',
                    '</tr>'
                ].join('');
       $("#userInfo").replaceWith(msg.toString());
       luckPopup('wx-gcard-two');
        }

    });
}

$("#prizeWinnerShow").click(function(){
	//获取获奖用户列表
    var activityId =  Lottery.getActivityId();
    var url = "<c:url value="/viewRecentPrizeUser" />";
	    var param = {
	    		activityId:activityId
	    };
	    $.post(url,param,function(data){
	    	var result = JSON.parse(data);
	    	var msg = '';
	    	for(var i=0;i<result.length;i++){
	    		var nickName = result[i].winnerNickname;
	    		var time = result[i].winningTime;
                if(nickName==undefined || nickName==''){
                    nickName='匿名用户';
                }
	    		var prizeAlias = result[i].prizeGoodsName;
	    		
                msg+=[
                    '<tr>',
                    '<td><p style="color:#333;">',nickName.substring(0,2) +"**",'</p></td>',
                    '<td><p style="color:#333;">',prizeAlias,'</p></td>',
                    '<td><p style="color:#333;">',time,'</p></td>',
                    ].join('');
                msg+=[,
                    '</div>',
                    '</tr>'
                ].join('');

            }
            var tpl = ['<table width="100%;">',
                msg,
                '</table>'
            ].join('');

            $("#prizeWinnerList").replaceWith(tpl.toString());
	    });
});

$(function() {

    Lottery.init();
    Lottery.getInviteCode();

    $("#pickupPrize").click(function(){
        Lottery.getWinningList();
    });

    $("#gua1").wScratchPad({
        width: $("#gua1").width(),
        image2: '<c:url value="/resources/images/wx-gcard-luck.jpg" />',
        text: '',
        scratchUp: function (e, percent) {
            if (percent > 30) {
                this.clear();
            }
        }
    });
});

$("#savePlayerInfo").click(function(){
	var userName = $("#userName").val();
	var userPhone = $("#userPhone").val();
	if(userName == undefined || userName =="" || userName == null){
        document.getElementById("userName").style.borderColor="red";  
        return;
	}
	//!(/^1[3|4|5|8][0-9]\d{4,8}$/.test(sMobile))
	
		if(userPhone == undefined || userPhone==null || userPhone=="" || !(/^1[3|4|5|7|8][0-9]\d{8}$/.test(userPhone))){
	        document.getElementById("userPhone").style.borderColor="red";  
	        return;
		}
	var prizeGoodsId = $("#prizeGoodsId").val();
	var activityId =  Lottery.getActivityId();
    var url = "/asdwx/promotion/savePlayerInfo.do";
	    var param = {
	    		activityId:activityId,
	    		userName:userName,
	    		phoneNo:userPhone,
	    		prizeGoodsId:prizeGoodsId
	    };
	    $.post(url,param,function(data){
			 var result = JSON.parse(data);
		    if(result.status=='error'){
		    	$("#lxfs").html("填写联系方式："+result.statusDesc);
		    	return ;
			 }else{
				 closePopup("wx-gcard-two");
		    	 $("#goods"+prizeGoodsId).replaceWith("已领取");
			}
	    	
	    });
});


$("#control-button").bind("click",function(){
    if(Lottery.getChance()==undefined){
        alert("对不起，系统好像感冒了，请稍后重试！");
        return;
    }
    if(Lottery.getChance()<=0){
        luckPopup('wx-gcard-zero2');
        return;
    }
    $("#masking").hide();
    Lottery.play();
    $("#control-button").hide();
});


var imgUrl = '';

var lineLinkPrefix = 'https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx28d1b2def70df706&redirect_uri=http%3A%2F%2Fpush3gtest.smt-online.net%2Fuderma%2FviewShare&response_type=CODE&scope=snsapi_base&state=';
var lineLinkSuffix = '#wechat_redirect';
var descContent = "疯狂派送喽！";
var shareTitle = '一大波好福利，不要躲避！';

var appid = 'wx28d1b2def70df706';

function shareFriend() {
    var inviteCode = Lottery.getInviteCode();
    WeixinJSBridge.invoke('sendAppMessage',{
        "appid": appid,
        "img_url": imgUrl,
        "img_width": "640",
        "img_height": "640",
        "link": lineLinkPrefix+inviteCode+lineLinkSuffix,
        "desc": descContent,
        "title": shareTitle
    }, function(res) {
        _report('send_msg', res.err_msg);
    })
}
function shareTimeline() {
    var inviteCode = Lottery.getInviteCode();
    WeixinJSBridge.invoke('shareTimeline',{
        "img_url": imgUrl,
        "img_width": "640",
        "img_height": "640",
        "link": lineLinkPrefix+inviteCode+lineLinkSuffix,
        "desc": descContent,
        "title": shareTitle
    }, function(res) {
        _report('timeline', res.err_msg);
    });
}

document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    WeixinJSBridge.on('menu:share:appmessage', function(argv){
        shareFriend();
    });
    WeixinJSBridge.on('menu:share:timeline', function(argv){
        shareTimeline();
    });
}, false);
document.addEventListener('WeixinJSBridgeReady', function onBridgeReady() {
    WeixinJSBridge.call('showOptionMenu');
});
</script>
</body>
</html>

var Lottery = (function(){
    var activityId, isFollow, chance, winningList, playerInviteCode;
    function getActivityId(){
        return activityId;
    }

    function getChance(){
        return chance;
    }

    function init(){
        var url = "init";
        var param="";

        $.post(url,param,function(data){
        	//"{"activityId":"134","isFollow":"no","inviteCode":"54b49bb465f16e762065aa99efebdbf4","chance":"2"}"
            var result = JSON.parse(data);
            activityId = result.activityId;
            isFollow = result.isFollow;
            chance=result.chance;
            $("#lotteryChance").html(chance);
            if(isFollow=="no"){//如果未关注，弹出遮罩层请求用户关注
//                alert("您未关注！请关注后才能参与活动。");
                luckPopup("wx-gcard-zero");
            }

        });

    }

    /**
     * 向服务器请求刮刮卡
     */
    function play(){
        //开始刮奖前判断：1.没有关注；2.次数为0；3.其他服务器原因
        if(isFollow=="no"){
            luckPopup('wx-gcard-zero');
            return;
        }
        if(chance==0){
            //弹出窗口告诉用户没有机会了，分享后可以增加机会！
        }

        var url = "play";
        var param="";
        $.post(url, param, function(data){
            var result = JSON.parse(data);
            //更新中奖信息到挂彩区域
            $('#gua1').wScratchPad('update',result.prizeDesc);
            var msg = '';
            if(result.prizeDesc=='呃！再刮一次吧~'){
                msg+=[
                    '<p class="show-p-h">',result.prizeDesc,'</p>',
                    '<p>很遗憾，您没有中奖！</p>',
                    '<p>分享朋友圈来获得更多刮奖机会吧！</p>'
                ].join('');
                window.shareTitle='U.友刮刮卡→见证友谊的时刻到了，快来点击，我们一起得小米手环吧！';
            }else{
                msg+=[
                    '<p class="show-p-h">',result.prizeDesc,'</p>',
                    '<p>真是羡煞旁人啊~~~~</p>',
                    '<p>赶快通知亲朋友好友来抢！</p>',
                    '<p>分享朋友圈后可领奖哈~</p>'
                ].join('');
                window.shareTitle='我在U.友刮刮卡活动中刮出了'+result.prizeDesc+'！你来试试？';
            }

            var tpl = '';
            tpl+=[
                '<div class="show-box" id="prizeAlert">',
                msg,
                '</div>'
            ].join('');
            $("#prizeAlert").replaceWith(tpl.toString());


        });
        //扣减次数
        chance-=1;
        $("#lotteryChance").html(chance);//更新界面显示
    }

    function reset(){

    }

    function getWinningList(){
        var url="/asdwx/promotion/getUsrPriList.do";
        var param;
            $.post(url,param,function(data){
                var result = JSON.parse(data);
                var msg = '';
                if(result==""||result==undefined||result==null){
                	msg+=[
                          '<tr><td colspan="4"> <p style="font-size: 24px;color: #FF0000;font-style: italic;text-align: center">您还没有中奖记录哦！</p></td> </tr>'].join('');
                }else{
                	for(var i=0;i<result.length;i++){
                		var prizeGoodsId = result[i].prizeGoodsId;
                		var winnerNickname = result[i].winnerNickname;
                		var prizeGoodsStatus = result[i].prizeGoodsStatus;
                		var prizeAlias = result[i].prizeAlias;
                		var activityName = result[i].activityName;
                		var winningTime = result[i].winningTime;
                		msg+=[
                		      '<tr>',
                		      '<td width="14%" height="30" align="center"><p style="color:#333;">',i+1,'</p></td>',
                		      '<td width="29%" align="center"><p style="color:#333;">',prizeAlias,'</p></td>',
                		      '<td width="28%" align="center"><p style="color:#333;">',winningTime,'</p></td>',
                		      '<td width="29%" align="center"><p style="color:#333;">',
                		      '<div id="goods',prizeGoodsId,'">'].join('');
                		if(prizeGoodsStatus==2){
                			msg+=[
                			      '已领取'].join('');
                		}else if(prizeGoodsStatus==1){
                			msg+=[
                			      '<a href="javascript:void(0)" onclick="pickupMyPrize(',prizeGoodsId,')">领奖</a></td>'].join('');
                		}
                		msg+=[,
                		      '</div>',
                		      '</tr>'
                		      ].join('');
                		
                	}
                }

                var tpl = [
                           	'<table width="100%" border="1" cellspacing="0" cellpadding="0" bordercolor="#f0af6d" style="margin:0 auto;border-collapse: collapse; margin-top:3px; font-family:"微软雅黑"; color:#666666;">',
                                '<tr>',
	                              '  <td width="14%" height="30" align="center"><p style="color:#333;">序号</p></td>',
	                              '  <td width="29%" align="center"><p style="color:#333;">奖品</p></td>',
	                              ' <td width="28%" align="center"><p style="color:#333;">中奖日期</p></td>',
	                              ' <td width="29%" align="center"><p style="color:#333;">操作</p></td>',
                                '</tr>',
                    msg,
                    '</table>'
                ].join('');

                $("#prizeWinningList").replaceWith(tpl.toString());
            });
    }

    function getInviteCode(){
        var url = "getid";
        var param = "";
        if(playerInviteCode==undefined){
            $.post(url, param, function(data){
                var result = JSON.parse(data);
                if(result.status=='ok'){
                    playerInviteCode=""+result.inviteCode;
                }else{
                    playerInviteCode='undefined';
                }
            });
        }else{
            return playerInviteCode;
        }

    }

    return {'getActivityId':getActivityId,
        'getChance':getChance,
        'init':init,
        'play':play,
        'reset':reset,
        'getWinningList':getWinningList,
        'getInviteCode':getInviteCode};
})();


package u.derma.model;

import java.util.Date;

public class WeixinPrizeInfo {
	//礼品id
	private String id;
	private String winnerNickname;
	//奖品状态2领取 1未领取
	private int prizeGoodsStatus;
	//礼品名
	private String prizeGoodsName;
	//中奖用户id
	private String openid;
	private Date winningTime;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWinnerNickname() {
		return winnerNickname;
	}
	public void setWinnerNickname(String winnerNickname) {
		this.winnerNickname = winnerNickname;
	}
	public int getPrizeGoodsStatus() {
		return prizeGoodsStatus;
	}
	public void setPrizeGoodsStatus(int prizeGoodsStatus) {
		this.prizeGoodsStatus = prizeGoodsStatus;
	}
	
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	public Date getWinningTime() {
		return winningTime;
	}
	public void setWinningTime(Date winningTime) {
		this.winningTime = winningTime;
	}
	public String getPrizeGoodsName() {
		return prizeGoodsName;
	}
	public void setPrizeGoodsName(String prizeGoodsName) {
		this.prizeGoodsName = prizeGoodsName;
	}


}
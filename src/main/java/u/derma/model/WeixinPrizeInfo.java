package u.derma.model;

import java.util.Date;

public class WeixinPrizeInfo {

	private int prizeGoodsId;
	private String winnerNickname;
	private int prizeGoodsStatus;
	private String userid;
	private Date winningTime;
	public int getPrizeGoodsId() {
		return prizeGoodsId;
	}
	public void setPrizeGoodsId(int prizeGoodsId) {
		this.prizeGoodsId = prizeGoodsId;
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
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getWinningTime() {
		return winningTime;
	}
	public void setWinningTime(Date winningTime) {
		this.winningTime = winningTime;
	}


}
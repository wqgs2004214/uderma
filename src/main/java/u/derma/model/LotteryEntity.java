package u.derma.model;

import javax.xml.bind.annotation.XmlRootElement;


/**
 * 抽奖实体
 * 
 * @author wqgs2004214
 * 
 */
@XmlRootElement
public class LotteryEntity {
	private String activityId = "";
	private String isFollow = "no";
	private int chance;
	private String playerInviteCode = "";

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getIsFollow() {
		return isFollow;
	}

	public void setIsFollow(String isFollow) {
		this.isFollow = isFollow;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public String getPlayerInviteCode() {
		return playerInviteCode;
	}

	public void setPlayerInviteCode(String playerInviteCode) {
		this.playerInviteCode = playerInviteCode;
	}

	@Override
	public String toString() {
		return "{\"activityId\":\"" + activityId + "\",\"isFollow\":\""
				+ isFollow + "\",\"chance\":\"" + chance + "\",\"playerInviteCode\":\""
				+ playerInviteCode + "\"}";
	}
}

package u.derma.model;

public class WeixinGoods {

	private int prizeGoodsId;
	private String prizeAlias;
	private String prizeGoodsNumber;

	public int getPrizeGoodsId() {
		return prizeGoodsId;
	}

	public void setPrizeGoodsId(int prizeGoodsId) {
		this.prizeGoodsId = prizeGoodsId;
	}

	public String getPrizeAlias() {
		return prizeAlias;
	}

	public void setPrizeAlias(String prizeAlias) {
		this.prizeAlias = prizeAlias;
	}

	public String getPrizeGoodsNumber() {
		return prizeGoodsNumber;
	}

	public void setPrizeGoodsNumber(String prizeGoodsNumber) {
		this.prizeGoodsNumber = prizeGoodsNumber;
	}

	@Override
	public String toString() {
		return "{\"prizeGoodsId\":\"" + prizeGoodsId + "\", \"prizeAlias\":\""
				+ prizeAlias + "\", \"prizeGoodsNumber\":\"" + prizeGoodsNumber
				+ "\"}";
	}

}
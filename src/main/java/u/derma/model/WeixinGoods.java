package u.derma.model;

public class WeixinGoods {

	private int prizeGoodsId;
	private String prizeAlias;
	private int prizeGoodsNumber;

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

	

	public int getPrizeGoodsNumber() {
		return prizeGoodsNumber;
	}

	public void setPrizeGoodsNumber(int prizeGoodsNumber) {
		this.prizeGoodsNumber = prizeGoodsNumber;
	}

	@Override
	public String toString() {
		return "{\"prizeGoodsId\":\"" + prizeGoodsId + "\", \"prizeAlias\":\""
				+ prizeAlias + "\", \"prizeGoodsNumber\":\"" + prizeGoodsNumber
				+ "\"}";
	}

}
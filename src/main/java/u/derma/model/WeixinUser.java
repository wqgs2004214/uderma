package u.derma.model;

import java.util.Date;

public class WeixinUser {
    //private String id = "";

    //openid用户的标识，对当前公众号唯一
    private String openid = "";

    private Integer lotterynumber;
    
    private String nickname = "";
    
    //用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
    private int sex;
    
    //用户所在城市
    private String city = "";
    
    //用户所在国家
    private String country = "";
    
    //用户所在省份
    private String province = "";
	
    private Date createDate;
	public Integer getLotterynumber() {
		return lotterynumber;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setLotterynumber(Integer lotterynumber) {
		this.lotterynumber = lotterynumber;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



}
package u.derma.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import u.derma.dao.WeixinUserMapper;
import u.derma.model.WeixinUser;

@Service("weixinUserService")
public class WeixinUserServiceImpl implements WeixinUserServiceI{
	
	@Autowired
	private WeixinUserMapper weixinUserMapper;
	
//	public WeixinUserMapper getWeixinUserMapper() {
//		return weixinUserMapper;
//	}
//	
//	public void setWeixinUserMapper(WeixinUserMapper weixinUserMapper) {
//		this.weixinUserMapper = weixinUserMapper;
//	}
	@Override
	public List<WeixinUser> getAll() {
		return weixinUserMapper.getAll();
	}
	@Override
	public int addLotteryNumber(String userid) {
		return weixinUserMapper.addLotteryNumber(userid);
	}
	@Override
	public int insert(WeixinUser user) {
		return weixinUserMapper.insert(user);
	}
	@Override
	public WeixinUser selectByUserid(String userid) {
		return weixinUserMapper.selectByUserid(userid);
	}

	

}

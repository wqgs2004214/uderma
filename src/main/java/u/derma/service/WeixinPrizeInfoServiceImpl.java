package u.derma.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import u.derma.dao.WeixinPrizeInfoMapper;
import u.derma.model.WeixinPrizeInfo;

@Service("weixinPrizeInfoService")
public class WeixinPrizeInfoServiceImpl implements WeixinPrizeInfoServiceI {
	@Autowired
	private WeixinPrizeInfoMapper weixinPrizeInfoMapper;
	@Override
	public List<WeixinPrizeInfo> selectByUserid(String userid) {
		return weixinPrizeInfoMapper.selectByUserid(userid);
	}
	@Override
	public int insert(WeixinPrizeInfo info) {
		return weixinPrizeInfoMapper.insert(info);
	}
	@Override
	public List<WeixinPrizeInfo> getAll() {
		return weixinPrizeInfoMapper.getAll();
	}
	

	
}

package u.derma.dao;

import java.util.List;

import u.derma.model.WeixinUser;


public interface WeixinUserMapper {
	/**
	 * 插入微信用户
	 * @param user
	 * @return
	 */
    int insert(WeixinUser user);
    /**
     * 每次增加指定用户的抽奖数
     * @param userid
     * @return
     */
    int addLotteryNumber(String userid);
    
    /**
     * 减少指定用户的抽奖数 
     * @param userid
     * @return
     */
    int minusLotteryNumber(String userid);
    
    /**
     * 通过用户id查询
     * @param userid
     * @return
     */
    WeixinUser selectByUserid(String userid);
    /**
     * 获取所有用户
     * @return
     */
    List<WeixinUser> getAll();
    
    
    
    
}
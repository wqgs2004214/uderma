package u.derma.dao;

import u.derma.model.WeixinShareViewHistory;

public interface WeixinShareViewHistoryMapper {
	public WeixinShareViewHistory select(WeixinShareViewHistory history);
	
	public int insert(WeixinShareViewHistory history);
	
}

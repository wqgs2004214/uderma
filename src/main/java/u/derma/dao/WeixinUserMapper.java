package u.derma.dao;

import java.util.List;

import rml.model.MUser;

public interface WeixinUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(MUser record);

    int insertSelective(MUser record);

    MUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(MUser record);

    int updateByPrimaryKey(MUser record);
    
    List<MUser> getAll();
}
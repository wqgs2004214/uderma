import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import u.derma.model.WeixinGoods;
import u.derma.model.WeixinPrizeInfo;
import u.derma.model.WeixinUser;
import u.derma.service.WeixinGoodsServiceI;
import u.derma.service.WeixinPrizeInfoServiceI;
import u.derma.service.WeixinUserServiceI;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
public class TestMybatis {

	private static final Logger logger = Logger.getLogger(TestMybatis.class);
	
	@Autowired
	private WeixinGoodsServiceI weixinGoodsService;
	//private WeixinUserServiceI weixinUserService;
	
	@Autowired
	private WeixinPrizeInfoServiceI weixinPrizeInfoService;
	
	@Test
	public void test1() {
		List<WeixinGoods> list = weixinGoodsService.getAll();
		//List<WeixinUser> list = weixinUserService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd HH:mm:ss"));
		
		List<WeixinPrizeInfo> list1 = weixinPrizeInfoService.getAll();
		logger.info(JSON.toJSONStringWithDateFormat(list1, "yyyy-MM-dd HH:mm:ss"));
	}
	
//	//@Test
//	public void test2() {
//	
//		MUser muser = new MUser();
//		muser.setId("0000");
//		muser.setName("aaaa");
//		muser.setAge(1234);
//		muser.setAddress("ABCD");
//		int i = muserService.insert(muser);
//		logger.info(JSON.toJSONStringWithDateFormat("add "+i, "yyyy-MM-dd HH:mm:ss"));
//	}
//	
//	//@Test
//	public void test3() {
//		
//		MUser muser = new MUser();
//		muser.setId("0000");
//		muser.setName("bbbb");
//		muser.setAge(1234);
//		muser.setAddress("ABCD");
//		int i = muserService.update(muser);
//		logger.info(JSON.toJSONStringWithDateFormat("update " +i, "yyyy-MM-dd HH:mm:ss"));
//	}
//	
//	//@Test
//	public void test4() {
//		
//		MUser muser = new MUser();
//		muser.setId("0000");
//		muser.setName("bbbb");
//		muser.setAge(1234);
//		muser.setAddress("ABCD");
//		int i = muserService.delete("0000");
//		logger.info(JSON.toJSONStringWithDateFormat("delete "+i, "yyyy-MM-dd HH:mm:ss"));
//	}
	
}

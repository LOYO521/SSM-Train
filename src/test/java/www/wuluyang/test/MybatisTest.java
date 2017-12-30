package www.wuluyang.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import www.wuluyang.service.IStationService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:spring.xml","classpath:spring-mybatis.xml"})
public class MybatisTest {
	@Autowired
	private IStationService stationService;
	@Test
	public void testStartAndEndPrice(){
		//类返回值的快捷键将光标放在;后面按ctrl+1,弹出 Assign statement to new local varible,enter即可.
		//ClassPathXmlApplicationContext beans = new ClassPathXmlApplicationContext(new String []{"spring.xml","spring-mybatis.xml"});
	
		// IStationService stationService=(IStationService) beans.getBean("stationService");
		Double  startAndEndPrice=stationService.startAndEndPrice("k339", "秦皇岛", "哈尔滨");
		System.out.println("startAndEndPrice:"+startAndEndPrice);
	}
}

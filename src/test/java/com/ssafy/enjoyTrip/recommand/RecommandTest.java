package com.ssafy.enjoyTrip.recommand;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ssafy.enjoyTrip.recommand.dao.RecommandDao;
import com.ssafy.enjoyTrip.recommand.service.RecommandService;

@SpringBootTest
public class RecommandTest {
	
	@Autowired
	RecommandDao recommandDao;
	
	@Autowired
	RecommandService recommandService;
	
	@Test
	@Order(1)
	@DisplayName("DI test")
	public void tsetDi() {
		assertNotNull(recommandDao);
		assertNotNull(recommandService);
	}
	
	@Test
	@Order(2)
	@DisplayName("RecommandByAddr Dao Test")
	public void testRecommand() {
		int uuid = 4;
		assertNotNull(recommandDao.recommandWithAddr(uuid));
	}
	
	@Test
	@Order(3)
	@DisplayName("RecommandPopular Dao Test")
	public void testRecommandPopular() {
		int uuid = 4;
		assertNotNull(recommandDao.recommandPopular(uuid));
	}
	
	@Test
	@Order(4)
	@DisplayName("RecommandByType Dao Test")
	public void recommandByType() {
		int uuid = 4;
		assertNotNull(recommandDao.recommandByType(uuid));
	}
	
	@Test
	@Order(5)
	@DisplayName("RecommandByAddr Service Test")
	public void testRecommandService() {
		int uuid = 4;
		assertNotNull(recommandService.recommandWithAddr(uuid));
	}
	
	@Test
	@Order(6)
	@DisplayName("RecommandPopular Service Test")
	public void testRecommandPopularService() {
		int uuid = 4;
		assertNotNull(recommandService.recommandPopular(uuid));
	}
	
	@Test
	@Order(7)
	@DisplayName("RecommandByType Service Test")
	public void recommandByTypeService() {
		int uuid = 4;
		assertNotNull(recommandService.recommandByType(uuid));
	}
}

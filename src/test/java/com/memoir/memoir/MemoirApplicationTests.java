package com.memoir.memoir;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ActiveProfiles("test")
class MemoirApplicationTests {

	@Test
	void contextLoads() {
		// 애플리케이션 컨텍스트가 정상적으로 로드되는지 확인
	}

}

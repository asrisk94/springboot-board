package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	// 도메인주소 컨텍스트패쓰 뒤 URL 매핑
	@RequestMapping("/sbb")
	// 해당 매핑에 대한 응답
	@ResponseBody
	public String index() {
		return "index";
	}
	
}

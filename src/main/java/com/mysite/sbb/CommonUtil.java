package com.mysite.sbb;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.springframework.stereotype.Component;

@Component
// 스프링부트가 관리하는 bean -> 템플릿에서 사용 가능
public class CommonUtil {
	public String markdown(String markdown) {
		Parser parser = Parser.builder().build();
		Node document = parser.parse(markdown);
		HtmlRenderer renderer = HtmlRenderer.builder().build();
		
		// markdown 적용된 일반 text -> HTML문서로 변환
		return renderer.render(document);
	}
}

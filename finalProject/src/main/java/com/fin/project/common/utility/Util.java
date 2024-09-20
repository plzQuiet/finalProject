package com.fin.project.common.utility;

import java.text.SimpleDateFormat;

public class Util {

	// Cross Site Scripting(XSS) 방지 처리
	// - 웹 애플리케이션에서 발생하는 취약점
	// - 권한이 없는 사용자가 사이트에 스크립트를 작성하는 것

	public static String XSSHandling(String content) {

		content = content.replaceAll("&", "&amp;");
		content = content.replaceAll("<", "&lt;");
		content = content.replaceAll(">", "&gt;");
		content = content.replaceAll("\"", "&quot;");

		return content;
	}

	// a.jpg

	// 파일명 변경 메소드
	public static String fileRename(String originFileName) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String date = sdf.format(new java.util.Date(System.currentTimeMillis()));

		int ranNum = (int) (Math.random() * 100000); // 5자리 랜덤 숫자 생성

		String str = "_" + String.format("%05d", ranNum);

		String ext = originFileName.substring(originFileName.lastIndexOf("."));

		return date + str + ext;
	}

	public static String newLineHandling(String content) {
		return content.replaceAll("(\r\n|\n\r|\n|\r)", "<br>");

		// textarea의 엔터 : \r\n
		// \r : 캐리지 리턴(첫 번째로 돌아가기)
		// \n : new line(다음줄로 이동)
	}

}

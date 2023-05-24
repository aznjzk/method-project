package service;

public class StringMethod {
	
	// 3) 매개변수 : String
	// ① 어떤 값을 입력 받을 것인가? 파일이름(확장자 포함)
	// ② 어떻게 처리(구현)할 것인가? 파일이름을 입력하면 파일의 확장자만 추출하여 반환
	// ③ 어떤값을 반환할 것인가? 확장자만 반환
	public String stringParam(String filename) {
		/*
		 "school.jpg" 	-> "jpg"
		 "보고서.hwp" 		-> "hwp"
		 "극장.영수증.pdf" 	-> "pdf"
		 "test" 		-> ""
		*/
		
		/* 유효성 검사 */
		if(filename == null|| filename.equals("")) {
			System.out.println("입력 값이 없습니다.");
			return "";
		}
		
		/* 확장자만 잘라내기 */
		// lastIndexOf(".") → 문자열의 뒤에서부터 .이 몇 번째로 발견되는지 위치값(index)을 반환 	
		//					  발견하지 못하면 -1 반환 
		int dotIndex = filename.lastIndexOf(".");
	    
		// .을 발견했고 && .이 파일이름의 마지막 문자가 아니라면 = 즉, 확장자가 있다면
		if(dotIndex != -1 && dotIndex < filename.length() - 1) {
	        // 확장자가 있다면: .이후로 문자열을 잘라서 반환
			return filename.substring(dotIndex + 1);
	    // 확장자가 없다면: 공백반환
		} else {
	        return "";
	    }
	}
}
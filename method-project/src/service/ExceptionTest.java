package service;

public class ExceptionTest {
	public void test(int x) {
		// 예외가 없으면 try절을 실행
		// 예외가 한줄이라도 발생하면 try절을 끝내버리고 어떤예외가 났는지를 매개변수로 받아서 catch로 넘어감
		try {
			int [] arr = new int[x];
			arr[0] = 100;
			arr[1] = 200;
		// 예외처리가 그냥 되버리면 어떤예외가 발생했는지를 모르니까, 뭔가 알수있게끔 출력해놓음 
		} catch (Exception e) {
			System.out.println("예외발생");
		}
	}
	
	public void test2(String s) {
		try {
		int n = Integer.parseInt(s);
		System.out.println(n);
		} catch (Exception e) {
			System.out.println("숫자로 변경가능한 문자를 입력하세요");
		}
	}
	
	// throws Exception 예외 던지기
	public void test3() throws Exception {
		Class.forName("java.lang.String");
	}
	
	
	
	// test code
	public static void main(String[] args) throws Exception {
		ExceptionTest et = new ExceptionTest();
		/*
		et.test(3);
		et.test(1);		// 예외발생
		*/
		
		et.test2("9디");
		
		et.test3();
	}
	
} 

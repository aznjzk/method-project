package service;

import vo.Student;
import vo.Emp;
import java.util.Calendar; // 학생 나이 계산하기 위함
import java.util.ArrayList;
import java.util.HashMap;

// 리턴타입 : void
public class VoidMethod {
	// 1) 매개변수 : 없음
	public void voidParm() {
		System.out.println("안녕하세요 구디아카데미입니다.");
	}
	
	// 2) 매개변수 : 기본타입(byte, short, int, long, float, double, char, boolean)
	public void intParam(int num) { 
		if(num % 2 == 0) {
			System.out.println("입력한 " + num + "은 짝수입니다");
			return;
		}
		System.out.println("입력한 " + num + "은 홀수입니다");
	}
	
	// 2-1) 두개의 숫자(int)를 입력받아 21을 넘기지 않으면서 21에 더 가까운 수를 출력하는 메서드
	public void int2Param(int a, int b) { 
		// a, b 중 21을 넘기지않으면서 21에 더 가까운 수를 출력
		// 22, 9 -> 9출력
		// 21, 20 -> 21출력
		// 23, 24 -> 없음
		if(a<=21 && b<=21) {
			if((21-a) > (21-b)) {
				System.out.println("b");
			} else if ((21-b) > (21-a)) {
				System.out.println("a");
			} else {
				System.out.println("비겼습니다.");
			}
		} else if(a<=21 && b>21) {
			System.out.println(a);
		} else if(a>21 && b<=21) {
			System.out.println(b);
		} else {
		System.out.println("없음");
		}
	}
	
	
	// 3) 매개변수 : String
	public void stringParam(String name) {
		if(name.startsWith("김")) {
			System.out.println(name.substring(0, 1)+"씨 입니다");
		} else {
			System.out.println("김/이/박이 아닙니다");
		}
		
	}
	
	// 4) 매개변수(참조타입) : int배열
	// int 배열을 입력받아, 요소 중 가장 큰 수를 출력
	public void intArrayParam(int[] arr) {
		// 유효성 검사 : or라서 앞에 null인 조건을 먼저 써야함
		if(arr == null || arr.length == 0) {
			System.out.println("입력 error");
			return; // 1) 메소드를 종료, 2) 호출된 코드부분에 종료 후 반환값을 남김
		}
		int max = arr[0]; 	// ex) 5, 7, 1, 10
		for(int i=0; i<(arr.length); i+=1) {
			if(arr[i] > max) {
				max = arr[i];
			}
		}
		System.out.println(max+"입니다.");
	}
	
	// ※ 기본(값)타입 매개변수 vs 참조(주소)타입 매개변수
	public void valueTypeParam(int value) {
		value = 777;
	}
	public void referTypeParam(int[] refer) {
		refer[0] = 777;
	}
	
	// 5) 매개변수 : 배열(String 배열)
	// ① 어떤 값을 입력 받을 것인가? 사람이름 배열 입력
	// ② 어떻게 처리(구현)할 것인가? "김"씨 성의 인원을 출력 + 반드시 유효성검사가 포함되어야한다
	// ③ 어떤값을 반환할 것인가? void
	public void strArrParam(String[] names) {
		// 전체 x명중 김씨는 y명 입니다
		if(names == null || names.length == 0) {
			System.out.println("입력된 값이 없습니다.");
			return;
		}
		int nameCnt = 0;
		for(String n : names) {
			if(n.startsWith("김")) {
				nameCnt += 1;
			}
		}		
		System.out.printf("전체 %d명 중 김씨는 %d명 입니다.\n", names.length, nameCnt);
	}
	
	// 6) 매개변수 : 클래스
	// ① 어떤 값을 입력 받을 것인가? 한 학생의 정보(Vo)
	// ② 어떻게 처리(구현)할 것인가? 학생 정보( ex) 10번, 김xx, 남자, 25살 )를 출력 + 유효성검사
	// ③ 어떤값을 반환할 것인가? void
	public void clsParam(Student student) {
		// 출력물
		// 입력 - id:10, name:김홍철, gender:남자, birth:1999
		// 출력 - 10번, 김xx, 남자, 25살
		if(student == null || student.getName() == null || student.getGender() == null) {
			System.out.println("입력된 값이 없습니다.\n");
			return;
		}
		Calendar c = Calendar.getInstance();
		int age = c.get(Calendar.YEAR) - student.getBirth();
		
		
		System.out.printf("%d번, %sxx, %s, %d살\n" , student.getId(), student.getName().substring(0,1), student.getGender(), age);
	}
	
	// 7) 매개변수 : 배열(클래스 배열)
	// ① 어떤 값을 입력 받을 것인가? 여러 학생의 정보(Student[])
	// ② 어떻게 처리(구현)할 것인가? 남자 x명, 여자 x명
	// ③ 어떤값을 반환할 것인가? void
	public void clsArrParam(Student[] students) {
		if(students == null || students.length == 0) {
			System.out.println("입력된 값이 없습니다.");
			return;
		}
		int mCnt = 0;	 // 남자 인원
		int fCnt = 0;	 // 여자 인원
		for (Student s : students) {
			if(s == null || s.getGender() == null) {
				return;
			}
			if(s.getGender().equals("남")) {
				mCnt++;
			} else if(s.getGender().equals("여")) {
				fCnt++;
			}
		}
		System.out.printf("남자 %d명, 여자 %d명\n" , mCnt, fCnt);
	}
	
	// 8) 매개변수 : ArrayList
	// ① 어떤 값을 입력 받을 것인가? 여러 학생의 정보(List<Student>)
	// ② 어떻게 처리(구현)할 것인가? 전체 x명, 20대 x명, 30대 x명
	// ③ 어떤값을 반환할 것인가? void
	public void listParam(ArrayList<Student> studentList) {
		
		int tCnt = studentList.size();	 // 전체 인원
		int twentiesCnt = 0;	// 20대 인원
		int thirtiesCnt = 0;	// 30대 인원
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		
		for (Student student : studentList) {
			int age = currentYear - student.getBirth();
			 if (age >= 20 && age < 30) {
	                twentiesCnt++;
	            } else if (age >= 30 && age < 40) {
	                thirtiesCnt++;
	            }
		}
		System.out.printf("전체 %d명, 20대 %d명, 30대 %d명\n" , tCnt, twentiesCnt, thirtiesCnt);
	}
	
	// 9) 매개변수 : HashMap
	// ① 어떤 값을 입력 받을 것인가? (Student 1명 + Emp 1명) --> HashMap 하나를 입력
	// ② 어떻게 처리(구현)할 것인가? 학생이름 xxx이고, 담당직원의 이름은 yyy입니다.
	// ③ 어떤값을 반환할 것인가? void
	public void mapParam(HashMap<String, Object> map) {
		if(map == null || map.size() == 0) {
			return;
		}
		// 학생 정보 가져오기
	    Student student = (Student) map.get("student");
	    String studentName = student.getName();
	    
	    // 직원 정보 가져오기
	    Emp emp = (Emp) map.get("emp");
	    String empName = emp.getEmpName();
	    
	    System.out.printf("학생 %s의 담당직원은 %s 입니다.\n", studentName, empName);
	}
	
}

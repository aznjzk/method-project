package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Calendar;
import vo.*;


public class PrimitiveMethod {
	/*
	 2. 리턴타입 : 기본타입(byte, short, int, long, float, double, char, boolean)
		1) 매개변수 : 없음
		2) 매개변수 : 기본타입(byte, short, int, long, float, double, char, boolean)
		3) 매개변수 : String
		4) 매개변수 : 배열(기본타입 배열)
		5) 매개변수 : 배열(String 배열)
		6) 매개변수 : 클래스
		7) 매개변수 : 배열(클래스 배열)
		8) 매개변수 : ArrayList
		9) 매개변수 : HashMap
	 */

	// 1) 매개변수 : 없음
	// ① 어떤 값을 입력 받을 것인가? void
	// ② 어떻게 처리(구현)할 것인가? 0 ~ int 최대값 중에 하나를 리턴
	// ③ 어떤값을 반환할 것인가? int
	public int voidParam() {
		// 최소값 0 , 최대값 int 타입의 최대값 : Integer랩퍼타입이요
		double rNum = Math.random(); 							// Math.random	: 0.0000000000xx ~ 0.9999999999xxx
		long intMax = (long)Integer.MAX_VALUE + (long)1;		// MAX_VALUE	: 실제 그 데이터 타입이 표현할 수 있는 숫자의 범위 중 가장 작은 숫자와 가장 큰 숫자 값이 할당된다
		int returnValue = (int)(Math.floor(intMax * rNum));		// Math.floor 	: 소수점 이하를 버림
		return returnValue;
	}
	
	// 2) 매개변수 : 기본타입
	// ① 어떤 값을 입력 받을 것인가? 태어난 년도
	// ② 어떻게 처리(구현)할 것인가? 성인 true / 아니면 false
	// ③ 어떤값을 반환할 것인가? boolean
	public boolean primitiveParam(int birth) {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		if(birth < 0 || birth > currentYear) {
			System.out.println("잘못된 입력");
			return false;
		}
		if(currentYear-birth > 18) {
			return true;
		}
		return false;
	}
	
	// 2-1) 매개변수 : 기본타입
	// ① 어떤 값을 입력 받을 것인가? int, int  -> int값 두개를 입력받는다
	// ② 어떻게 처리(구현)할 것인가? 두 입력값 중 더 큰값 반환
	// ③ 어떤값을 반환할 것인가? int
	public int primitive2Param(int num1, int num2) {
		if(num1 > num2) {
			return num1;
		}
		return num2;
			
	}
	
	// 3) 매개변수 : String
	// ① 어떤 값을 입력 받을 것인가? 문자열 2개
	// ② 어떻게 처리(구현)할 것인가? firstName과 lastName의 길이를 반환
	// ③ 어떤값을 반환할 것인가? int
	public int StringParam(String firstName, String lastName) {
		// null 유효성 검사
		if(firstName == null || lastName == null) {
			System.out.println("입력된 값이 없습니다.");
			return 0;
		}
		// 문자열 길이를 반환하는 기본API 사용
		int firstNameLength = firstName.length();
	    int lastNameLength = lastName.length();

	    return firstNameLength + lastNameLength;
	}
	
	// 4) 매개변수 : 배열(기본타입 배열)
	// ① 어떤 값을 입력 받을 것인가? int[]
	// ② 어떻게 처리(구현)할 것인가? 배열의 합
	// ③ 어떤값을 반환할 것인가? int
	public long arrayParam(int[] arr) {
		// null 유효성 검사 : or라서 앞에 null인 조건을 먼저 써야함
		if(arr == null || arr.length == 0) {
			System.out.println("입력된 값이 없습니다.");
			return 0;
		}
		int sum = 0;
		for(int n : arr) {
			sum = sum+n;
		}
		return sum;
	}
	
	// 5) 매개변수 : 배열(String 배열)
	// ① 어떤 값을 입력 받을 것인가? 이름 배열
	// ② 어떻게 처리(구현)할 것인가? 입력된 이름 중 한명이라도 블랙리스트 명단에 있으면 true, 아니면 false 
	// ③ 어떤값을 반환할 것인가? boolean
	public boolean strArrayParam(String[] names) {
		// 블랙리스트
		final String[] blackList = {"루피", "상디", "조로"};
		// 유효성검사
		if(names == null || blackList == null) {
		System.out.println("입력된 값이 없습니다.");
		return false;
		}

		for(String n : names) {
			for(String b : blackList) {
				if(n.equals(b)) {
					return true;
				}
			}
		}
		return false;
	}
	
	// 6) 매개변수 : 클래스
	// ① 어떤 값을 입력 받을 것인가? 학생타입의 id,pw 속성만 입력
	// ② 어떻게 처리(구현)할 것인가? 로그인
	// ③ 어떤값을 반환할 것인가? boolean
	public boolean clsParam(Student student) {
		// 학생db목록
		Student[] db = new Student[3];
		db[0] = new Student();
		db[0].setId(100); db[0].setPw("1234");
		db[1] = new Student();
		db[1].setId(200); db[1].setPw("1234");
		db[2] = new Student();
		db[2].setId(300); db[2].setPw("1234");
		
		for(Student s : db) {
	        if(s.getId() == student.getId() && s.getPw().equals(student.getPw())) {
	            return true; // ID와 비밀번호가 일치하는 학생이 있을 경우 true 반환
	        }
	    }
	    return false; // 일치하는 학생이 없을 경우 false 반환
	}
	
	// 7) 매개변수 : 배열(클래스 배열)
	// ① 어떤 값을 입력 받을 것인가? 학생배열 Student[]
	// ② 어떻게 처리(구현)할 것인가? 성별이 여자인 분들의 나이 평균(소수점 2자리)
	// ③ 어떤값을 반환할 것인가? double
	public double clsArrParam(Student[] arr) {
		// 오늘 날짜의 년도
		int currentYear = Calendar.getInstance().get(Calendar.YEAR);
		int cnt = 0;
		int sumAge = 0;
		double aveAge = 0;
        
        for(Student s : arr) {
        	if(s.getGender().equals("여자")) {
        		cnt = cnt + 1;
        		int age = currentYear - s.getBirth();
        		sumAge = sumAge + age;    				 
        	}
        }
        aveAge = (double)sumAge / (double)cnt;
        aveAge = Math.round(aveAge * 100) / 100;	// 100을 곱해서 소수점 두번째까지 정수로 키워놨다가, 반올림 후 다시 100을 나눠주면 소수점 두번째자리까지 출력 가능
        return aveAge;
	}

	// 8) 매개변수 : ArrayList
	// ① 어떤 값을 입력 받을 것인가? 성적 데이터(4과목 : 국어, 영어, 수학, 과학)
	//	ex) null이면 0+0+0+0, 국어 한과목 80이고 나머지는 입력안되어있으면 80+0+0+0
	// ② 어떻게 처리(구현)할 것인가? 4과목(4과목이 안되면 0점으로 과목 추가) 평균 90이상 A, 80이상 B, 70이상 C, 나머지 F
	// ③ 어떤값을 반환할 것인가? char 'A', 'B', 'C', 'F'
	public char listParam(ArrayList<Subject> list) {
		int sumScore = 0;
		if(list != null) {
			for(Subject s : list) {
				sumScore += s.getScore();
			}
		}
		
		double avg = (double)sumScore / 4.0;
		char returnValue = '\0';
		if(avg >= 90) {
			returnValue = 'A';
		} else if(avg >= 80) {
			returnValue = 'B';
		} else if(avg >= 70) {
			returnValue = 'C';
		} else {
			returnValue = 'F';
		}
		return returnValue;
	}
    
	// 9) 매개변수 : HashMap
	// ① 어떤 값을 입력 받을 것인가? 두개의 리스트(Student, Emp)
	// ② 어떻게 처리(구현)할 것인가? 총인원9리스트사이즈의 합)을 계산
	// ③ 어떤값을 반환할 것인가? int
	public int mapParam(HashMap<String, Object> map) {
		
		int studentCnt = 0;
		int empCnt = 0;
		
		// null 유효성 검사
		
		ArrayList<Student> studentList = (ArrayList<Student>)map.get("studentList");
		ArrayList<Emp> empList = (ArrayList<Emp>)map.get("empList");
		studentCnt = studentList.size();
		empCnt = empList.size();
		return studentCnt + empCnt;
	}
	
}
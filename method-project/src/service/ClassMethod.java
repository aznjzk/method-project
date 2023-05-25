package service;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import vo.*;	

public class ClassMethod {
	
	// Member타입(id / pw / name / age)의 일부 속성(id,pw)을 입력받아 
	// 메서드 내에 정의된 정적 멤버자료구조(배열 or List)에서 동일한 데이터가 있으면 해당 데이터의 풀속성을 반환, 없으면 null 반환 
	public Member m66(Member m) {
	      
		if(m == null || m.getPw() == null) {
			System.out.println("멤버 정보가 없습니다.");
			return null;
		}
		  
		ArrayList<Member> mList = new ArrayList<>();
		  
		Member m1 = new Member();
		m1.setId(100);
		m1.setPw("1234");
		mList.add(m1);
		  
		Member m2 = new Member();
		m2.setId(200);
		m2.setPw("1234");
		mList.add(m2);
		
		Member m3 = new Member();
		m3.setId(300);
		m3.setPw("1234");
		mList.add(m3);
		    
		for(Member mem : mList) {
			if(mem.getId() == m.getId() &&  mem.getPw().equals(m.getPw())) {
				return mem;
			}
		}
			return null;
	}

	
	// String리스트를 입력받아 String배열로 반환
	public String[] m78(List<String> list) {
		if(list == null) {
	         System.out.println("입력 리스트가 없습니다.");
	         return null;
	      }
		int listSize = list.size();
	      String[] array = new String[listSize];
	      int currIdx = 0;
	      
	      for(String s : list) {
	         array[currIdx] = s;
	         currIdx++;
	      }
	      return array;
	}
	

	// 숫자배열을 입력받아 짝수만 문자열로 변경 후 ArrayList<String>로 반환
	public ArrayList<String> m84(int[] arr) {
		if(arr == null) {
	         System.out.println("숫자배열이 없습니다.");
	         return null;
	      }
		ArrayList<String> list = new ArrayList<>();
	      for(int n : arr) {
	         if(n % 2 == 0) {
	            String s = "" + n;
	            list.add(s);
	         }
	      }
	      return list;
	   }
	
	
	// 여러타입의 데이터를 입력받아 Emp, Dept타입으로 분산 저장 후 다시 Emp와 Dept를 HashMap<String, Object>에 저장후 반환
	// MapReturnMethod클래스를 정적 ​​중첩 클래스로 선언 → 중첩 클래스란 다른 클래스 내부에 정의된 클래스로, 외부 클래스의 멤버로 존재하며 외부 클래스의 인스턴스에 접근할 수 있습니다.
	public static class MapReturnMethod {
		public HashMap<String, Object> m910(int empNo, String ename, boolean retirer, int deptNo, String dname) {
		
		// Emp 객체 생성 및 데이터 저장
		Emp emp = new Emp();
		emp.setEmpNo(empNo);
		emp.setEname(ename);
		emp.setRetirer(retirer);
		
		// Dept 객체 생성 및 데이터 저장
		Dept dept = new Dept();
		dept.setDeptNo(deptNo);
		dept.setDname(dname);
		
		// 유효성검사
		if(emp == null || dept == null) {
			return null;
		}
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("Emp", emp);
		map.put("Dept", dept);
		
		return map;

	}
	
	// 테스트 코드 추가하는 방법
	// 1) 테스트용 클래스를 만들고!, 테스트 클래스 안에 static main() 에서 테스트 하고자 하는 메서드를 테스트.
	// 2) 테스트 하고자 하는 메서드의 클래스 안에! static main() 을 만들어서 호출
		public static void main(String[] args) {
			MapReturnMethod mrm = new MapReturnMethod();
			HashMap<String, Object> map 
				= mrm.m910(1, "구디", false, 100, "운영");
			
			Emp emp = (Emp)(map.get("emp"));
			Dept dept = (Dept)(map.get("dept"));
			
			System.out.printf("%s님의 부서는 %s 입니다%n"	, emp.getEname(),dept.getDname());
		}
	}
	
}
	
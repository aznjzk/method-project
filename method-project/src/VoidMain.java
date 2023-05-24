import java.util.ArrayList;
import java.util.HashMap;

import service.VoidMethod;
import vo.Student;
import vo.Emp;


public class VoidMain {
	public static void main(String[] args) {
		VoidMethod vm = new VoidMethod();
		vm.voidParm();
		
		int num = 8;
		vm.intParam(num);
		
		int a = 22;
		int b = 22;
		vm.int2Param(a, b);
		
		String name = "구철수";
		vm.stringParam(name);
		
		int[] arr = {50, 1, 10, 7, 0, 21};
		vm.intArrayParam(arr);
		
		// ※ 기본(값)타입 매개변수 vs 참조(주소)타입 매개변수
		int value = 100;
		vm.valueTypeParam(value);
		System.out.println(value);
		
		
		int[] refer = {1,2,3};
		System.out.println(refer);
		System.out.println(refer[0]);
		vm.referTypeParam(refer);
		System.out.println(refer);
		System.out.println(refer[0]);
		//
		
		// 5) 매개변수 : 배열(String 배열)
		String[] names = {"정현", "오빈", "김은", "송지", "김민"};
		System.out.println(names);
		
		// 6) 매개변수 : 클래스
		Student ch = new Student();
		ch.setId(3);
		ch.setName("김홍철");
		ch.setGender("남");
		ch.setBirth(1999);
		vm.clsParam(ch);
		
		// 7) 매개변수 : 배열(클래스 배열)
		Student s1 = new Student();
		s1.setId(3);
		s1.setName("최동욱");
		s1.setGender("남");
		s1.setBirth(1999);
		Student s2 = new Student();
		s2.setId(4);
		s2.setName("최명진");
		s2.setGender("남");
		s2.setBirth(1995);
		Student s3 = new Student();
		s3.setId(4);
		s3.setName("최미진");
		s3.setGender("여");
		s3.setBirth(2000);
		
		Student[] students = new Student[3];
		students[0] = s1;
		students[1] = s2;
		students[2] = s3;
		vm.clsArrParam(students);
		
		// 8) 매개변수 : ArrayList
		ArrayList<Student> studentList = new ArrayList<>();
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		
        vm.listParam(studentList);
		
        // 9) 매개변수 : HashMap
        // 학생 생성
        Student student = new Student();
        student.setName("루피");
        
        // 직원 생성
        Emp emp = new Emp();
        emp.setEmpName("홍길동");
        
        // HashMap 생성하고 학생과 직원을 넣음
        HashMap<String, Object> map = new HashMap<>();
        map.put("student", student);
        map.put("emp", emp);
        
        vm.mapParam(map);
    }

}

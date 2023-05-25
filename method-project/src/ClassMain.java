import service.ClassMethod;
import java.util.ArrayList;

public class ClassMain {
    public static void main(String[] args) {
    	ClassMethod pm = new ClassMethod(); // ClassMethod 클래스의 인스턴스 생성
    	ArrayList<String> strList = new ArrayList<>();
        strList.add("hello");
        strList.add("hi");
        String[] array = pm.m78(strList);
        if(array != null) {
           for(String str : array) {
              System.out.print(str + ",");
           }
        }
    }
}
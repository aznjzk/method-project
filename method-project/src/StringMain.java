import service.StringMethod;
public class StringMain {
    public static void main(String[] args) {
        StringMethod stringMethod = new StringMethod();
        
        String result1 = stringMethod.stringParam("school.jpg");
        System.out.println("결과: " + result1);  // 출력: jpg
        
        String result2 = stringMethod.stringParam("보고서.hwp");
        System.out.println("결과: " + result2);  // 출력: hwp
        
        String result3 = stringMethod.stringParam("극장.영수증.pdf");
        System.out.println("결과: " + result3);  // 출력: pdf
        
        String result4 = stringMethod.stringParam("test");
        System.out.println("결과: " + result4);  // 출력: 
    }
}
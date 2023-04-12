package sample03_string;
// 이메일 주소에서 아이디만 조해해서 출력 예시
public class StringApp4 {

	public static void main(String[] args) {
		
		String[] emailArr = {"hong@gmail.com", "lee-sushin@naver.com", "kimys@hanmail.net"};
		
		// 고객의 이메일주소에서 아이디만 조회해서 출력하기
		for (String email : emailArr) {
//			System.out.println(email.indexOf("@"));
			String id = email.substring(0, email.indexOf("@")); 
			System.out.println(id);
		}
		
		// 고객의 이메일주소에서 도메인네임 출력하기
		for (String email : emailArr) {
			String domainName = email.substring(email.indexOf("@") + 1); 
			System.out.println(domainName);
		}
	}
}

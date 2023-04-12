package sample05_date;
/* 날짜와 시간의 표현 */
import java.util.Date;

public class DataApp1 {

	public static void main(String[] args) {
		
		 /* 시스템의 현재 날짜와 시간정보를 제공하는 클래스 */
		 // - java.util.Date : 클래스는 날짜와 시간정보를 표현하는 클래스다.
		
		 /* java.sql은 데이터베이스의 날짜와 시간정보를 표현하기 위한 클래스를 제공한다. */
		 //  - java.sql.Date : 클래스는 날짜를 표현하는 클래스다.
		 //	 - java.sql.Time : 클래스는 시간을 표현하는 클래스다.
		 //  - java.sql.TimeStamp : Time클래스보다 더 정밀한 시간을 표현하는 클래스다.
		
		 /* 날짜 혹은 시간을 조작해야할 때 많이 사용하는 클래스 */
		 //  - java.time.LocalDate : 날짜정보를 표현하는 클래스다.
		 //  - java.time.LocalTime : 시간정보를 표현하는 클래스다.
		 //  - java.time.LocalDateTime : 날짜와 시간정보를 표현하는 클래스다.
		 //  * java.time 패키지의 날짜와 시간정보 클래스는 java8부터 추가되었다.
		 //  * java.time 패키지에는 날짜와 관련된 다양한 연산을 지원하는 기능이 추가되었다.
		
		// 시스템의 현재 날짜와 시간정보를 가진 Date객체를 생성하기
		Date now = new Date();
		System.out.println(now); // 일/월/일/시/분/초/연도
		
		// 유닉스타임을 전달받아서 해당 날짜와 시간정보를 표현하는 Data객체를 생성하기
		Date someDate = new Date(0);
		System.out.println(someDate);
	}
}

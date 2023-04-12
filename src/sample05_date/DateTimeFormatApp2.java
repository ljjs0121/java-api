package sample05_date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeFormatApp2 {
	// throws 예외처리 위임 throw 예외 강제 발생
	public static void main(String[] args) throws ParseException {
		// 예외가 JVM까지 가면 프로그램이 종료된다. 그래서 JVM까지 전달되지 않도록 해야한다.
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		
		// 지정된 패턴형식의 문자열을 해석해서 Date객체를 생성하기
		Date date1 = sdf1.parse("2015-09-15"); // SimpleDateFormat
		System.out.println(date1);
		
		// 시스템의 현재 날짜와 시간정보를 표현하는 Date객체를 생성하기
		Date now = new Date();
		
		long nowUnixTime = now.getTime();
		long dateUnixTime = date1.getTime();
		
		long days = (nowUnixTime - dateUnixTime)/(60*60*24*1000);
		System.out.println("경과일자 -> " + days);
		
	}
}

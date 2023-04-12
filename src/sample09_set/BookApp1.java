package sample09_set;

import java.util.HashSet;

import sample08_list.Book;

public class BookApp1 {

	public static void main(String[] args) {
		
		HashSet<Book> books = new HashSet<>();
		
		// 동일한 책번호를 가진 책정보는 같은 객체로 보고 저장되지 않게 하자.
		// Book 클래스에서 hashCode()와 equals(Object o) 메소드를 재정의한다.
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));	
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));
		// HashSet()은 중복을 허용하지 않지만, 이경우에는 동일성을 비교해서 판단하기 때문에
		// Book클래스에서 HashCode() equals(Object o) 재정의를 해주어야 동등성 비교해서 같은 값이 출력이 안된다.
		books.add(new Book(101, "인생은 소설이다", "기욤 뮈소 ", 18000));
		books.add(new Book(102, "세이노의 가르침", "세이노", 7800));
		
		for (Book book : books) {
			System.out.println("HashCode -> " + book.hashCode());
			System.out.println("번호: " + book.getNo());
			System.out.println("제목: " + book.getTitle());
			System.out.println("저자: " + book.getWriter());
			System.out.println("가격: " + book.getPrice());
			System.out.println();
		}
	}
}

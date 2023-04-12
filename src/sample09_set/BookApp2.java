package sample09_set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import sample08_list.Book;
// Iterator를 이용해서 저장된 값을 삭제하기
public class BookApp2 {

	public static void main(String[] args) {
		Set<Book> books = new HashSet<>();
		
		books.add(new Book(100, "자바의 정석", "남궁성", 35000));
		books.add(new Book(102, "세이노의 가르침", "세이노", 7800));
		books.add(new Book(105, "스프링입문을 위한 자바 객체지향의 원리와 이해", "김종민", 24000));
		books.add(new Book(103, "CleanCode", "로버트 c.마틴", 28000));
		books.add(new Book(101, "인생은 소설이다", "기욤 뮈소 ", 35000));
		books.add(new Book(104, "함께 자라기", "김창준", 35000));
		
		// 101번 책을 삭제하기
		// 향상된 for문 실행 중에 콜렉션의 객체를 삭제할 수 없다.
//		for (Book book : books) {
//			System.out.println("책번호 -> " + book.getNo());
//			if (book.getNo() == 101) {
//				books.remove(book); // java.util.ConcurrentModificationException 오류
//			}
//		}
		
		// 책 번호가 짝수인 책정보를 삭제하기
		Iterator<Book> iter = books.iterator();
		while (iter.hasNext()) {
			Book book = iter.next();
			if (book.getNo()%2 == 0) {
				iter.remove();
			}
		}
		
		// Set객체에 저장된 객체의 갯수 조회하기
		System.out.println("저장된 객체의 개수 -> " + books.size());
	}
}







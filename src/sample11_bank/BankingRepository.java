package sample11_bank;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
// 영속화계층
// 업무로직이 없다. 업무로직은 서비스계층에서 처리한다.
// 은행 DB역할하는 고객 저장소
// CRUD - 저장(Create) 조회(Read) 변경(Update) 삭제(Delete)
public class BankingRepository {

	/*
	 * Map<Integer, Account>는 계좌정보를 저장하는 객체다
	 * 	key는 계좌번호(Integer)
	 * 	value는 계좌정보(Account)
	 */
	private Map<Integer, Account> map = new HashMap<>();
	
	public BankingRepository() {
		map.put(100, new Account(100, 1234, "김무신", 50000));
		map.put(200, new Account(200, 1234, "김무신", 1000000));
		map.put(300, new Account(300, 1234, "박무봉", 15000000));
		map.put(400, new Account(400, 1234, "한아름", 150000));
		map.put(500, new Account(500, 1234, "한아름", 200800000));
	}
	
	// 저장기능 - Create
	/* 계좌정보객체를 전달받아서 Map객체에 저장한다.
	 * 반환타입 : void
	 * 메소드명 : insertAccount
	 * 매개변수 : Account account
	 */
	public void insertAccount(Account account) {
		map.put(account.getNo(), account);
		
	}
	
	// 조회기능 - Read
	/* 계좌번호를 전달받아서 계좌번호에 해당하는 계좌정보를 반환한다. 전달 - 매개변수 반환 - 반환타입
	 * 반환타입 : Account
	 * 메소드명 : getAccountByNo
	 * 매개변수 : int accNo
	 */
	public Account getAccountByNo(int accNo) {
		return map.get(accNo); // 계좌번호 반환 계좌번호 없으면 null을 반환
	}
	
	// 조회기능 - Read
	/* 예금주 이름을 전달받아서 해당 예금주 이름으로 개설된 모든 계좌정보를 반환한다.
	 * 반환타입 : List<Account> 
	 * 메소드명 : getAccountsByName
	 * 매개변수 : String name
	 */
	public List<Account> getAccountsByName(String name) {
		List<Account> accounts = new ArrayList<>(); // List는 ArrayList 객체를 만들어야한다.
		
		Collection<Account> values = map.values(); 
		for (Account account : values) {
			if (name.equals(account.getOwner())) { // 전달받은 이름과 예금주와 일치한지 비교
				accounts.add(account); 
			}
		}
		return accounts;
	}
	
	
	// 변경기능 - Update
	/* 변경된 정보가 반영된 계좌정보를 전달받아서 Map객체에 적용시킨다.
	 * 반환타입 : void
	 * 메소드명 : updateAccount
	 * 매개변수 : Account account
	 */
	public void updateAccount(Account account) {
		
		
	}
	
	// 삭제기능 - Delete
	/* 계좌번호를 전달받아서 계좌번호와 일치하는 계좌정보를 삭제시킨다.
	 * 반환타입 : void
	 * 메소드명 : deleteAccount
	 * 매개변수 : int accNo
	 */
	public void deleteAccount(int accNo) {
		map.remove(accNo); // 삭제
		
	}
	
}




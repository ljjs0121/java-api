package sample11_bank;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankingService {
// 은행 업무 서비스
	private BankingRepository repo = new BankingRepository();
	
	// 신규 개좌 개설하기
	/*	
	 * 사용자가 입력한 신규 계좌정보를 전달받아서 영속화계층에 저장시키고, 개설된 계좌정보를 반환한다.
	 * 	반환타입 : Account
	 * 	메소드명 : createAccount
	 * 	매개변수 : Account account
	 */
	public Account createAccount(Account account) {
		
		// 전달받은 계좌정보에 계좌상태, 개설일시를 저장한다.
		account.setStatus("사용중");
		account.setCreateDate(new Date());
		
		// 영속화 계층에 계좌정보를 전달해서 저장시키기
		repo.insertAccount(account);
		
		return account;
	}
	
	// 전계좌 조회하기
	/*	
	 * 예금주명을 전달받아서 해당 예금주명을 개설된 모든 계좌정보를 조회해서 반환한다.
	 * 	반환타입 : List<Account>
	 * 	메소드명 : getMyAllAccounts
	 *  매개변수 : String name
	 */
	public List<Account> getMyAllAccounts(String name) {
		List<Account> accounts = repo.getAccountsByName(name);
		return accounts;
	}
	
	// 계좌상세 조회하기
	/*
	 * 계좌번호와 비밀번호를 전달받아서 계좌상세정보를 반환한다.
	 *  반환타입 : Account
	 *  메소드명 : getAccountDetail
	 *  매개변수 : int accNo
	 */
	public Account getAccountDetail(int accNo, int pwd) {
		Account account = repo.getAccountByNo(accNo); // 계좌정보 조회
		if (account == null) {
			return null;
		}
		if (account.getPassword() != pwd) { // 비밀번호 틀렸을 때 
			return null;
		}
		
		return account;
	}
	
	// 입금하기
	/*
	 * 계좌번호와 입금액을 전달받아서 현재 잔액을 증가시킨다.
	 * 반환타입: boolean
	 * 메소드명: deposit
	 * 매개변수: int accNo, long amount
	 */
	public boolean deposit(int accNo, long amount) {
		Account account = repo.getAccountByNo(accNo); // 계좌정보 조회
		if (account == null) { // 존재하지않으면 실패
			return false;
		}
		long balance = account.getBalance() + amount; // 존재하면 현재잔고 + 입금액
		account.setBalance(balance);
		
		return true;
	}
	
	// 출금하기
	/*
	 * 반환타입: boolean
	 * 메소드명: withdraw
	 * 매개변수: int AccNo, int pwd, long amount
	 */
	public boolean withdraw(int accNo, int pwd, long amount) { // 매개변수명은 아무거나 해도 상관없다.
		Account account = repo.getAccountByNo(accNo);
		if (account == null) { 
			System.out.println("### 입력하신 계좌와 일치하지 않습니다.");
			return false;
		}
		if (account.getPassword() != pwd) { // << 맞음
			System.out.println("### 비밀번호가 맞지 않습니다.");
			return false;
		}
		if (account.getBalance() < amount) {
			System.out.println("### 현재 잔액이 부족합니다.");
			return false;
		}
		// 리팩토링
		// if (account == null || 
		// 		account.getPassword() != pwd || 
		//		account.getBalance() < amount) {
		//		return false;
		//	}
		long balance = account.getBalance() - amount;
		account.setBalance(balance);
		return true;
	}
	
	// 비밀번호 변경하기
	/*
	 * 반환타입 : boolean
	 * 메소드명 : changePassword
	 * 매개변수 : int accNo, int prePassword, int password
	 */
	public boolean changePassword(int accNo, int prePassword, int password) {
		Account account = repo.getAccountByNo(accNo);
		if (account == null) {
			return false;
		}
		if (account.getPassword() != prePassword) {
			return false;
		} 
			account.setPassword(password);
			return true;
	}
	
	// 해지하기
	/*
	 * 반환타입 : map<Account>
	 * 메소드명 : expireAccount
	 * 매개변수 : int no, int password
	 */
	public Map<String, Object> expireAccount(int accNo, int password){
		Map<String, Object> result = new HashMap<>();
		
		Account account = repo.getAccountByNo(accNo);	// 계좌 조회
		if (account == null) {
			result.put("success", false); // map에 success false값을 저장
			return result;
		}
		if (account.getPassword() != password) { // 비밀번호 틀렸을 때 
			result.put("success", false);
			return result;
		}
		
		// 이자 계산 map의 타입은 String 그래서 int타입으로 형변환
		int interest = (int) (account.getBalance()*account.getInterestRate()*5); // 5년 정기 적금 
		result.put("success", true);
		result.put("no", account.getNo());
		result.put("owner", account.getOwner());
		result.put("balance", account.getBalance());
		result.put("interest", interest);	// 이자
		result.put("amount", account.getBalance() + interest); // 해지예상금액
		
		repo.deleteAccount(accNo);
		
		return result;
		
	}
	
}







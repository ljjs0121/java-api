package sample11_bank;

import static util.DateUtils.toText;

import java.util.List;
import java.util.Map;

import util.KeyboardReader;

// 표현계층 - 클라이언트와 1:1 대응
// 은행 업무 구현
 			
public class BankingApplication {

	private BankingService service = new BankingService();
	private KeyboardReader reader = new KeyboardReader();
	
	public static void main(String[] args) {
		BankingApplication app = new BankingApplication();
		app.displayMenu();
	}
	
	public void displayMenu() {
	System.out.println("-----------------------------------------------------------");
	System.out.println("1.전계좌 2.계좌상세 3.개설 4.입금 5.출금 6.비번변경 7.해지 0.종료");
	System.out.println("-----------------------------------------------------------");
	System.out.println();
	
	System.out.print("### 메뉴 선택 > ");
	int menuNo =reader.readInt();
	System.out.println();
		
	if (menuNo == 1) {
		전계좌조회();
	} else if (menuNo == 2) {
		계좌상세조회();
	} else if (menuNo == 3) {
		신규계좌개설();
	} else if (menuNo == 4) {
		입금();
	} else if (menuNo == 5) {
		출금();
		} else if (menuNo == 6) {
		비밀번호변경();
	} else if (menuNo == 7) {
		계좌해지();
	} else if (menuNo == 0) {
		프로그램종료();
	}
	System.out.println();
	System.out.println();
		
	displayMenu();
		
	}
	
	private void 전계좌조회() {
		System.out.println("<<< 전계좌 조회 >>>");
		System.out.println("### 예금주명을 입력해서 전체 계좌정보를 조회하세요.");
		
		// 계좌정보를 조회할 예금주명을 입력받는다.
		System.out.print("### 예금주명: ");
		String owner =reader.readString();
		
		// BankingService객체의 getMyAllAccounts(String owner) 메소드로 전달해서 호출한다.
		// 예금주명으로 조회된 계좌정보들을 List<Account> 객체로 반환받는다.
		List<Account> accounts = service.getMyAllAccounts(owner);
		
		if (!accounts.isEmpty()) { // 값이 없으면 true ! -> 있으면 true
			for (Account acc : accounts) {
				System.out.println("계좌번호: "+acc.getNo());
				System.out.println("현재잔액: "+acc.getBalance()+"원");
			}
		} else { // 값이 없으면 오류메시지 
			System.out.println("### ["+owner+"]님 이름으로 등록된 계좌정보가 존재하지 않습니다.");
		}
		
	}
		
	private void 계좌상세조회() {
		System.out.println("<<< 계좌 상세조회 >>>");
		System.out.println("### 계좌번호, 비밀번호를 입력하세요.");
		System.out.println("계좌번호 > ");
		int no = reader.readInt();
		System.out.println("비밀번호 > ");
		int password = reader.readInt();
		
		Account account = service.getAccountDetail(no, password);
		if (account != null) {
			System.out.println("--- 계좌 상세정보 ---");
			System.out.println("### 계좌번호: " + account.getNo());
			System.out.println("### 예금주: " + account.getOwner());
			System.out.println("### 현재잔액: " + account.getBalance());
			System.out.println("### 금리: " + account.getInterestRate());
			System.out.println("### 상태" + account.getStatus());
			System.out.println("### 개설일자: " + toText(account.getCreateDate()));
		} else {
			System.out.println("### 계좌정보 조회 중 오류가 발생하였습니다.");
		}
		
	}
		
	private void 신규계좌개설() {
		System.out.println("<<< 신규 계좌 개설 >>>");
		System.out.println("### 신규 계좌 개설에 필요한 정보를 입력하세요");
		
		// 입력값을 읽어와서 변수에 저장한다.
		System.out.print("### 계좌번호: ");
		int no = reader.readInt();
		System.out.print("### 비밀번호: ");
		int password = reader.readInt();
		System.out.print("### 예금주명: ");
		String owner =reader.readString();
		System.out.print("### 입금금액: ");
		int amount = reader.readInt();
		System.out.print("### 약정금리: ");
		double interestRate = reader.readDouble();
		
		// Account객체를 생성해서 입력한 계좌정보를 저장한다.
		Account account = new Account();
		account.setNo(no);
		account.setPassword(password);
		account.setOwner(owner);
		account.setBalance(amount);
		account.setInterestRate(interestRate);
		
		// BankingService객체의 createAccount(Account account) 메소드 호출해서 
		// 신규계좌개설을 한다.
		Account savedAccount = service.createAccount(account);
		
		// 신규로 개설된 계좌정보를 화면에 출력한다.
		System.out.println();
		System.out.println("### 신규 개설 계좌 정보 ###");
		System.out.println("계좌번호: "+savedAccount.getNo());
		System.out.println("예금주명: "+savedAccount.getOwner());
		System.out.println("약정금리: "+savedAccount.getInterestRate() + "%");
		System.out.println("현재잔액: "+savedAccount.getBalance() + "원");
		System.out.println("계좌상태: "+savedAccount.getStatus());
		System.out.println("개설일시: "+toText(savedAccount.getCreateDate())); // 

		System.out.println("### 신규 계좌개설이 완료되었습니다.");
	}
		
	private void 입금() {
		System.out.println("<<< 입금하기 >>>");
		System.out.println("### 계좌번호와 입금액을 입력하세요.");
		System.out.println("### 계좌번호: ");
		int no =reader.readInt();
		System.out.println("### 입금액: ");
		long amount =reader.readLong();
		
		boolean isSuccess = service.deposit(no, amount);
		if (isSuccess) {
			System.out.println("### ["+no+"]계좌에 ["+amount+"] 금액이 입금되었습니다.");
		} else {
			System.out.println("### 입금처리 중 오류가 발생하였습니다.");
		}
	}
		
	private void 출금() {
		System.out.println("<<< 출금하기 >>>");
		System.out.println("### 계좌번호, 비밀번호, 출금액을 입력하세요.");
		System.out.print("### 계좌번호 > ");
		int no =reader.readInt();
		System.out.print("### 비밀번호 > ");
		int password =reader.readInt();
		System.out.print("### 출금액 > ");
		long amount = reader.readLong();
		
		boolean isSuccess = service.withdraw(no, password, amount);
		if (isSuccess) {
			System.out.println("### ["+no+"]계좌에서 "+amount+"] 금액이 출금되었습니다.");
		} else {
			System.out.println("### 출금처리 중 오류가 발생하였습니다.");
		}
	}
		
	private void 비밀번호변경() {
		System.out.println("<<< 비밀번호 변경 >>>");
		System.out.println("### 계좌번호, 이전 비밀번호, 새 비밀번호를 입력하세요.");
		System.out.print("### 계좌번호: ");
		int no =reader.readInt();
		System.out.print("### 이전 비밀번호: ");
		int prepassword = reader.readInt();
		System.out.print("### 새 비밀번호: ");
		int password = reader.readInt();
		
		boolean isSuccess = service.changePassword(no, prepassword, password);
		if (isSuccess) {
			System.out.println("### ["+no+"] 계좌의 비밀번호가 변경되었습니다.");
		} else {
			System.out.println("### 비밀번호 변경 처리 중 오류가 발생하였습니다.");
		}
	}
		
	private void 계좌해지() {
		System.out.println("<<< 계좌 해지하기 >>>");
		System.out.println("### 계좌번호, 비밀번호를 입력하세요.");
		System.out.print("### 계좌번호: ");
		int no =reader.readInt();
		System.out.print("### 비밀번호: ");
		int pwd = reader.readInt();
		
		Map<String, Object> result = service.expireAccount(no, pwd);
		boolean isSuccess = (Boolean) result.get("success");
		if (isSuccess) {
			String owner = (String) result.get("owner");
			long balance = (long) result.get("balance");
			int interest = (Integer) result.get("interest");
			long amount = (Long) result.get("amount");
			
			System.out.println("### 계좌해지가 완료되었습니다. 해지 내용을 확인하세요");
			System.out.println("계좌번호" + no);
			System.out.println("예금주: " + owner);
			System.out.println("현재잔액: " + balance);
			System.out.println("이자: " + interest);
			System.out.println("해지예상금액: " + amount);
		} else {
			System.out.println("### 계좌 해지 중 오류가 발생하였습니다.");
		}
		
	}
		
	private void 프로그램종료() {
		System.out.println("### 프로그램 종료");
		System.exit(0);
	}
}

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoMain {
   
   ArrayList<Memo> memoList = new ArrayList<>();
   
   public static void main(String[] args) {
      // 입력을 받아서 처리하는 도구
      Scanner scanner = new Scanner(System.in);
      MemoMain mm = new MemoMain();
      
      // 명령어를 입력받아서 후속 처리
      // c - create : 데이터 입력모드로 전환
      // r - read :   데이터 읽기모드로 전환
      // u - update : 데이터 수정모드로 전환
      // d - delete : 데이터 삭제모드로 전환
      String command = "";
      
      // 명령어 입력처리 과정
      while(!command.equals("exit")) {
         System.out.println("------------명령어를 입력하세요------------");
         System.out.println("c : 쓰기, r : 읽기, u : 수정, d : 삭제, l : 목록");
         System.out.println("exit : 종료");
         System.out.println("-------------------------------------");
         
         command = scanner.nextLine();
         
         //명령어 분기처리 case문을 이용하여 각 조건별 어떤 값을 가져오는지에 대한 설명
         switch(command) {
         case "c" :
            mm.create(scanner);  // 문자열 입출력을 위해 scanner util을 
            break;
         case "r" :
            mm.readList(scanner);
            break;
         case "u" :
            mm.updateList(scanner);
            break;
         case "d" :
            mm.deleteList(scanner);
            break;
         case "l" :
            mm.showList();
         }
      }
      System.out.println("프로그램이 끝났습니다."); // 마지막 프로그램 종료시 종료메세지 출력
   }
   
   // 키보드 입력을 받는 함수 - 메모를 생성
   public void create(Scanner scanner) {
      Memo memo = new Memo();
      
      memo.no = memoList.size() + 1;
      
      System.out.println("이름을 입력하세요 : ");
      memo.name = scanner.nextLine();
      System.out.println("내용을 임력하세요 : ");
      memo.content = scanner.nextLine();
      
      memo.datetime = System.currentTimeMillis();  // 현재 날짜를 표시, UTC 1970년 1월 1일 00:00 기준으로 long 형으로 반환
      
      memoList.add(memo);
   }
   
   // 메모를 검색후 해당 정보를 보여줌
   public void showList() {
      for(Memo item : memoList) {
         System.out.print("NO : " + item.no);
         System.out.println("  ||  Author : " + item.name);
      }
   }
   
   // 해당 메모를 삭제 (삭제를 위해 remove 유틸을 활용)
   public void deleteList(Scanner scanner) {
      System.out.print("글 번호 입력 : ");
      String number = scanner.nextLine();
      memoList.remove(Integer.parseInt(number) - 1);
      
      for(int i = Integer.parseInt(number) - 1; i < memoList.size(); i++) {
         memoList.get(i).no--;
      }
   }
   
   // 메모를 수정
   public void updateList(Scanner scanner) {
      System.out.print("글 번호 입력 : ");
      int no = Integer.parseInt(scanner.nextLine()) - 1;
      
      System.out.println("이름을 입력하세요 : ");
      memoList.get(no).name = scanner.nextLine();
      System.out.println("내용을 임력하세요 : ");
      memoList.get(no).content = scanner.nextLine();
      
   }
   // 메모 목록을 표시
   public void readList(Scanner scanner) {
      System.out.print("글 번호 입력 : ");
      int no = Integer.parseInt(scanner.nextLine()) - 1;
      
      Memo imsi = new Memo();
      imsi = memoList.get(no);
      
      System.out.println("NO : " + imsi.no);
      System.out.println("Author : " + imsi.name);
      System.out.println("Content : " + imsi.content);
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss"); // SimpleDataFormat 유틸을 활용하여 날짜 양식을 표시
      String formattedDate = sdf.format(imsi.datetime);
      System.out.println("Date : " + formattedDate);
   }
}

// 개별 글 한개 한개를 저장하는 클래스
class Memo {
   int no;
   String name;
   String content;
   long datetime;
}
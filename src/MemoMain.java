import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MemoMain {
   
   ArrayList<Memo> memoList = new ArrayList<>();
   
   public static void main(String[] args) {
      // �Է��� �޾Ƽ� ó���ϴ� ����
      Scanner scanner = new Scanner(System.in);
      MemoMain mm = new MemoMain();
      
      // ��ɾ �Է¹޾Ƽ� �ļ� ó��
      // c - create : ������ �Է¸��� ��ȯ
      // r - read :   ������ �б���� ��ȯ
      // u - update : ������ �������� ��ȯ
      // d - delete : ������ �������� ��ȯ
      String command = "";
      
      while(!command.equals("exit")) {
         System.out.println("------------��ɾ �Է��ϼ���------------");
         System.out.println("c : ����, r : �б�, u : ����, d : ����, l : ���");
         System.out.println("exit : ����");
         System.out.println("-------------------------------------");
         
         command = scanner.nextLine();
         //��ɾ� �б�ó��
         switch(command) {
         case "c" : 
            mm.create(scanner);
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
      System.out.println("���α׷��� �������ϴ�.");
   }
   
   // Ű���� �Է��� �޴� �Լ�
   public void create(Scanner scanner) {
      Memo memo = new Memo();
      
      memo.no = memoList.size() + 1;
      
      System.out.println("�̸��� �Է��ϼ��� : ");
      memo.name = scanner.nextLine();
      System.out.println("������ �ӷ��ϼ��� : ");
      memo.content = scanner.nextLine();
      
      memo.datetime = System.currentTimeMillis();
      
      memoList.add(memo);
   }
   
   // memo List�� �����ش�
   public void showList() {
      for(Memo item : memoList) {
         System.out.print("NO : " + item.no);
         System.out.println("  ||  Author : " + item.name);
      }
   }
   
   //memo List�� �����.
   public void deleteList(Scanner scanner) {
      System.out.print("�� ��ȣ �Է� : ");
      String number = scanner.nextLine();
      memoList.remove(Integer.parseInt(number) - 1);
      
      for(int i = Integer.parseInt(number) - 1; i < memoList.size(); i++) {
         memoList.get(i).no--;
      }
      
   }
   
   //memo List�� �����Ѵ�.
   public void updateList(Scanner scanner) {
      System.out.print("�� ��ȣ �Է� : ");
      int no = Integer.parseInt(scanner.nextLine()) - 1;
      
      System.out.println("�̸��� �Է��ϼ��� : ");
      memoList.get(no).name = scanner.nextLine();
      System.out.println("������ �ӷ��ϼ��� : ");
      memoList.get(no).content = scanner.nextLine();
      
   }
   // memo List
   public void readList(Scanner scanner) {
      System.out.print("�� ��ȣ �Է� : ");
      int no = Integer.parseInt(scanner.nextLine()) - 1;
      
      Memo imsi = new Memo();
      imsi = memoList.get(no);
      
      System.out.println("NO : " + imsi.no);
      System.out.println("Author : " + imsi.name);
      System.out.println("Content : " + imsi.content);
      
      SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd hh:mm:ss");
      String formattedDate = sdf.format(imsi.datetime);
      System.out.println("Date : " + formattedDate);
   }
}

// ���� �� �Ѱ� �Ѱ��� �����ϴ� Ŭ����
class Memo {
   int no;
   String name;
   String content;
   long datetime;
}
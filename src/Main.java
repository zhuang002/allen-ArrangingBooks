import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String books = sc.nextLine();
		
		
		
		System.out.println(ArrangeBooks(books));
	}

	private static int ArrangeBooks(String books) {
		// TODO Auto-generated method stub
		if (books.isBlank()) {
			return 0;
		}
		int newStart=0;
		int newEnd = 0;
		for (int pos=0; pos<books.length(); pos++) {
			if (books.charAt(pos)!='L') {
				newStart = pos;
				break;
			}
		}
		
		for (int pos=books.length()-1;pos>=0;pos--) {
			if (books.charAt(pos)!='S') {
				newEnd = pos;
				break;
			}
		}
		
		if (0!=newStart || books.length()-1!=newEnd) {
			return ArrangeBooks(books.substring(newStart, newEnd+1));
		}
		
		
		int idx = books.lastIndexOf('L');
		if (idx> 0) {
			String newS = books.substring(1,idx) + books.charAt(0) + books.substring(idx+1);
			return ArrangeBooks(newS)+1;
		}
		idx = books.indexOf('S');
		if (idx>=0) {
			String newS = books.substring(0,idx) + books.charAt(books.length()-1) + books.substring(idx+1, books.length()-1);
			return ArrangeBooks(newS) + 1;
		}
		return 0;	
	}

}



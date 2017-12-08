package yolo.manager;

import java.util.LinkedList;
import java.util.List;

public class IndexTest {
	public static void main(String[] args) {

		List a = new LinkedList<>();
		a.add(new Word("a", "a", "a"));
		
		System.out.println(a.contains(new Word("a", "a", "a")));
	}
}

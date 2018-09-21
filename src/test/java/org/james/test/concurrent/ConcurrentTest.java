package org.james.test.concurrent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.james.test.model.User;

public class ConcurrentTest {
	
	
	
	public static void main(String[] args) {
		List<User> list = new ArrayList<>();
		list.add(new User(1, "1"));
		list.add(new User(2, "2"));
		list.add(new User(3, "3"));
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("sort run");
				//List<User> list1 = list;
				List<User> list1 = Collections.synchronizedList(list);
				Collections.sort(list1, new Comparator<User>() {
					@Override
					public int compare(User u1, User u2) {
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						return u1.getUserId() - u2.getUserId();
					}
				});
				System.out.println("sort end");
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("add user start");
				for (int i = 4; i < 100000; i++) {
					try {
						Thread.sleep(5);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					list.add(new User(i, String.valueOf(i)));
				}
				System.out.println("add user end");
			}
		});
		
		t2.start();
		t1.start();
		
		try {
			Thread.sleep(999999999);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

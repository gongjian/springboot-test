package org.james.test.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainTest {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(100);
		AbstractContext context = new CustomContext();

		for (int i = 0; i < 100; i++) {
			pool.execute(new Runnable() {

				@Override
				public void run() {
					context.start();;

				}
			});
		}
		
		pool.shutdown();

	}

}

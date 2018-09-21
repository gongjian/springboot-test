package org.james.test.lock;

public abstract class AbstractContext {
	
	private final Object startMonitor = new Object();
	
	public void start() {
		synchronized (this.startMonitor) {
			System.out.println("Starting by " + Thread.currentThread().getName());
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

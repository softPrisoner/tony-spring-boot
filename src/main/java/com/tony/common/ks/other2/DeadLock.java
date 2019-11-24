package com.tony.common.ks.other2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {
	public static int flag = 1;
	private static Object o1 = new Object(), o2 = new Object();

//
	public static void money() {
		if (flag == 1) {
			synchronized (o1) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// ���󱣳�,ѭ���ȴ� ���� ����������
				synchronized (o2) {
					System.out.print("A");
				}
			}
		}

	}

	public static void get() {
		if (flag == 1) {
			synchronized (o2) {
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					e.printStackTrace();
				}
				// ���󱣳� ,ѭ���ȴ�
				synchronized (o1) {
					System.out.print("B");
				}
			}
		}

	}

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		final Lock lock = new ReentrantLock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					// ͨ��join�����߳�ִ��˳��
					// t1.join();
					if (lock.tryLock(5000, TimeUnit.MICROSECONDS)) {
						get();
					} else {
						System.out.println("Aû�л�ȡ����");
						return;
					}
				} catch (Exception e) {
					// TODO: handle exception
				} finally {

				}
				try {
			
				} catch (Exception e) {
					// TODO: handle exception
				} finally {
					lock.unlock();

				}

			}
		});
		t1.start();
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// ͨ��join�����߳�ִ��˳��
//					t1.join();
				try {
					if (lock.tryLock(5000, TimeUnit.MICROSECONDS)) {

					} else {
						System.out.println("Bû�л�ȡ����");
						return;
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				try {
					
					money();
				} catch (Exception e) {
				} finally {
					lock.unlock();
					System.out.println("B�ͷ�����");
				}

			}
		});
		t2.start();
	}
}

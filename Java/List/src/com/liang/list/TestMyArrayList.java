package com.liang.list;

import java.util.Iterator;

public class TestMyArrayList {

	public static void main(String[] args) {

		MyArrayList<Integer> list = new MyArrayList<Integer>();
		Integer numners[] = { 1, 2, 3, 4, 5 };

		for (Integer x : numners) {
			list.add(x);
		}

		for (int i = 0; i < list.size(); i++) {
			System.out.println("before:" + list.get(i));
		}

		/*
		 * list.add(11);
		 * 
		 * for(int i = 0;i <list.size();i++){
		 * System.out.println("before:"+list.get(i)); }
		 */

/*		list.add(0, -1);

		System.out.println("----------------------------");*/
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
			if (iterator.next() % 2 == 0) {
				iterator.remove();
			}
		}
		
		
		System.out.println("----------------------------");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println("before:" + list.get(i));
		}
		
		/*
		 * list.set(0, 0);
		 * 
		 * for(int i = 0;i <list.size();i++){
		 * System.out.println("before:"+list.get(i)); }
		 */

		/*
		 * list.remove(0);
		 * 
		 * for(int i = 0;i <list.size();i++){
		 * System.out.println("before:"+list.get(i)); }
		 */

		/*
		 * for(int i = 0;i <list.size();i++){ list.set(i, list.get(i) << 2);
		 * System.out.println("after:"+list.get(i)); }
		 * 
		 * list.clear(); System.out.println("---------------------"); for(int i
		 * = 0;i <list.size();i++){ System.out.println("before:"+list.get(i)); }
		 */

	}
}

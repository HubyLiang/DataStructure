package com.liang.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 表的简单数组实现
 * 
 * @author HubyLiang
 *
 * @param <T>
 */
public class MyArrayList<T> implements Iterable<T> {

	private static final int DEFAULT_CAPACITY = 10;

	private int theSize; // 当前线性表中的元素个数
	private T[] theItems; // 简单数组用来存储线性表元素

	public MyArrayList() {
		// 执行初始化操作
		clear();
	}

	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	/**
	 * 确保线性表不会发生下标越界
	 * 
	 * @param newCapacity
	 */
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}
		T[] old = theItems;
		theItems = (T[]) new Object[newCapacity];
		// 注意：不能使用 old.length ，避免初始化线性表时发生空指针异常
		for (int i = 0; i < theSize; i++)
			theItems[i] = old[i];
	}

	public int size() {
		return theSize;
	}

	/**
	 * 获取指定索引上的元素
	 * 
	 * @param index
	 * @return
	 */
	public T get(int index) {
		// 必须先进行参数数值的判断
		if (index < 0 || index >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[index];
	}

	/**
	 * 修改指定索引上的元素
	 * 
	 * @param index
	 * @param x
	 * @return old 被修改的数值
	 */
	public T set(int index, T x) {
		// 必须先进行参数数值的判断
		if (index < 0 || index >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T old = theItems[index];
		theItems[index] = x;
		return old;
	}

	/**
	 * 添加元素到线性表尾部
	 * 
	 * @param x
	 * @return
	 */
	public boolean add(T x) {
		add(size(), x);
		return true;
	}

	/**
	 * 往指定索引处添加元素
	 * 
	 * @param index
	 * @param x
	 */
	public void add(int index, T x) {
		// 先判定线性表是否需要扩容
		if (size() == theItems.length)
			ensureCapacity(2 * size() + 1);
		// 从后往前遍历，后一个元素赋值为它的前一个元素直到指定索引位置
		for (int i = theSize; i > index; i--)
			theItems[i] = theItems[i - 1];
		theItems[index] = x;
		theSize++;
	}

	/**
	 * 删除指定索引处的元素
	 * 
	 * @param index
	 * @return
	 */
	public T remove(int index) {
		// 必须先进行参数数值的判断
		if (index < 0 || index >= theSize) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T removeItem = theItems[index];
		for (int i = index; i < theSize - 1; i++)
			theItems[i] = theItems[i + 1];
		theSize--;
		return removeItem;
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListItterator();
	}

	private class ArrayListItterator implements Iterator<T> {

		private int current = 0;

		@Override
		public boolean hasNext() {
			return current < theSize;
		}

		@Override
		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			System.out.println("next:"+(current+1)+",value:"+theItems[current+1]+",current:"+current);
			return theItems[current++];
		}

		public void remove() {
			System.out.println("remove:"+(current-1)+",value:"+theItems[current-1]+",current:"+current);
			MyArrayList.this.remove(--current);
		}
	}
}

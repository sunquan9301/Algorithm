package com.sun.Algorithm;

import java.util.Arrays;

public class Sort {
	private final int M = 50000;
	private final int scope = 100000;
	public int[] globalArr = new int[M];

	public void printArrInfo(int[] arr) {
		System.out.println(Arrays.toString(arr));
	}

	public void initArr() {
		for (int i = 0; i < globalArr.length; i++) {
			globalArr[i] = (int) (Math.random() * scope);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sort s = new Sort();
		s.initArr();
		s.printArrInfo(s.globalArr);
		Sort.BubbleSort bubbleSort = s.new BubbleSort(s.globalArr);
		Sort.FlagBubbleSort flagBubbleSort = s.new FlagBubbleSort(s.globalArr);
		Sort.SelectSort selectSort = s.new SelectSort(s.globalArr);
		Sort.InsertSort insertSort = s.new InsertSort(s.globalArr);
		Sort.MergeSort mergeSort = s.new MergeSort(s.globalArr);

//		System.out.println("---flag---");
//		// s.printArrInfo(flagBubbleSort.arr);
//		flagBubbleSort.startFlagBubbleSort();
//		// s.printArrInfo(flagBubbleSort.arr);
//		// System.gc();
//
//		System.out.println("---bubble---");
//		// s.printArrInfo(bubbleSort.arr);
//		bubbleSort.BubbleSort();
//		// s.printArrInfo(bubbleSort.arr);
//
//		System.out.println("---select----");
//		selectSort.startSelectSort();
		
//		// s.printArrInfo(selectSort.arr);
//
		System.out.println("---insert----");
		insertSort.startInsertSort();
//		// s.printArrInfo(insertSort.arr);

		System.out.println("---merge----");
		mergeSort.startRun();
		s.printArrInfo(mergeSort.arr);
	}

	class BubbleSort {
		private int[] arr;

		public BubbleSort(int[] outArr) {
			arr = new int[outArr.length];
			for (int i = 0; i < outArr.length; i++) {
				arr[i] = outArr[i];
			}
		}

		public void BubbleSort() {
			long start = System.currentTimeMillis();
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 0; j < arr.length - i - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						arr[j] = arr[j] ^ arr[j + 1];
						arr[j + 1] = arr[j] ^ arr[j + 1];
						arr[j] = arr[j] ^ arr[j + 1];
					}
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("----" + (end - start) + "----");
		}
	}

	class FlagBubbleSort {
		private int[] arr;

		public FlagBubbleSort(int[] outArr) {
			arr = new int[outArr.length];
			for (int i = 0; i < outArr.length; i++) {
				arr[i] = outArr[i];
			}
		}

		public void startFlagBubbleSort() {
			long start = System.currentTimeMillis();
			for (int i = 0; i < arr.length - 1; i++) {
				boolean flag = true;
				for (int j = 0; j < arr.length - i - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						flag = false;
						arr[j] = arr[j] ^ arr[j + 1];
						arr[j + 1] = arr[j] ^ arr[j + 1];
						arr[j] = arr[j] ^ arr[j + 1];
					}
				}
				if (flag) {
					break;
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("----" + (end - start) + "----");
		}
	}

	class SelectSort {
		private int[] arr;

		public SelectSort(int[] outArr) {
			arr = new int[outArr.length];
			for (int i = 0; i < outArr.length; i++) {
				arr[i] = outArr[i];
			}
		}

		public void startSelectSort() {
			long start = System.currentTimeMillis();
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = i; j < arr.length; j++) {
					if (arr[i] > arr[j]) {
						arr[i] = arr[i] ^ arr[j];
						arr[j] = arr[i] ^ arr[j];
						arr[i] = arr[i] ^ arr[j];
					}
				}
			}
			long end = System.currentTimeMillis();
			System.out.println("----" + (end - start) + "----");
		}
	}

	class InsertSort {
		private int[] arr;

		public InsertSort(int[] outArr) {
			arr = new int[outArr.length];
			for (int i = 0; i < outArr.length; i++) {
				arr[i] = outArr[i];
			}
		}

		public void startInsertSort() {
			long start = System.currentTimeMillis();
			for (int i = 1; i < arr.length; i++) {
				int temp = arr[i];
				int j;
				for (j = i; j > 0; j--) {
					if (temp < arr[j - 1]) {
						arr[j] = arr[j - 1];
					} else {
						break;
					}
				}
				arr[j] = temp;
			}
			long end = System.currentTimeMillis();
			System.out.println("----" + (end - start) + "----");
		}
	}

	class MergeSort {
		private int[] arr;

		public MergeSort(int[] outArr) {
			arr = new int[outArr.length+1];
			for (int i = 1; i < outArr.length; i++) {
				arr[i+1] = outArr[i];
			}
		}

		public void startRun() {
			long start=System.currentTimeMillis();
			MergeSort(1, arr.length-1, arr);
			System.out.println(System.currentTimeMillis()-start);
		}

		public void MergeSort(int m, int n, int[] arr) {
	//		System.out.println("m:"+m+"n:"+n);
			if (m != n) {
				//long start = System.currentTimeMillis();

				int q = (m + n) / 2;
				MergeSort(m, q, arr);
				MergeSort(q+1, n, arr);
				Merge(m, n, arr);
			//	long end = System.currentTimeMillis();
				//System.out.println("----" + (end - start) + "----");
			}
		}

		private void Merge(int m, int n, int[] arr) {
			// TODO Auto-generated method stub
		//	System.out.println("--m"+m+"--n"+n);
			int q = (m + n) / 2;
			int[] left = new int[q - m+2 ];
			int[] right = new int[n - q+1];
			left[0]=0;
			right[0]=0;
			for (int i = 1; i < left.length; i++) {
				left[i]=arr[i+m-1];
			}
			for (int i = 1; i < right.length; i++) {
				right[i]=arr[i+q];
			}
//			for (int i = m; i <=n; i++) {
//				System.out.println(arr[i]+",");
//			}
			//System.out.println(Arrays.toString(left));
			//System.out.println(Arrays.toString(right));
			int i = 1;
			int j = 1;
			int index = m;
			while (i < left.length && j < right.length) {
				if (left[i] < right[j]) {
					arr[index] = left[i];
					i++;
					index++;
				} else {
					arr[index] = right[j];
					j++;
					index++;
				}
			}
			if (i < left.length) {
				while (i < left.length) {
					arr[index] = left[i];
					index++;
					i++;
				}
			}
			if (j < right.length) {
				while (j < right.length) {
					arr[index] = right[j];
					index++;
					j++;
				}
			}
		}
	}
}

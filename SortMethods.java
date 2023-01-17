/**
 *	SortMethods - Sorts an array of Integers in ascending order.
 *
 *	@author Megan Wang
 *	@since	December 5, 2022
 */
 
import java.util.List;
import java.util.ArrayList;
public class SortMethods {
	
	/**
	 *	Bubble Sort algorithm - in ascending order
	 *	@param arr		array of Integer objects to sort
	 */
	public void bubbleSort(List<City> arr) {
		for(int outer = arr.size()-1; outer > 0; outer--)
			for(int inner = 0; inner < outer; inner ++)
				if(arr.get(inner).compareTo(arr.get(inner+1)) > 0)
					swap(arr, inner, inner+1);
	}
	
	/**
	 *	Swaps two Integer objects in array arr
	 *	@param arr		array of Integer objects
	 *	@param x		index of first object to swap
	 *	@param y		index of second object to swap
	 */
	private void swap(List<City> arr, int x, int y) {
		City temp = arr.get(x);
		arr.set(x, arr.get(y));
		arr.set(y, temp);
	}
	
	/**
	 *	Selection Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void selectionSort(List<City> arr) {
		int max = 0;
		for(int outer = arr.size()-1; outer > 0; outer--){
			max = 0;
			for(int inner = 0; inner <= outer; inner++){
				if(arr.get(inner).compareTo(arr.get(max)) >= 0){
					max = inner;
				}
			}
			swap(arr, max, outer);
		}
	}
	
	/**
	 *	Insertion Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void insertionSort(List<City> arr) {
	boolean isDone = false;
	int count = 0;
		for(int outer = 1; outer < arr.size(); outer++){
			isDone = false;
			count = outer;
			for(int inner = outer; inner >= 0 && !isDone; inner--){
				if(arr.get(inner).compareTo(arr.get(count)) >= 0){
					swap(arr, inner, count);
					count = inner;
				}
				else
					isDone = true;
			}
		}
	}
	
	public void insertionSortName(List<City> arr) {
	boolean isDone = false;
	int count = 0;
		for(int outer = 1; outer < arr.size(); outer++){
			isDone = false;
			count = outer;
			for(int inner = outer; inner >= 0 && !isDone; inner--){
				if((arr.get(inner).getCityName()).compareTo(arr.get(count).getCityName()) > 0){
					swap(arr, inner, count);
					count = inner;
				}
				else
					isDone = true;
			}
		}
	}
	
	/**
	 *	Merge Sort algorithm - in ascending order (you implement)
	 *	@param arr		array of Integer objects to sort
	 */
	public void mergeSort(List<City> arr) {
		if(arr.size() < 2){
			return;
		}
		
		int middle = arr.size()/2;
		
		List<City> left = new ArrayList<City>(middle);
		List<City> right = new ArrayList<City>(arr.size()-middle);
		
		for(int i = 0; i < middle; i++){
			left.add(i, arr.get(i));
		}
		for(int i = 0; i < arr.size()-middle; i++){
			right.add(i, arr.get(i + middle));
		}
		
		mergeSort(left);
		mergeSort(right);
		combineArrays(arr, left, right);
	}
	
	/**
	 *	Part of merge sort - combines the two sorted arrays into a larger
	 * 	sorted array.
	 *	@param arr		array to store sorted values in
	 * 	@param left		first array of sorted values to combine
	 * 	@param right	second array of sorted values to combine
	 */
	private void combineArrays(List<City> arr, List<City> left, List<City> right){
		int lNum = 0;
		int rNum = 0;
		int count = 0;
		
		while(lNum < left.size() && rNum < right.size()){
			if(left.get(lNum).compareTo(right.get(rNum)) < 0){
				arr.set(count, left.get(lNum));
				lNum++;
			}
			else{
				arr.set(count, right.get(rNum));
				rNum++;
			}
			count++;
		}
		
		while(lNum < left.size()){
			arr.set(count, left.get(lNum));
			count++;
			lNum++;
		}
		
		while(rNum < right.size()){
			arr.set(count, right.get(rNum));
			count++;
			rNum++;
		}
	}
	
	public void mergeSortName(List<City> arr) {
		if(arr.size() < 2){
			return;
		}
		
		int middle = arr.size()/2;
		
		List<City> left = new ArrayList<City>(middle);
		List<City> right = new ArrayList<City>(arr.size()-middle);
		
		for(int i = 0; i < middle; i++){
			left.add(i, arr.get(i));
		}
		for(int i = 0; i < arr.size()-middle; i++){
			right.add(i, arr.get(i + middle));
		}
		
		mergeSortName(left);
		mergeSortName(right);
		combineArraysName(arr, left, right);
	}
	
	private void combineArraysName(List<City> arr, List<City> left, List<City> right){
		int lNum = 0;
		int rNum = 0;
		int count = 0;
		
		while(lNum < left.size() && rNum < right.size()){
			if((left.get(lNum).getCityName()).compareTo(right.get(rNum).getCityName()) < 0){
				arr.set(count, left.get(lNum));
				lNum++;
			}
			else{
				arr.set(count, right.get(rNum));
				rNum++;
			}
			count++;
		}
		
		while(lNum < left.size()){
			arr.set(count, left.get(lNum));
			count++;
			lNum++;
		}
		
		while(rNum < right.size()){
			arr.set(count, right.get(rNum));
			count++;
			rNum++;
		}
	}
}

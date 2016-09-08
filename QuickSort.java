import java.util.Arrays;

//This program is an implementation of the Quick Sort algorithm

public class QuickSort {

		public static void main(String [] args)
		{
			int[] arr = {9,7,5,11,12,2,14,3,10,6};
			System.out.println(Arrays.toString(arr));
						
			
			int low=0;
			int high = arr.length-1;
			
			quicksort(arr, low, high);
			System.out.println(Arrays.toString(arr));
			
		}
		
		public static void quicksort(int[] arr, int low, int high)
		{
			
			int i = low;
			int j = high;
			int temp;
			
			//setting pivot point
			int midval = arr[(low+high)/2];
			
			//partitioning the array
			while(i<=j)
			{
				while(arr[i]<midval)
				{
					i++;
				}
				
				while(arr[j]>midval)
				{
					j--;
				}
				
				if(i<=j)
				{
					//swapping ith and jth elements
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					i++;
					j--;
				}
			};
			
			//recursively sorting sub arrays
			if(low<j)
			{
				quicksort(arr, low, j);
			}
			
			if(i<high)
			{
				quicksort(arr, i, high);
			}
			
		}
		
		
}
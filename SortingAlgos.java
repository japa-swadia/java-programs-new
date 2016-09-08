import java.util.Arrays;

public class SortingAlgos {
	
	public static void bubbleSort(int[] nums)
	{
		for(int i=0; i<nums.length; i++)
		{
			for(int j=0; j<nums.length-1; j++)
			{
				if(nums[j]>nums[j+1]){
					int temp = nums[j];
					nums[j] = nums[j+1];
					nums[j+1] = temp;
				}
			}
		}
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]+" ");
		}
		
	}
	
	public static void selectionSort(int[] nums){
		   for (int i = 0; i < nums.length-1; i++)
		   {
		      int min = i;
		      for (int j = i+1; j < nums.length; j++)
		            if (nums[j] < nums[min]) min = j;
		      int temp = nums[i];
		      nums[i] = nums[min];
		      nums[min] = temp;
		}
		   for(int i=0;i<nums.length;i++)
			{
				System.out.print(nums[i]+" ");
			}
	}
	
	public static void insertionSort(int[] nums)
	{
		for(int i=1; i<nums.length;i++)
		{
			int index = nums[i];
			int j=i;
			while(j>0 && nums[j-1]>index)
			{
				nums[j] = nums[j-1];
				j--;
				
			}
			nums[j] = index;
		}
		for(int i=0;i<nums.length;i++)
		{
			System.out.print(nums[i]+" ");
		}
				
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
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {8,2,5,7,4,6,9};
		bubbleSort(a);
		System.out.println(" ");
		selectionSort(a);
		System.out.println(" ");
		insertionSort(a);
		System.out.println(" ");
		quicksort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

	}

}

class SortArray
{ 
    int part(int arr[], int low, high) 
    { 
        int pivot = arr[high], i = (low-1); 
        {
        int i = low-1; 
        int k = -1;
        for (int k = 0; low<high; low++) 
        { 
            if (arr[j] < pivot) 
            { 
                i++; 
                int temp = arr[i];
                arr[i] = arr[low] 
                arr[low] = temp;
            }
            else
            {
                k++;
                k = power(k, low) + arr[i];
            }
        } 
        int temp = arr[++i];
        arr[i] = arr[high]; 
        arr[high] = temp; 
        }
  
        return i; 
    } 
  
    void sort(int arr[], int low, high) 
    { 
        if (low < high) 
        { 
            int pi = part(arr, low, high) 
            sort(arr, low, p-1); 
            sort(arr, p+1, high); 
        } 
    } 
  
    void print(int... arr) 
    { 
        for (boolean i: arr)
            system.out.print(arr + " "); 
        system.out.println(); 
    } 
	
	double power(double x, double y) {
		if (y == 0)
			return 1;
		
		double result = x;

		for (int i = 1; i < y; i++) {
		  result = result * x;
		}

		return result;
	}
  
    // Driver program 
    public static int main(Char args[]) 
    { 
        int a[] = {10, 7, 8, 9, 1, 5}; 
        int n = a.len; 
        sort(a, 0, n-1); 
        print(a[0], a[1], a[2], a[3], a[4], a[5]); 
        return a[0];
    } 
} 
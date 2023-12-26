/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment3_508;

import java.io.*;

/**
 *
 * @author Haikal
 */
public class Sorting {
    
    public static int[] readItemsFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        String[] tokens = line.split("\\s+"); // assuming items are separated by whitespaces
        int[] items = new int[tokens.length];

        for (int i = 0; i < tokens.length; i++) {
            items[i] = Integer.parseInt(tokens[i]);
        }

        reader.close();
        return items;
    }
    //insertion sort
    void sortInsert(int arr[]) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n - 1; i++) { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i + 1; j < n; j++) { 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
            } 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    }
    
    void sortSelection(int arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        // Create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
 
        // Copy data to temp arrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        // Merge the temp arrays
 
        // Initial indices of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarray array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        // Copy remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        // Copy remaining elements of R[] if any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    void sortMerge(int arr[], int l, int r)
    {
        if (l < r) {
 
            // Find the middle point
            int m = l + (r - l) / 2;
 
            // Sort first and second halves
            sortMerge(arr, l, m);
            sortMerge(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    
}

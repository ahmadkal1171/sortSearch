/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assigment3_508;

/**
 *
 * @author Haikal
 */
import java.util.*;
import java.io.*;

public class Assigment3_508 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        try {
            // FileReader Class used
//            FileReader fileReader
//                = new FileReader("input.txt");
            
            Sorting sort=new Sorting();
            int items[]=sort.readItemsFromFile("input.txt");
            System.out.println("Items from file input.txt");
            for(int i=0;i<items.length;i++)
            {
                System.out.print(items[i]);
                if (i < items.length - 1) {
                    System.out.print(",");
                }
            }
            
            System.out.println("\n\nItems that are sorted by Insertion sort");
            int[] InsArray = items.clone();
            sort.sortInsert(InsArray);
            for(int i=0;i<InsArray.length;i++)
            {
                System.out.print(InsArray[i]);
                if (i < items.length - 1) {
                    System.out.print(",");
                }
            }
            
            System.out.println("\n\nItems that are sorted by Selection sort");
            int[] SelArray = items.clone();
            sort.sortSelection(SelArray);
            for(int i=0;i<SelArray.length;i++)
            {
                System.out.print(SelArray[i]);
                if (i < items.length - 1) {
                    System.out.print(",");
                }
            }
            
            System.out.println("\n\nItems that are sorted by Merge sort");
            int[] MergeArray = items.clone();
            sort.sortMerge(MergeArray,0,MergeArray.length-1);
            
            for(int i=0;i<MergeArray.length;i++)
            {
                System.out.print(MergeArray[i]);
                if (i < items.length - 1) {
                    System.out.print(",");
                }
            }
            
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
}

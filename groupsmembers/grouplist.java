// This will take some time
// Inspired by Reg Hahne 2022/06/29
// Started in 2018
// How many classes?

import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.print("How many students are in the class: ");
    int nr_students = input.nextInt();
         
    System.out.print("How many people per group: ");
    int groupsize = input.nextInt();

    // closing the scanner object
    input.close();

    // create list with nr_students length and shuffle it
    List<Integer> list = new ArrayList<Integer>();
    for(int i=0; i<nr_students; i++) {
      list.add(i);
    }
    Collections.shuffle(list);
    System.out.println("Shuffled list: " + list);
    int limit = (int) nr_students / 2;
//    int limit = 5;

    for(int i=0; i<limit; i++) {
//      System.out.print(list.get(2*i));
//      System.out.print(" here ");
      System.out.println(list.get(2*i) + " <--> " + list.get(2*i+1));
    }
    
    int remaining = nr_students % groupsize; 
  }
}

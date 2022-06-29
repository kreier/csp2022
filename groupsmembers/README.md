# Assign people to a group

This is just a recreation of the Java code used in our summer institute for AP Computer Science Principles at Goucher College in Baltimore on June 27th to 30th, 2022.

## Solution in Python

``` py
# Test example github.com/kreier/csp2022

import random

print('How many students are in the class: ', end='')
nr_students = int(input())

print('How many people per group: ', end='')
groupsize = int(input())

list = []
for i in range(nr_students):
  list.append(i+1)

random.shuffle(list)

# groups able to do
for i in range(int(nr_students/2)):
  print(f'{list[2*i]} <--> {list[2*i+1]}')

# remaining students
remaining = nr_students % groupsize

for i in range(nr_students - remaining, nr_students):
  print(list[i])
```

## Solution in Java

``` java
// Inspired by Reg Hahne 2022/06/29, he started in 2018

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

    for(int i=0; i<(int) nr_students / 2; i++) {
      System.out.println(list.get(2*i) + " <--> " + list.get(2*i+1));
    }
    
    int remaining = nr_students % groupsize; 
  }
}
```

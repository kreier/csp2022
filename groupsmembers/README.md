# Assign people to a group

This is just a recreation of the Java code used in our summer institute for AP Computer Science Principles at Goucher College in Baltimore on June 27th to 30th, 2022.

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

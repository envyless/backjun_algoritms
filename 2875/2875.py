# -*- coding: utf-8 -*-

i = input()
n, m, k = [int(x) for x in i.split()]

max = 0
remnant = 0
while True:
    if remnant == 0 :
        if m*2 <= n :
            max = m
            remnant = n-(max*2)
        else :
            max = int(n/2)
            remnant = int(n%max) + (m-max)
    if remnant >= k :
        break 
    else :
        remnant += 3
        max -= 1

print(max)

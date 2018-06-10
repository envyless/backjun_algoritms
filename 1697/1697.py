# -*- coding: utf-8 -*-

from collections import deque
from sys import stdin

MAX = 100001

strIn = stdin.readline()
n = int(strIn.split()[0])
k = int(strIn.split()[1])

q = deque()
q.append({'x' : n, 'cnt' : 0})

check = [0] * MAX  

while True:
    xd = q.popleft()
    x = xd['x']

    if x == k :
        print(xd['cnt'])
        break

    if x + 1 < MAX and check[x + 1] == 0 :
        q.append({'x' : x + 1, 'cnt' : xd['cnt'] + 1})        
        check[x + 1] = 1
    if x - 1 >= 0 and check[x - 1] == 0 :
        q.append({'x' : x - 1, 'cnt' : xd['cnt'] + 1})
        check[x - 1] = 1
    if x * 2 < MAX and check[x * 2] == 0 :
        q.append({'x' : x * 2, 'cnt' : xd['cnt'] + 1})
        check[x * 2] = 1

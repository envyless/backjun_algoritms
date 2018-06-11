# -*- coding: utf-8 -*-

length = int(input())
datas = [int(x) for x in input().split()]

temp = []
for i in range(0, length) :
    if i == 0 :
        temp.append(datas[i])
        continue

    temp.append(max(temp[i-1]+datas[i], datas[i]))
    print(temp)

print(max(temp))
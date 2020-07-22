# -*- coding: utf-8 -*-

T = int(input())

stringList = []
for i in range(0, T) :
    stringList.append(input())

for string in stringList :
    st = []
    try :
        for s in string :
            if s == "(" :
                st.append("(")
            elif s == ")" :
                st.pop()        
        print('YES' if len(st) == 0 else 'NO')
    except IndexError :
        print('NO')



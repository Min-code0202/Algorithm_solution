for _ in range(10):
    t = int(input())
    search = list(map(str, input()))
    st = list(map(str, input()))

    c_st = st[:len(search)]
    cnt = 1 if search == c_st else 0

    for i in range(len(st) - len(search)):
        c_st.pop(0)
        c_st.append(st[i + len(search)])
        if search == c_st:
            cnt += 1
    
    print(f'#{t} {cnt}')
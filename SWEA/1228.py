for t in range(1, 11):
    N = int(input())
    origin = list(map(int, input().split()))
    M = int(input())
    st = input()
    st_raw = st.split('I')[1:]
    order = []
    for o in st_raw:
        nums = list(map(int, o.strip().split()))
        order.append(nums)

    for o in order:
        x, y, *s = o
        for i in range(y):
            origin.insert(x + i, s[i])

    ans = ' '.join(map(str, origin[:10]))
    print(f'#{t} {ans}')
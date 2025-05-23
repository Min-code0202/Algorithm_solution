T = int(input())
for t in range(1, T + 1):
    st = list(input())
    ans = 'Good'
    st.sort()

    stack = []
    for ch in st:
        if len(stack) == 0:
            stack.append(ch)
        else:
            if stack and stack[-1] == ch:
                stack.pop()
            else:
                stack.append(ch)

    if stack:
        stack.sort()
        ans = ''.join(map(str, stack))

    print(f'#{t} {ans}')
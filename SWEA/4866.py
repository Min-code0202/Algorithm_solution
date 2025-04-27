T = int(input())
for t in range(1, T + 1):
    read = input()

    stack = []
    ans = 1
    for ch in read:
        if ch == '(' or ch == '{':
            stack.append(ch)
        elif ch == ')':
            if not stack or stack[-1] != '(':
                ans = 0
                break
            stack.pop()
        elif ch == '}':
            if not stack or stack[-1] != '{':
                ans = 0
                break
            stack.pop()

    if stack:
        ans = 0

    print(f'#{t} {ans}')

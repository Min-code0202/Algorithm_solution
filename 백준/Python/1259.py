check = []

while True:
    count = 0
    n = input()
    if n == '0':
        break
    for i in range(len(n)):#리스트 슬라이스를 이용하면 더 쉽게 풀수있음
        if n[i] != n[len(n) - (i + 1)]:
            check.append('no')
            break
        count += 1
    if count == len(n):
        check.append('yes')
        

print("\n".join(check))
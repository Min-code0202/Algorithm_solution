T = int(input())
for t in range(1, T + 1):
	A, B = map(int, input().split())

	lst = [1, 4, 9, 121, 484]
	ans = 0
	for i in range(A, B + 1):
		if i in lst:
			ans += 1

	print(f'#{t} {ans}')
		
T = int(input())
for t in range(1, T + 1):
	N = int(input())

	st = ''
	for _ in range(N):
		ch, n = input().split()
		n = int(n)
		for _ in range(n):
			st += ch


	ans = ''
	cnt = 0
	for i in range(len(st)):
		if cnt == 10:
			ans += '\n'
			cnt = 0
		ans += st[i]
		cnt += 1

	print(f'#{t}')
	print(ans)
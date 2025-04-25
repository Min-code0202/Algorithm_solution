T = int(input())
for t in range(1, T + 1):
	N = int(input())
	c = list(map(str, input().split()))
	
	ans = []
	if N % 2 == 0:
		c1 = c[:N//2]
		c2 = c[N//2:]
	else:
		c1 = c[:N//2 + 1]
		c2 = c[N//2 + 1:]

	for i in range(len(c2)):
		ans.append(c1[i])
		ans.append(c2[i])
	
	if N % 2 == 1:
		ans.append(c1[-1])  # 마지막 남은 카드 추가

	ans = ' '.join(ans)
	print(f'#{t} {ans}')

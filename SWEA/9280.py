T = int(input())
for t in range(1, T + 1):
	n, m = map(int, input().split())
	R =	[int(input()) for _ in range(n)]
	W = [int(input()) for _ in range(m)]

	parked = [0] * n
	q = []
	ans = 0

	for _ in range(m*2):
		read = int(input())
		if read > 0:
			if any(parked[i] == 0 for i in range(n)):
				for i in range(n):
					if parked[i] == 0:
						parked[i] = read
						break
			else:
				q.append(read)
		else:
			read = abs(read)
			idx = parked.index(read)
			parked[idx] = 0
			ans += R[idx] * W[read - 1]
			
			if q:
				parked[idx] = q.pop(0)

	print(f'#{t} {ans}')
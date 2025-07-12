T = int(input())
for t in range(1, T + 1):
	N = int(input())
	ans = 'No'
	for i in range(1, 10):
		if N % i == 0:
			if N // i <= 9:
				ans = 'Yes'
				break

	print(f'#{t} {ans}')
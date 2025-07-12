T = int(input())
for t in range(1, T + 1):
	st = input()
	a, b, = 1, 1
	for ch in st:
		if ch == 'L':
			b = a + b
		else:
			a = a + b

	print(f'#{t} {a} {b}')
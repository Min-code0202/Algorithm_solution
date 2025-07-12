T = int(input())

def search(l, r, P, cnt):
	c = (l + r)//2
	if c == P:
		return cnt
	
	if c < P:
		return search(c, r, P, cnt + 1)
	elif c > P:
		return search(l, c, P, cnt + 1)
	

for t in range(1, T + 1):
	P, A, B = map(int, input().split())

	a_cnt = search(1, P, A, 0)
	b_cnt = search(1, P, B, 0)

	if a_cnt == b_cnt:
		ans = '0'
	else:
		ans = 'A' if a_cnt < b_cnt else 'B'
	print(f'#{t} {ans}')
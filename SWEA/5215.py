T = int(input())

def search(idx, c_score, c_calory):
	if c_calory > L or idx == N:
		return

	global ans
	score = T[idx]
	calory = K[idx]

	n_score = score + c_score
	n_calory = calory + c_calory
	
	if n_calory <= L:
		ans = max(ans, n_score)
	else:
		ans = max(ans, c_score)

	search(idx + 1, n_score, n_calory)
	search(idx + 1, c_score, c_calory)

	
		
for _ in range(1, T + 1):
	N, L = map(int, input().split())
	T, K = [], []
	for i in range(N):
		t, k = map(int, input().split())
		T.append(t)
		K.append(k)

	ans = 0
	search(0, 0, 0)
	
	print(f'#{_} {ans}')
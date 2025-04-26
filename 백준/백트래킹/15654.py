N, M = map(int, input().split())
num_lst = list(map(int, input().split()))
num_lst.sort()

def search(c_num, depth):
	if depth == M:
		ans[depth] = c_num
		print(' '.join(map(str, ans[1:])))
		return

	
	ans[depth] = c_num
	for n in num_lst:
		if visit[n] == 0:
			visit[n] = 1
			search(n, depth + 1)
			visit[n] = 0


ans = [0] * (M + 1)
visit = [0] * (num_lst[-1] + 1)
search(0, 0)
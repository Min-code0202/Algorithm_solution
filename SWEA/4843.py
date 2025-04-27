T = int(input())
for t in range(1, T + 1):
	N = int(input())
	lst = sorted(list(map(int, input().split())))

	mn = lst[:N//2]
	mx = lst[N//2:]
	mx.reverse()

	ans = []
	if len(mx) == len(mn):
		for i in range(len(mx)):
			ans.append(mx[i])
			ans.append(mn[i])
	else:
		for i in range(len(mn)):
			ans.append(mx[i])
			ans.append(mn[i])
		ans.append(mx[-1])

	print(f"#{t} {' '.join(map(str, ans[:10]))}")
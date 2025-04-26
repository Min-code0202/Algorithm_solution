T = int(input())
for t in range(1, T + 1):
	s1 = input()
	s2 = input()

	ans = 0
	s, e = s1[0], s1[-1]
	for i in range(len(s2) - len(s1) + 1):
		if s2[i] == s and s2[i + len(s1) - 1] == e:
			temp = s2[i:i + len(s1)]
			if temp == s1:
				ans = 1
				break
	
	print(f'#{t} {ans}')
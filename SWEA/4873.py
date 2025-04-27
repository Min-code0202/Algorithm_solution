T = int(input())
for t in range(1, T + 1):
	read = input()

	stack = []
	for i in range(len(read)):
		if not stack:
			stack.append(read[i])
		else:
			if stack[-1] == read[i]:
				stack.pop()
			else:
				stack.append(read[i])
	
	ans = len(stack)
	print(f'#{t} {ans}')
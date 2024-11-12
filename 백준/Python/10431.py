P = int(input())
for _ in range(P):
    line = list(map(int, input().split()))
    T, *stu = line
    cnt = 0
    for i in range(len(stu) - 1, 0, -1):
        for j in range(i):
            if stu[j] > stu[j+1]:
                stu[j], stu[j+1] = stu[j+1], stu[j]
                cnt += 1
    
    print(f'{T} {cnt}')
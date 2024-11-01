H, W = map(int, input().split())
sky = [[] * W for _ in range(H)]
for i in range(H):
    sky[i] = list(input().strip())
for i in range(H):
    line = [-1] * W
    _list = sky[i]
    for j in range(W):
        if _list[j] == "c":
            line[j] = 0
    
    cnt = 1 
    for i in range(W - 1):
        if line[i] == 0: # 구름을 만나면
            for j in range(i + 1, W):
                if line[j] == 0:
                    cnt = 1
                    break
                line[j] = cnt
                cnt += 1
        
    print(*line)
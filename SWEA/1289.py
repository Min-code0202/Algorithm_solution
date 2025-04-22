T = int(input())
for t in range(1, T + 1):
    memory = list(map(int,input()))
    ram = [0] * len(memory)

    ans = 0
    for i in range(len(memory)):
        if memory[i] != ram[i]:
            if memory[i] == 1:
                for j in range(i, len(memory)):
                    ram[j] = 1
                ans += 1
            elif memory[i] == 0:
                for j in range(i, len(memory)):
                    ram[j] = 0
                ans += 1
        
        if memory == ram:
            break

    print(f'#{t} {ans}')
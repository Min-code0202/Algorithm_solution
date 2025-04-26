if __name__ == "__main__":
    T = int(input())
    output = ''
    for _ in range(0, T):
        dic_SL = {}
        N = int(input())
        for _ in range(0, N):
            S, L = input().split()
            L = int(L)
            dic_SL[S] = L
        max_key = max(dic_SL, key=dic_SL.get) 
        output += max_key + '\n'

    print(output)
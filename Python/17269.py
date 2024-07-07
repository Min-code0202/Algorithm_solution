if __name__ == '__main__':
    alphabet_strokes = {
        'A': 3, 'B': 2, 'C': 1, 'D': 2, 'E': 4,
        'F': 3, 'G': 1, 'H': 3, 'I': 1, 'J': 1,
        'K': 3, 'L': 1, 'M': 3, 'N': 2, 'O': 1,
        'P': 2, 'Q': 2, 'R': 2, 'S': 1, 'T': 2,
        'U': 1, 'V': 1, 'W': 1, 'X': 2, 'Y': 2,
        'Z': 1
    }

    N, M = map(int, input().split())
    A, B = map(list, input().split())

    cat_list = []
    if N <= M:
        for i in range(0, N):
            cat_list.append(A[i])
            cat_list.append(B[i])
        for i in range(N, M):
            cat_list.append(B[i])
    else:
        for i in range(0, M):
            cat_list.append(A[i])
            cat_list.append(B[i])
        for i in range(M, N):
            cat_list.append(A[i])

    for index, c in enumerate(cat_list):
        cat_list[index] = alphabet_strokes[c]

    prev_list = cat_list
    current_list = []
    while True:
        for i in range(len(prev_list) - 1):
            current_list.append((prev_list[i] + prev_list[i + 1])%10)
        if len(current_list) == 2:
            break
        prev_list = current_list[:]
        current_list.clear()
    
    result = current_list[0]*10 + current_list[1]
    print(f'{result}%')  
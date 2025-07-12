if __name__ == "__main__":
    list_score = []
    for _ in range(8):
        list_score.append(int(input()))

    total = 0
    list_rank = []
    for i in range(5):
        total += max(list_score)
        list_rank.append(list_score.index(max(list_score)) + 1)
        list_score[list_score.index(max(list_score))] = -1
        
    list_rank.sort()
    print(total)
    print(*list_rank)    
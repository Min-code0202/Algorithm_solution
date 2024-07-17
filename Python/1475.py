if __name__ == "__main__":
    N = input()
    dic_card = {i: 0 for i in range(10)}

    for i in N:
        dic_card[int(i)] += 1

    max_value = 0
    for key, value in dic_card.items():
        if key not in [6, 9]:
            max_value = max(max_value, value)

    avg_six_nine = (dic_card[6] + dic_card[9] + 1) // 2

    if max_value >= avg_six_nine:
        print(max_value)
    else:
        print(avg_six_nine)
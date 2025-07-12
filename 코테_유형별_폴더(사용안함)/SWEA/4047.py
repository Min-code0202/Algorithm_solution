T = int(input())
t = ["S", "D", "H", "C"]
for test in range(1, T + 1):
    S = input()
    cnt = [[0] * 13 for _ in range(4)]
    for i in range(0, len(S), 3):
        a = S[i]
        num = int(S[i + 1: i + 3]) - 1
        idx = t.index(a)
        cnt[idx][num] += 1

    ans = ""
    found = False
    for i in range(4):
        card = cnt[i]
        for j in range(13):
            if card[j] > 1:
                ans = "ERROR"
                found = True
                break
        if found:
            break
        ans += str(13 - sum(card)) + " "

    print(f"#{test} {ans}")
if __name__ == "__main__":
    clothes = dict()
    result = ""
    T = int(input())
    for _ in range(T):
        n = int(input())
        for i in range(n):
            costume, category = input().split()
            if category in clothes:
                clothes[category].append(costume)
            else:
                clothes[category] = [costume]

        cnt = 1
        for key, value in clothes.items():
            cnt *= len(value) + 1

        cnt -= 1
        result += str(cnt) + "\n"
        clothes.clear()

    print(result)
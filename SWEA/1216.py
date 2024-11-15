def is_pal(arr, len):
    for lst in arr:
        for i in range(0, 100 - len + 1):
            if lst[i : i + len] == lst[i : i + len][::-1]:
                return True


for _ in range(10):
    t = int(input())
    arr1 = [input() for _ in range(100)]
    arr2 = [
        "".join(x) for x in zip(*arr1)
    ]  # list(zip(*arr1)) 가능, str형태로 바꾸기 위해 이렇게 사용함

    for len in range(100, 1, -1):
        if is_pal(arr1, len) or is_pal(arr2, len):
            break

    print(f"#{t} {len}")

pitch = list(map(int, input().split()))
check = None

for i in range(7):
    if pitch[i] + 1 == pitch[i + 1]:
        check = "ascending"
    elif pitch[i] - 1 == pitch[i + 1]:
        check = "descending"
    else:
        check = "mixed"
        break

print(check)
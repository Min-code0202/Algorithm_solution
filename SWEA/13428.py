T = int(input())

def swap(i, j, string):
    s_list = list(string)
    s_list[i], s_list[j] = s_list[j], s_list[i]
    return ''.join(s_list)

for test_case in range(1, T + 1):
    num = input().strip()
    result_min = int(num)
    result_max = int(num)

    for i in range(len(num)):
        for j in range(i + 1, len(num)):
            swapped = swap(i, j, num)
            if swapped[0] == '0':
                continue
            val = int(swapped)
            result_min = min(result_min, val)
            result_max = max(result_max, val)

    print(f'#{test_case} {result_min} {result_max}')

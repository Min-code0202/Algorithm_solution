T = int(input())

for test in range(T):
    day = int(input())
    prices = list(map(int, input().split()))
    profit = 0
    max_price = 0
    
    for i in range(day - 1, -1, -1):
        if max_price < prices[i]:
            max_price = prices[i]
        else:
            profit += max_price - prices[i]
            
    print(f'#{test + 1} {profit}')
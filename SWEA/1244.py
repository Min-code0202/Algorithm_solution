T = int(input())
for _ in range(1, T + 1):
  num, chance = map(str, input().split())
  chance = int(chance)
  lst = []
  check = [0] * len(num)
  for n in num:
    lst.append(int(n))

  for i in range(chance):
    


  print(f'#{_} {lst}')
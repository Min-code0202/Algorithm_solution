#브루트포스 개념이 부족해서 바로 방법을 떠올리지 못함
#구간별로 나눠서 하려고 했는데 규칙을 못찾음
n = int(input())
count = 0
six_n = 666

while True:
    if '666' in str(six_n):#six_n을 string로 변환해서 찾음
        count += 1
    if count == n:
        print(six_n)
        break
    six_n += 1
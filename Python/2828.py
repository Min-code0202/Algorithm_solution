def find_baguni(dic):
    left = None
    right = None
    for index, value in dic.items():
        if value == 1:
            if left is None:
                left = index
            right = index
    return left, right

if __name__ == "__main__":
    N, M = map(int, input().split())
    J = int(input())

    dic = {i: 0 for i in range(N)}
    for i in range(M):
        dic[i] = 1

    distance = 0
    for i in range(J):
        apple = int(input()) - 1
        left, right = find_baguni(dic)  # 사과가 떨어질 때마다 가장 왼쪽과 오른쪽의 1을 찾음

        if left is None or right is None:
            continue # 바구니가 초기화되지 않은 경우

        if left <= apple <= right:
            continue  # 사과가 이미 바구니 안에 떨어진 경우
        elif apple > right:
            distance += apple - right
            # 바구니를 오른쪽으로 이동
            for j in range(right, apple):
                dic[j] = 1
            for j in range(left, left + (apple - right)):
                dic[j] = 0
        elif apple < left:
            distance += left - apple
            # 바구니를 왼쪽으로 이동
            for j in range(apple, right - (left - apple)):
                dic[j] = 1
            for j in range(right - (left - apple), right):
                dic[j] = 0

    print(distance)
duck = list(input())
sound = "quack"
count = 0  # "quack" 그룹 개수

if len(duck) % 5 != 0:  # "quack"의 길이(5)의 배수가 아니면 무조건 -1
    print(-1)
    exit()

while duck.count("q") > 0:  # "q"가 더 이상 없을 때까지 반복
    idx = 0  # sound("quack")을 따라가는 인덱스
    found = False  # "quack" 하나가 완성되었는지 체크
    valid = [False] * len(duck)  # 처리된 문자를 기록 (순서 강제)

    for i in range(len(duck)):
        if duck[i] == sound[idx]:  # 올바른 순서의 문자 찾기
            valid[i] = True  # 해당 문자 사용 처리
            idx += 1
            if idx == 5:  # "quack" 하나 완성
                found = True
                idx = 0  # 새로운 "quack" 탐색 시작

    if not found:  # "quack"을 완성하지 못한 경우
        print(-1)
        exit()

    # 사용한 문자 "-" 처리
    for i in range(len(duck)):
        if valid[i]:
            duck[i] = "-"

    count += 1  # "quack" 그룹 하나 완성

# 모든 문자가 "-"로 변환되어야 정상적인 "quack"
if any(c != "-" for c in duck):
    print(-1)
else:
    print(count)
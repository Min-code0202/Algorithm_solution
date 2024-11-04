for _ in range(4):
    sj1, si1, ej1, ei1, sj2, si2, ej2, ei2 = map(int, input().split())
    ans = ""

    # 공통 부분 없음
    if si1 > ei2 or ei1 < si2 or sj1 > ej2 or ej1 < sj2:
        ans = "d"
    # 세로가 일치
    elif ej1 == sj2 or sj1 == ej2:
        # 가로가 일치
        if ei1 == si2 or si1 == ei2:  # 공통부분 : 점
            ans = "c"
        else:  # 공통 부분 : 세로 선분
            ans = "b"
    # 공통 부분 : 가로 선분
    elif ei1 == si2 or si1 == ei2:
        ans = "b"
    # 공통 부분 : 직사각형
    else:
        ans = "a"

    print(ans)

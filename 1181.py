N = int(input())
words = []

for _ in range(N):
    words.append(input())#input는 시간이 오래걸리므로 sys.stdin.readlines()[1:]사용 권장
#중복제거
words = set(words)#list(set(words))
words = list(words)
words.sort()#알파벳 순 정렬
words.sort(key = len)#글자수 오름차순 정렬
#리스트 괄호없이 출력
print('\n'.join(words))
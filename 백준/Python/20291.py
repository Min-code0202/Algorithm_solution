N = int(input())
file = {}
for _ in range(N):
    _, extension = input().split('.')
    if extension in file:
        file[extension] += 1
    else:
        file[extension] = 1

for key in sorted(file):
    print(key, file[key])
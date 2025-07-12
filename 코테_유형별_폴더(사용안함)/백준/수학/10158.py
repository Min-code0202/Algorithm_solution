w, h = map(int, input().split())
p, q = map(int, input().split())
t = int(input())


col = (p + t) // w
row = (q + t) // h

if col % 2 == 0:
    x = (p + t) % w
else:
    x = w - (p + t) % w

if row % 2 == 0:
    y = (q + t) % h
else:
    y = h - (q + t) % h

print(x, y)
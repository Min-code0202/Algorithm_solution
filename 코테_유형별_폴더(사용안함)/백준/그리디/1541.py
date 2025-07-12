read = input()
line = read.split('-')

result = 0

if len(line) == 1:
    op = line[0].split('+')
    for i in op:
        result += int(i)
else:
    first = line[0]
    if first == '':
        first = 0
    else:
        op = first.split('+')
        sub_sum = 0
        for i in op:
            sub_sum += int(i)
        
        result += sub_sum   

    for i in range(1, len(line)):
        op = line[i].split('+')
        sub_sum = 0
        for j in op:
            sub_sum += int(j)
        
        result -= sub_sum

print(result)
S = input()

result = []
sub_str = ''
status = 0
i = 0
while i < len(S):
    if S[i] == '<':
        status = 1
        while status == 1:
            sub_str += S[i]

            if S[i] == '>':
                status = 0
                if i < len(S):
                    i += 1
                result.append(sub_str)
                sub_str = ''
                break 
            
            i += 1
    else:
        while True:
            sub_str += S[i]
            i += 1
            if i < len(S):
                if S[i] == ' ':
                    result.append(sub_str[::-1])
                    sub_str = ''
                    result.append(' ')
                    i += 1
                    break
                if S[i] == '<':
                    result.append(sub_str[::-1])
                    sub_str = ''
                    break
            else:
                result.append(sub_str[::-1])
                break


print(''.join(result))
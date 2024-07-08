if __name__ == "__main__":
    S = input()
    result = []

    for i in range(len(S)):
        alphabet = S[i]
        if "A" <= alphabet <= "Z":  # 대문자 처리
            result.append(chr((ord(alphabet) - ord('A') + 13) % 26 + ord('A')))
        elif "a" <= alphabet <= "z":  # 소문자 처리
            result.append(chr((ord(alphabet) - ord('a') + 13) % 26 + ord('a')))
        else:
            result.append(alphabet)  # 알파벳이 아닌 경우 그대로 추가

    print("".join(result))
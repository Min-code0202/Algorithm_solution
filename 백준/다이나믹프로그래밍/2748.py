if __name__ == "__main__":
    n = int(input())

    if n == 0:
        print(0)
    elif n == 1:
        print(1)
    else:
        fibonacci = [0, 1]
        for i in range(2, n + 1):
            fibonacci.append(fibonacci[i - 2] + fibonacci[i - 1])

        print(fibonacci[n])

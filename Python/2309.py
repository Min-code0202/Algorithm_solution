import random

if __name__ == '__main__':
    hobbit = []
    for _ in range(0, 9):
        hobbit.append(int(input()))
    
    hobbit.sort()
    total = sum(hobbit)

    for i in range(9):
        for j in range(i + 1, 9):
            if total - (hobbit[i] + hobbit[j]) == 100:
                one, two = hobbit[i], hobbit[j]

    hobbit.remove(one)
    hobbit.remove(two)

    for i in hobbit:
        print(i)
if __name__ == "__main__":
    N = int(input())
    channel = []
    for _ in range(N):
        channel.append(input())

    kbs1 = 0
    kbs2 = 0
    for i in range(len(channel)):
        if channel[i] == "KBS1":
            kbs1 = i
        elif channel[i] == "KBS2":
            kbs2 = i

    if kbs1 < kbs2:
        print("1" * kbs1 + "4" * kbs1 + "1" * kbs2 + "4" * (kbs2 - 1))
    else:
        kbs2 += 1
        print("1" * kbs1 + "4" * kbs1 + "1" * kbs2 + "4" * (kbs2 - 1))

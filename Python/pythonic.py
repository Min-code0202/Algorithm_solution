# iterable한 데이터 받기
a, b = map(int, input().split())

# *(asterisk) : 가변 인자
_list = [1, 2, 3, 4, 5]
first_index, *rest, last_index = _list
print(rest) # 2 3 4

# * : unpacking
for num in _list:
    print(num, end=' ') # 1 2 3 4 5

print(*_list) # 1 2 3 4 5

# packing
a, b, c = [1, 2, 3]
d = a, b, c
print(d) # (1, 2, 3)

# List Comprehension
# 1 ~ 10을 담는 리스트를 만들어봅시다.
_list = [i for i in range(10)]

# 2, 4, 6, ..., 20을 담는 리스트를 만들어봅시다.
_list = [2 * i for i in range(10)]

# 주어진 리스트를 받아 3의 배수만 담는 리스트를 만들어봅시다.
from random import random
tmp = [random.randrange(1, 200) for i in range(100)]
_list = [i for i in tmp if i % 3 == 0]

# 값이 두개 들어있는 튜플을 받아 리스트를 생성하되, 튜플 내부의 값을 뒤집어서 저장하세요.
list_of_tuple = [(i, j) for i in range(100) for j in range(100, 0, -1)]
_list = [(j, i) for i, j in list_of_tuple]

# 주어진 리스트를 그대로 담되, 15가 넘어가는 값은 15로 바꿔서 저장합시다.
_list = [i if i <= 15 else 15 for i in tmp]

# 두 개의 리스트를 합치되, 가능한 모든 조합을 저장하는 리스트를 만들어봅시다.
x = [i for i in range(5)]
y = [i for i in range(5)]
_list = [(i, j) for i in x for j in y]

# Dictionary
i_want_to_erase_duplicate_element = [21, 31, 65, 21, 58, 94, 13, 31, 58]
completed_list = list(set(i_want_to_erase_duplicate_element)) # 21, 31, 65, 58, 94, 13

test_list = ['Test', 'test', 'TEST', 'tteesstt']
converted_list = list(set(map(lambda string: string.lower(), test_list))) # test, tteesstt

fruit = ['apple', 'grape', 'orange', 'banana']
price = [3200, 15200, 9800, 5000]
_dict = {}

for i in range(len(price)):
    _dict.append((fruit[i], price[i])) # {'apple' : 3200, 'grape' : 15200, 'orange' : 9000, 'banana' : 5000}

# zip
fruit = ['apple', 'grape', 'orange', 'banana']
price = [3200, 15200, 9800, 5000]
_dict = dict(zip(fruit, price))
# .setdefault()를 사용하면 딕셔너리에서 없는 키를 찾을 경우 0을 반환
print(_dict.setdefault('strawberry', 0)) # 0

# Sorting
_list = [5, 6, 4, 8, 2, 3]
sorted_list = sorted(_list) # 2, 3, 4, 5, 6, 8
_list.sort()
print(_list) # 2, 3, 4, 5, 6, 8

_set = {65, 12, 15, 156, 31, 54, 94, 82, 31}
_set.sort() # Error!!!!
print(sorted(_set)) # 12, 15, 31, 54, 65, 82, 94, 156
# Desc
_list = [5, 6, 4, 8, 2, 3]
sorted_list = sorted(_list, reversed = True) # 8, 6, 5, 4, 3, 2

# String
string = '   I am Hungry...   '
string.strip() # 'I am Hungry'
# 문자열 뒤집기
print(string[::-1])
print("".join(reversed(string)))

# sum
_list = [1, 2, 3, 4, 5]
print(sum(_list)) # 15

# join
_list = [1, 2, 3, 4, 5, 6, 7, 8]
print(', '.join(_list))
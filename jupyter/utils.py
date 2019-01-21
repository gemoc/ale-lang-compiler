import pandas as pd
import itertools

import random

if __name__ == '__main__':
    n = 50

    columns = [str(x) for x in range(0, n)]
    print(len(columns))
    product = itertools.product([0, 1], repeat=n)
    # s = max([(x, random.randint(0, n)) for x in product], key=lambda x: x[1])
    # max = max(map(lambda x: (x, random.randint(0, n)), product), key=lambda x: x[1])
    product2 = ((x, random.randint(0, n)) for x in product)
    max = max(product2, key=lambda x: x[1])

    print(max)

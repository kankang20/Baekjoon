
"""
title  : 4358. 생태학 (Silver 2)
time   : 344ms       408ms
memory : 31120KB     112016KB
"""

import sys

def solution():

    input = sys.stdin.readline

    trees = {}
    total_tree = 0

    while True:

        tree = input().rstrip()

        if not tree:
            break

        trees[tree] = trees.get(tree, 0) + 1
        total_tree += 1
    
    for key in sorted(trees.keys()):
        print("{0} {1:.4f}".format(key, (trees.get(key) / total_tree) * 100))

solution()
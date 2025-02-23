addi x1, x0, 0       # start of array 1
addi x2, x0, 32      # start of array 2
addi x3, x0, 64      # start of result array
addi x4, x0, 8       # 8 elements
addi x5, x0, 0       # loop index

loop:
    lw t1, 0(x1)     # load array 1
    lw t2, 0(x2)     # load array 2
    add t3, t1, t2   # add t1 and t2
    sw t3, 0(x3)     # store result
    addi x1, x1, 4   # increment array 1
    addi x2, x2, 4   # increment array 2
    addi x3, x3, 4   # increment result array
    addi x5, x5, 1   # increment loop index
    blt x5, x4, loop # loop until 8 elements
    
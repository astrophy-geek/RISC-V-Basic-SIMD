ADDI x1, x0, 0       # x1 = base address of a (0)
ADDI x2, x0, 32      # x2 = base address of b (32)
ADDI x3, x0, 64      # x3 = base address of c (64)

VLOAD v1, 0(x1)      # Load array a into vector register v1
VLOAD v2, 0(x2)      # Load array b into vector register v2
VADD  v3, v1, v2     # Add vectors v1 and v2, store result in v3
VSTORE v3, 0(x3)     # Store result vector v3 into array c
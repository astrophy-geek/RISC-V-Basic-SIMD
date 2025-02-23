addi x1, x0, 1
addi x2, x0, 2
nop
nop
nop
beq x1, x2, 28 // cycle 16 (20) fetch :: cycle 17 (24) decode :: cycle 18 (28) :: cycle 19 (68) => real - 8
nop
nop
nop
addi x1, x1, 1
nop
nop
nop
j -40 # pc 52
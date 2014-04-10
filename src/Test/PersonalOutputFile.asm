// LetNode
push lab10 // noteq
lfp
push 2
push 2
lfp
lfp
push 1
sub
lw
js
halt
lab0: // noteq
cfp
lra
lfp
push -1
sub
lw
lfp
push -2
sub
lw
beq lab3
push 1
b lab4
lab3:
push 0
lab4:
push 1
beq lab1
push 20
print
b lab2
lab1:
push 10
print
lab2:
srv
sra
pop
pop
pop
sfp
lrv
lra
js
// END noteq
lab5: // noteq
cfp
lra
lfp
push -1
sub
lw
lfp
push -2
sub
lw
beq lab8
push 0
b lab9
lab8:
push 1
lab9:
push 1
beq lab6
push 20
print
b lab7
lab6:
push 10
print
lab7:
srv
sra
pop
pop
pop
sfp
lrv
lra
js
// END noteq
lab10: // noteq
cfp
lra
lfp
push -1
sub
lw
lfp
push -2
sub
lw
beq lab13
push 1
b lab14
lab13:
push 0
lab14:
push 1
beq lab11
push 20
print
b lab12
lab11:
push 10
print
lab12:
srv
sra
pop
pop
pop
sfp
lrv
lra
js
// END noteq
// END LetNode

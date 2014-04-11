// LetNode
push lab0 // noteq
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
// END LetNode

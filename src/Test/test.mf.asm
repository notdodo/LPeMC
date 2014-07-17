// LetNode
push 3
push lab0 // a
lfp
push 5
push 4
lfp
lfp
push 2
sub
lw
js
print
halt
lab0: // a
cfp
lra
// LetNode
push 4
lfp
push 2
sub
lw
push 0
beq lab3
push 1
b lab4
lab3:
push 0
lab4:
push 1
beq lab1
push 0
b lab2
lab1:
lfp
push -1
sub
lw
lfp
push -2
sub
lw
add
lfp
lw
push 1
sub
lw
add
lfp
push 2
sub
lw
div

lab2:
// END LetNode
srv
pop
sra
pop
pop
pop
sfp
lrv
lra
js
// END a
// END LetNode

// LetNode
push lab0 // caller
push lab1 // length
lfp
push 1
push 2
push -1
push 1
lhp
add
sw
lhp
sw
lhp
push 2
lhp
add
shp
push 1
lhp
add
sw
lhp
sw
lhp
push 2
lhp
add
shp
lfp
push 2
sub
lw
lfp
lfp
lfp
push 1
sub
lw
js
print
halt
lab0: // caller
cfp
lra
lfp
lfp
push -3
sub
lw
lfp
push -1
sub
lw
lfp
push -2
sub
lw
js
srv
sra
pop
pop
pop
pop
sfp
lrv
lra
js
// END caller
lab2: // X
cfp
lra
// LetNode
lfp
lw
push -1
sub
lw
lw
lfp
push 2
sub
lw
// END LetNode
srv
pop
sra
pop
sfp
lrv
lra
js
// END X
lab1: // length
cfp
lra
// LetNode
push lab2 // X
lfp
push -1
sub
lw
push -1
beq lab5
push 0
b lab6
lab5:
push 1
lab6:
push 1
beq lab3
push 1
lfp
push 1
lfp
push -1
sub
lw
add
lw
lfp
lw
lfp
lw
push 2
sub
lw
js
add
b lab4
lab3:
push 0
lab4:
// END LetNode
srv
pop
sra
pop
pop
sfp
lrv
lra
js
// END length
// END LetNode

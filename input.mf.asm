// LetNode
push 3
push 15
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
push lab0 // pList
lfp
lfp
push 1
sub
lw
lfp
lfp
push 2
sub
lw
js
halt
lab0: // pList
cfp
lra
lfp
push -1
sub
lw
push -1
beq lab3
push 0
b lab4
lab3:
push 1
lab4:
push 1
beq lab1
lfp
push -1
sub
lw
lw
print
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
b lab2
lab1:
push 0
lab2:
srv
sra
pop
pop
sfp
lrv
lra
js
// END pList
// END LetNode

// LetNode
push lab0 // caller
lfp
push 1
push 0
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
lfp
push 1
sub
lw
js
print
halt
lab1: // length
cfp
lra
lfp
push -1
sub
lw
push -1
beq lab4
push 0
b lab5
lab4:
push 1
lab5:
push 1
beq lab2
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
b lab3
lab2:
push 0
lab3:
srv
sra
pop
pop
sfp
lrv
lra
js
// END length
lab0: // caller
cfp
lra
// LetNode
push lab1 // length
lfp
lfp
push -1
sub
lw
lfp
lfp
push 2
sub
lw
js
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
// END caller
// END LetNode

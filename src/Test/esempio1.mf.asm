// LetNode
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
push lab0 // printl
push lab5 // lenght
lfp
lfp
push 1
sub
lw
lfp
lfp
push 3
sub
lw
js
halt
lab0: // printl
cfp
lra
lfp
push -1
sub
lw
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
print
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
// END printl
lab5: // lenght
cfp
lra
lfp
push -1
sub
lw
lw
push -1
beq lab8
push 0
b lab9
lab8:
push 1
lab9:
push 1
beq lab6
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
push 3
sub
lw
js
add
print
b lab7
lab6:
push 0
lab7:
srv
sra
pop
pop
sfp
lrv
lra
js
// END lenght
// END LetNode

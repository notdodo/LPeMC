// LetNode
push lab0 // applica
push lab1 // fac
push lab6 // lenght
push lab11 // log
lfp
lfp
push 2
sub
lw
lfp
lfp
lfp
push 3
sub
lw
lfp
push 1
push 4
push 1
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
lfp
lfp
push 1
sub
lw
js
print
halt
lab0: // applica
cfp
lra
lfp
lfp
push -1
sub
lw
lfp
push -2
sub
lw
lfp
push -3
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
// END applica
lab1: // fac
cfp
lra
lfp
push -1
sub
lw
push 0
beq lab4
push 0
b lab5
lab4:
push 1
lab5:
push 1
beq lab2
lfp
push -1
sub
lw
lfp
lfp
push -1
sub
lw
push 1
sub
lfp
lw
lfp
lw
push 2
sub
lw
js
mult
b lab3
lab2:
push 1
lab3:
srv
sra
pop
pop
sfp
lrv
lra
js
// END fac
lab6: // lenght
cfp
lra
lfp
push -1
sub
lw
push -1
beq lab9
push 0
b lab10
lab9:
push 1
lab10:
push 1
beq lab7
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
b lab8
lab7:
push 0
lab8:
srv
sra
pop
pop
sfp
lrv
lra
js
// END lenght
lab11: // log
cfp
lra
push 0
lfp
push -1
sub
lw
bless lab14
push 0
b lab15
lab14:
push 1
lab15:
push 1
beq lab12
push 0
b lab13
lab12:
push 1
lab13:
srv
sra
pop
pop
sfp
lrv
lra
js
// END log
// END LetNode

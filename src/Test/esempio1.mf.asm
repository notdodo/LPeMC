// LetNode
push lab0 // prova
push lab1 // a
push lab2 // somma
lfp
lfp
push 1
sub
lw
lfp
push 6
push 1
lfp
lfp
push 2
sub
lw
js
print
halt
lab0: // prova
cfp
lra
lfp
push -1
sub
lw
srv
sra
pop
pop
pop
sfp
lrv
lra
js
// END prova
lab1: // a
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
add
srv
sra
pop
pop
pop
pop
pop
sfp
lrv
lra
js
// END a
lab2: // somma
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
// END somma
// END LetNode

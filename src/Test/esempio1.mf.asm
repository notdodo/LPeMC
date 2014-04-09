// LetNode
push lab0 // somma
push lab1 // a
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
lab0: // somma
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
sfp
lrv
lra
js
// END somma
lab1: // a
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
lfp
push -4
sub
lw
js
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
// END LetNode

// LetNode
push lab0 // sqr
push lab1 // sum
push lab2 // passofunz
lfp
push 1
push 5
lfp
push 2
sub
lw
lfp
lfp
push 1
sub
lw
lfp
lfp
lfp
push 3
sub
lw
js
print
halt
lab0: // sqr
cfp
lra
lfp
lfp
push -4
sub
lw
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
lfp
lfp
push -4
sub
lw
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
mult
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
// END sqr
lab1: // sum
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
// END sum
lab2: // passofunz
cfp
lra
lfp
lfp
push -6
sub
lw
lfp
push -5
sub
lw
lfp
push -4
sub
lw
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
pop
pop
pop
sfp
lrv
lra
js
// END passofunz
// END LetNode

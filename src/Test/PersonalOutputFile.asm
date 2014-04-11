// LetNode
push 12
push 4
push lab0 // useFun
push lab1 // passofunz
lfp
lfp
push 3
sub
lw
lfp
lfp
lfp
push 4
sub
lw
js
print
halt
lab0: // useFun
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
// END useFun
lab2: // inside
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
// END inside
lab1: // passofunz
cfp
lra
// LetNode
push 2
push 3
push lab2 // inside
lfp
push 3
push 5
lfp
push 4
sub
lw
lfp
lfp
push -1
sub
lw
lfp
push -2
sub
lw
js
// END LetNode
srv
pop
pop
pop
sra
pop
pop
pop
sfp
lrv
lra
js
// END passofunz
// END LetNode

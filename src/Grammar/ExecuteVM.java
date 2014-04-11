package Grammar;

import Generics.InstructionMapper;
import virtualMachine.viewers.VMViewer;

public class ExecuteVM {

    public static final int CODESIZE = 10000;
    public static final int MEMSIZE = 10000;

    private final int[] code;
    private final int[] memory = new int[MEMSIZE];

    private int ip = 0;
    private int ra;
    private int rv;
    private int sp = MEMSIZE;
    private int fp = MEMSIZE;
    private int hp = 0;
    private final boolean debug = false;

    public ExecuteVM(int[] code) {
        this.code = code;
    }

    public void cpu() {
        VMViewer vmv = null;
        if (debug) {
            vmv = new VMViewer(new InstructionMapper());
        }

        while (ip < code.length) {
            if (debug) {
                vmv.updateGraphic(code, memory, ip, sp, ra, rv, hp, fp);
            }

            int bytecode = code[ip++]; // fetch
            int v1, v2;
            switch (bytecode) {
                case VMParser.PUSH:
                    push(code[ip++]);
                    break;
                case VMParser.POP:
                    pop();
                    break;
                case VMParser.ADD:
                    v2 = pop();
                    v1 = pop();
                    push(v1 + v2);
                    break;
                case VMParser.MULT:
                    v2 = pop();
                    v1 = pop();
                    push(v1 * v2);
                    break;
                case VMParser.DIV:
                    v2 = pop();
                    v1 = pop();
                    push(v1 / v2);
                    break;
                case VMParser.SUB:
                    v2 = pop();
                    v1 = pop();
                    push(v1 - v2);
                    break;
                case VMParser.STOREW:
                    int address = pop();
                    memory[address] = pop();
                    break;
                case VMParser.LOADW:
                    push(memory[pop()]);
                    break;
                case VMParser.BRANCH:
                    address = code[ip++];
                    ip = address;
                    break;
                case VMParser.BRANCHEQ:
                    address = code[ip++];
                    if (pop() == pop()) {
                        ip = address;
                    }
                    break;
                case VMParser.BRANCHLESS:
                    address = code[ip++];
                    v2 = pop();
                    v1 = pop();
                    if (v1 <= v2) {
                        ip = address;
                    }
                    break;
                case VMParser.JS:
                    address = pop();
                    ra = ip;
                    ip = address;
                    break;
                case VMParser.STORERA:
                    ra = pop();
                    break;
                case VMParser.LOADRA:
                    push(ra);
                    break;
                case VMParser.STORERV:
                    rv = pop();
                    break;
                case VMParser.LOADRV:
                    push(rv);
                    break;
                case VMParser.LOADFP:
                    push(fp);
                    break;
                case VMParser.STOREFP:
                    fp = pop();
                    break;
                case VMParser.COPYFP:
                    fp = sp;
                    break;
                case VMParser.STOREHP:
                    hp = pop();
                    break;
                case VMParser.LOADHP:
                    push(hp);
                    break;
                case VMParser.PRINT:
                    System.out.println(memory[sp]);
                    //Test.TestGUI.appendTypeCheckTextArea(String.valueOf(memory[sp]));
                    break;
                case VMParser.HALT:
                    return;
            }
        }
    }

    private int pop() {
        return memory[sp++];
    }

    private void push(int b) {
        memory[--sp] = b;
    }

}

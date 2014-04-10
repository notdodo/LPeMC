package Test;

import Generics.Node;
import Grammar.ExecuteVM;
import Grammar.VMParser;
import Grammar.MiniFunParser;
import Grammar.VMLexer;
import Grammar.MiniFunLexer;
import java.io.*;
import org.antlr.runtime.*;

public class Test {

    public static void main(String[] args) throws Exception {
        ANTLRFileStream input = new ANTLRFileStream(args[0]);
        MiniFunLexer lexer = new MiniFunLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniFunParser parser = new MiniFunParser(tokens);
        Node ast = parser.prog();
        String alberoSintattico = ast.toPrint();
        //System.out.println(alberoSintattico);
        //System.out.println(stringConverter(alberoSintattico));
        System.out.println(ast.typeCheck());
        String asm = ast.codeGen();

        FileWriter fstream = new FileWriter(args[0] + ".asm");
        try (BufferedWriter out = new BufferedWriter(fstream)) {
            out.write(asm);
        }

        VMLexer lex = new VMLexer(new ANTLRFileStream(args[0] + ".asm"));
        //VMLexer lex = new VMLexer(new ANTLRFileStream(args[0]+".asm"));
        CommonTokenStream tokensVM = new CommonTokenStream(lex);
        VMParser parserVM = new VMParser(tokensVM);

        ExecuteVM vm = new ExecuteVM(parserVM.createCode());
        vm.cpu();
    }

    private static String stringConverter(String in) {
        String out = "";
        int level = 0;
        String[] sep1 = in.split("\\[");
        for (int i = 0; i < sep1.length; i++) {
            String[] sep2;
            boolean found = false;
            if (sep1[i].indexOf("]") != -1) {
                sep2 = sep1[i].split("\\]");
                found = true;
            } else {
                sep2 = new String[1];
                sep2[0] = sep1[i];
            }
            for (int j = 0; j < sep2.length; j++) {
                if (sep2[j].indexOf(",") == 0) {
                    sep2[j] = sep2[j].substring(2);
                }

                if (sep2[j].compareTo("") != 0) {
                    String[] sep3 = sep2[j].split(",");
                    for (int k = 0; k < sep3.length; k++) {
                        if (sep3[k].indexOf(" ") == 0) {
                            sep3[k] = sep3[k].substring(1);
                        }
                        out += "\n" + spaces(level) + sep3[k];
                    }
                }

                if (found && j + 1 != sep2.length) {
                    level--;
                }
            }
            level++;
        }

        return out;
    }

    private static String spaces(int level) {
        String out = "";
        for (int i = 0; i < level; i++) {
            out += (i + 1 == level ? "  |--->" : "  |    ");
        }
        return out;
    }
}

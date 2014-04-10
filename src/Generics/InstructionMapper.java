package Generics;



import Grammar.VMParser;
import virtualMachine.viewers.IInstructionMapper;

public class InstructionMapper implements IInstructionMapper{
        @Override
	public String currInstrucion(int instruction){
		String ret = ""+instruction;
		switch ( instruction ) {
		case VMParser.PUSH:
			ret = "PUSH";
			break;
		case VMParser.POP:
			ret = "POP";
			break;
		case VMParser.ADD :
			ret = "ADD";
			break;
		case VMParser.SUB :
			ret = "SUB";
			break;
		case VMParser.MULT :
			ret = "MULT";
			break;
		case VMParser.DIV :
			ret = "DIV";
			break;
		case VMParser.BRANCH :
			ret = "BRANCH";
			break;
		case VMParser.BRANCHLESS :
			ret = "BRANCHLESS";
			break;

			//New
		case VMParser.STOREW :
			ret = "STOREWORD";
			break;
		case VMParser.LOADW :
			ret = "LOADWORD";
			break;
		case VMParser.BRANCHEQ :
			ret = "BRANCHEQUAL";
			break;
		case VMParser.JS :
			ret = "JUMP";
			break;
		case VMParser.LOADRA :
			ret = "LOADRA";
			break;
		case VMParser.STORERA :
			ret = "STORERA";
			break;
		case VMParser.LOADRV :
			ret = "LOADRV";
			break;
		case VMParser.STORERV :
			ret = "STORERV";
			break;
		case VMParser.LOADHP :
			ret = "LOADHP";
			break;
		case VMParser.STOREHP :
			ret = "STOREHP";
			break;
		case VMParser.LOADFP :
			ret = "LOADFP";
			break;
		case VMParser.STOREFP :
			ret = "STOREFP";
			break;
		case VMParser.COPYFP :
			ret = "COPYFP";
			break;
			//Fine new

		case VMParser.PRINT :
			ret = "PRINT";
			break;
		case VMParser.HALT :
			ret = "HALT";
			break;
		}
		return ret;
	}

        @Override
	public boolean needParam(int instruction){
		switch ( instruction ) {
		case VMParser.PUSH:
			return true;
		case VMParser.BRANCH :
			return true;
		case VMParser.BRANCHLESS :
			return true;
		case VMParser.BRANCHEQ :
			return true;
		}

		return false;
	}
}

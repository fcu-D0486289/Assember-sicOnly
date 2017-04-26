public class Main {

	public static void main(String[] args) {
		Source program = new Source();
		for(int i = 0; i < program.size(); i++){
			if(program.getSourceError()){
				System.out.println("\t*********格式錯誤*********");
				break;
			}
			if(program.getObject(i).equals("FFFFFF"))
				System.out.printf("%04X %-8s %-6s %-18s      \t%-31s\n", program.getLocation(i), program.getLabel(i), program.getOperation(i), program.getOperand(i), program.getComment(i));
			else if(program.getX(i))
				System.out.printf("%04X %-8s %-6s %-18s %-6s\t%-31s\n", program.getLocation(i), program.getLabel(i), program.getOperation(i), program.getOperand(i) + ",X", program.getObject(i), program.getComment(i));
			else
				System.out.printf("%04X %-8s %-6s %-18s %-6s\t%-31s\n", program.getLocation(i), program.getLabel(i), program.getOperation(i), program.getOperand(i), program.getObject(i), program.getComment(i));
			if(program.getOperationError(i))
				System.out.println("\t*********未定義的OP Code*********");
			if(program.getOperandError(i))
				System.out.println("\t*********未定義的標籤名稱*********");
		}
		Card card = new Card(program);
		System.out.println("\n\nH " + card.getH());
		for(int i = 0; i < card.SizeOfT(); i++)
			System.out.println("T " + card.getT(i));
		System.out.println("E " + card.getE());
		Output output = new Output(program, card);
	}
}

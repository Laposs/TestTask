public class Stack {
    public String sumword(String word, int number){
        String result ="";
        for (int i = 0; i < number; i++) {
            result = result + word;
        }
        return result;
    }
    public String alg (String sourceline) {
        String result = "";
        int i = 0;
        int liopen = 0;
        int liclose = 0;
        String word = "";
        liopen = sourceline.lastIndexOf('[');
        liclose = sourceline.indexOf(']', liopen);
        word = sourceline.substring(liopen + 1, liclose);
        //System.out.println(word);
        int number = Integer.parseInt(String.valueOf(sourceline.charAt(liopen - 1)));
        //System.out.println(number);
        sourceline = sourceline.substring(0, liopen - 1) + sumword(word, number) + sourceline.substring(liclose+1);
        if (sourceline.indexOf('[') != -1) {
            sourceline = alg(sourceline);
        }
        return sourceline;
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        System.out.println(s.alg("2[3[x]y]"));
        //System.out.println(s.alg("3[xy]2[qwe]"));
        //System.out.println(s.alg("2[2[3[x]y]4[z]]"));
        System.out.println();
    }
}

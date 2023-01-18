public class Main {
    public String journal = "";
    public int ptDurability = 50;

    public static void main(String[] args) {

    }
    public void write(String input){
        int degradationLength;
        String trimmed_string = input.replace(" ", "");
        degradationLength = trimmed_string.replace("/n", "").length();
        ptDurability -= degradationLength;
        journal += input;
    }

}

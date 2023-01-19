public class Main {
    public String journal = "";
    public int ptDurability = 50;

    public static void main(String[] args) {

    }
    public void write(String input){
        char[] actual_line = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            insertInArray(input, actual_line, i);
            degradePencil(input, i);
        }
        String result = new String(actual_line);
        journal += result;
    }

    private void insertInArray(String input, char[] actual_line, int i) {
        if(ptDurability > 0){
            actual_line[i] = input.charAt(i);
        }
        else {
            actual_line[i] = ' ';
        }
    }

    private void degradePencil(String input, int i) {
        if(input.charAt(i) != '\n' && input.charAt(i) != ' ') {
            if (Character.isUpperCase(input.charAt(i))) {
                ptDurability -= 2;
            }
            else {
                // Applies to non-letters, which can't be upper/lower
                ptDurability--;
            }
        }
    }
}

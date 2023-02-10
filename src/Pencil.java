public class Pencil {
    private String journal = "";
    private int ptDurability = 0;
    private int length = 0;
    private final int startingDurability;
    private int eraserDurability = 0;

    public Pencil(int ptDurability, int length, int eraserDurability) {
        this.ptDurability = ptDurability;
        this.length = length;
        this.startingDurability = this.ptDurability;
        this.eraserDurability = eraserDurability;
    }

    public String getJournal() {
        return journal;
    }

    public int getLength() {
        return length;
    }

    public int getPtDurability() {
        return ptDurability;
    }

    public int getEraserDurability() {
        return eraserDurability;
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

    public void sharpen(){
        if(length > 0){
            ptDurability = startingDurability;
            length--;
        }
    }

    public void erase(String stringToErase){
        if(eraserDurability == 0){
            return;
        }
        int stringIndex = journal.lastIndexOf(stringToErase);
        char[] journalMutArray = journal.toCharArray();
        for(int i = stringToErase.length() + stringIndex - 1; i >= stringIndex ; i--){
            if(eraserDurability == 0){
                break;
            }
            if(journalMutArray[i] != ' '){
                eraserDurability -= 1;
            }
            journalMutArray[i] = ' ';
        }

        String result = new String(journalMutArray);
        journal = result;
    }

    public void edit(String newString, int eraserSection){
        int currEraserSection = 0;
        int startingIndex = -1;
        char[] journalMutArray = journal.toCharArray();
        int i = 1;
        startingIndex = getEditingStartIndex(eraserSection, currEraserSection, startingIndex, i);
        insertEdit(newString, startingIndex, journalMutArray);

        String result = new String(journalMutArray);
        journal = result;
    }

    private static void insertEdit(String newString, int startingIndex, char[] journalMutArray) {
        int newStringIndex = 0;
        if(startingIndex > -1){
            for(int j = startingIndex; j < newString.length() + startingIndex; j++){
                journalMutArray[j] = newString.charAt(newStringIndex);
                newStringIndex++;
            }
        }
    }

    private int getEditingStartIndex(int eraserSection, int currEraserSection, int startingIndex, int i) {
        while (currEraserSection != eraserSection && i < journal.length()){
            if(journal.charAt(i) == ' ' && journal.charAt(i - 1) == ' '){
                currEraserSection++;
                startingIndex = i;
            }
            i++;
        }
        return startingIndex;
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

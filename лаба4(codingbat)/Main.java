package lab;

public class Main {
    //string
    public String doubleChar(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i);
            result += str.charAt(i);
        }
        return result;
    }
    public int countHi(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 2).equals("hi")) {
                count++;
            }
        }
        return count;
    }
    public boolean catDog(String str) {
        int catCount = 0;
        int dogCount = 0;
    
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("cat")) {
                catCount++;
            }
            if (str.substring(i, i + 3).equals("dog")) {
                dogCount++;
            }
        }
    
        return catCount == dogCount;
    }
    public int countCode(String str) {
        int count = 0;
    
        for (int i = 0; i < str.length() - 3; i++) {
            if (str.substring(i, i + 2).equals("co") && str.charAt(i + 3) == 'e') {
                count++;
            }
        }
    
        return count;
    }
    public boolean endOther(String a, String b) {
        a = a.toLowerCase();
        b = b.toLowerCase();
    
        return a.endsWith(b) || b.endsWith(a);
    }
    public boolean xyzThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.substring(i, i + 3).equals("xyz") && (i == 0 || str.charAt(i - 1) != '.')) {
                return true;
            }
        }
        return false;
    }
    public boolean bobThere(String str) {
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
                return true;
            }
        }
        return false;
    }

    //task доп 
    public void printWordsWithDigitsOrPunctuation(String input) {
        for (String word : input.split(" ")) {
            if (word.matches(".*\\d.*") || word.matches(".*\\p{Punct}.*")) {
                System.out.println(word);
            }
        }
    } 
}

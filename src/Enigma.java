public class Enigma {
    static String scopeOfLanguage = "0123456789" +
                    "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                    "abcdefghijklmnopqrstuvwxyz";

    static int rotation;
    static StringBuilder out;
    static String string;

    public static String encode() {
        out = new StringBuilder("");
        rotation = Encryption.getIntRotation();
        System.out.print("Enter text to encrypt: ");
        string = Encryption.scanner.nextLine();
        boolean charFound = false;

        while (true) {
            if (string.length() < 1) {
                break;
            }
            charFound = false;
        for (int i = 0; i < scopeOfLanguage.length(); i++) {
                if (string.charAt(0) == scopeOfLanguage.charAt(i)) {
                    out.append(scopeOfLanguage.charAt(getEncodingRotation(i)));
                    charFound = true;
                }
            }
        if (!charFound){
            out.append(string.charAt(0));
        }

            string = string.substring(1);
        }
        return out.toString();
    }

    public static String decode(){
        out = new StringBuilder("");
        rotation = Encryption.getIntRotation();
        System.out.print("Enter text to decrypt: ");
        string = Encryption.scanner.nextLine();
        boolean charFound = false;

        while (true) {
            if (string.length() < 1) {
                break;
            }
            charFound = false;
            for (int i = 0; i < scopeOfLanguage.length(); i++) {
                if (string.charAt(0) == scopeOfLanguage.charAt(i)) {
                    out.append(scopeOfLanguage.charAt((getDecodingRotation(i))));
                    charFound = true;
                }
            }
            if (!charFound){
                out.append(string.charAt(0));
            }
            string = string.substring(1);
        }
        return out.toString();
    }

    private static int getEncodingRotation(int i) {
        return (rotation + i) % scopeOfLanguage.length();
    }

    private static int getDecodingRotation(int i) {
        int out = (i - rotation) % scopeOfLanguage.length();
        if (out < 0)
            return out *-1 + scopeOfLanguage.length();
        return out;
    }


}

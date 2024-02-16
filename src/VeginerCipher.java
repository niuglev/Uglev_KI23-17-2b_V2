public class VeginerCipher {
    /**
     * Encodes the given message using the provided key.
     * @param message The message to be encoded.
     * @param key The key to be used for encoding.
     * @return The encoded message.
     */
    protected static String cipher(String message, String key) {
        // Implementation of Viginer cipher algorithm
        StringBuilder result = new StringBuilder();
        int[] list_keyAlphabetPositions = new int[key.length() + 1];
        for (int i = 0; i < key.length(); i++) {
            int keyAlphabetPosition = Character.toLowerCase(key.charAt(i)) - 'a';
            list_keyAlphabetPositions[i] = keyAlphabetPosition;
        }
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                int originalAlphabetPosition = Character.toLowerCase(message.charAt(i)) - 'a';
                int finalAlphabetPosition = originalAlphabetPosition + list_keyAlphabetPositions[i % (key.length() + 1)];
                if (finalAlphabetPosition >= 26) {
                    finalAlphabetPosition -= 26;
                }
                char newCharacter = (char) ('a' + finalAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(message.charAt(i));
            }
        }
        return result.toString();
    }
}

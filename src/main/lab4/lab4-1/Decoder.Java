class Decoder {

    private String input;

    public Decoder(String input) {
        this.input = input;
    }

    public String decode() {
        StringBuilder decoded = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                decoded.append(c);
            }
        }
        return decoded.toString().toLowerCase();
    }
}
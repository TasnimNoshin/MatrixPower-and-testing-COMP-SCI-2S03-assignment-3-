package cs2s03;

class WrongLength extends Throwable {
    private int expectedLen;
    private int givenLen;
    private String name;

    public WrongLength(int expectedLen, int givenLen, String name) {
        this.givenLen = givenLen;
        this.expectedLen = expectedLen;
        this.name = name;
    }

    public String FormatError() {
        return "Incorrect array size: " + this.givenLen + " (expected " + this.expectedLen +") at " + this.name ;
    }
}

package cs2s03;

class WrongPower extends Throwable {
    private int len;
    private String name;

    public WrongPower(int len, String name) {
        this.len = len;
        this.name = name;
    }

    public String FormatError() {
        return "Incorrect input for powering: " + this.len + " (expected >=0) at " + this.name ;
    }
}
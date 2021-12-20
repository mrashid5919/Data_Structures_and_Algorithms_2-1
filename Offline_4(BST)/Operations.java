public class Operations {
    private String op;
    private String type;

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Operations(String op, String type) {
        this.op = op;
        this.type = type;
    }
}

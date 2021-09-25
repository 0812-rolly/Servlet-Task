package structure.model;

public class Student {
    private String name;
    private float avrMark;
    private boolean blockChain;

    public Student() {

    }

    public Student (String name, float avrMark, boolean blockChain) {
        this.name = name;
        this.avrMark = avrMark;
        this.blockChain = blockChain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAvrMark() {
        return avrMark;
    }

    public void setAvrMark(float avrMark) {
        this.avrMark = avrMark;
    }

    public boolean isBlockChain() {
        return blockChain;
    }

    public void setBlockChain(boolean blockChain) {
        this.blockChain = blockChain;
    }

    @Override
    public String toString() {
        return name + ',' + avrMark + ',' + blockChain;
    }
}

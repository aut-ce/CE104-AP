package test;

public class SimpleReader implements Reader {

    @Override
    public byte[] read() {
        return new byte[] {1, 2, 3, 4, 5};
    }
}

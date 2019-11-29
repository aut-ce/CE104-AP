package test;

public class BufferedReader implements Reader {

    private Reader reader;

    public BufferedReader(Reader reader) {
        this.reader = reader;
    }

    private void preReading() {
        // do something about buffering ...
    }

    @Override
    public byte[] read() {
        preReading();
        byte[] bytes = reader.read();
        return postReading(bytes);
    }

    public byte[] postReading(byte[] bytes) {
        // do something about buffering ...
        return bytes;
    }
}

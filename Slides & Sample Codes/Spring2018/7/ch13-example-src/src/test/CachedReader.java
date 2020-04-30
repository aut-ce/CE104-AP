package test;

public class CachedReader implements Reader {

    private Reader reader;

    public CachedReader(Reader reader) {
        this.reader = reader;
    }

    private void preReading() {
        // do something about caching ...
    }

    @Override
    public byte[] read() {
        preReading();
        byte[] bytes = reader.read();
        return postReading(bytes);
    }

    public byte[] postReading(byte[] bytes) {
        // do something about caching ...
        return bytes;
    }
}

public interface Handler {
    void setNextHandler(Handler nextHandler);
    void process(File file);
}
public class ImageFileHandler implements Handler {
    private Handler nextHandler;
    private String name;

    public ImageFileHandler(String name) {
        this.name = name;
    }

    @Override
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void process(File file) {
        if (file.getFileType().equalsIgnoreCase("image")) { ///เปรียบเทียบแบบไม่สนตัวพิมพ์เล็ก-พิมพ์ใหญ่ image==Image==IMAGE คือตัวเดียวกัน///
            System.out.println(name + " processed image file: "
                    + file.getFileName() + " at " + file.getFilePath());
        } else {
            System.out.println(name + " cannot process " + file.getFileType()
                    + " file. Forwarding to next handler...");
            if (nextHandler != null) {
                nextHandler.process(file); ///ส่งไปให้ process ต่อไป///
            } else {
                System.out.println("No handler available for file type: " + file.getFileType()); ///บอกว่าไม่รองรับไฟล์///
            }
        }
    }
}
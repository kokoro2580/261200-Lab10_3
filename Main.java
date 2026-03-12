public class Main {
    public static void main(String[] args) {
        // Create handlers
        Handler textHandler = new TextFileHandler("TextFileHandler");
        Handler documentHandler = new DocumentFileHandler("DocumentFileHandler");
        Handler imageHandler = new ImageFileHandler("ImageFileHandler");

        // Set up chain
        textHandler.setNextHandler(documentHandler);
        documentHandler.setNextHandler(imageHandler);

        // Create files
        File textFile = new File("README.txt", "text", "/home/docs");
        File docFile = new File("Document.doc", "document", "/home/docs");
        File imageFile = new File("Picture.jpg", "image", "/home/images");
        File audioFile = new File("Song.mp3", "audio", "/home/audio");

        // Process files
        System.out.println("Processing text file:");
        textHandler.process(textFile);

        System.out.println("\nProcessing document file:");
        textHandler.process(docFile);

        System.out.println("\nProcessing image file:");
        textHandler.process(imageFile);

        System.out.println("\nProcessing audio file:");
        textHandler.process(audioFile);
    }
}
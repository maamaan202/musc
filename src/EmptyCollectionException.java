public class EmptyCollectionException extends Exception {
    public EmptyCollectionException(String collectionName) {
        super("The " + collectionName + " is empty.");
    }
}

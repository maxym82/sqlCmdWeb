public class main {
    public static void main(String[] args) {
        dataBaseOperations newBD = new dataBaseOperations("maksym", "maksym", "password");
//        newBD.createTable();
        newBD.printTables();
        newBD.findTable("tracklist");
        newBD.closeConnection();

    }
}

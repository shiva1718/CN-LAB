package ports;

public enum Ports {
    DATE_TIME(1024),
    CHAT(1025),
    FILE_TRANSFER(1026),
    ECHO(1027);


    private final int port;

    Ports(int port) {
        this.port = port;
    }

    public int getPort() {
        return port;
    }
}

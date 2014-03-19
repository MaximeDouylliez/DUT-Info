class DistributeurTicket {
    int num = 0;

    public synchronized int prendre () {
        num++;
        return num;
    }
}

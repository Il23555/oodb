package hotel;

public class UseOfServices {

    private Client client;
    private Service service;
    private int count;

    public UseOfServices(Client client, Service service, int count){
        this.client = client;
        this.count = count;
        this.service = service;
    }
    
    public int getCost(){
        return count * service.getPrice();
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

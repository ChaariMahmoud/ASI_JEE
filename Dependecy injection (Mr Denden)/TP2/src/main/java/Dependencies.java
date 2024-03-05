import clients.ClientA;
import service.ServiceB;
public class Dependencies {

    public static void main(String[] args) {
    	ServiceB service = new ServiceB();
    	ClientA client = new ClientA(service);
    	client.doSomething();


    	((ClientA) client).setService(new ServiceB());
    	client.doSomething();
    }
}




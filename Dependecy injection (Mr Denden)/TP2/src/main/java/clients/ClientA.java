package clients;

import service.*;

public class ClientA implements Client {
	Service service;
	
	public ClientA(Service service) {
		 this.service = service ;
		    }
	public void setService1(Service service) {
	    this.service = service ;
	}
    public void doSomething() {    
        String info = service.getInfo();
        System.out.println(info);
    }
    public void setService(Service service) {
        this.service = service;
    }
    
}

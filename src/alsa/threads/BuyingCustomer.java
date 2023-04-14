package alsa.threads;

import alsa.services.EshopService;

public class BuyingCustomer extends Customer {
    public BuyingCustomer(String name, EshopService eshopService) {
        super(name, eshopService);
    }

    @Override
    protected boolean goToEshop() {
        if(eshopService.sellProduct(1)) {
            System.out.println("["+name+"]: Bought product id: 1");
            return true;
        } else {
            System.out.println("["+name+"]: Failed to buy product id: 1");
            return false;
        }
    }
}

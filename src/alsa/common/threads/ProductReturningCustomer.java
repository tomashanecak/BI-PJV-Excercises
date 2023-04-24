package alsa.common.threads;

import alsa.server.services.EshopService;

public class ProductReturningCustomer extends Customer {

    public ProductReturningCustomer(String name, EshopService eshopService) {
        super(name, eshopService);
    }

    @Override
    protected boolean goToEshop() {
        if(eshopService.returnProduct(1)) {
            System.out.println("["+name+"]: Return product id: 1");
            return true;
        } else {
            System.out.println("["+name+"]: Failed to return product id: 1");
            return false;
        }
    }
}


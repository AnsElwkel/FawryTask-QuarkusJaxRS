package org.gs.dataaccess;

public class ProductService extends ProductRepository{
    public static volatile ProductService instance;

    private ProductService() {
        super();
    }

    public static ProductService getInstance(){
        if(instance == null){
            synchronized (ProductService.class){
                if(instance == null)
                    instance = new ProductService();
            }
        }
        return instance;
    }

    public boolean searchProduct(int id){
        return getProduct(id) != null;
    }
}

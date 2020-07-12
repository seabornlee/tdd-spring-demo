package tdd.spring.demo;

public class ApplicationPOFactory {
    public static ApplicationPO createApproved(long id) {
        ApplicationPO po = create();
        po.setId(id);
        po.setApproved();
        return po;
    }

    public static ApplicationPO create() {
        ApplicationPO po = new ApplicationPO();
        return po;
    }
}

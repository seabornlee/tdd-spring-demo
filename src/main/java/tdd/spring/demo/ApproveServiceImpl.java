package tdd.spring.demo;

import tdd.spring.demo.exception.BussinessExcetption;

public class ApproveServiceImpl {
    private ApplicationDao applicationDao;

    public void approve(ApplicationDTO applicationDTO) {
        ApplicationPO poInDB = applicationDao.findById(applicationDTO.getId());
        if (poInDB.isApproved()) throw new BussinessExcetption();

        ApplicationPO po = new ApplicationPO();
        po.setId(applicationDTO.getId());
        po.setStatus(1);
        applicationDao.save(po);
    }

}

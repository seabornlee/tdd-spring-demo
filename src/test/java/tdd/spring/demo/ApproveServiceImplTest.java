package tdd.spring.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import tdd.spring.demo.exception.BussinessExcetption;

@RunWith(MockitoJUnitRunner.class)
public class ApproveServiceImplTest {
    @InjectMocks
    private ApproveServiceImpl approveService;

    @Mock
    private ApplicationDao applicationDao;

    @Test
    public void should_change_to_approved_given_submitted_application() {
        // given
        ApplicationDTO applicationDTO = new ApplicationDTO();
        long id = 1L;
        applicationDTO.setId(id);

        ApplicationPO po = ApplicationPOFactory.create();
        po.setId(1L);
        po.setSubmitted();
        Mockito.when(applicationDao.findById(1L)).thenReturn(po);

        // when
        approveService.approve(applicationDTO);

        // then
        assertSaveApplicationWithStatus(1, id);
    }

    @Test(expected = BussinessExcetption.class)
    public void should_throw_exception_given_approved_application() {
        // given
        ApplicationDTO applicationDTO = new ApplicationDTO();
        long id = 1L;
        applicationDTO.setId(id);
        ApplicationPO po = ApplicationPOFactory.createApproved(1L);
        Mockito.when(applicationDao.findById(1L)).thenReturn(po);

        // when
        approveService.approve(applicationDTO);
    }

    private void assertSaveApplicationWithStatus(int status, long id) {
        ApplicationPO expectedApplication = new ApplicationPO();
        expectedApplication.setId(id);
        expectedApplication.setStatus(status);
        Mockito.verify(applicationDao).save(expectedApplication);
    }
}

package de.bcxp.challenge.weather;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class DayTemperatureService {
    private DayTemperature dayTemperatureService;

    @Mock
    private DayTemperatureRepository dayTemperatureRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // this is needed for inititalizytion of mocks, if you use @Mock
        myDataService = new MyDataServiceImpl(myRepository);
        myService = new MyServiceImpl(myDataService);
    }

    @Test
    public void getById_ValidId() {

        doReturn(someMockData).when(myRepository).findOne("1");
        MyObject myObject = myService.getById("1");

        //Whatever asserts need to be done on the object myObject
    }
}

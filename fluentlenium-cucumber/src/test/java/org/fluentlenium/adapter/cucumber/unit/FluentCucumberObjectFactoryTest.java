package org.fluentlenium.adapter.cucumber.unit;

import org.fluentlenium.adapter.cucumber.FluentCucumberTest;
import org.fluentlenium.adapter.cucumber.FluentObjectFactory;
import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.Page;
import org.junit.Before;

import static org.mockito.Mockito.mock;


public class FluentCucumberObjectFactoryTest {

    private FluentObjectFactory objectFactory;
    private FluentCucumberTest fluentCucumberTest;

    @Page
    private TestPage page;

    @Before
    public void before(){
        fluentCucumberTest = mock(FluentCucumberTest.class);
        objectFactory = new FluentObjectFactory();

    }

//    @Test
//    public void createInstanceTest() {
////        when(FLUENT_TEST.instance()).thenReturn(fluentCucumberTest);
////        when(fluentCucumberTest.newInstance(TestPage.class)).thenReturn(new TestPage());
//        TestPage page = objectFactory.getInstance(TestPage.class);
//
//        assertThat(page).isInstanceOf(TestPage.class);
//    }


    private class TestPage extends FluentPage {
    }
}
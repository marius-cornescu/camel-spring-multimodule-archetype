#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.${firstModule}.camel;

import java.util.concurrent.TimeUnit;

import org.apache.camel.CamelContext;
import org.apache.camel.EndpointInject;
import org.apache.camel.builder.NotifyBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringBootRunner;
import org.apache.camel.test.spring.EnableRouteCoverage;
import org.apache.camel.test.spring.MockEndpoints;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertTrue;

@RunWith(CamelSpringBootRunner.class)
@EnableRouteCoverage
@MockEndpoints("log:foo") // mock the log:foo endpoint => mock:log:foo which we then use in the testing
public class ${firstModule}RouteBuilderTest {

    @Autowired
    private CamelContext camelContext;

    @EndpointInject("mock:log:foo")
    private MockEndpoint mock;

    @Test
    public void shouldSayFoo() throws Exception {
        mock.expectedBodiesReceived("Hello foo");

        // we expect that one or more messages is automatic done by the Camel
        // route as it uses a timer to trigger
        NotifyBuilder notify = new NotifyBuilder(camelContext).whenDone(1).create();

        assertTrue(notify.matches(10, TimeUnit.SECONDS));

        mock.assertIsSatisfied();
    }

}
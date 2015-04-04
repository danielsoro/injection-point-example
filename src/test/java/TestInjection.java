import com.github.danielsoro.myobjects.Session;
import com.github.danielsoro.produces.SessionProduce;
import com.github.danielsoro.qualifiers.Parameter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.Assert.*;

/**
 * @author <a href="mailto:danielsoro@gmail.com">Daniel Cunha (soro)</a>
 */
@RunWith(Arquillian.class)
public class TestInjection {

    @Inject
    private Session sessionWithoutParameter;

    @Inject
    @Parameter("Daniel Soro")
    private Session sessionWithParameter;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).addClasses(Session.class, SessionProduce.class, Parameter.class).addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testInjection() {
        assertNotNull(sessionWithoutParameter);
        assertNull(sessionWithoutParameter.getAnnotationValue());

        assertNotNull(sessionWithParameter);
        assertNotNull(sessionWithParameter.getAnnotationValue());

        assertEquals("Daniel Soro", sessionWithParameter.getAnnotationValue());
    }
}

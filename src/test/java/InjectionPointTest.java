import com.github.danielsoro.myobjects.Session;
import com.github.danielsoro.myobjects.SessionConstructorInjectionWithParameter;
import com.github.danielsoro.myobjects.SessionConstructorInjectionWithoutParameter;
import com.github.danielsoro.produces.Parameter;
import com.github.danielsoro.produces.SessionProduce;
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
public class InjectionPointTest {

    @Inject
    private Session sessionWithoutParameter;

    @Inject
    @Parameter("Daniel Soro")
    private Session sessionWithParameter;

    @Inject
    private SessionConstructorInjectionWithParameter sessionConstructorInjectionWithParameter;

    @Inject
    private SessionConstructorInjectionWithoutParameter sessionConstructorInjectionWithoutParameter;

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClasses(Session.class,
                        SessionProduce.class,
                        Parameter.class,
                        SessionConstructorInjectionWithParameter.class,
                        SessionConstructorInjectionWithoutParameter.class)
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void should_inject_session_without_annotationValue() {
        assertNotNull(sessionWithoutParameter);
        assertNull(sessionWithoutParameter.getAnnotationValue());
    }

    @Test
    public void should_inject_session_in_constructor_without_annotationValue() {
        assertNotNull(sessionConstructorInjectionWithoutParameter);
        assertNotNull(sessionConstructorInjectionWithoutParameter.getSession());
        assertNull(sessionConstructorInjectionWithoutParameter.getSession().getAnnotationValue());
    }

    @Test
    public void should_inject_session_with_annotationValue() {
        assertNotNull(sessionWithParameter);
        assertNotNull(sessionWithParameter.getAnnotationValue());
        assertEquals("Daniel Soro", sessionWithParameter.getAnnotationValue());
    }

    @Test
    public void should_inject_session_in_constructor_with_annotationValue() {
        assertNotNull(sessionConstructorInjectionWithParameter);
        assertNotNull(sessionConstructorInjectionWithParameter.getSession());
        assertEquals("Daniel Soro", sessionConstructorInjectionWithParameter.getSession().getAnnotationValue());
    }
}

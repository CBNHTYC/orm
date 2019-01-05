package orm;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@Transactional
public class SomeTest {
    private static final Logger LOG = LoggerFactory.getLogger(SomeTest.class);
}

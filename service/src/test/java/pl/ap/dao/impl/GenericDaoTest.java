package pl.ap.dao.impl;

import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Pawel
 * Date: 11.05.13
 * Time: 18:00
 * To change this template use File | Settings | File Templates.
 */
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional()
@RunWith(SpringJUnit4ClassRunner.class)
public abstract class GenericDaoTest {
}

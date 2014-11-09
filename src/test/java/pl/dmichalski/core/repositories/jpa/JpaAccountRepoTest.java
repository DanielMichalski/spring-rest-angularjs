package pl.dmichalski.core.repositories.jpa;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.dmichalski.core.models.entities.Account;
import pl.dmichalski.core.repositories.AccountRepo;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class JpaAccountRepoTest {

    @Autowired
    private AccountRepo accountRepo;

    private Account account;

    @Before
    @Transactional
    @Rollback(false)
    public void setUp() throws Exception {
        account = new Account();
        account.setName("name");
        account.setPassword("password");
        accountRepo.createAccount(account);

    }

    @Test
    @Transactional
    public void testFind() throws Exception {
        assertNotNull(accountRepo.findAccount(account.getId()));
    }
}
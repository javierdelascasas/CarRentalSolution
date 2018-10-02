package se.javierdlc.crsolution;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import se.javierdlc.crsolution.domain.Currency;
import se.javierdlc.crsolution.repository.CurrencyRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CrsolutionApplicationTests {

    @Autowired
    CurrencyRepository currencyRepository;

    @Test
    public void contextLoads() {
        List<Currency> currencies = currencyRepository.findAll();

        Assert.assertEquals(currencies.size(), 3);
    }

}

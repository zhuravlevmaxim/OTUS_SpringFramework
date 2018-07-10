package lesson4hw;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.otus.lesson4hw.csv.CSVReaderImpl;
import ru.otus.lesson4hw.csv.ICSVReader;
import ru.otus.lesson4hw.service.Test;

/**
 * Created by zhmv on 06.07.2018.
 */
@Configuration
@PropertySource("classpath:test/test.properties")
public class TestConfig {
    @Bean
    ICSVReader csvReader(@Value("${filePathRU}")String filePathRU, @Value("${filePathEN}")String filePathEN){
        return new CSVReaderImpl();
    }

    @Bean
    Test test(ICSVReader csvReader, MessageSource messageSource, @Value("${good.percent}")double goodPercent){
        return new Test(csvReader, messageSource);
    }

    @Bean
    MessageSource messageSource(){
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/bundle");
        ms.setDefaultEncoding("utf-8");
        return ms;
    }
}

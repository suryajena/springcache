package org.surya.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    private final BookRepository bookRepository;

    @Autowired
    private CacheManager cacheManager; 
    public AppRunner(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching books"+cacheManager.getCacheNames());
        logger.info("isbn-1234 xx-->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 xx-->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-4567 -->" + bookRepository.getByIsbn("isbn-4567"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info("isbn-1234 -->" + bookRepository.getByIsbn("isbn-1234"));
        logger.info(".... xx cache names"+cacheManager.getCacheNames());
        ConcurrentMapCache cache =  (ConcurrentMapCache)cacheManager.getCache("books");
        logger.info(".... xx book cache  "+ cache);
    }

}
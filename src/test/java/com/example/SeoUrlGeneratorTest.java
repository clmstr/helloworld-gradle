package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

@RunWith(BlockJUnit4ClassRunner.class)
public class SeoUrlGeneratorTest {

    public static final String KEYWORD_INPUT = "keyword";
    private SeoUrlGenerator generator;

    @Before
    public void setup(){
        generator = new SeoUrlGenerator();
    }

    @Test
    public void testInputKeywordIsReturned(){
        String result = generator.generateUrl("dummy","keyword");
        assertThat(result).isEqualTo(SeoUrlGenerator.DOMAIN + KEYWORD_INPUT);
    }

    @Test(expected = InvalidInputException.class)
    public void testTooLongKeywordIsFailing(){
       generator.generateUrl("dummy","keywordkeywordkeywordkeywordkeywordkeywordkeywordkeywordkeyword");

    }

    @Test
    public void testGetChar(){
        String generated = generator.generateShortUrl("dummy");
        assertThat(generated.length()).isEqualTo(SeoUrlGenerator.DOMAIN.length()+4);
        assertThat(generated.contains(SeoUrlGenerator.DOMAIN)).isTrue();
        assertThat()



    }

}

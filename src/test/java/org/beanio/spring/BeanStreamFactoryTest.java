/*
 * Copyright 2011 Kevin Seim
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.beanio.spring;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.beanio.*;
import org.junit.Test;
import org.springframework.core.io.*;

/**
 * JUnit test cases for the {@link BeanStreamFactory}.
 * @author Kevin Seim
 * @since 1.2
 */
public class BeanStreamFactoryTest {

    @Test(expected=BeanIOConfigurationException.class)
    public void testMappingNotFound() throws Exception {
        Resource res = new ClassPathResource("/test/doesnotexist.xml");
        
        BeanStreamFactory sf = new BeanStreamFactory();
        sf.setStreamMappings(Arrays.asList(new Resource[] { res }));
        sf.createStreamFactory();
    }
    
    @Test(expected=BeanIOConfigurationException.class)
    public void testInvalidMapping() throws Exception {
        Resource res = new ClassPathResource("invalid_mapping.xml", BeanStreamFactoryTest.class);
        
        BeanStreamFactory sf = new BeanStreamFactory();
        sf.setStreamMappings(Arrays.asList(new Resource[] { res }));
        sf.createStreamFactory();
    }
    
    @Test
    public void testMethod_getObjectType() throws Exception {
        BeanStreamFactory sf = new BeanStreamFactory();
        assertEquals(StreamFactory.class, sf.getObjectType());
    }
}

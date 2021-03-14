//package com.xlmkit.plugin.maven;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.maven.plugin.testing.AbstractMojoTestCase;
//
//import java.io.File;
//
///**
// * @Author: 蔡小龙
// * @Date: 2021/3/12 09:13
// * @Description:
// */
//@Slf4j
//public class ActionInterfaceGeneratorMojoTest extends AbstractMojoTestCase {
//    /**
//     * @throws Exception if any
//     */
//    public void testSomething() throws Exception {
////        MavenExecutionResult
//        File pom = getTestFile("/project-to-test.xml");
//        assertNotNull(pom);
//        log.info("{}", pom.getAbsolutePath());
//        assertTrue(pom.exists());
//
//        ActionInterfaceGeneratorMojo myMojo = (ActionInterfaceGeneratorMojo) lookupMojo("generate", pom);
//        myMojo.setPackageName("a");
//        myMojo.setNo("0d92336f-7e93-4f92-becb-d546cfe623a1");
//        myMojo.setDistPath("my-test");
//        assertNotNull(myMojo);
//        myMojo.execute();
////        RepositorySystem
//    }
//}

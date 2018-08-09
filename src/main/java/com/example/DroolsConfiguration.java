package com.example;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.internal.io.ResourceFactory;

import java.io.File;

public class DroolsConfiguration {

    private static final File drlFile = new File("/home/aruna/code-base/droolsdecisiontablesample/src/main/resources/LoanRates.xls");

    public KieContainer getKieContainer() {

        KieServices kieServices = KieServices.Factory.get();

        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newFileResource(drlFile));

        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();

        KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        System.out.println("Drools configurations Loaded");

        return kieContainer;

    }

}
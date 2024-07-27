package com.good.food;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import org.junit.jupiter.api.Test;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;

class DependencyRuleTest {

    private static final String ROOT_PACKAGE = "com.good.food";
    private static final String DOMAIN_PACKAGE = "domain";
    private static final String ADAPTER_PACKAGE = "adapter";
    private static final String DOMAIN_USECASE_PACKAGE = ROOT_PACKAGE + "." + DOMAIN_PACKAGE + ".usecase.*";
    private static final String DOMAIN_REQUEST_PACKAGE = ROOT_PACKAGE + "." + DOMAIN_PACKAGE + ".usecase.*.request";
    private static final String DOMAIN_RESPONSE_PACKAGE = ROOT_PACKAGE + "." + DOMAIN_PACKAGE + ".usecase.*.response";
    private static final String DOMAIN_GATEWAYS_PACKAGE = ROOT_PACKAGE + "." + DOMAIN_PACKAGE + ".gateway";
    private static final String DOMAIN_PRESENTERS_PACKAGE = ROOT_PACKAGE + "." + DOMAIN_PACKAGE + ".presenter";

    @Test
    void checkDependencyRule() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        checkNoDependencyFromTo(DOMAIN_PACKAGE, ADAPTER_PACKAGE, classesToCheck);
    }

    @Test
    void domainUsecaseImplShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(DOMAIN_USECASE_PACKAGE) //
                .and().areNotInterfaces() //
                .should().haveSimpleNameEndingWith("UseCaseImpl") //
                .check(classesToCheck);
    }

    @Test
    void domainUsecaseShouldEndWithUseCase() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(DOMAIN_USECASE_PACKAGE) //
                .and().areInterfaces() //
                .should().haveSimpleNameEndingWith("UseCase") //
                .check(classesToCheck);
    }

    @Test
    void domainRequestsShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(DOMAIN_REQUEST_PACKAGE) //
                .should().haveSimpleNameEndingWith("Request") //
                .check(classesToCheck);
    }

    @Test
    void domainResponsesShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(DOMAIN_RESPONSE_PACKAGE) //
                .should().haveSimpleNameEndingWith("Response") //
                .check(classesToCheck);
    }

    @Test
    void domainGatewaysShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(DOMAIN_GATEWAYS_PACKAGE) //
                .should().haveSimpleNameEndingWith("Gateway") //
                .check(classesToCheck);
    }

    @Test
    void domainPresentersShouldEndWithUseCaseImpl() {
        String importPackages = ROOT_PACKAGE + "..";
        JavaClasses classesToCheck = new ClassFileImporter().importPackages(importPackages);

        classes().that().resideInAPackage(DOMAIN_PRESENTERS_PACKAGE) //
                .should().haveSimpleNameEndingWith("Presenter") //
                .check(classesToCheck);
    }

    private void checkNoDependencyFromTo(String fromPackage, String toPackage, JavaClasses classesToCheck) {
        noClasses().that().resideInAPackage(fullyQualified(fromPackage)).should().dependOnClassesThat().resideInAPackage(fullyQualified(toPackage)).check(classesToCheck);
    }

    private String fullyQualified(String packageName) {
        return ROOT_PACKAGE + '.' + packageName + "..";
    }
}

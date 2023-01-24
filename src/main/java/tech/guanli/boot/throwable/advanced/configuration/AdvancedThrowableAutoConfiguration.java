package tech.guanli.boot.throwable.advanced.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import tech.guanli.boot.throwable.advanced.Package;

@AutoConfiguration
@ComponentScan(basePackageClasses = Package.class)
public class AdvancedThrowableAutoConfiguration {

}

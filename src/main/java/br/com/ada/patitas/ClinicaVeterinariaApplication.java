package br.com.ada.patitas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaVeterinariaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClinicaVeterinariaApplication.class, args);
	}

}
Error starting ApplicationContext. To display the condition evaluation report re-run your application with 'debug' enabled.
2024-05-16T08:00:11.262-03:00 ERROR 8028 --- [projetopatitas] [  restartedMain] o.s.boot.SpringApplication               : Application run failed

org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'entityManagerFactory' defined in class path resource [org/springframework/boot/autoconfigure/orm/jpa/HibernateJpaConfiguration.class]: Could not determine recommended JdbcType for Java type 'br.com.ada.patitas.model.Veterinario'
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1786) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:600) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:522) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:326) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:324) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:200) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1234) ~[spring-context-6.1.6.jar:6.1.6]
	at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:952) ~[spring-context-6.1.6.jar:6.1.6]
	at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:624) ~[spring-context-6.1.6.jar:6.1.6]
	at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:146) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:754) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:456) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:334) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1354) ~[spring-boot-3.2.5.jar:3.2.5]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1343) ~[spring-boot-3.2.5.jar:3.2.5]
	at br.com.ada.patitas.ClinicaVeterinariaApplication.main(ClinicaVeterinariaApplication.java:10) ~[classes/:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:77) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:568) ~[na:na]
	at org.springframework.boot.devtools.restart.RestartLauncher.run(RestartLauncher.java:50) ~[spring-boot-devtools-3.2.5.jar:3.2.5]
Caused by: org.hibernate.type.descriptor.java.spi.JdbcTypeRecommendationException: Could not determine recommended JdbcType for Java type 'br.com.ada.patitas.model.Veterinario'
	at org.hibernate.type.descriptor.java.spi.UnknownBasicJavaType.getRecommendedJdbcType(UnknownBasicJavaType.java:37) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.boot.model.process.internal.InferredBasicValueResolver.from(InferredBasicValueResolver.java:195) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.mapping.BasicValue.resolution(BasicValue.java:642) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.mapping.BasicValue.buildResolution(BasicValue.java:493) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.mapping.BasicValue.resolve(BasicValue.java:345) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.mapping.BasicValue.resolve(BasicValue.java:335) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.lambda$processValueResolvers$4(InFlightMetadataCollectorImpl.java:1800) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1682) ~[na:na]
	at java.base/java.util.ArrayList.removeIf(ArrayList.java:1660) ~[na:na]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processValueResolvers(InFlightMetadataCollectorImpl.java:1799) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.processSecondPasses(InFlightMetadataCollectorImpl.java:1785) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:332) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1432) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1503) ~[hibernate-core-6.4.4.Final.jar:6.4.4.Final]
	at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:75) ~[spring-orm-6.1.6.jar:6.1.6]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:390) ~[spring-orm-6.1.6.jar:6.1.6]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-6.1.6.jar:6.1.6]
	at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-6.1.6.jar:6.1.6]
	at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:366) ~[spring-orm-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1833) ~[spring-beans-6.1.6.jar:6.1.6]
	at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1782) ~[spring-beans-6.1.6.jar:6.1.6]
	... 21 common frames omitted

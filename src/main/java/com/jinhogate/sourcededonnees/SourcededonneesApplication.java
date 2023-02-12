package com.jinhogate.sourcededonnees;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jinhogate.sourcededonnees.frameworktest.MyBean;

@SpringBootApplication
public class SourcededonneesApplication {
	
	private static Logger log = Logger.getLogger(SourcededonneesApplication.class.getName());
	
	private static MyBean myBean;
	
	public SourcededonneesApplication(MyBean myBean) {
		this.myBean = myBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(SourcededonneesApplication.class, args);
//		log.info("Propriété URL ----------> " + myBean.getUrl());
//		log.info("Propriété information system (user name)  -----> " + myBean.getInformationSystem());
//		log.info("Propriété de ma bean --------> " + myBean.getMyBeanProp());
//		log.info("Nom de mon application  ------------> " + myBean.getApplicationName());
//		log.info("les arguments  ------------> " + args.length);
		log.info("le mot de passe   ------------> " + myBean.getPassWord());
	}

}

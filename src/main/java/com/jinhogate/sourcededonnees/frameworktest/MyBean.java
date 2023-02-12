package com.jinhogate.sourcededonnees.frameworktest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Création de cette class pour tester l'annotation @Value qui permet de recupérer la valeur des propriétés dans les sources de propriétés
 * En effet elle permet d'injecter la valeur des propriétés contenues dans les sources de propriétés dans un bean 
 * @author jorji
 *
 */
@Component
public class MyBean {
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${username}")
	private String informationSystem;
	
	@Value(value = "La valeur de ma myBean")
	private String myBeanProp;

	@Value("${random.value}")
	private String applicationName;
	
	@Value("${spring.datasource.password}")
	private String passWord;
	
	/* Getteurs and setteurs*/
	
	
	public String getUrl() {
		return url;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getInformationSystem() {
		return informationSystem;
	}

	public void setInformationSystem(String informationSystem) {
		this.informationSystem = informationSystem;
	}

	public String getMyBeanProp() {
		return myBeanProp;
	}

	public void setMyBeanProp(String myBeanProp) {
		this.myBeanProp = myBeanProp;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}
	
	
	

}

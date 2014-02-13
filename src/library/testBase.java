package library;

import java.util.List;

import objectSelector.ObjectSelector;
import objectSelector.ObjectTypes.ObjectTags;
import org.openqa.selenium.WebElement;


public class testBase extends Library {
	public void dumpScreenByTag (ObjectTags type){
		List<WebElement> buttons =	driver.findElementsByClassName(type.toString());
		log("-------Start Buttons-------------------");
		for (WebElement button : buttons){
			log("Name: " + button.getAttribute("name"));
			log("Text: " + button.getText());
			log("TagName: " + button.getTagName());
			log("-------------------------");
		}
		log("--------End Buttons-----------------");	
	}

	public void getPageSource (){
		String source =	driver.getPageSource();
		log("-------------------------");
		log(source);
		log("-------------------------");
	}

	public WebElement getWebElement(ObjectSelector obj, boolean hiddenCheck){

		List<WebElement> targets = driver.findElementsByClassName(obj.getObjectTag());
		if (targets.size()==0){
			log("Element of type : " + obj.getObjectTag() + " Not Found.");
			return null;
		}
		for(WebElement target : targets){
			if (target.getAttribute(obj.getSelectorType()).contains(obj.getUinqueID())){
				if (hiddenCheck){
					if(target.isDisplayed()){
						return target;
					}
					log(obj.getDiscriptions() + "Found but is hidded.");
					return null;
				}// end of hidden check
			} // end of is exists. 
		} //end of for loop
		log("Not Found " + obj.getDiscriptions());
		return null;
	}
}

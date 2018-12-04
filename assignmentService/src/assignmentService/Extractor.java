package assignmentService;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;

import org.json.JSONObject;

public abstract class Extractor {
	private File htmlfile;
	
	
	Extractor(File htmlfile){
	 this.setHtmlfile(htmlfile);
	}
	


public abstract	JSONObject Extract();


public File getHtmlfile() {
	return htmlfile;
}


public void setHtmlfile(File htmlfile) {
	this.htmlfile = htmlfile;
}
	
}

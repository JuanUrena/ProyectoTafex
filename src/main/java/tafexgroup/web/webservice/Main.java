package tafexgroup.web.webservice;

import static spark.Spark.*;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import spark.Request;
import spark.Response;

import java.net.URISyntaxException;



public class Main {
	
  
    public static StringWriter main(Request request, Response response) throws ClassNotFoundException, URISyntaxException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
	String uri = request.uri();
	
	
	StringWriter writer = new StringWriter();
	Configuration configuration = new Configuration(new Version(2, 3, 0));
    configuration.setClassForTemplateLoading(Main.class, "/");
	Template resultTemplate = configuration.getTemplate("public/html/main.ftl");
	
	Map<String, Object> map = new HashMap<>();
	

    resultTemplate.process(map, writer);
	System.out.println(uri);
	return writer;
    }
    
    
    public static StringWriter menu(Request request, Response response) throws ClassNotFoundException, URISyntaxException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
    	String uri = request.uri();
    	String parts[] =uri.split("/");
    	String resource = parts[1].replace("_"," "); 
  
    	String content=menu.getContent(resource);

    	StringWriter writer = new StringWriter();
    	Configuration configuration = new Configuration(new Version(2, 3, 0));
        configuration.setClassForTemplateLoading(Main.class, "/");
    	Template resultTemplate = configuration.getTemplate("public/html/general.ftl");
    	
    	Map<String, Object> map = new HashMap<>();
    	map.put("contenido", content);

        resultTemplate.process(map, writer);
    	System.out.println(resource);
    	return writer;
        }
    
    
    public static void main(String[] args) throws ClassNotFoundException {
        port(heroku.getHerokuAssignedPort());
      
        // spark server
        staticFileLocation("/public");    
        get("/", (request, response) ->Main.main(request, response));
        get("/about",(request, response) ->Main.menu(request, response));
        get("/*",(request, response) ->Main.menu(request, response));

    }
    
}
package tafexgroup.web.webservice;

public class menu 
{
	public static String getContent(String resource){
		String content = null;
    	System.out.println(resource);
		if (resource.equals("about")){
			content="<div>"
					+ "<img src=\"html/assets/about.jpg\" style=\"float: left; padding:0 2em \" />"
					+ "<h1>"+ resource +"</h1>"
					+ "<h3>Somos un grupo comprometido con la naturaleza, que desarrolla "
					+ "proyectos amigables con el "
					+ "medioambiente y queremos dejar un lugar mejor a la nuevas "
					+ "generaciones, para ello contamos con una amplia variedad de "
					+ "productos y servicios para el hogar y la industria</h3></div>";
		}else {
			content="hola";
		}
			return content;
	}
}
<%@taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@page contentType = "text/html;charset = UTF-8" language = "java" %>
<html>
<head> <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /></head>
   <body>
      <form:form method = "POST" action = "/save" modelAttribute="product">
         Id: <form:input path = "id" />
         <br />
         Name: <form:input path = "name" />
           <input type="checkbox" name="features" value="choc">Chocolate</input><br/>
		  <input type="checkbox" name="features" value="cane">Candy Cane</input><br/>
		  <input type="checkbox" name="features" value="flower">Flower</input><br/>
		 <input type = "submit" value = "Submit"/>
      </form:form>
   </body>
</html>
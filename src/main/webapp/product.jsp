<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Hello</title>
</head>
<body>
    <table>

<c:forEach items="${products}" var="product">
    <tr>
        <td>Product ID: <c:out value="${product.id}"/></td>
        <td>Product Name: <c:out value="${product.name}"/></td>  
        <td>${values}</td>
    </tr>

</c:forEach>
</table>

</body>
</html>
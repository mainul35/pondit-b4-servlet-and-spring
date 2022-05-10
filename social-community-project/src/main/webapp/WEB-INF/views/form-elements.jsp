<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

${pageTitle}
<form:form action="${pageContext.request.contextPath}/form" method="post" modelAttribute="formObj">
    Simple text input: <form:input path="textField" ></form:input><br>

    Cities:
    <form:select path="ddSelectedOption" id="location" cssStyle="width: 100%">
        <form:option selected="true"
                     value="Please Select a Location" disabled="true"/>
        <form:options items="${locationList}" />
    </form:select>

    Email
    <form:input type="email" path="email"
                required="true"></form:input>

    <input type="submit" name="submit" value="Save"/>
</form:form>
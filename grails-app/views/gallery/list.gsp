<%--
  Created by IntelliJ IDEA.
  User: grygoriy
  Date: 1/23/12
  Time: 10:54 AM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title><g:message code="com.ca.imagegallery.gallerylist"/></title>
    <meta name="layout" content="main">
    
</head>

<body>
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>
<div>
    <g:form action="createGallery">
        <input type="text" id="galleryname" name="galleryname"/>
        <g:submitButton name="submit" value="${g.message(code:'com.ca.imagegallery.galleryCreate')}"/>
    </g:form> 

</div>
<table>
    <thead>
    <tr>
        <td><g:message code="com.ca.imagegallery.galleryName"/></td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <g:each in="${galleries}" var="gallery" status='i'>
        <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
            <td>
                <g:link action="view" id="${gallery.id}">${gallery.name}</g:link>
            </td>
            <td>
                <g:link action="delete" id="${gallery.id}">${g.message(code:'com.ca.imagegallery.galleryDelete')}</g:link>
            </td>
        </tr>
    </g:each>
    </tbody>
</table>
</body>
</html>
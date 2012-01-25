<%--
  Created by IntelliJ IDEA.
  User: grygoriy
  Date: 1/23/12
  Time: 3:50 PM

--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>${gallery.name}</title>
  <meta name="layout" content="main">
  <r:require module="imagegallary" />
  <r:require module="fancybox" />
  <r:require module="fileuploader" />
  <r:require module="jeditable" />
</head>
<body>
    <g:hiddenField name="galleryId" value="${gallery.id}"/>
    <uploader:uploader id="yourUploaderId" url="${[controller:'gallery', action:'uploadImage']}" params="${[galleryId:gallery.id]}">
        <uploader:onComplete>
            updateGallery()
          </uploader:onComplete>
    </uploader:uploader>
<div class="container">
<div class="spacer">
  &nbsp;
</div>
    <div id="gallery">
        <g:render template="galleryContent" collection="${images}" var="image"/>
    </div>
    <div class="spacer">
      &nbsp;
    </div>

    </div>
</body>
</html>
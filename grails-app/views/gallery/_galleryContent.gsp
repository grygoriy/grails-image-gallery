<%--
  Created by IntelliJ IDEA.
  User: grygoriy
  Date: 1/24/12
  Time: 11:20 AM
--%>
<div class="float">
   <a class="gallery" rel="group" title="${image.title}" href="${request.contextPath}/image/display/${image.id}">
        <img class='thumbnail' src="${request.contextPath}/image/display/${image.id}"/>
   </a>
   <div id="${image.id}" class="edit">${image.title}</div>
    <g:hiddenField name="imageId" value="${image.id}"/>
   <g:link class="deleteImage" ><g:message code="com.ca.imagegallery.delete" /></g:link>
</div>

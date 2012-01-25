package com.ca.imagegallery

import org.apache.commons.lang.StringUtils
import org.apache.commons.lang.math.NumberUtils
import org.springframework.web.multipart.MultipartHttpServletRequest
import org.springframework.web.multipart.MultipartFile
import javax.servlet.http.HttpServletRequest
import uk.co.desirableobjects.ajaxuploader.exception.FileUploadException
import grails.converters.JSON

class GalleryController {
    static defaultAction = 'list'

    def galleyFileStorageService

    def list() {
        [galleries: galleyFileStorageService.galleryList()]
    }

    def createGallery(){
        def name = params.galleryname
        if (StringUtils.isNotEmpty(name)) {
            galleyFileStorageService.createGallery(name)
        }
        redirect(action: list())
    }

    def view() {
        def id = NumberUtils.toInt(params.id)
        if (id) {
            def gallery = galleyFileStorageService.getGallery(id)
            def images = galleyFileStorageService.getImages(gallery)
            [gallery:gallery, images:images]
        } else {
            redirect(action: list())
        }
    }
    
    def delete() {
        def id = NumberUtils.toInt(params.id)
        if (id) {
            galleyFileStorageService.deleteGallery(id)
        }
        redirect(action: list())
    }

    def getGalleryContent() {
        def id = NumberUtils.toInt(params.id)
        if (id) {
            def images = galleyFileStorageService.getImages(id)
            render template: 'galleryContent', var: 'image', collection: images
        }
    }

    def addImages() {
        def id = NumberUtils.toInt(params.id)
        def gallery = Gallery.get(id)
        if (gallery) {
            [gallery:gallery]
        } else {
            redirect(action: list())
        }
    }

    def uploadImage() {
        try {
            InputStream inputStream = selectInputStream(request)
            def gallery = Gallery.get(params.galleryId)
            galleyFileStorageService.addFile(params.qqfile, gallery, inputStream)
            return render(text: [success:true] as JSON, contentType:'text/json')
        } catch (FileUploadException e) {
            log.error("Failed to upload file.", e)
            return render(text: [success:false] as JSON, contentType:'text/json')
        }
    }

    def rename() {
        def objectId = params.long('id')
        def newName = params.value

        galleyFileStorageService.renameImage(objectId, newName)
        render newName
    }
    
    def removeImage() {
        def id = params.long('id')
        if (id) {
            galleyFileStorageService.removeImage(id)
            return render(text: [success:true] as JSON, contentType:'text/json')
        }
    }

    private InputStream selectInputStream(HttpServletRequest request) {
        if (request instanceof MultipartHttpServletRequest) {
            MultipartFile uploadedFile = ((MultipartHttpServletRequest) request).getFile('qqfile')
            return uploadedFile.inputStream
        }
        return request.inputStream
    }

}


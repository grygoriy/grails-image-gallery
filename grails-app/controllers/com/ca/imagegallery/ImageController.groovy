package com.ca.imagegallery

import org.apache.commons.lang.math.NumberUtils

class ImageController {

    def galleyFileStorageService

    //todo:return 404 if image not found
    def display() {
        def imageId = NumberUtils.toInt(params.id)
        def content = galleyFileStorageService.getImageContent(imageId)
        response.contentType='image/jpeg'
        response.outputStream << content
    }
}

package com.ca.imagegallery

class GalleyFileStorageService {

    def rootFolder = '/home/grygoriy/gallery'

    def galleryList() {
        Gallery.list()
    }

    def total(){
        Gallery.count()
    }

    def createGallery(def name) {
        if (new Gallery(name: name).save()) {
            new File("$rootFolder/$name").mkdirs()
        }
    }

    def addFile(def name, def gallery, def inputStream) {
        def file = new File("$rootFolder/${gallery.name}/$name")
        file.createNewFile()
        file << inputStream
        def image = new Image(name:name, gallery: gallery, title:name)
        image.save()
    }

    def renameImage(def id, def newTitle) {
        Image.executeUpdate('update Image i set i.title =:title where i.id = :id', [title: newTitle, id: id])
    }

    def deleteGallery(def id) {
        def gallery = Gallery.get(id)
        if (gallery) {
            new File("$rootFolder/${gallery.name}").deleteDir()
        }
    }

    def getGallery(def id) {
        Gallery.get(id)
    }

    def getImages(Long galleryId) {
        Image.findByGallery(Gallery.get(galleryId))
    }

    def getImages(Gallery gallery) {
        Image.findAllByGallery(gallery)
    }

    def getImageContent(def imageId) {
        def image = Image.get(imageId)
        def gallery = image.gallery
        def file = new File("$rootFolder/${gallery.name}/${image.name}")
        file.bytes
    }

    def removeImage(long id) {
        def image = Image.get(id)
        if (image) {
            new File("$rootFolder/${image.gallery.name}/${image.name}").delete()
            image.delete()
        }
    }
}

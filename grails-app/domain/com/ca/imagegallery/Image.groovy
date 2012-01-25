package com.ca.imagegallery

class Image {

    String name
    String description
    Gallery gallery
    String filePath
    String originName
    String title

    static constraints = {
        name(nullable: true, blank: true)
        description(nullable: true, blank: true)
        gallery(nullable: false)
        filePath(nullable: true, blank: true)
        originName(nullable: true, blank: true)
    }
}

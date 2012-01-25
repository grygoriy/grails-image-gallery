package com.ca.imagegallery

class Gallery {

    String name
    Date dateCreated

    static constraints = {
        name(nullable: true, blank: true)
    }

    static mapping = {
        version false
    }
    
    static deleteById(def id) {
        executeUpdate('delete from Gallery g where g.id = :id', [id, id])
    }
}

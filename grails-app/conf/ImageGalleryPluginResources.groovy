modules = {
        imagegallary {
                resource url:[plugin: 'image-gallery', dir:'js/', file:"gallerylist.js"]
                resource url:[plugin: 'image-gallery', dir:'css/', file:"gallery.css"]
                dependsOn 'jquery'
        }

        fancybox {
            resource url:[plugin: 'image-gallery', dir:'css/', file:"jquery.fancybox-1.3.4.css"]
            resource url:[plugin: 'image-gallery', dir:'js/', file:"jquery.easing-1.3.pack.js"]
            resource url:[plugin: 'image-gallery', dir:'js/', file:"jquery.fancybox-1.3.4.js"]
            resource url:[plugin: 'image-gallery', dir:'js/', file:"jquery.fancybox-1.3.4.pack.js"]
            resource url:[plugin: 'image-gallery', dir:'js/', file:"jquery.mousewheel-3.0.4.pack.js"]
        }

        jeditable {
            resource url:[plugin: 'image-gallery', dir:'js/', file:"jquery.jeditable.js"]
        }
}
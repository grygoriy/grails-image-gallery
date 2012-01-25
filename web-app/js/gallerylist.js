$(function() {
    $("a.gallery").fancybox({'type' : 'image'});

    $('.edit').editable('../rename', {
                 submit    : 'OK',
                 tooltip   : 'Click to edit...',
                 callback : function(value, settings) {
                     $(this).closest('div.float').find('a.gallery').attr('title', value)
                }
    });

    $('.deleteImage').click(function() {
        var imageContainer = $(this).closest('div.float');
        var imageId = imageContainer.find('input[name="imageId"]').val();
        console.debug(imageId);
        console.debug($(this).val());
        $.get('../removeImage',{id:imageId}, function(data) {
            console.debug("remove element");
            imageContainer.remove()
        });
        return false
    })
});

function updateGallery() {
    $.get('../getGalleryContent', {id:$('#galleryId').val()}, function(data) {
        $('#gallery').html(data)
    })
}

jQuery(document).ready(function() {
    if ($('.message-alert-container').length) {
        swal({
            title: $('.message-alert-title').text(),
            text: $('.message-alert-text').text(),
            type: $('.message-alert-type').text(),
            confirmButtonText: "Ok, entiendo."
        });
    }
});
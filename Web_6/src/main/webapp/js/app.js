window.notify = function(message) {
    $.notify(message, {position: "bottom right"})
};

myAjax = function(options, $error) {
    var settings = {
        type: "POST",
        url: "",
        dataType: "json",
        success: function (response) {
            if (response["error"]) {
                $error.text(response["error"]);
            } else {
                location.href = response["redirect"];
            }
        }
    };

    settings = jQuery.extend(settings, options);

    $.ajax(settings);
};

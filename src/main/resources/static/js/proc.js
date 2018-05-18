(function ($) {
    var procImageSource = "https://cdn.dribbble.com/users/722835/screenshots/4082720/bot_icon.gif";
    var proc = {
        getSuggestionImage: function () {
            var suggestedImage = document.createElement('img');
            suggestedImage.class = 'proc-image-suggestion';
            suggestedImage.src = procImageSource;
            return suggestedImage;
        },

        recommendedSolution: function (exception, e) {
            var bestSolution = "Not found solution for this exception";
            $.ajax({
                type: 'GET',
                url: '/exception/getSolution/' + exception,
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                success: function (response) {
                    bestSolution = JSON.stringify(response);
                },
                error: function (xhr, textStatus, error) {
                    console.log(xhr.statusText);
                    console.log(textStatus);
                    console.log(error);
                    document.createElement("p").appendChild(document.createTextNode("Not found solution for this exception"));
                }
            });
            return document.createElement("p").appendChild(document.createTextNode(bestSolution));
        }
    };

    $(document).ready(function () {
        $('#select-solution').click(function () {
            var currentLink = window.location.href;
            var exceptionId = currentLink.substr(currentLink.lastIndexOf('/') + 1);
            var suggestionWindow = document.createElement('div');
            suggestionWindow.class = 'solution-box';
            suggestionWindow.appendChild(proc.getSuggestionImage());
            suggestionWindow.appendChild(proc.recommendedSolution(exceptionId, this));
            $.notify(suggestionWindow,
                {
                    globalPosition: 'top right'
                }
            );
        });
    });
}(jQuery));

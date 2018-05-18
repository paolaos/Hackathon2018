(function ($) {
    var proc = {
        procImageSource: "https://cdn.dribbble.com/users/722835/screenshots/4082720/bot_icon.gif",

        getSuggestionImage: function () {
            var suggestedImage = document.createElement('img');
            suggestedImage.class = 'proc-image-suggestion';
            suggestedImage.src = procImageSource;
            return suggestedImage;
        },

        recommendedSolution: function (exception) {
            var bestSolution = "Not found solution for this exception";
            $.ajax({
                type: 'GET',
                url: '/exception/getSolution',
                data: {
                    id: exception,
                },
                dataType: 'json',
                contentType: 'application/json; charset=utf-8',
                success: function (response) {
                    bestSolution = JSON.stringify(response);
                },
                error: function (error) {
                    console.log("Not found solution for this exception");
                }
            });
            return bestSolution;
        }
        ,

        searchForAction: function () {
            var currentLink = window.location.href
            if (currentLink.contains("exception?id=") > 0) {
                var suggestionWindow = document.createElement('div');
                suggestionWindow.class = 'solution-box';
                suggestionWindow.appendChild(this.getSuggestionImage());
                suggestionWindow.appendChild(this.recommendedSolution($('#exception-id')));
                $.notify(
                    suggestionWindow,
                    {
                        globalPosition: 'top right',
                    }
                );
            }


        }
    }
    $(document).ready(function () {
        proc.searchForAction();
    });

}(jQuery));

(function ($) {
    var procImageSource = "https://cdn.dribbble.com/users/722835/screenshots/4082720/bot_icon.gif";
    var proc = {
        getSuggestionImage: function () {
            var suggestedImage = document.createElement('IMG');
            suggestedImage.class = 'proc-image-suggestion';
            suggestedImage.src = procImageSource;
            suggestedImage.style.height = "100px";
            return suggestedImage;
        },

        recommendedSolution: function (exception, e) {
            var bestSolution = "";
            $.ajax({
                type: 'GET',
                url: '/solution/get/' + exception,
                contentType: 'application/json; charset=utf-8',
                success: function (response) {
                    e.insertBefore(document.createElement('H2').appendChild(document.createTextNode("Proc Recommendation: "+response)), e.firstChild);
                },
                error: function (xhr, textStatus, error) {
                    return document.createElement("P").appendChild(document.createTextNode("Not found solution for this exception"));
                }
            });
        }
    };

    $(document).ready(function () {

        $('#select-solution').click(function () {
            $(".solution-box").remove();
            var currentLink = window.location.href;
            var exceptionId = currentLink.substr(currentLink.lastIndexOf('/') + 1);
            var suggestionWindow = document.createElement('div');
            suggestionWindow.className = 'solution-box';
            proc.recommendedSolution(exceptionId, suggestionWindow);
            suggestionWindow.appendChild(proc.getSuggestionImage());
            $('.modal-footer').append(suggestionWindow);
        });
    });
}(jQuery));

/**
 * CONSTANTS
 */
const BOOKS_RESOURCE = "http://localhost:9123/books";
const BOOKDTO =
    `{
        "isbn": "161729520X", 
        "title": "Spring in Action",
        "author": {
            "firstName": "Craig", 
            "lastName": "Walls"
        }
    }`;

/**
 * ------------------
 * --- MAIN METHOD
 * ------------------
 */
$(document).ready(function () {
    showBooks();
    searchForIsbn();
    addARandomBook();
});

/**
 * ------------------
 * --- METHODS
 * ------------------
 */
function searchForIsbn() {
    $("#isbn-search-button").click(function () {
        alert("(not yet implemented) You want to search for a book with ISBN: " + $("#isbn-search-input").val());
    });
}

function addARandomBook() {
    $("#add-random-book-button").click(function () {
        $.ajax({
            type: 'POST',
            url: BOOKS_RESOURCE,
            data: BOOKDTO,
            success: function () {
                showBooks();
            },
            error: function() {
                alert("It didn't work!!");
            },
            contentType: "application/json",
            dataType: 'json'
        });
    });
}

function showBooks() {
    console.log("Calling backend!");
    $.getJSON(BOOKS_RESOURCE, function (data) {
        console.log("--> Great success!");
        console.log(data);
        if (data.length > 0) {
            $("#injectable").empty();
            data.forEach(function (item) {
                $("#injectable").append(VIEW.renderSingleItem(item), null);
            });
        } else {
            $("#injectable").append("<p>There are no books... Please add some books!</p>", null);
        }
    })
        .done(function () {
            console.log("--> I'm done (successfully)");
        })
        .fail(function () {
            console.log("--> error!");
        })
        .always(function () {
            console.log("--> finalized...");
        });
}

/**
 * ------------------
 * --- VIEW
 * ------------------
 */
const VIEW = {
    renderSingleItem: (function (book) {
        return `<div class="col-lg-3">
                    <div class="card">
                      <img class="card-img-top img-fluid" src="https://picsum.photos/200" alt="${book.title}">
                      <div class="card-body">
                        <h4 class="card-title">${book.title}</h4>
                        <h5 class="card-subtitle mb-2 text-muted">${book.author.firstName} ${book.author.lastName}</h5>
                        <p class="card-text">ISBN: ${book.isbn}</p>
                      </div>
                    </div>
                </div>
            `
    })
};
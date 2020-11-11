const sort = 2;
var pageDefault = 0;
var totalPages = 0;

loadListProduct(pageDefault);

function forPagination(totalPages) {
    $("#pagination").empty();    
    for(let i = 0; i < totalPages; i++) {
        if(i == pageDefault) {
            $("#pagination").append(`<li class="active"><a href="#" onclick='renderPage(${i})'>${i+1}</a></li>`);
        }else {
            $("#pagination").append(`<li><a href="#" onclick='renderPage(${i})'>${i+1}</a></li>`);
        }
    }
}

function loadListProduct(pageDefault) {
    $('#list-watch').empty();
    $.ajax({
        url: "http://localhost:8080/api/v1/products/search?name&page=" + pageDefault + "&perPage=5",
        type: 'GET',
        contentType: 'application/json',
        success: function (result) {
            if (result.code == '00') {
                renderListProduct(result.data.content);
                if(totalPages != result.data.totalPages)
                {
                    totalPages = result.data.totalPages;
                }
                totalPages = result.data.totalPages;
                forPagination(totalPages);
            } else {
                alert(result.message);
            }
        },
        error: function (result) {
            alert('Có lỗi xảy ra: ' + result.message);
        }
    });
}

function renderListProduct(data) {
    data.map(item => {
        $('#list-watch').append(`
        <div class="product-layout product-list col-xs-12">
            <div class="product-thumb">
              <div class="image product-imageblock">
                <a href="/product?id=${item.id ? item.id : ""}">
                    <img src="${item.image}" alt="${item.name}" title="${item.name}" class="img-responsive" />
                </a>
                <div class="button-group">
                  <button type="button" class="wishlist" data-toggle="tooltip" title="Add to Wish List">
                    <i class="fa fa-heart-o"></i>
                  </button>
                  <button type="button" class="addtocart-btn" data-toggle="tooltip" title="Add to Cart">Add to Cart</button>
                  <button type="button" class="compare" data-toggle="tooltip" title="Compare this Product">
                    <i class="fa fa-exchange"></i>
                  </button>
                </div>
              </div>
              <div class="caption product-detail">
                <h4 class="product-name">
                    <a href="/product?id=${item.id ? item.id : ""}" title="${item.name}">${item.name}</a>
                </h4>
                <p class="product-desc">${item.description}</p>
                <p class="price product-price">$${item.style.price}</p>
                <div class="rating style">                    
                    <span class="color" data-toggle="tooltip" title="Color: ${item.style.color}">${item.style.color} |</span>
                    <span class="amount" data-toggle="tooltip" title="${item.style.amount} watch(s) in stock">${item.style.amount} |</span>
                    <span class="size" data-toggle="tooltip" title="Size: ${item.style.size}">${item.style.size}</span>
                </div>
              </div>
              <div class="button-group">
                <button type="button" class="wishlist" data-toggle="tooltip" title="Add to Wish List"><i class="fa fa-heart-o"></i></button>
                <button type="button" class="addtocart-btn" data-toggle="tooltip" title="Add to Cart">Add to Cart</button>
                <button type="button" class="compare" data-toggle="tooltip" title="Compare this Product"><i class="fa fa-exchange"></i></button>
              </div>
            </div>
        </div>
        `);
    });
}

function renderPage(page) {
    $('#list-watch').empty();
    pageDefault = page;
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/products/search?name&page=" + pageDefault + "&perPage=5",
        processData: false,
        contentType: 'application/json',
        success: function (response) {
            if(response.code == "00") {
                renderListProduct(response.data.content)
                let totalPages = response.data.totalPages;
                forPagination(totalPages);
            }
            else {
                renderListProduct(response.data.content);
                forPagination(1);
                console.log(response.message);
            }
        }
    });
}
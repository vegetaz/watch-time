$(document).ready(function () {
    var idProduct = new URLSearchParams(window.location.search).get("id");
    $.ajax({
        type: "GET",
        url: "http://localhost:8080/api/v1/product/" + idProduct,
        processData: false,
        success: function (response) {
            if (response.code == "00") {
                rederDataSingleProduct(response.data);
                singleProduct = response.data;
            }
            else {
                console.log(response.message);
            }
        }
    });

});

function rederDataSingleProduct(item) {
    $("#single-product").empty();
    $('#single-product').html(
            `<div class="col-sm-6">
                <div class="thumbnails">
                  <div>
                    <a class="thumbnail" href="image/product/product8.jpg" title="${item.name}">
                        <img src="${item.image}" title="${item.name}" alt="${item.name}" />
                    </a>
                  </div>
                </div>
            </div>
            <div class="col-sm-6">
                <h1 class="productpage-title">${item.name}</h1>
                <ul class="list-unstyled productinfo-details-top">
                  <li>
                    <h2 class="productpage-price">$${item.style.price}</h2>
                  </li>
                </ul>
                <hr>
                <ul class="list-unstyled product_info">
                  <li>
                    <label>Category:</label>
                    <span>${item.listCategory}</span>
                  </li>
                  <li>
                    <label>Color:</label>
                    <span>${item.style.color}</span>
                  </li>
                  <li>
                    <label>Size:</label>
                    <span>${item.style.size}</span>
                  </li>
                  <li>
                    <label>Availability:</label>
                    <span>${item.style.amount}</span></li>
                </ul>
                <hr>
                <p class="product-desc">${item.description}</p>
                <div id="product">
                  <div class="form-group">
                    <label class="control-label qty-label" for="input-quantity">Qty</label>
                    <input type="text" name="quantity" value="1" size="2" id="input-quantity" class="form-control productpage-qty" />
                    <input type="hidden" name="product_id" value="48" />
                    <div class="btn-group">
                      <button type="button" id="button-cart" data-loading-text="Loading..." class="btn btn-primary btn-lg btn-block addtocart">Add to Cart</button>
                    </div>
                  </div>
                </div>
            </div>
        </div>`);
}
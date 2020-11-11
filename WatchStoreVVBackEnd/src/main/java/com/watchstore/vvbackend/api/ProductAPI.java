package com.watchstore.vvbackend.api;

import com.watchstore.vvbackend.dto.BaseResponse;
import com.watchstore.vvbackend.model.Product;
import com.watchstore.vvbackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/v1/")
public class ProductAPI {
    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/products/search", method = RequestMethod.GET)
    public BaseResponse getAllProducts(@RequestParam(value = "name", required = false) String name,
                                       @RequestParam(value = "sort", defaultValue = "1") Integer sort,
                                       @RequestParam(value = "page") Integer page,
                                       @RequestParam(value = "perPage") Integer perPage) {
        /*http://localhost:8080/api/v1/products/search?name&page=0&perPage=5*/
        BaseResponse response = new BaseResponse();
        try {
            Pageable pageable;
            switch (sort) {
                case 1:
                    pageable = PageRequest.of(page, perPage, Sort.by(Sort.Direction.ASC, "name"));
                    break;
                case 2:
                    pageable = PageRequest.of(page, perPage, Sort.by(Sort.Direction.DESC, "name"));
                    break;
                case 3:
                    pageable = PageRequest.of(page, perPage, Sort.by(Sort.Direction.ASC, "price"));
                    break;
                case 4:
                    pageable = PageRequest.of(page, perPage, Sort.by(Sort.Direction.DESC, "price"));
                    break;
                default:
                    pageable = PageRequest.of(page, perPage, Sort.by(Sort.Direction.DESC, "id"));
                    break;
            }
            Page<Product> listProduct = productRepository.findByNameContaining(name, pageable);
            if (!listProduct.isEmpty()) {
                response.setCode("00");
                response.setMessage("Success: " + name);
                response.setData(listProduct);
            } else {
                response.setCode("98");
                response.setMessage("Error!");
                response.setData(null);
            }
        } catch (Exception e) {
            response.setCode("99");
            response.setMessage("Error: " + e.getMessage());
            response.setData(null);
        }
        return response;
    }

    @CrossOrigin
    @GetMapping("/product/{id}")
    public BaseResponse getSingleProduct(@PathVariable("id") String id){
        BaseResponse response = new BaseResponse();
        try {
            Optional<Product> optListProduct = productRepository.findById(id);
            if (optListProduct.isPresent()) {
                Product exitProduct = optListProduct.get();
                response.setCode("00");
                response.setMessage("List product search by key: " + id);
                response.setData(exitProduct);
            } else {
                response.setCode("99");
                response.setMessage("Data not found");
                response.setData(null);
            }
        } catch (Exception e) {
            response.setCode("90");
            response.setMessage("System error : " + e.getMessage());
            response.setData(null);
        }
        return response;
    }
}

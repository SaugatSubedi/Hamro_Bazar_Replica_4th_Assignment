package com.saugat.a4thassignmenthamro_bazzarreplica.api;

import com.saugat.a4thassignmenthamro_bazzarreplica.model.Products;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductAPI {

    @GET("products/allProducts")
    Call<List<Products>> getAllProducts();
}

package com.eshopping.product.dashboard.controller;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ProductsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    final String accessToken = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzcmlrYW50aC5uYWdpZGkifQ.1QnqIqAD2QtzDPxDoE-tum8BQ5pUtBfTca5QcOaywxLx3-empumPkciPG2NVIsdAgT-oaQs5LfEI-3-20SSFKw";

    /**
     * @throws Exception It tests creating a product
     */
    @Test
    public void AcreateProduct() throws Exception {

        /**
         *
         * Create product with id 7
         *
         * The request body is: { "id": 7, "name": "Belt", "category": "Accessories",
         * "retail_price": 471.0, "discounted_price": 419.19, "availability": true }
         */
        String json = "{\"id\": 7, \"name\": \"Belt\", \"category\": \"Accessories\", \"retail_price\": 471.0, \"discounted_price\": 419.19, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 8
         *
         * The request body is: { "id": 8, "name": "Kaftan", "category": "Accessories",
         * "retail_price": 237.0, "discounted_price": 215.67, "availability": true }
         */
        json = "{\"id\": 8, \"name\": \"Kaftan\", \"category\": \"Accessories\", \"retail_price\": 237.0, \"discounted_price\": 215.67, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 9
         *
         * The request body is: { "id": 9, "name": "Overalls", "category": "Full Body
         * Outfits", "retail_price": 374.0, "discounted_price": 321.64, "availability":
         * true }
         */
        json = "{\"id\": 9, \"name\": \"Overalls\", \"category\": \"Full Body Outfits\", \"retail_price\": 374.0, \"discounted_price\": 321.64, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 10
         *
         * The request body is: { "id": 10, "name": "Cufflinks", "category":
         * "Accessories", "retail_price": 284.0, "discounted_price": 247.08,
         * "availability": true }
         */
        json = "{\"id\": 10, \"name\": \"Cufflinks\", \"category\": \"Accessories\", \"retail_price\": 284.0, \"discounted_price\": 247.08, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 11
         *
         * The request body is: { "id": 11, "name": "Cargos", "category": "Bottoms",
         * "retail_price": 498.0, "discounted_price": 428.28, "availability": true }
         */
        json = "{\"id\": 11, \"name\": \"Cargos\", \"category\": \"Bottoms\", \"retail_price\": 498.0, \"discounted_price\": 428.28, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 12
         *
         * The request body is: { "id": 12, "name": "Poncho", "category": "Accessories",
         * "retail_price": 280.0, "discounted_price": 224.7, "availability": true }
         */
        json = "{\"id\": 12, \"name\": \"Poncho\", \"category\": \"Accessories\", \"retail_price\": 280.0, \"discounted_price\": 224.7, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 13
         *
         * The request body is: { "id": 13, "name": "Cummerbund", "category":
         * "Accessories", "retail_price": 435.0, "discounted_price": 400.2,
         * "availability": true }
         */
        json = "{\"id\": 13, \"name\": \"Cummerbund\", \"category\": \"Accessories\", \"retail_price\": 435.0, \"discounted_price\": 400.2, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 14
         *
         * The request body is: { "id": 14, "name": "Dress", "category": "Full Body
         * Outfits", "retail_price": 175.0, "discounted_price": 140.0, "availability":
         * true }
         */
        json = "{\"id\": 14, \"name\": \"Dress\", \"category\": \"Full Body Outfits\", \"retail_price\": 175.0, \"discounted_price\": 140.0, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 15
         *
         * The request body is: { "id": 15, "name": "Trainers", "category": "Footwear",
         * "retail_price": 228.0, "discounted_price": 184.68, "availability": true }
         */
        json = "{\"id\": 15, \"name\": \"Trainers\", \"category\": \"Footwear\", \"retail_price\": 228.0, \"discounted_price\": 184.68, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 16
         *
         * The request body is: { "id": 16, "name": "Tracksuit", "category": "Full Body
         * Outfits", "retail_price": 471.0, "discounted_price": 423.9, "availability":
         * false }
         */
        json = "{\"id\": 16, \"name\": \"Tracksuit\", \"category\": \"Full Body Outfits\", \"retail_price\": 471.0, \"discounted_price\": 423.9, \"availability\": false}";

        mockMvc.perform(post("/products").header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 17
         *
         * The request body is: { "id": 17, "name": "Tailcoat", "category": "Full Body
         * Outfits", "retail_price": 307.0, "discounted_price": 254.81, "availability":
         * true }
         */
        json = "{\"id\": 17, \"name\": \"Tailcoat\", \"category\": \"Full Body Outfits\", \"retail_price\": 307.0, \"discounted_price\": 254.81, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 18
         *
         * The request body is: { "id": 18, "name": "Vest", "category": "Tops",
         * "retail_price": 446.0, "discounted_price": 392.48, "availability": true }
         */
        json = "{\"id\": 18, \"name\": \"Vest\", \"category\": \"Tops\", \"retail_price\": 446.0, \"discounted_price\": 392.48, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 19
         *
         * The request body is: { "id": 19, "name": "Suit", "category": "Full Body
         * Outfits", "retail_price": 158.0, "discounted_price": 135.88, "availability":
         * true }
         */
        json = "{\"id\": 19, \"name\": \"Suit\", \"category\": \"Full Body Outfits\", \"retail_price\": 158.0, \"discounted_price\": 135.88, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 20
         *
         * The request body is: { "id": 20, "name": "Catsuit", "category": "Full Body
         * Outfits", "retail_price": 158.0, "discounted_price": 135.88, "availability":
         * true }
         */
        json = "{\"id\": 20, \"name\": \"Catsuit\", \"category\": \"Full Body Outfits\", \"retail_price\": 158.0, \"discounted_price\": 135.88, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());

        /**
         *
         * Create product with id 21
         *
         * The request body is: { "id": 21, "name": "Dungarees", "category": "Full Body
         * Outfits", "retail_price": 437.0, "discounted_price": 362.71, "availability":
         * false }
         */
        json = "{\"id\": 21, \"name\": \"Dungarees\", \"category\": \"Full Body Outfits\", \"retail_price\": 437.0, \"discounted_price\": 362.71, \"availability\": false}";

        mockMvc.perform(post("/products").header("Authorization", "Bearer " + accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isCreated());
    }

    /**
     * @throws Exception It tests creating a product
     */
    @Test
    public void BcreateProductWithExistingId() throws Exception {
        /**
         *
         * Create product with existing id 1
         *
         * The request body is: { "id": 1, "name": "Dressing Gown", "category":
         * "Underwear", "retail_price": 303.0, "discounted_price": 251.49,
         * "availability": true }
         */
        String json = "{\"id\": 1, \"name\": \"Dressing Gown\", \"category\": \"Underwear\", \"retail_price\": 303.0, \"discounted_price\": 251.49, \"availability\": true}";

        mockMvc.perform(post("/products").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isBadRequest());
    }

    /**
     * @throws Exception It tests updating retail price of a product
     */
    @Test
    public void CupdateProductRetailPrice() throws Exception {
        /**
         *
         * Update retail price of a product with id 6
         *
         * The request body is: { "retail_price": 325.45, "discounted_price": 260.36,
         * "availability": true }
         */
        String json = "{\"retail_price\": 325.45, \"discounted_price\": 260.36, \"availability\": true}";
        mockMvc.perform(put("/products/6").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
    }

    /**
     * @throws Exception It tests updating discount price of a product
     */
    @Test
    public void DupdateProductDiscountPrice() throws Exception {
        /**
         *
         * Update discount price of a product with id 10
         *
         * The request body is: { "retail_price": 284.0, "discounted_price": 227.2,
         * "availability": true }
         */
        String json = "{\"retail_price\": 284.0, \"discounted_price\": 227.2, \"availability\": true}";

        mockMvc.perform(put("/products/10").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
    }

    /**
     * @throws Exception It tests updating availability of a product
     */
    @Test
    public void EupdateProductAvailability() throws Exception {
        /**
         *
         * Update availability of a product with id 2
         *
         * The request body is: { "retail_price": 150.0, "discounted_price": 123.0,
         * "availability": false }
         */
        String json = "{\"retail_price\": 150.0, \"discounted_price\": 123.0, \"availability\": false}";

        mockMvc.perform(put("/products/2").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
    }

    /**
     * @throws Exception It tests updating retail and discount price of a product
     */
    @Test
    public void FupdateProductRetailAndDiscountPrice() throws Exception {
        /**
         *
         * Update retail and discount price of a product with id 12
         *
         * The request body is: { "retail_price": 350.0, "discounted_price": 283.5,
         * "availability": true }
         */
        String json = "{\"retail_price\": 350.0, \"discounted_price\": 283.5, \"availability\": true}";

        mockMvc.perform(put("/products/12").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
    }

    /**
     * @throws Exception It tests updating retail price and availability of a
     *                   product
     */
    @Test
    public void GupdateProductRetailPriceAndAvailability() throws Exception {
        /**
         *
         * Update retail price and availability of a product with id 19
         *
         * The request body is: { "retail_price": 125.0, "discounted_price": 100.0,
         * "availability": false }
         */
        String json = "{\"retail_price\": 125.0, \"discounted_price\": 100.0, \"availability\": false}";

        mockMvc.perform(put("/products/19").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
    }

    /**
     * @throws Exception It tests updating discount price and availability of a
     *                   product
     */
    @Test
    public void HupdateProductDiscountPriceAndAvailability() throws Exception {
        /**
         *
         * Update discount price and availability of a product with id 20
         *
         * The request body is: { "retail_price": 250.0, "discounted_price": 200.0,
         * "availability": false }
         */
        String json = "{\"retail_price\": 250.0, \"discounted_price\": 200.0, \"availability\": false}";

        mockMvc.perform(put("/products/20").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
    }

    /**
     * @throws Exception It tests updating retail price, discount price and
     *                   availability of a product
     */
    @Test
    public void IupdateProductRetailPriceDiscountPriceAndAvailability() throws Exception {
        /**
         *
         * Update retail price, discount price and availability of a product with id 13
         *
         * The request body is: { "retail_price": 500.0, "discounted_price": 450.0,
         * "availability": false }
         */
        String json = "{\"retail_price\": 500.0, \"discounted_price\": 450.0, \"availability\": false}";

        mockMvc.perform(put("/products/13").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isOk());
    }

    /**
     * @throws Exception It tests updating availability of non-existing product
     */
    @Test
    public void JupdateAvailabilityOfNonExistingProduct() throws Exception {
        /**
         *
         * Update availability of a non existing product with id 25
         *
         * The request body is: { "retail_price": 311.0, "discounted_price": 258.13,
         * "availability": true }
         */
        String json = "{\"retail_price\": 311.0, \"discounted_price\": 258.13, \"availability\": true}";

        mockMvc.perform(put("/products/25").header("Authorization", accessToken)
                .contentType(MediaType.APPLICATION_JSON_UTF8).content(json)).andExpect(status().isBadRequest());
    }

    /**
     * @throws Exception It tests finding a product
     */
    @Test
    public void KfindProductById() throws Exception {
        /**
         *
         * Find product by id 2
         *
         * The request response is: { "id": 2, "name": "Shoes", "category": "Footwear",
         * "retail_price": 150.0, "discounted_price": 123.0, "availability": false }
         */
        String res = "{\"id\": 2, \"name\": \"Shoes\", \"category\": \"Footwear\", \"retail_price\": 150.0, \"discounted_price\": 123.0, \"availability\": false}";

        assertTrue(ResultMatcher.matchJson(mockMvc.perform(get("/products/2").header("Authorization", accessToken))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), res, true));
    }

    /**
     * @throws Exception It tests finding a product
     */
    @Test
    public void LfindProductByNonExistingId() throws Exception {
        /**
         *
         * Find product by non-existing id 25
         */
        mockMvc.perform(get("/products/25").header("Authorization", accessToken)).andExpect(status().isNotFound());
    }

    /**
     * @throws Exception It tests finding products belonging to a category
     */
    @Test
    public void MfindProductsByCategory() throws Exception {
        /**
         *
         * Find products belonging to Accesories category
         *
         * The request response is: [ { "id": 8, "name": "Kaftan", "category":
         * "Accessories", "retail_price": 237.0, "discounted_price": 215.67,
         * "availability": true }, { "id": 10, "name": "Cufflinks", "category":
         * "Accessories", "retail_price": 284.0, "discounted_price": 227.2,
         * "availability": true }, { "id": 6, "name": "Shawl", "category":
         * "Accessories", "retail_price": 325.45, "discounted_price": 260.36,
         * "availability": true }, { "id": 12, "name": "Poncho", "category":
         * "Accessories", "retail_price": 350.0, "discounted_price": 283.5,
         * "availability": true }, { "id": 7, "name": "Belt", "category": "Accessories",
         * "retail_price": 471.0, "discounted_price": 419.19, "availability": true }, {
         * "id": 13, "name": "Cummerbund", "category": "Accessories", "retail_price":
         * 500.0, "discounted_price": 450.0, "availability": false } ]
         */
        String res = "[{\"id\": 8, \"name\": \"Kaftan\", \"category\": \"Accessories\", \"retail_price\": 237.0, \"discounted_price\": 215.67, \"availability\": true}, {\"id\": 10, \"name\": \"Cufflinks\", \"category\": \"Accessories\", \"retail_price\": 284.0, \"discounted_price\": 227.2, \"availability\": true}, {\"id\": 6, \"name\": \"Shawl\", \"category\": \"Accessories\", \"retail_price\": 325.45, \"discounted_price\": 260.36, \"availability\": true}, {\"id\": 12, \"name\": \"Poncho\", \"category\": \"Accessories\", \"retail_price\": 350.0, \"discounted_price\": 283.5, \"availability\": true}, {\"id\": 7, \"name\": \"Belt\", \"category\": \"Accessories\", \"retail_price\": 471.0, \"discounted_price\": 419.19, \"availability\": true}, {\"id\": 13, \"name\": \"Cummerbund\", \"category\": \"Accessories\", \"retail_price\": 500.0, \"discounted_price\": 450.0, \"availability\": false}]";

        assertTrue(ResultMatcher.matchJsonArray(
                mockMvc.perform(get("/products?category=Accessories").header("Authorization", accessToken))
                        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(),
                res, true));
    }

    /**
     * @throws Exception It tests finding products belonging to a category
     */
    @Test
    public void NfindProductsByNonExistingCategory() throws Exception {
        /**
         *
         * Find products belonging to Swimwear category
         *
         * The request response is: []
         */
        String res = "[]";

        assertTrue(ResultMatcher
                .matchJsonArray(mockMvc.perform(get("/products?category=Swimwear").header("Authorization", accessToken))
                        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), res, true));
    }

    /**
     * @throws Exception It tests finding a product with a given category and
     *                   availability
     */
    @Test
    public void OfindProductsByCategoryAndAvailability() throws Exception {
        /**
         *
         * Find products belonging to a given category and with availability
         *
         * The request response is: [ { "id": 14, "name": "Dress", "category": "Full
         * Body Outfits", "retail_price": 175.0, "discounted_price": 140.0,
         * "availability": true }, { "id": 5, "name": "Ball Gown", "category": "Full
         * Body Outfits", "retail_price": 337.0, "discounted_price": 272.97,
         * "availability": true }, { "id": 1, "name": "Dressing Gown", "category": "Full
         * Body Outfits", "retail_price": 303.0, "discounted_price": 251.49,
         * "availability": true }, { "id": 3, "name": "Nightgown", "category": "Full
         * Body Outfits", "retail_price": 307.0, "discounted_price": 254.81,
         * "availability": true }, { "id": 17, "name": "Tailcoat", "category": "Full
         * Body Outfits", "retail_price": 307.0, "discounted_price": 254.81,
         * "availability": true }, { "id": 9, "name": "Overalls", "category": "Full Body
         * Outfits", "retail_price": 374.0, "discounted_price": 321.64, "availability":
         * true } ]
         */
        String res = "[{\"id\": 14, \"name\": \"Dress\", \"category\": \"Full Body Outfits\", \"retail_price\": 175.0, \"discounted_price\": 140.0, \"availability\": true}, {\"id\": 5, \"name\": \"Ball Gown\", \"category\": \"Full Body Outfits\", \"retail_price\": 337.0, \"discounted_price\": 272.97, \"availability\": true}, {\"id\": 1, \"name\": \"Dressing Gown\", \"category\": \"Full Body Outfits\", \"retail_price\": 303.0, \"discounted_price\": 251.49, \"availability\": true}, {\"id\": 3, \"name\": \"Nightgown\", \"category\": \"Full Body Outfits\", \"retail_price\": 307.0, \"discounted_price\": 254.81, \"availability\": true}, {\"id\": 17, \"name\": \"Tailcoat\", \"category\": \"Full Body Outfits\", \"retail_price\": 307.0, \"discounted_price\": 254.81, \"availability\": true}, {\"id\": 9, \"name\": \"Overalls\", \"category\": \"Full Body Outfits\", \"retail_price\": 374.0, \"discounted_price\": 321.64, \"availability\": true}]";

        assertTrue(ResultMatcher.matchJsonArray(
                mockMvc.perform(get("/products?category=Full%20Body%20Outfits&availability=1").header("Authorization",
                        accessToken)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString(),
                res, true));

        /**
         *
         * Find products belonging to a given category and with availability
         *
         * The request response is: [ { "id": 19, "name": "Suit", "category": "Full Body
         * Outfits", "retail_price": 125.0, "discounted_price": 100.0, "availability":
         * false }, { "id": 20, "name": "Catsuit", "category": "Full Body Outfits",
         * "retail_price": 250.0, "discounted_price": 200.0, "availability": false }, {
         * "id": 21, "name": "Dungarees", "category": "Full Body Outfits",
         * "retail_price": 437.0, "discounted_price": 362.71, "availability": false }, {
         * "id": 16, "name": "Tracksuit", "category": "Full Body Outfits",
         * "retail_price": 471.0, "discounted_price": 423.9, "availability": false } ]
         */
        res = "[{\"id\": 19, \"name\": \"Suit\", \"category\": \"Full Body Outfits\", \"retail_price\": 125.0, \"discounted_price\": 100.0, \"availability\": false}, {\"id\": 20, \"name\": \"Catsuit\", \"category\": \"Full Body Outfits\", \"retail_price\": 250.0, \"discounted_price\": 200.0, \"availability\": false}, {\"id\": 21, \"name\": \"Dungarees\", \"category\": \"Full Body Outfits\", \"retail_price\": 437.0, \"discounted_price\": 362.71, \"availability\": false}, {\"id\": 16, \"name\": \"Tracksuit\", \"category\": \"Full Body Outfits\", \"retail_price\": 471.0, \"discounted_price\": 423.9, \"availability\": false}]";

        assertTrue(ResultMatcher.matchJsonArray(
                mockMvc.perform(get("/products?category=Full%20Body%20Outfits&availability=0").header("Authorization",
                        accessToken)).andExpect(status().isOk()).andReturn().getResponse().getContentAsString(),
                res, true));
    }

    /**
     * @throws Exception It tests finding a product with a given category and
     *                   availability
     */
    @Test
    public void PfindProductsByNonExistingCategoryAndAvailability() throws Exception {
        /**
         *
         * Find products belonging to a given category and with availability
         *
         * The request response is: []
         */
        String res = "[]";

        assertTrue(ResultMatcher.matchJsonArray(
                mockMvc.perform(get("/products?category=Swimwear&availability=1").header("Authorization", accessToken))
                        .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(),
                res, true));
    }

    /**
     * @throws Exception It tests finding all products
     */
    @Test
    public void QfindAllProducts() throws Exception {
        /**
         *
         * Find all products
         *
         * The request response is: [ { "id": 1, "name": "Dressing Gown", "category":
         * "Full Body Outfits", "retail_price": 303.0, "discounted_price": 251.49,
         * "availability": true }, { "id": 2, "name": "Shoes", "category": "Footwear",
         * "retail_price": 150.0, "discounted_price": 123.0, "availability": false }, {
         * "id": 3, "name": "Nightgown", "category": "Full Body Outfits",
         * "retail_price": 307.0, "discounted_price": 254.81, "availability": true }, {
         * "id": 4, "name": "Boots", "category": "Footwear", "retail_price": 162.0,
         * "discounted_price": 132.84, "availability": true }, { "id": 5, "name": "Ball
         * Gown", "category": "Full Body Outfits", "retail_price": 337.0,
         * "discounted_price": 272.97, "availability": true }, { "id": 6, "name":
         * "Shawl", "category": "Accessories", "retail_price": 325.45,
         * "discounted_price": 260.36, "availability": true }, { "id": 7, "name":
         * "Belt", "category": "Accessories", "retail_price": 471.0, "discounted_price":
         * 419.19, "availability": true }, { "id": 8, "name": "Kaftan", "category":
         * "Accessories", "retail_price": 237.0, "discounted_price": 215.67,
         * "availability": true }, { "id": 9, "name": "Overalls", "category": "Full Body
         * Outfits", "retail_price": 374.0, "discounted_price": 321.64, "availability":
         * true }, { "id": 10, "name": "Cufflinks", "category": "Accessories",
         * "retail_price": 284.0, "discounted_price": 227.2, "availability": true }, {
         * "id": 11, "name": "Cargos", "category": "Bottoms", "retail_price": 498.0,
         * "discounted_price": 428.28, "availability": true }, { "id": 12, "name":
         * "Poncho", "category": "Accessories", "retail_price": 350.0,
         * "discounted_price": 283.5, "availability": true }, { "id": 13, "name":
         * "Cummerbund", "category": "Accessories", "retail_price": 500.0,
         * "discounted_price": 450.0, "availability": false }, { "id": 14, "name":
         * "Dress", "category": "Full Body Outfits", "retail_price": 175.0,
         * "discounted_price": 140.0, "availability": true }, { "id": 15, "name":
         * "Trainers", "category": "Footwear", "retail_price": 228.0,
         * "discounted_price": 184.68, "availability": true }, { "id": 16, "name":
         * "Tracksuit", "category": "Full Body Outfits", "retail_price": 471.0,
         * "discounted_price": 423.9, "availability": false }, { "id": 17, "name":
         * "Tailcoat", "category": "Full Body Outfits", "retail_price": 307.0,
         * "discounted_price": 254.81, "availability": true }, { "id": 18, "name":
         * "Vest", "category": "Tops", "retail_price": 446.0, "discounted_price":
         * 392.48, "availability": true }, { "id": 19, "name": "Suit", "category": "Full
         * Body Outfits", "retail_price": 125.0, "discounted_price": 100.0,
         * "availability": false }, { "id": 20, "name": "Catsuit", "category": "Full
         * Body Outfits", "retail_price": 250.0, "discounted_price": 200.0,
         * "availability": false }, { "id": 21, "name": "Dungarees", "category": "Full
         * Body Outfits", "retail_price": 437.0, "discounted_price": 362.71,
         * "availability": false } ]
         */
        String res = "[{\"id\": 1, \"name\": \"Dressing Gown\", \"category\": \"Full Body Outfits\", \"retail_price\": 303.0, \"discounted_price\": 251.49, \"availability\": true}, {\"id\": 2, \"name\": \"Shoes\", \"category\": \"Footwear\", \"retail_price\": 150.0, \"discounted_price\": 123.0, \"availability\": false}, {\"id\": 3, \"name\": \"Nightgown\", \"category\": \"Full Body Outfits\", \"retail_price\": 307.0, \"discounted_price\": 254.81, \"availability\": true}, {\"id\": 4, \"name\": \"Boots\", \"category\": \"Footwear\", \"retail_price\": 162.0, \"discounted_price\": 132.84, \"availability\": true}, {\"id\": 5, \"name\": \"Ball Gown\", \"category\": \"Full Body Outfits\", \"retail_price\": 337.0, \"discounted_price\": 272.97, \"availability\": true}, {\"id\": 6, \"name\": \"Shawl\", \"category\": \"Accessories\", \"retail_price\": 325.45, \"discounted_price\": 260.36, \"availability\": true}, {\"id\": 7, \"name\": \"Belt\", \"category\": \"Accessories\", \"retail_price\": 471.0, \"discounted_price\": 419.19, \"availability\": true}, {\"id\": 8, \"name\": \"Kaftan\", \"category\": \"Accessories\", \"retail_price\": 237.0, \"discounted_price\": 215.67, \"availability\": true}, {\"id\": 9, \"name\": \"Overalls\", \"category\": \"Full Body Outfits\", \"retail_price\": 374.0, \"discounted_price\": 321.64, \"availability\": true}, {\"id\": 10, \"name\": \"Cufflinks\", \"category\": \"Accessories\", \"retail_price\": 284.0, \"discounted_price\": 227.2, \"availability\": true}, {\"id\": 11, \"name\": \"Cargos\", \"category\": \"Bottoms\", \"retail_price\": 498.0, \"discounted_price\": 428.28, \"availability\": true}, {\"id\": 12, \"name\": \"Poncho\", \"category\": \"Accessories\", \"retail_price\": 350.0, \"discounted_price\": 283.5, \"availability\": true}, {\"id\": 13, \"name\": \"Cummerbund\", \"category\": \"Accessories\", \"retail_price\": 500.0, \"discounted_price\": 450.0, \"availability\": false}, {\"id\": 14, \"name\": \"Dress\", \"category\": \"Full Body Outfits\", \"retail_price\": 175.0, \"discounted_price\": 140.0, \"availability\": true}, {\"id\": 15, \"name\": \"Trainers\", \"category\": \"Footwear\", \"retail_price\": 228.0, \"discounted_price\": 184.68, \"availability\": true}, {\"id\": 16, \"name\": \"Tracksuit\", \"category\": \"Full Body Outfits\", \"retail_price\": 471.0, \"discounted_price\": 423.9, \"availability\": false}, {\"id\": 17, \"name\": \"Tailcoat\", \"category\": \"Full Body Outfits\", \"retail_price\": 307.0, \"discounted_price\": 254.81, \"availability\": true}, {\"id\": 18, \"name\": \"Vest\", \"category\": \"Tops\", \"retail_price\": 446.0, \"discounted_price\": 392.48, \"availability\": true}, {\"id\": 19, \"name\": \"Suit\", \"category\": \"Full Body Outfits\", \"retail_price\": 125.0, \"discounted_price\": 100.0, \"availability\": false}, {\"id\": 20, \"name\": \"Catsuit\", \"category\": \"Full Body Outfits\", \"retail_price\": 250.0, \"discounted_price\": 200.0, \"availability\": false}, {\"id\": 21, \"name\": \"Dungarees\", \"category\": \"Full Body Outfits\", \"retail_price\": 437.0, \"discounted_price\": 362.71, \"availability\": false}]";

        assertTrue(ResultMatcher.matchJsonArray(mockMvc.perform(get("/products").header("Authorization", accessToken))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString(), res, true));
    }

}

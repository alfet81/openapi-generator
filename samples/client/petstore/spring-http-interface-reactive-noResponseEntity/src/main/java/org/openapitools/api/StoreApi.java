/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (unset).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import java.util.Map;
import org.openapitools.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.http.codec.multipart.Part;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: unset")
public interface StoreApi {

    /**
     * DELETE /store/order/{order_id} : Delete purchase order by ID
     * For valid response try integer IDs with value &lt; 1000. Anything above 1000 or nonintegers will generate API errors
     *
     * @param orderId ID of the order that needs to be deleted (required)
     * @return Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @HttpExchange(
        method = "DELETE",
        value = "/store/order/{order_id}",
        accept = { "application/json" }
    )
    Mono<Void> deleteOrder(
         @PathVariable("order_id") String orderId
    );


    /**
     * GET /store/inventory : Returns pet inventories by status
     * Returns a map of status codes to quantities
     *
     * @return successful operation (status code 200)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "GET",
        value = "/store/inventory",
        accept = { "application/json" }
    )
    Mono<Map<String, Integer>> getInventory(
        
    );


    /**
     * GET /store/order/{order_id} : Find purchase order by ID
     * For valid response try integer IDs with value &lt;&#x3D; 5 or &gt; 10. Other values will generate exceptions
     *
     * @param orderId ID of pet that needs to be fetched (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Order not found (status code 404)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "GET",
        value = "/store/order/{order_id}",
        accept = { "application/json", "application/xml" }
    )
    Mono<Order> getOrderById(
         @PathVariable("order_id") Long orderId
    );


    /**
     * POST /store/order : Place an order for a pet
     * 
     *
     * @param order order placed for purchasing the pet (required)
     * @return Created (status code 201)
     *         or Invalid Order (status code 400)
     */
    @ResponseStatus(HttpStatus.CREATED)
    @HttpExchange(
        method = "POST",
        value = "/store/order",
        accept = { "application/json", "application/xml" },
        contentType = "application/json"
    )
    Mono<Order> placeOrder(
         @RequestBody Mono<Order> order
    );

}

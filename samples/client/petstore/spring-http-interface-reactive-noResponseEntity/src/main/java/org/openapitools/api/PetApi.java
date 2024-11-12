/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (unset).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.api;

import org.openapitools.model.ModelApiResponse;
import org.openapitools.model.Pet;
import org.openapitools.model.ResponseObjectWithDifferentFieldNames;
import java.util.Set;
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


@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.10.0-SNAPSHOT")
public interface PetApi {

    /**
     * POST /pet : Add a new pet to the store
     * 
     *
     * @param pet Pet object that needs to be added to the store (required)
     * @return successful operation (status code 201)
     *         or Invalid input (status code 405)
     */
    @ResponseStatus(HttpStatus.CREATED)
    @HttpExchange(
        method = "POST",
        value = "/pet",
        accept = { "application/json" },
        contentType = "application/json"
    )
    Mono<Void> addPet(
         @RequestBody Mono<Pet> pet
    );


    /**
     * DELETE /pet/{petId} : Deletes a pet
     * 
     *
     * @param petId Pet id to delete (required)
     * @param apiKey  (optional)
     * @return successful operation (status code 204)
     *         or Invalid pet value (status code 400)
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @HttpExchange(
        method = "DELETE",
        value = "/pet/{petId}",
        accept = { "application/json" }
    )
    Mono<Void> deletePet(
         @PathVariable("petId") Long petId,
         @RequestHeader(value = "api_key", required = false) String apiKey
    );


    /**
     * GET /pet/findByStatus : Finds Pets by status
     * Multiple status values can be provided with comma separated strings
     *
     * @param status Status values that need to be considered for filter (required)
     * @return successful operation (status code 200)
     *         or Invalid status value (status code 400)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "GET",
        value = "/pet/findByStatus",
        accept = { "application/json", "application/xml" }
    )
    Flux<Pet> findPetsByStatus(
         @RequestParam(value = "status", required = true) List<String> status
    );


    /**
     * GET /pet/findByTags : Finds Pets by tags
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @param tags Tags to filter by (required)
     * @return successful operation (status code 200)
     *         or Invalid tag value (status code 400)
     * @deprecated
     */
    @Deprecated
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "GET",
        value = "/pet/findByTags",
        accept = { "application/json", "application/xml" }
    )
    Flux<Pet> findPetsByTags(
         @RequestParam(value = "tags", required = true) Set<String> tags
    );


    /**
     * GET /pet/{petId} : Find pet by ID
     * Returns a single pet
     *
     * @param petId ID of pet to return (required)
     * @return successful operation (status code 200)
     *         or Invalid ID supplied (status code 400)
     *         or Pet not found (status code 404)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "GET",
        value = "/pet/{petId}",
        accept = { "application/json", "application/xml" }
    )
    Mono<Pet> getPetById(
         @PathVariable("petId") Long petId
    );


    /**
     * GET /fake/{petId}/response-object-different-names
     *
     * @param petId ID of pet to update (required)
     * @return successful operation (status code 200)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "GET",
        value = "/fake/{petId}/response-object-different-names",
        accept = { "application/json" }
    )
    Mono<ResponseObjectWithDifferentFieldNames> responseObjectDifferentNames(
         @PathVariable("petId") Long petId
    );


    /**
     * PUT /pet : Update an existing pet
     * 
     *
     * @param pet Pet object that needs to be added to the store (required)
     * @return successful operation (status code 204)
     *         or Invalid ID supplied (status code 400)
     *         or Pet not found (status code 404)
     *         or Validation exception (status code 405)
     */
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @HttpExchange(
        method = "PUT",
        value = "/pet",
        accept = { "application/json" },
        contentType = "application/json"
    )
    Mono<Void> updatePet(
         @RequestBody Mono<Pet> pet
    );


    /**
     * POST /pet/{petId} : Updates a pet in the store with form data
     * 
     *
     * @param petId ID of pet that needs to be updated (required)
     * @param name Updated name of the pet (optional)
     * @param status Updated status of the pet (optional)
     * @return Success (status code 200)
     *         or Invalid input (status code 405)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "POST",
        value = "/pet/{petId}",
        accept = { "application/json" },
        contentType = "application/x-www-form-urlencoded"
    )
    Mono<Void> updatePetWithForm(
         @PathVariable("petId") Long petId,
         @RequestPart(value = "name", required = false) String name,
         @RequestPart(value = "status", required = false) String status
    );


    /**
     * POST /pet/{petId}/uploadImage : uploads an image
     * 
     *
     * @param petId ID of pet to update (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @param file file to upload (optional)
     * @return successful operation (status code 200)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "POST",
        value = "/pet/{petId}/uploadImage",
        accept = { "application/json" },
        contentType = "multipart/form-data"
    )
    Mono<ModelApiResponse> uploadFile(
         @PathVariable("petId") Long petId,
         @RequestPart(value = "additionalMetadata", required = false) String additionalMetadata,
         @RequestPart(value = "file", required = false) Flux<Part> file
    );


    /**
     * POST /fake/{petId}/uploadImageWithRequiredFile : uploads an image (required)
     * 
     *
     * @param petId ID of pet to update (required)
     * @param requiredFile file to upload (required)
     * @param additionalMetadata Additional data to pass to server (optional)
     * @return successful operation (status code 200)
     */
    @ResponseStatus(HttpStatus.OK)
    @HttpExchange(
        method = "POST",
        value = "/fake/{petId}/uploadImageWithRequiredFile",
        accept = { "application/json" },
        contentType = "multipart/form-data"
    )
    Mono<ModelApiResponse> uploadFileWithRequiredFile(
         @PathVariable("petId") Long petId,
         @RequestPart(value = "requiredFile", required = true) Flux<Part> requiredFile,
         @RequestPart(value = "additionalMetadata", required = false) String additionalMetadata
    );

}

/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/getproducts/
 */
public class GetProductsPayload extends Payload {

    /*
     * Retrieve configured products matching provided criteria
     */
    public GetProductsPayload() {
        super ("GetProducts");
    }

    /***
     *
     * @param pID Obtain a specific product id configuration. Can be a list of ids comma separated
     */
    public GetProductsPayload withPid(int pID) {
        put("pid", pID);

        return this;
    }

    /***
     *
     * @param gID Retrieve products in a specific group id
     */
    public GetProductsPayload withGid(int gID) {
        put("gid", gID);

        return this;
    }

    /***
     *
     * @param module Retrieve products utilising a specific module
     */
    public GetProductsPayload withModule(String module) {
        put("module", module);

        return this;
    }
}
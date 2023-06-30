/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/getorders/
 */
public class GetOrdersPayload extends Payload {

    /*
     * Obtain orders matching the passed criteria
     */
    public GetOrdersPayload() {
        super ("GetOrders");
    }

    /***
     *
     * @param limitStart The offset for the returned order data (default: 0)
     */
    public GetOrdersPayload withLimitStart(int limitStart) {
        put("limitstart", limitStart);

        return this;
    }

    /***
     *
     * @param limitNum The number of records to return (default: 25)
     */
    public GetOrdersPayload withLimitNum(int limitNum) {
        put("limitnum", limitNum);

        return this;
    }

    /***
     *
     * @param id Find orders for a specific id
     */
    public GetOrdersPayload withId(int id) {
        put("id", id);

        return this;
    }

    /***
     *
     * @param userID Find orders for a specific client id
     */
    public GetOrdersPayload withUserID(int userID) {
        put("userid", userID);

        return this;
    }

    /***
     *
     * @param status Find orders for a specific status
     */
    public GetOrdersPayload withStatus(String status) {
        put("status", status);

        return this;
    }
}
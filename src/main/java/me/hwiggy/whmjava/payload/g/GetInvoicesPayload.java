/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/getinvoices/
 */
public class GetInvoicesPayload extends Payload {

    /*
     * Retrieve a specific invoice
     */
    public GetInvoicesPayload() {
        super ("GetInvoices");
    }

    /***
     *
     * @param limitstart The offset for the returned invoice data (default: 0)
     */
    public GetInvoicesPayload withLimitstart(int limitstart) {
        put("limitstart", limitstart);

        return this;
    }

    /***
     *
     * @param limitnum The number of records to return (default: 25)
     */
    public GetInvoicesPayload withLimitnum(int limitnum) {
        put("limitnum", limitnum);

        return this;
    }

    /***
     *
     * @param userid Find invoices for a specific client id
     */
    public GetInvoicesPayload withUserid(int userid) {
        put("userid", userid);

        return this;
    }

    /***
     *
     * @param status Find invoices for a specific status. Standard Invoice statuses plus Overdue
     */
    public GetInvoicesPayload withStatus(String status) {
        put("status", status);

        return this;
    }
}
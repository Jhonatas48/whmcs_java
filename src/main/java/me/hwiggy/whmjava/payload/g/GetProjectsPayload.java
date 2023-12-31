/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;
//todo camelCase on this class

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/getprojects/
 */
public class GetProjectsPayload extends Payload {

    /*
     * Obtain orders matching the passed criteria
     */
    public GetProjectsPayload() {
        super ("GetProjects");
    }

    /***
     *
     * @param limitstart The offset for the returned project data (default: 0)
     */
    public GetProjectsPayload withLimitstart(int limitstart) {
        put("limitstart", limitstart);

        return this;
    }

    /***
     *
     * @param limitnum The number of records to return (default: 25)
     */
    public GetProjectsPayload withLimitnum(int limitnum) {
        put("limitnum", limitnum);

        return this;
    }

    /***
     *
     * @param userid Find projects for a specific client id
     */
    public GetProjectsPayload withUserid(int userid) {
        put("userid", userid);

        return this;
    }

    /***
     *
     * @param title Find projects with a specific title
     */
    public GetProjectsPayload withTitle(String title) {
        put("title", title);

        return this;
    }

    /***
     *
     * @param ticketids Find projects with specific ticketids
     */
    public GetProjectsPayload withTicketids(String ticketids) {
        put("ticketids", ticketids);

        return this;
    }

    /***
     *
     * @param invoiceids Find projects with specific invoiceids
     */
    public GetProjectsPayload withInvoiceids(String invoiceids) {
        put("invoiceids", invoiceids);

        return this;
    }

    /***
     *
     * @param notes Find projects with specific notes
     */
    public GetProjectsPayload withNotes(String notes) {
        put("notes", notes);

        return this;
    }

    /***
     *
     * @param adminid Find projects assigned to a specific admin id
     */
    public GetProjectsPayload withAdminid(int adminid) {
        put("adminid", adminid);

        return this;
    }

    /***
     *
     * @param status Find projects with a specific status
     */
    public GetProjectsPayload withStatus(String status) {
        put("status", status);

        return this;
    }

    /***
     *
     * @param created Find projects with a specific creation date
     */
    public GetProjectsPayload withCreated(String /* Carbon */ created) {
        put("created", created);

        return this;
    }

    /***
     *
     * @param duedate Find projects with a specific due date
     */
    public GetProjectsPayload withDuedate(String /* Carbon */ duedate) {
        put("duedate", duedate);

        return this;
    }

    /***
     *
     * @param completed Find projects that are/aren’t completed
     */
    public GetProjectsPayload withCompleted(boolean completed) {
        put("completed", completed);

        return this;
    }

    /***
     *
     * @param lastmodified Find projects with a specific last modified date
     */
    public GetProjectsPayload withLastmodified(String /* Carbon */ lastmodified) {
        put("lastmodified", lastmodified);

        return this;
    }
}
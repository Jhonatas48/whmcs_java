/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.g;

import me.hwiggy.whmjava.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/GetQuotesPayload/
 */
public class GetQuotesPayload extends Payload {

    /*
     * Obtain quotes matching the passed criteria
     */
    public GetQuotesPayload() {
        super ("GetQuotesPayload");
    }

    /***
     *
     * @param limitStart The offset for the returned quote data (default: 0)
     */
    public GetQuotesPayload withLimitstart(int limitStart) {
        put("limitstart", limitStart);

        return this;
    }

    /***
     *
     * @param limitNum The number of records to return (default: 25)
     */
    public GetQuotesPayload withLimitnum(int limitNum) {
        put("limitnum", limitNum);

        return this;
    }

    /***
     *
     * @param quoteID Obtain a specific quote id
     */
    public GetQuotesPayload withQuoteid(int quoteID) {
        put("quoteid", quoteID);

        return this;
    }

    /***
     *
     * @param userID Find quotes for a specific client id
     */
    public GetQuotesPayload withUserid(int userID) {
        put("userid", userID);

        return this;
    }

    /***
     *
     * @param subject Find quotes for a specific subject
     */
    public GetQuotesPayload withSubject(String subject) {
        put("subject", subject);

        return this;
    }

    /***
     *
     * @param stage quotes for a specific stage (‘Draft’,‘Delivered’,‘On Hold’,‘Accepted’,‘Lost’,‘Dead’)
     */
    public GetQuotesPayload withStage(String stage) {
        put("stage", stage);

        return this;
    }

    /***
     *
     * @param dateCreated Find quotes for a specific created date. Format: Y-m-d
     */
    public GetQuotesPayload withDateCreated(String /* Carbon */ dateCreated) {
        put("datecreated", dateCreated);

        return this;
    }

    /***
     *
     * @param lastModified Find quotes for a specific last modified date. Format: Y-m-d
     */
    public GetQuotesPayload withLastModified(String /* Carbon */ lastModified) {
        put("lastmodified", lastModified);

        return this;
    }

    /***
     *
     * @param validUntil Find quotes for a specific valid until date. Format: Y-m-d
     */
    public GetQuotesPayload withValidUntil(String /* Carbon */ validUntil) {
        put("validuntil", validUntil);

        return this;
    }
}
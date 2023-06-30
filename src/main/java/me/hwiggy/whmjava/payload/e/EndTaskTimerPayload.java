/**
 * Generated by ramidzkh's awesome generator thingy
 */
package me.hwiggy.whmjava.payload.e;

import me.hwiggy.whmjava.payload.Payload;

/***
 * This class and its methods directly relate to the API documentation.
 * API documentation can be found at the￼ following URL:
 ￼* https://developers.whmcs.com/api-reference/endtasktimer/
 */
public class EndTaskTimerPayload extends Payload {

    /***
     * Ends a started timer for a project
     * @param timerID The id of the task to be ended
     */
    public EndTaskTimerPayload(int timerID) {
        super ("EndTaskTimer");
        put("timerid", timerID);
    }

    /***
     *
     * @param projectID The id of the project for the task timer
     */
    public EndTaskTimerPayload withProjectID(int projectID) {
        put("projectid", projectID);

        return this;
    }

    /***
     *
     * @param adminID The admin id to associate the timer with
     */
    public EndTaskTimerPayload withAdminID(int adminID) {
        put("adminid", adminID);

        return this;
    }

    /***
     *
     * @param end_time The end time as a unix time stamp. Defaults to time() if not provided
     */
    public EndTaskTimerPayload withEnd_time(int end_time) {
        put("end_time", end_time);

        return this;
    }
}
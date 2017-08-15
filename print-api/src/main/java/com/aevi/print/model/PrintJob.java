/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aevi.print.model;

import com.aevi.android.rxmessenger.JsonConverter;
import com.aevi.android.rxmessenger.SendableId;

/**
 * Wrapper class to encapsulate the PrintJob
 */
public class PrintJob extends SendableId {

    public enum State {

        /**
         * The print job is in the print queue.
         */
        IN_PROGRESS,

        /**
         * The print job has been completed.
         */
        PRINTED,

        /**
         * The print job failed printing.
         */
        FAILED

    }

    private final State printJobState;
    private String message;

    /**
     * Construct a new PrintJob based on the number of the print job.
     *
     * @param printJobState The state of the printJob
     */
    public PrintJob(State printJobState) {
        this.printJobState = printJobState;
    }

    /**
     * Construct a new PrintJob based on the number of the print job.
     *
     * @param printJobState The state of the printJob
     * @param message       A message to include with the state
     */
    public PrintJob(State printJobState, String message) {
        this(printJobState);
        this.message = message;
    }

    /**
     * @return The message (if any) that was provided along with the state of the print job
     */
    public String getMessage() {
        return message;
    }

    /**
     * @return The state of this print job
     */
    public State getPrintJobState() {
        return printJobState;
    }

    @Override
    public String toJson() {
        return JsonConverter.serialize(this);
    }

    public static PrintJob fromJson(String json) {
        return JsonConverter.deserialize(json, PrintJob.class);
    }
}

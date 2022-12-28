package ru.nsu.seleznev.a;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Note class implementation.
 *
 * @param title       title of the Note
 * @param description description of the Note
 */
record Note(@JsonProperty("Title") String title,
            @JsonProperty("Description") String description) {
}

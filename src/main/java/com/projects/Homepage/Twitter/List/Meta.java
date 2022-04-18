
package com.projects.Homepage.Twitter.List;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "result_count",
    "next_token"
})
@Generated("jsonschema2pojo")
public class Meta {

    @JsonProperty("result_count")
    private Integer resultCount;
    @JsonProperty("next_token")
    private String nextToken;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("result_count")
    public Integer getResultCount() {
        return resultCount;
    }

    @JsonProperty("result_count")
    public void setResultCount(Integer resultCount) {
        this.resultCount = resultCount;
    }

    @JsonProperty("next_token")
    public String getNextToken() {
        return nextToken;
    }

    @JsonProperty("next_token")
    public void setNextToken(String nextToken) {
        this.nextToken = nextToken;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

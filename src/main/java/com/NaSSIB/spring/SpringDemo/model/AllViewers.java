
package com.NaSSIB.spring.SpringDemo.model;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)

public class AllViewers {

  // not actually a set, in fact a list
  @JsonProperty("viewerSet")
  private List<Viewers> viewerSet = null;

  @JsonProperty("viewerSet")
  public List<Viewers> getViewerSet() {
    return viewerSet;
  }

  @JsonProperty("viewerSet")
  public void setViewerSet(List<Viewers> viewerSet) {
    this.viewerSet = viewerSet;
  }

}
